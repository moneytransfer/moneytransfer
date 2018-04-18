

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageCustomerController', manageCustomerController)

    //Customer Login site
    manageCustomerController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageCustomerController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerId = 0;


        $('body').removeClass('modal-open').css('padding-right', '0px');

        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
            }
        }
        //Remove BackDrop
        $('.modal-backdrop').remove();

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId":0}));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getcustomerbycompanyid',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            idata = $filter('orderBy')(idata, 'CustomerId', $scope.reverse);
            vm.totalItems = idata.length;
            vm.currentPage = 1;
            vm.itemsPerPage = 15;
            vm.$watch("currentPage", function () {
                setPagingData(vm.currentPage);
            });

            function setPagingData(page) {
                var pagedData = idata.slice(
                  (page - 1) * vm.itemsPerPage,
                  page * vm.itemsPerPage
                );
                vm.ManageCustomers = pagedData;
            }
        });
        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);

            return dateOut;
        };

        //-------------------- Get details------------------------//
        vm.CustomerDetails = [];
        vm.CustomerTransactions = [];

        vm.GetDetails = function (id) {
            var iCustomerId = id;
            if (iCustomerId > 0) {
                GetCustomerTransaction(iCustomerId);
            }
        }

        function GetCustomerTransaction(id) {
            var iCustomerId = id;

            angular.forEach(vm.ManageCustomers, function (customer, index) {
                if (customer.CustomerId == iCustomerId) {
                    vm.CustomerDetails.puse(customer);
                }
            });


            //Get Method Details
            var formData = JSON.parse(JSON.stringify({ "CustomerId": iCustomerId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'gettranscationdetails',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                idata = $filter('orderBy')(idata, 'CustomerId', $scope.reverse);
                vm.totalItems = idata.length;
                vm.currentPage = 1;
                vm.itemsPerPage = 8;
                vm.$watch("currentPage", function () {
                    setPagingData(vm.currentPage);
                });

                function setPagingData(page) {
                    var pagedData = idata.slice(
                      (page - 1) * vm.itemsPerPage,
                      page * vm.itemsPerPage
                    );
                    vm.CustomerTransactions = pagedData;
                }
            });
        }
    }

})();