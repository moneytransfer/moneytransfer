(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageContectUsController', manageContectUsController)


    manageContectUsController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageContectUsController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;

        vm.CompanyId = 0;
        vm.CustomerId = 0;

        if ($localStorage.GustCustomer) {

        }

        vm.ContactUsModal = { "Name": " ", "Email": "", "ReceivingCountry": "0", "FalconLoopTransactionNumber": " ", "Subject": "", "Question": "" };

        vm.RequestRefundModal = { "Name": " ", "Email": "", "ReceivingCountry": "0", "FalconLoopTransactionNumber": " ", "Subject": "", "Question": "" };

        //Get Country
        $http({
            method: 'GET',
            url: baseUrl + 'getcountrydetails',
            headers: { 'Content-Type': 'application/json' }
        })
        .success(function (data) {
            var idata = data;
            vm.Countries = idata;
        });

        vm.Create = function (RequestNumber) {
            vm.Request = RequestNumber;
            var formData = '';
            if (RequestNumber == 1) {
                formData = JSON.parse(JSON.stringify(vm.ContactUsModal));
            }
            else {
                formData = JSON.parse(JSON.stringify(vm.RequestRefundModal));
            }
            $http({
                method: 'POST',
                url: baseUrl + 'getSendEmailTLS',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.Result == "Success") {
                    if (vm.Request == 1) {
                        Alert(1, "Thanks for contact us we will get back to you soon");
                    }
                    else {
                        Alert(1, "Your Request Refund processed successfully");
                    }
                    setTimeout(function () {
                        vm.ContactUsModal = { "ReceivingCountry": "0" };
                    }, 500);
                }
                else {
                    Alert(2, idata.Error);
                }
            });
        }

        vm.CancelEmail = function () {
            vm.ContactUsModal = { "ReceivingCountry": "0" }
        }

        vm.CancelRequest = function () {
            vm.RequestRefundModal = { "ReceivingCountry": "0" }
        }

    }
})();
