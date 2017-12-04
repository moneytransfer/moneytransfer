

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
            //if (idata.length > 5) {
                vm.totalItems = idata.length;
                vm.currentPage = 1;
                vm.itemsPerPage = 15;

                vm.$watch("currentPage", function () {
                    setPagingData(vm.currentPage);
                });
            //}
            //else {
            //    vm.ManagePayBill = idata;
            //}


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


        vm.PaymentMethods = [];
        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompanyid ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.PaymentMethods = idata;
        });




        vm.PayDetails = { SenderName: '', FaceAmount: '', InvoiceAmount: '', MobileNumber: '', InvoiceNumber: '' };
        vm.PaybillModel = { CompanyId: vm.CompanyId, CustomerId: vm.CustomerId, PaymentMethodId: '0'}
        vm.ExpireModel = {}
        //Get Method Details



        vm.Create = function () {
            debugger;
            var idata = vm.PaybillModel;

            var sMonth = vm.ExpireModel.ExpireMonth;
            if (sMonth < 10) {
                sMonth = '0' + sMonth
            }
            var sYear = vm.ExpireModel.ExpireYear;
            var expiremonth = sMonth + '' + sYear;
            idata.setExpirationDate = expiremonth;

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