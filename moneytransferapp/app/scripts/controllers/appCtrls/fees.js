

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
        vm.ManageFees = [{ PaymentMethod: "", Fees: "", CreatedDate: "", ChargeSendingAmount: "", FeesType: "", DestinationCountry: "", SourceCountry: "", FeeCategory: "" }];
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

        //Get Fee Category
        $http({
            method: 'GET',
            url: baseUrl + 'getFeesCategoryDetails',
            headers: { 'Content-Type': 'application/json' }
        })
          .success(function (data) {

              var idata = data;
              vm.FeesCategory = idata;
          });

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompany ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
           .success(function (data) {
               var idata = data;
               vm.PaymentMethods = idata;
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
              vm.ReloadData();
          });

        //Load data
        vm.ReloadData = function () {
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
                   //vm.getfeeCategory(fee, index);
                   vm.getOtherData(fee, index);
               });
           });
        }

        //Get Ref. Data for Fee Details
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
             if (data12.length > 0) {
                 vm.ManageFees[i].PayInAgentName = data12[0].AgentFirstName;
             }
             var data123 = $filter('filter')(vm.ManageAgent, {
                 AgentId: fee.PayOutAgentId,
             }, true);

             if (data123.length > 0) {
                 vm.ManageFees[i].PayOutAgentName = data123[0].AgentFirstName;
             }

             var SourcecountryData = $filter('filter')(vm.Countries, {
                 CountryId: fee.SourceCountry,
             }, true);
             if (SourcecountryData.length > 0)
                 vm.ManageFees[i].Sourcecountry = SourcecountryData[0].CountryName;
             var DestinationcountryData = $filter('filter')(vm.Countries, {
                 CountryId: fee.DestinationCountry,
             }, true);

             if (SourcecountryData.length > 0)
                 vm.ManageFees[i].Destinationcountry = DestinationcountryData[0].CountryName;

             var Payment = $filter('filter')(vm.PaymentMethods, {
                 PaymentMethodId: fee.PaymentMethodId,
             }, true);

             if (Payment.length > 0)
                 vm.ManageFees[i].Payment = Payment[0].Title;
             var FeeCategory = $filter('filter')(vm.FeesCategory, {
                 FeesCategoryId: fee.FeesCategoryId,
             }, true);

             if (FeeCategory.length > 0)
                 vm.ManageFees[i].FeeCategory = FeeCategory[0].FeesCategoryName;

         });
        }

        //Filter Fee Data
        vm.Feesfilter = { FeesCategoryId: "-1" };

        vm.FilterFees = function (CategoryId) {
            var CategoryId = parseInt(CategoryId);
            var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getPaymentFeesDetails',
                data: formData,
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
           .success(function (data) {

               var idata = data;
               if (CategoryId > 0) {
                   vm.ManageFees = [];
                   angular.forEach(idata, function (fee, index) {
                       if (fee.FeesCategoryId == CategoryId) {
                           vm.ManageFees.push(fee);
                       }
                   });
                   angular.forEach(vm.ManageFees, function (fee, index) {
                       vm.getOtherData(fee, index);
                   });
               }
               else {
                   vm.ManageFees = idata;
                   angular.forEach(vm.ManageFees, function (fee, index) {
                       vm.getOtherData(fee, index);
                   });
               }
           });
        }

        //Link Button Click
        vm.dfees = 0;
        vm.feeId = 0;
        vm.getExchangeRateDetails = function (CountryId, fees, feeId, ExchangeRateCode) {
            vm.dfees = parseFloat(fees);
            vm.feeId = parseInt(feeId);
            $http({
                method: 'GET',
                url: baseUrl + 'getglobalExchangerateByComapny',
                // data: formData,
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            }).success(function (data2) {
              
                var idata = data2;
                if (CountryId > 0) {
                    $('#updatefee').modal('toggle');
                    vm.globalExchangeRateDetails = [];
                    angular.forEach(idata, function (fee, index) {
                        if (fee.DestinationCountryId == CountryId) {
                            vm.globalExchangeRateDetails.push(fee);

                            var SourcecountryData = $filter('filter')(vm.Countries, {
                                CountryId: fee.SourceCountryId,
                            }, true);
                            if (SourcecountryData.length > 0)
                                vm.globalExchangeRateDetails[index].Sourcecountry = SourcecountryData[0].CurrencyCode;

                            var DestinationcountryData = $filter('filter')(vm.Countries, {
                                CountryId: fee.DestinationCountryId,
                            }, true);

                            if (DestinationcountryData.length > 0)
                                vm.globalExchangeRateDetails[index].Destinationcountry = DestinationcountryData[0].CurrencyCode;
                        }
                    });
                    setTimeout(function () {
                        if (ExchangeRateCode != "") {
                            angular.forEach(vm.globalExchangeRateDetails, function (fee, index) {
                                if (fee.Code == ExchangeRateCode) {
                                    $("input[name=chkglobalrate][value=" + fee.GlobalExchangeId + "]").attr("checked", true);
                                    var row = $("input[name=chkglobalrate][value=" + fee.GlobalExchangeId + "]").parent().parent().addClass('selected');
                                }
                            });
                        }
                    }, 500);
                }
            });
        }



        vm.checkvalue = { GlobalExchangeId: 0 };
        vm.updateExchangeRate = function () {
            var gender = document.querySelector('input[name = chkglobalrate]:checked').value;
            var GlobalExchangeraetId = parseInt(gender);
            if (GlobalExchangeraetId > 0 && vm.dfees > 0) {
                var formData = JSON.parse(JSON.stringify({ "GlobalExchangeId": GlobalExchangeraetId, "AutoFees": vm.dfees, "PaymentFeesId": vm.feeId }));
                $http({
                    method: 'POST',
                    url: baseUrl + 'updateglobalExchangerateFees',
                    data: formData,
                    headers: { 'Content-Type': 'application/json; charset=utf-8' }
                })
               .success(function (data) {
                   var idata = data;
                   if (idata.Result == "Sucess") {
                       setTimeout(function () {
                           $('#updatefee').modal('toggle');
                           Alert(1, "! Global exchange rate updated successfully");
                           vm.ReloadData();
                       }, 500);
                   }
               });
            }
            else {
                Alert(2, "! Select a valid exchange rate to update");
            }
        }

        vm.addfees = function () {
            $state.go('app.add_Fees');
        }

        vm.EditFee = function (Id) {
            $state.go('app.Edit_Fees', { PaymentFessId: Id });
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
        vm.FeesModel = { PaymentFessId: "0", CompanyId: "0", SourceCountry: "0", DestinationCountry: "0", FeesType: "0", FeesCategoryId: "0", PayInAgentId: "0", PayOutAgentId: "0", PaymentMethodId: "-1" };
        vm.Companies = [];
        vm.DeliveryMethod = [];
        vm.code = "";
        vm.header = 'Add New';
        vm.Error = "";

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

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompany ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.PaymentMethods = idata;
        });


        vm.FeeType = [{ Feetype: "1", FeeTypeName: "Flat" }, { Feetype: "2", FeeTypeName: "Percentage" }];
        //vm.FeesCategory = [{ FeesCategoryId: "1", FeesCategoryName: "Remittance" }, { FeesCategoryId: "2", FeesCategoryName: "Money transfer cancellation" },
        //    { FeesCategoryId: "3", FeesCategoryName: "Wallet money fund transfer" }, { FeesCategoryId: "4", FeesCategoryName: "Wallet money load cash" },
        //    { FeesCategoryId: "5", FeesCategoryName: "Airtime topup" }, { FeesCategoryId: "6", FeesCategoryName: "Bill" }, { FeesCategoryId: "7", FeesCategoryName: "Wallet money cash out" }
        //];

        //Get Fee Category
        $http({
            method: 'GET',
            url: baseUrl + 'getFeesCategoryDetails',
            headers: { 'Content-Type': 'application/json' }
        })
      .success(function (data) {

          var idata = data;
          vm.FeesCategory = idata;
      });


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
                     vm.FeesModel.PaymentFessId = "" + idata.PaymentFessId;
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
                     vm.FeesModel.PaymentMethodId = "" + idata.PaymentMethodId;
                     vm.FeesModel.ChargeSendingAmount = idata.ChargeSendingAmount
                     vm.FeesModel.EndAmount = idata.EndAmount;
                     vm.FeesModel.StartingAmount = idata.StartingAmount;
                     vm.FeesModel.Fees = +idata.Fees;
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
                //17 18 19 20
                if (vm.FeesModel.PaymentMethodId == "13" || vm.FeesModel.PaymentMethodId == "17" || vm.FeesModel.PaymentMethodId == "18" || vm.FeesModel.PaymentMethodId == "19" || vm.FeesModel.PaymentMethodId == "20") {
                    vm.FeesModel.PayInAgentId = '-1'
                    vm.FeesModel.PayOutAgentId = '-1';
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
                    if (idata && idata.PaymentFessId > 0 && idata.Result == "Sucess") {
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
                vm.FeesModel.Fees = +$('#Fees').val();
                var iData = vm.FeesModel;
                if (vm.FeesModel.PaymentMethodId == "13" || vm.FeesModel.PaymentMethodId == "17" || vm.FeesModel.PaymentMethodId == "18" || vm.FeesModel.PaymentMethodId == "19" || vm.FeesModel.PaymentMethodId == "20") {
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