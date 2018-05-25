

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageTransactionController', manageTransactionController)
     .controller('manageAllTransactionController', manageAllTransactionController)

    //Customer Login site
    manageTransactionController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageTransactionController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
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
            idata = $filter('orderBy')(idata, 'TransactionId', $scope.reverse);
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


    //Admin Site
    manageAllTransactionController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageAllTransactionController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
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
        var formData = JSON.parse(JSON.stringify({ "CompanyId": 17 }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'gettranscationdetailsByCompany',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {

            var idata = data;
            $scope.reverse = true;
            idata = $filter('orderBy')(idata, 'TransactionId', $scope.reverse);
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


        //-------------------- Get details------------------------//
        vm.BeneficiaryDetails = [];
        vm.TransactionDetails = [];

        vm.GetDetails = function (id) {
            var iTransactionId = id;
            if (iTransactionId > 0) {
                SelectedTransaction(iTransactionId);
            }
        }

        function SelectedTransaction(id) {
            var iTransactionId = id;
            if (iTransactionId > 0) {
                //Get Method Details
                var formData = JSON.parse(JSON.stringify({ "TransactionId": iTransactionId }));
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'getTranscationdetailsById',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' }
                })
                .success(function (data) {
                    var idata = data[0];
                    vm.transactionDetails = idata;
                    BeneficiaryDetails(idata.BeneficiaryId);

                });

            }

        }

        function BeneficiaryDetails(Id) {
            var iBeneficiaryId = parseInt(Id);
            var formData = JSON.parse(JSON.stringify({ "BeneficiaryId": iBeneficiaryId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getbeneficiarydetailsbyId',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 var idata = data;
                 vm.BeneficiaryDetails = idata;
                 $('#transactionDetails').modal('toggle');
             });

        }

        vm.RefundModal = { "CompanyId": 0, "PaymentGatewayTransactionId": 0, "SendingAmount": 0, "PaymentMethodId": 0, "RefundedBy": "" }

        vm.RefundConfrimation = function (objTransaction) {
            if (!objTransaction.IsRefunded) {
                vm.RefundModal.CompanyId = objTransaction.CompanyId;
                vm.RefundModal.PaymentGatewayTransactionId = objTransaction.PaymentGatewayTransactionId;
                vm.RefundModal.SendingAmount = objTransaction.SendingAmount;
                vm.RefundModal.PaymentMethodId = objTransaction.PaymentMethodId;
                vm.RefundModal.RefundedBy = authorisedUser.FirstName + " " + authorisedUser.LastName;
                $('#confirmrefund').modal('toggle');
            }
            else {
                Alert(2, "! Refund request already processed for this transaction");
            }

        }

        vm.RefundConfirm = function () {

            $('#confirmrefund').modal('toggle');
            var formData = JSON.parse(JSON.stringify(vm.RefundModal));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'refundTransaction',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var sdata = data;
                if (sdata.Result == "Success") {
                    Alert(1, "! Refund request processed successfully");
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                }
                else { Alert(2, sdata.Error); }
            });

        }
    }

})();