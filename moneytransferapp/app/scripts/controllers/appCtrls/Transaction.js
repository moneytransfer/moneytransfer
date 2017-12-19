

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageTransactionController', manageTransactionController)

    manageTransactionController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate','$log'];
    function manageTransactionController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate,$log) {
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
        var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.CustomerId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'gettranscationdetails',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {

            var idata = data;

           // $timeout(function () {
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
                vm.ManageTransaction = pagedData;
            }
            //}, 100);
        });

        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);

            return dateOut;
        };

        //DeleteUser
        var PaymentMethodID = 0;
        vm.deleteTransaction = function (Id) {
            PaymentMethodID = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var iPaymentMethodID = "";
            iPaymentMethodID = JSON.stringify(PaymentMethodID);

            var formData = JSON.parse(JSON.stringify({ "PaymentMethodId": iPaymentMethodID }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deletepaymentmethod',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.PaymentMethodId > 0) {
                    Alert(1, "! Payment Method deleted successfully");
                    var iPaymentMethods = vm.PaymentMethods;
                    vm.PaymentMethods = [];
                    for (var i = 0; i < iPaymentMethods.length; i++) {
                        if (iPaymentMethods[i].PaymentMethodId !== PaymentMethodID) vm.PaymentMethods.push(iPaymentMethods[i]);
                    }
                }
            });
        }

    }


})();