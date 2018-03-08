(function () {
    'use strict';
    angular.module('app')
      .controller('transactionFeeSharingController', transactionFeeSharingController)
     .controller('addEditTransactionFeesController', addEditTransactionFeesController)
    transactionFeeSharingController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function transactionFeeSharingController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {

        var vm = $scope;
        var IsAdmin = false;
        vm.UserId = 0;
        vm.CompanyId = 0;
        if ($window.sessionStorage.authorisedUser) {

            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) {
                vm.UserId = parseInt(authorisedUser.UserId);
                vm.CompanyId = parseInt(authorisedUser.CompanyId);
            }
        }
        vm.AddFeeSharing = function () {
            $state.go('app.add_Transaction_Fees_Sharing');
        }
    }
    addEditTransactionFeesController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditTransactionFeesController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {
        var vm = $scope;
        vm.TransactionFeeSharingDetails = { UniversalFee: 1 };

        vm.SelectedCompnay = "";
        vm.UserId = 0;
        vm.CompanyId = 0;
        vm.DeliveryMethod = [];
        vm.Companies = [];
        vm.CustomizeTransactionFeeData = {};
        if ($window.sessionStorage.authorisedUser) {

            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) {
                vm.UserId = parseInt(authorisedUser.UserId);
                vm.CompanyId = parseInt(authorisedUser.CompanyId);
            }
        }

        //Get Company
        $http({
            method: 'GET',
            url: baseUrl + 'getcompanydetails',
            headers: { 'Content-Type': 'application/json' }
        })
       .success(function (data) {
           var idata = data;
           vm.Companies = idata;

       });
        vm.selectedCompany = function (CompanyId) {
            //PaymentMethod
            var iComapnyId = parseInt(CompanyId);
            var formData = JSON.parse(JSON.stringify({ "CompanyId": iComapnyId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getpaymentmethodbycompanyid ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
    .success(function (data) {
        var idata = data;
        vm.DeliveryMethod = idata;
    });
            //Agent
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getAgentdetailsByCompanyId ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
                  .success(function (data) {
                      var idata = data;
                      vm.ManageAgent = idata;
                  });


        }
       
      
      
    }
})();