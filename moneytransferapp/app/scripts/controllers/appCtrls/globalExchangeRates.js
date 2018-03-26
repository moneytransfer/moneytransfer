(function () {
    'use strict';
    angular.module('app')
     .controller('globalExchangeRatesController', globalExchangeRatesController)
    .controller('addEditGlobalExchangeRatesController', addEditGlobalExchangeRatesController)

    globalExchangeRatesController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function globalExchangeRatesController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {
        var vm = $scope;
        var IsAdmin = false;
        vm.UserId = 0;
        vm.CompanyId = 0;
        vm.Companies = [];
        vm.PaymentMethodType = [];
        vm.Countries = [];

        vm.globalExchangeRateDataList = [{ GlobalExchangeId: 0, Company: "", PaymentMethod: "", SourceCountryName: "", DestinationCountryName: "", SpotPrice: "", AutoFees: "", SellSpotPrice: "", SellingExchangeRate: "", GlobalExchangeRate: "", CreatedDate: "", Code: "" }]
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
       $http({
           method: 'GET',
           url: baseUrl + 'getcompanydetails',
           headers: { 'Content-Type': 'application/json' }
       })
    .success(function (data) {
        var idata = data;
        vm.Companies = idata;
        var formData = JSON.parse(JSON.stringify({ "CompanyId": 0 }));



        $http({
            method: 'POST',
            url: baseUrl + 'getglobalExchangerateByComapny',
            data: formData,
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        }).success(function (data2) {
            var idata2 = data2;
            vm.globalExchangeRateDataList = idata2;
            angular.forEach(vm.globalExchangeRateDataList, function (data, index) {
                vm.getOtherData(data, index);
            });

        });
    });






   });




        vm.getOtherData = function (data, i) {
            var Company = $filter('filter')(vm.Companies, {
                CompanyId: data.CompanyId,
            }, true);

            if (Company.length > 0)
                vm.globalExchangeRateDataList[i].Company = Company[0].CompanyName;


            var SourcecountryData = $filter('filter')(vm.Countries, {
                CountryId: data.SourceCountryId,
            }, true);
            if (SourcecountryData.length > 0)
                vm.globalExchangeRateDataList[i].SourceCountryName = SourcecountryData[0].CountryName;

            var DestinationCountry = $filter('filter')(vm.Countries, {
                CountryId: data.DestinationCountryId,
            }, true);
            if (DestinationCountry.length > 0)
                vm.globalExchangeRateDataList[i].DestinationCountryName = DestinationCountry[0].CountryName;
            vm.globalExchangeRateDataList[i].GlobalExchangeRate = toFixed(vm.globalExchangeRateDataList[i].GlobalExchangeRate + "");

        }





        vm.addfees = function () {

            $state.go('app.add_Global_Exchange_Rates');

        }

        vm.EditGlobalExchange = function (GlobalExchangeId) {
            $state.go('app.edit_Global_Exchange_Rates', { GlobalExchangeId: GlobalExchangeId });
        }

        //Delete Confirm
        var DeleteUserID = 0;
        vm.deleteGlobalExchangeRateById = function (Id) {

            DeleteUserID = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var GlobalExchangeId = 0;
            GlobalExchangeId = +DeleteUserID;

            var formData = JSON.parse(JSON.stringify({ "GlobalExchangeId": GlobalExchangeId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deleteglobalExchangerateById',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {

                var idata = data;
                if (idata.GlobalExchangeId > 0 && idata.Result == "Sucess") {
                    Alert(1, "! Global Exchange Rate Deleted Successfully");
                    var iManageUsers = vm.globalExchangeRateDataList;
                    vm.globalExchangeRateDataList = [];
                    for (var i = 0; i < iManageUsers.length; i++) {
                        if (iManageUsers[i].GlobalExchangeId !== DeleteUserID) vm.globalExchangeRateDataList.push(iManageUsers[i]);
                    }
                }
            });
        }

        vm.setDisabled = function (id, IsActive) {


            var formData = JSON.parse(JSON.stringify({ "GlobalExchangeId": id, "IsActive": IsActive }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'enableDisableglobalExchangerate',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            }).success(function (data) {
                var idata = data;
                if (idata.Result == "Success") {
                    angular.forEach(vm.globalExchangeRateDataList, function (item) {
                        if (item.GlobalExchangeId == idata.GlobalExchangeId) {
                            item.IsActive = idata.IsActive
                        }
                    });
                } else {
                    alert(2, idata.Result);
                }

            });
        }




        function toFixed(num) {

            return num.slice(0, (num.indexOf(".")) + 3);
        }


    }

    addEditGlobalExchangeRatesController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function addEditGlobalExchangeRatesController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {
        var vm = $scope;
        vm.header = 'Add New';
        vm.Companies = [];
        vm.Countries = [];
        vm.Error = "";
        vm.TemporaryGlobalExchangeRate = {};
        vm.globalExchangeRateData = { GlobalExchangeId: 0, CompanyId: 17, SourceCountry: "", DestinationCountry: "", PaymentMethod: "-1", IsActive: true }
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

        //getDelivery Method
        vm.selectedCompany = function (companyId) {
            vm.getFeesDetails();
        }




        if ($stateParams.GlobalExchangeId) {
            vm.header = 'Update';
            var iGlobalExchangeId = 0;
            iGlobalExchangeId = $stateParams.GlobalExchangeId;
            var formData = JSON.parse(JSON.stringify({ "GlobalExchangeId": iGlobalExchangeId }));
            $http({
                method: 'POST',
                url: baseUrl + 'globalExchangerateById',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
           .success(function (data) {

               var idata = data;
               if (idata && idata.Result == "Sucess") {
                   vm.globalExchangeRateData = idata;
                   if (vm.globalExchangeRateData.IsActive) {
                       $('#disabledBtn').css("z-index", '');
                   } else {
                       $('#disabledBtn').css("z-index", 4);
                   }


                   vm.globalExchangeRateData.GlobalExchangeId = idata.GlobalExchangeId;
                   vm.globalExchangeRateData.CompanyId = "" + idata.CompanyId;
                   vm.globalExchangeRateData.PaymentMethod = idata.PaymentMethod;
                   vm.globalExchangeRateData.SourceCountry = "" + idata.SourceCountryId;
                   vm.globalExchangeRateData.DestinationCountry = "" + idata.DestinationCountryId;
                   vm.globalExchangeRateData.BaseCurrency = idata.SpotPrice;
                   vm.TemporaryGlobalExchangeRate.SpotPrice ="1"+" "+ idata.SpotPrice;
                   vm.getToCurrency(vm.globalExchangeRateData.DestinationCountry);


               }
           });
        }





        //GetBase Courency
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
          vm.globalExchangeRateData.BaseCurrency = idata.CurrencyCode;

          vm.TemporaryGlobalExchangeRate.SpotPrice = 1 + " " + vm.globalExchangeRateData.BaseCurrency;
          vm.getFeesDetails();
      });
        }

        //Get To Courrency
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
          vm.globalExchangeRateData.ToCurrency = idata.CurrencyCode;
          ConvertMoney(vm.globalExchangeRateData.ToCurrency);
          vm.getFeesDetails();
      });
        }


        //getExchangerate 
        function ConvertMoney(code) {
            if (code) {
                var accesstoken = 'rxv51rk8b4y1kjhasvww';
                $http({
                    url: 'https://currencydatafeed.com/api/converter.php?' + $.param({ token: accesstoken, from: "USD", to: code, amount: "1" }),
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                    .success(function (data) {

                        var idata = data;
                        if (idata.currency[0].value > 0) {
                            var value = parseFloat(idata.currency[0].value).toFixed(2);
                            vm.globalExchangeRateData.SellSpotPrice = parseFloat(value);
                            $('#exchnageRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                            if (vm.globalExchangeRateData.SellingExchangeRate) {
                                var RatePercant = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                                vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + RatePercant;
                                var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                                $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                                vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + " " + vm.globalExchangeRateData.ToCurrency;
                                vm.TemporaryGlobalExchangeRate.RatePercant = "" + parseFloat(RatePercant).toFixed(2);
                            } else {
                                vm.globalExchangeRateData.SellingExchangeRate = "0.00";
                                vm.globalExchangeRateData.GlobalExchangeRate = vm.globalExchangeRateData.SellSpotPrice;
                                $('#globalExchangeRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                                vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.GlobalExchangeRate + " " + vm.globalExchangeRateData.ToCurrency;
                                vm.TemporaryGlobalExchangeRate.RatePercant = "0.00";
                            }
                            ConvertMoneyMargin(code, vm.TemporaryGlobalExchangeRate.RatePercant);

                        }
                        else {
                            vm.globalExchangeRateData.SellingExchangeRate = "0.00";
                            vm.globalExchangeRateData.GlobalExchangeRate = "";
                            vm.globalExchangeRateData.SellSpotPrice = "";
                            vm.Error = "!sorry we can't proceed. ";
                            $('#deleteconfirm').modal('show');
                        }
                    });
            } else {
                vm.Error = "";

                vm.Error = "!sorry we can't proceed. ";
                $('#deleteconfirm').modal('show');

                vm.globalExchangeRateData.SellSpotPrice = "0.00";
                $('#exchnageRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                return 0;
            }

        }

        //To Get Exchange rate margin profit in USD
        function ConvertMoneyMargin(code, amount) {
            if (amount.startsWith("-")) {
                var amount = amount.substr(1);
            }
            if (code) {
                var accesstoken = 'rxv51rk8b4y1kjhasvww';
                $http({
                    url: 'https://currencydatafeed.com/api/converter.php?' + $.param({ token: accesstoken, from: code, to: "USD", amount: amount }),
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                    .success(function (data) {
                        var idata = data;
                        if (idata.currency[0].value > 0) {
                            var value = parseFloat(idata.currency[0].value).toFixed(2);
                            vm.TemporaryGlobalExchangeRate.MarginAmount = value + " " + "USD";
                        }
                        else { vm.TemporaryGlobalExchangeRate.MarginAmount = '0.00' + " " + "USD"; }

                    });
            }
        }


        vm.AddSellingExchangeRate = function (value) {

            if (value) {
                var data = .10 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    if (data == 0) {
                        vm.globalExchangeRateData.GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice));
                        $('#globalExchangeRate').val(vm.globalExchangeRateData.GlobalExchangeRate + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.GlobalExchangeRate + " " + vm.globalExchangeRateData.ToCurrency;
                        vm.TemporaryGlobalExchangeRate.RatePercant = "0.00" + " " + vm.globalExchangeRateData.ToCurrency;
                    } else {
                        var RatePercant = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                        vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + RatePercant;
                        var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                        $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + " " + vm.globalExchangeRateData.ToCurrency;
                        vm.TemporaryGlobalExchangeRate.RatePercant = "" + parseFloat(RatePercant).toFixed(2) + " " + vm.globalExchangeRateData.ToCurrency;
                        ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(RatePercant).toFixed(2));
                       
                    }
                }

            } else {
                vm.globalExchangeRateData.SellingExchangeRate = "0";
                var data = .10 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    var RatePercant = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                    vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + RatePercant;
                    var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                    $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                    vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + vm.globalExchangeRateData.ToCurrency;
                    vm.TemporaryGlobalExchangeRate.RatePercant = "" + parseFloat(RatePercant).toFixed(2) + " " + vm.globalExchangeRateData.ToCurrency;
                }

            }


        }




        vm.LessSellingExchangeRate = function (value) {

            if (value) {
                var data = parseFloat(vm.globalExchangeRateData.SellingExchangeRate) - .10;
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    if (data == 0) {
                        vm.globalExchangeRateData.GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice));
                        $('#globalExchangeRate').val(vm.globalExchangeRateData.GlobalExchangeRate + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.GlobalExchangeRate + " " + vm.globalExchangeRateData.ToCurrency;
                        vm.TemporaryGlobalExchangeRate.RatePercant = "0.00" + " " + vm.globalExchangeRateData.ToCurrency;


                       
                    } else {
                        var RatePercant = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                        vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + RatePercant;
                        var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                        $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + " " + vm.globalExchangeRateData.ToCurrency;


                        if (RatePercant.toString().startsWith("-")) {
                            var RatePercant = RatePercant.toString().substr(1);
                        }
                        vm.TemporaryGlobalExchangeRate.RatePercant = "" + parseFloat(RatePercant).toFixed(2) + " " + vm.globalExchangeRateData.ToCurrency;
                        ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(RatePercant).toFixed(2));
                    }
                }

            } else {
                vm.globalExchangeRateData.SellingExchangeRate = "0";
                var data = parseFloat(vm.globalExchangeRateData.SellingExchangeRate) - .10;
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    var RatePercant = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                    vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + RatePercant;
                    var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                    $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                    vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + vm.globalExchangeRateData.ToCurrency;
                    if (RatePercant.startsWith("-")) {
                        var RatePercant = RatePercant.substr(1);
                    }
                    vm.TemporaryGlobalExchangeRate.RatePercant = "" + parseFloat(RatePercant).toFixed(2) + " " + vm.globalExchangeRateData.ToCurrency;
                    ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(RatePercant).toFixed(2));
                }

            }

        }



        vm.getFee = function () {

            vm.getFeesDetails();
        }

        vm.getFeesDetails = function () {

            if (vm.globalExchangeRateData.CompanyId != "0" && vm.globalExchangeRateData.SourceCountry != "0" && vm.globalExchangeRateData.DestinationCountry != "0" && vm.globalExchangeRateData.PaymentMethod != "-1") {
                var formData = JSON.parse(JSON.stringify({ "CompanyId": parseInt(vm.globalExchangeRateData.CompanyId), "PaymentMethod": vm.globalExchangeRateData.PaymentMethod, "SourceCountry": parseInt(vm.globalExchangeRateData.SourceCountry), "DestinationCountry": parseInt(vm.globalExchangeRateData.DestinationCountry) }));
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'globalExchangerateFees ',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' }
                })
     .success(function (data) {
         if (data.Result == "Sucess") {
             var idata = data;
             vm.globalExchangeRateData.AutoFees = "" + data.Fees;
         } else {
             vm.globalExchangeRateData.AutoFees = "0";


         }


     });

            } else {
                vm.globalExchangeRateData.AutoFees = "0";
                return 0;
            }
        }
        vm.SaveGlobalExcahangeRate = function () {
          
            if ($stateParams.GlobalExchangeId) {

                var formData = JSON.parse(JSON.stringify({ "GlobalExchangeId": vm.globalExchangeRateData.GlobalExchangeId, "PaymentMethod": vm.globalExchangeRateData.PaymentMethod, "CompanyId": vm.globalExchangeRateData.CompanyId, "SourceCountryId": vm.globalExchangeRateData.SourceCountry, "DestinationCountryId": vm.globalExchangeRateData.DestinationCountry, "SpotPrice": vm.globalExchangeRateData.BaseCurrency, "AutoFees": vm.globalExchangeRateData.AutoFees, "SellSpotPrice": vm.globalExchangeRateData.SellSpotPrice, "SellingExchangeRate": vm.globalExchangeRateData.SellingExchangeRate, "GlobalExchangeRate": vm.globalExchangeRateData.GlobalExchangeRate, "IsActive": vm.globalExchangeRateData.IsActive }));
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'globalExchangerate',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                 .success(function (data) {

                     var idata = data;
                     if (idata && idata.Result == "Success") {
                         Alert(1, "! Global Exchange Rates Updated successfully");
                         setTimeout(function () {
                             $state.go('app.GlobalExchangeRates');
                         }, 1000);
                     }
                     else {

                         vm.Error = idata.Error;
                         $('#deleteconfirm').modal('show');
                     }
                 });
            } else {

                var formData = JSON.parse(JSON.stringify({ "PaymentMethod": vm.globalExchangeRateData.PaymentMethod, "CompanyId": vm.globalExchangeRateData.CompanyId, "SourceCountryId": vm.globalExchangeRateData.SourceCountry, "DestinationCountryId": vm.globalExchangeRateData.DestinationCountry, "SpotPrice": vm.globalExchangeRateData.BaseCurrency, "AutoFees": vm.globalExchangeRateData.AutoFees, "SellSpotPrice": vm.globalExchangeRateData.SellSpotPrice, "SellingExchangeRate": vm.globalExchangeRateData.SellingExchangeRate, "GlobalExchangeRate": vm.globalExchangeRateData.GlobalExchangeRate, "IsActive": vm.globalExchangeRateData.IsActive }));
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'globalExchangerate',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                       .success(function (data) {

                           var idata = data;
                           if (idata && idata.Result == "Success") {
                               Alert(1, "! Global Exchange Rates created successfully");
                               setTimeout(function () {
                                   $state.go('app.GlobalExchangeRates');
                               }, 1000);
                           }
                           else {

                               vm.Error = idata.Error;
                               $('#deleteconfirm').modal('show');

                               //Alert(2, idata.Error);
                           }
                       });
            }

        }

        vm.setDisabled = function () {
            vm.globalExchangeRateData.IsActive = false;
            $('#disabledBtn').css("z-index", 4);
        }

        vm.setEnabled = function () {
            vm.globalExchangeRateData.IsActive = true;
            $('#disabledBtn').css("z-index", '');
        }


        function toFixed(num) {
            return num.slice(0, (num.indexOf(".")) + 3);
        }


    }
})();