﻿

(function () {
    'use strict';
    angular
        .module('app')
        .controller('feesController', feesController)
        .controller('addEditFeesController', addEditFeesController)

    feesController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function feesController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {

        var vm = $scope;
        var IsAdmin = false;
        vm.ManageFees = [{ PaymentMethod: "", Fees: "", CreatedDate: "", ChargeSendingAmount: "", FeesType: "", DestinationCountry: "", SourceCountry:""}];
        vm.UserId = 0;
        vm.CompanyId = 0;
       
        vm.Countries = [];
     
        if ($window.sessionStorage.authorisedUser) {

            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) {
                vm.UserId = parseInt(authorisedUser.UserId);
                vm.CompanyId = parseInt(authorisedUser.CompanyId);
            }
        }
        //Get Country
        $http({
            method: 'GET',
            url: baseUrl + 'getcountrydetails',
            headers: { 'Content-Type': 'application/json' }
        })
      .success(function (data) {
          var idata = data;
          vm.Countries = idata;
          var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
           $http({
                  method: 'POST',
                  url: baseUrl + 'getPaymentFeesDetails',
                  data: formData,
                  headers: { 'Content-Type': 'application/json; charset=utf-8' }
              })
          .success(function (data) {
              
              var idata = data;
              vm.ManageFees = idata;
              angular.forEach(vm.ManageFees, function (fee, index) {
                  vm.getOtherData(fee, index);
              });









          });
      });



      

       

        vm.getOtherData = function (fee, i) {
           
            var formData = JSON.parse(JSON.stringify({ "CompanyId": fee.CompanyId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getAgentdetailsByCompanyId ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
         .success(function (data) {
                   
             vm.ManageAgent = data;
             var data12 = $filter('filter')(vm.ManageAgent, {
                 AgentId: fee.PayInAgentId,
             }, true);
             if (data12.length>0) {
                 vm.ManageFees[i].PayInAgentName = data12[0].AgentFirstName;
             }
             var data123 = $filter('filter')(vm.ManageAgent, {
                 AgentId: fee.PayOutAgentId,
             }, true);

             if (data123.length>0) {
                 vm.ManageFees[i].PayOutAgentName = data123[0].AgentFirstName;
             }
           
             var SourcecountryData = $filter('filter')(vm.Countries, {
                 CountryId: fee.SourceCountry,
             }, true);
             if (SourcecountryData.length>0)
                 vm.ManageFees[i].Sourcecountry = SourcecountryData[0].CountryName;


             var DestinationcountryData = $filter('filter')(vm.Countries, {
                 CountryId: fee.DestinationCountry,
             }, true);



             if (SourcecountryData.length>0)
                 vm.ManageFees[i].Destinationcountry = DestinationcountryData[0].CountryName;
            


         });
        }
        //Get users
      


      
        vm.addfees = function () {
            $state.go('app.add_Fees');
        }

        vm.EditFee = function (Id) {
            $state.go('app.Edit_Fees', {PaymentFessId: Id });
        }

        ////DeleteUser
        var DeleteUserID = 0;
        vm.deleteUser = function (Id) {
            DeleteUserID = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var PaymentFessId = 0;
            PaymentFessId = +DeleteUserID;

            var formData = JSON.parse(JSON.stringify({ "PaymentFessId": PaymentFessId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deletePaymentFeesById',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
       
                var idata = data;
                if (idata.PaymentFessId > 0 && idata.Result == "Sucess") {
                    Alert(1, "! Fees deleted successfully");
                    var iManageUsers = vm.ManageFees;
                    vm.ManageFees = [];
                    for (var i = 0; i < iManageUsers.length; i++) {
                        if (iManageUsers[i].PaymentFessId !== DeleteUserID) vm.ManageFees.push(iManageUsers[i]);
                    }
                }
            });
        }


    }

    addEditFeesController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditFeesController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
        vm.parseInt = parseInt;
        vm.ToCurrency = "";
        vm.BaseCurrency = "";
        vm.FeesModel = { PaymentFessId: "0", CompanyId: "0", SourceCountry: "0", DestinationCountry: "0", FeesType: "0", FeesCategoryId: "0", PayInAgentId: "0",PayOutAgentId:"0", PaymentMethod: "" };
        vm.Companies = [];
        vm.DeliveryMethod = [];
        vm.code = "";
        vm.header = 'Add New';
        vm.Error = "";
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

        vm.FeeType = [{ Feetype: "1", FeeTypeName: "Flat" }, { Feetype: "2", FeeTypeName: "Percentage" }];
        vm.FeesCategory = [{ FeesCategoryId: "1", FeesCategoryName: "Remittance" }, { FeesCategoryId: "2", FeesCategoryName: "Money transfer cancellation" },
            { FeesCategoryId: "3", FeesCategoryName: "Wallet money fund transfer" }, { FeesCategoryId: "4", FeesCategoryName: "Wallet money load cash" },
            { FeesCategoryId: "5", FeesCategoryName: "Airtime topup" }, { FeesCategoryId: "6", FeesCategoryName: "Bill" }, { FeesCategoryId: "7", FeesCategoryName: "Wallet money cash out" }
        ];

        //Get Aggent Details
        vm.selectedCompany = function (companyId) {
         
            var iComapnyId = parseInt(companyId);

            var formData = JSON.parse(JSON.stringify({ "CompanyId": iComapnyId }));
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



        if ($stateParams.PaymentFessId) {
          
            vm.header = 'Update';
            var iPaymentFessId = "";
            iPaymentFessId = JSON.stringify($stateParams.PaymentFessId);

            var formData = JSON.parse(JSON.stringify({ "PaymentFessId": iPaymentFessId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getPaymentFeesById',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
             
                 var idata = data;
                 //vm.FeesModel = idata;
                 if (idata) {
                     vm.FeesModel.PaymentFessId = ""+idata.PaymentFessId;
                     vm.FeesModel.PayInAgentId = "" + idata.PayInAgentId;
                     vm.FeesModel.PayOutAgentId = "" + idata.PayOutAgentId;
                     vm.FeesModel.IsPayInAgent = idata.IsPayInAgent;
                     vm.FeesModel.IsPayOutAgent = idata.IsPayOutAgent;
                     vm.FeesModel.CompanyId = "" + idata.CompanyId;
                     vm.selectedCompany(vm.FeesModel.CompanyId);
                     vm.FeesModel.DestinationCountry = "" + idata.DestinationCountry;
                     vm.getToCurrency(vm.FeesModel.DestinationCountry);
                     vm.FeesModel.FeesCategoryId = "" + idata.FeesCategoryId;
                     vm.FeesModel.FeesType = "" + idata.FeesType;
                     vm.FeesModel.SourceCountry = "" + idata.SourceCountry;
                     vm.getBaseCurrency(vm.FeesModel.SourceCountry);
                     vm.FeesModel.PaymentMethod = "" + idata.PaymentMethod;
                     vm.FeesModel.ChargeSendingAmount = idata.ChargeSendingAmount
                     vm.FeesModel.EndAmount = idata.EndAmount;
                     vm.FeesModel.StartingAmount = idata.StartingAmount;
                     vm.FeesModel.Fees = + idata.Fees;
                 }
             });
        }

        vm.getBaseCurrency = function (SourceCountryId) {
            var formData = JSON.parse(JSON.stringify({ "CountryId": SourceCountryId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getcountry ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
      .success(function (data) {
          var idata = data;
          vm.BaseCurrency = idata.CurrencyCode;
      });
        }



        vm.getToCurrency = function (DestinationCurrencyId) {
       
            var formData = JSON.parse(JSON.stringify({ "CountryId": DestinationCurrencyId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getcountry ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
      .success(function (data) {
          var idata = data;
          vm.ToCurrency = idata.CurrencyCode;
      });
        }

        vm.Create = function () {
            if ($stateParams.PaymentFessId) {
                vm.FeesModel.StartingAmount = $('#StartingAmount').val();
                vm.FeesModel.EndAmount = $('#EndAmount').val();
                vm.FeesModel.Fees = +$('#Fees').val();
                if (vm.FeesModel.PaymentMethod == 'Bank Transfer') {
                    vm.FeesModel.PayInAgentId = '-1'
                }
                var iData = vm.FeesModel;
                var formData = JSON.stringify(vm.FeesModel);
                $http({
                    method: 'POST',
                    url: baseUrl + 'addPaymentFees',
                    data: formData,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    dataType: "json",
                })
                .success(function (data) {
                  
                    var idata = data;
                    if (idata && idata.PaymentFessId > 0 && idata.Result=="Sucess" ) {
                        Alert(1, "! Fees updated successfully");
                        vm.FeesModel = angular.copy(vm.FeesModel);
                        setTimeout(function () {
                            $state.go('app.Fees');
                        }, 1000);

                    }
                    else {
                        vm.Error = idata.Error;
                        $('#deleteconfirm').modal('show');
                    }
                });
            }
            else {
          
                vm.FeesModel.StartingAmount = $('#StartingAmount').val();
                vm.FeesModel.EndAmount = $('#EndAmount').val();
                vm.FeesModel.Fees =+$('#Fees').val();
                var iData = vm.FeesModel;
                if (vm.FeesModel.PaymentMethod == 'Bank Transfer') {
                    vm.FeesModel.PayInAgentId = '-1';
                    vm.FeesModel.PayOutAgentId = '-1';
                  }
                //if (vm.UserModel.IsActive == true) {
                //    iData.IsActive = "true"
                //}
                //else {
                //    iData.IsActive = "false"
                //}

                var formData = JSON.stringify(iData);


                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'addPaymentFees',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {

                    var idata = data;
                    if (idata && idata.Result == "Sucess") {
                        Alert(1, "! Fees created successfully");
                        vm.FeesModel = angular.copy(vm.FeesModel);
                        setTimeout(function () {
                            $state.go('app.Fees');
                        }, 1000);
                       
                        

                    }
                    else {
                        vm.Error = idata.Error;
                        $('#deleteconfirm').modal('show');
                    }
                });
            }
        }

        vm.cancel = function () {
            $state.go('app.Fees');
        }


    }


})();