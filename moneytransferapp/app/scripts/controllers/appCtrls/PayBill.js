

(function () {
    'use strict';
    angular
        .module('app')
        .controller('managePayBillController', managePayBillController)
        .controller('addPayBillController', addPayBillController)
        .controller('addPayBillController', addPayBillController)

    managePayBillController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function managePayBillController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerId = 0;

        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
            }
        }

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.CustomerId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getBillPayDetails',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.totalItems = idata.length;
            vm.currentPage = 1;
            vm.itemsPerPage = 10;

            vm.$watch("currentPage", function () {
                setPagingData(vm.currentPage);
            });

            function setPagingData(page) {
                var pagedData = idata.slice(
                  (page - 1) * vm.itemsPerPage,
                  page * vm.itemsPerPage
                );
                vm.ManagePayBill = pagedData;
            }
            //}, 100);
        });

        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);

            return dateOut;
        };

    }

    addPayBillController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function addPayBillController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {

        var vm = $scope;

        vm.CompanyId = 0;
        vm.CustomerId = 0;

        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
            }
        }

        vm.PayDetails = { SenderName: '', FaceAmount: '', InvoiceAmount: '', MobileNumber: '', InvoiceNumber: '' };
        vm.PaybillModel = { CompanyId: vm.CompanyId, CustomerId: vm.CustomerId }
        //Get Method Details

        vm.Create = function () {

            var idata = vm.PaybillModel;
            var formData = JSON.stringify(idata);
            $http({
                method: 'POST',
                url: baseUrl + 'billPay',
                data: formData,
                headers: {
                    'Content-Type': 'application/json'
                },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                vm.PayDetails = idata;
                if (idata && idata.BillPayId > 0) {

                    $timeout(function () {
                        $('#ThankyouPaybill').modal('toggle');
                    }, 500);

                    $timeout(function () {
                        $('#ThankyouPaybill').modal('toggle');
                        $('.modal-backdrop').remove();
                        $state.go('app.manage_pay_bill');
                    }, 10000);

                }
                else {
                    Alert(2, idata.Error);
                }
            });
        }


        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);

            return dateOut;
        };

        vm.cancel = function () {
            $state.go('app.manage_pay_bill');
        }
    }



})();