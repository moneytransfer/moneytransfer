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

        vm.PayM = "";
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
         });

        $http({
            method: 'GET',
            url: baseUrl + 'getcompanydetails',
            headers: { 'Content-Type': 'application/json' }
        })
         .success(function (data) {
             var idata = data;
             vm.Companies = idata;
             // var formData = JSON.parse(JSON.stringify({ "CompanyId": 0 }));
         });

        setTimeout(function () {
            vm.LoadGlobalExchangeRate();
        }, 1000);

        //Load Global Exchange Rate
        vm.LoadGlobalExchangeRate = function () {
            //Update Exchange Rate
            vm.updateRate();
            //Load Updated Data
            setTimeout(function () {
                $http({
                    method: 'GET',
                    url: baseUrl + 'getglobalExchangerateByComapny',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' }
                }).success(function (data2) {
                    var idata2 = data2;
                    vm.globalExchangeRateDataList = idata2;
                    angular.forEach(vm.globalExchangeRateDataList, function (data, index) {
                        vm.getOtherData(data, index);
                        //vm.updateRate(data);
                    });
                });
            }, 500);
        }





        //DestinationCountryId
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
            vm.globalExchangeRateDataList[i].BaseCurrency = DestinationCountry[0].CurrencyCode;
            vm.globalExchangeRateDataList[i].GlobalExchangeRate = toFixed(vm.globalExchangeRateDataList[i].GlobalExchangeRate + "");

            var Payment = $filter('filter')(vm.PaymentMethods, {
                PaymentMethodId: data.PaymentMethodId,
            }, true);

            if (Payment.length > 0)
                vm.globalExchangeRateDataList[i].Payment = Payment[0].Title;

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
        //End Delete

        //Set Disabled
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

        //Update globalExchange Rate
        //Get Curency Code
        vm.updateRate = function () {

            $http({
                method: 'GET',
                url: baseUrl + 'getglobalExchangerateByComapny',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            }).success(function (data2) {
                var idata2 = data2;
                vm.globalExchange = idata2;
                angular.forEach(vm.globalExchange, function (data, index) {
                    var SourcecountryData = $filter('filter')(vm.Countries, {
                        CountryId: data.DestinationCountryId,
                    }, true);

                    if (SourcecountryData.length > 0)
                        vm.CountryCode = SourcecountryData[0].CurrencyCode;

                    UpdateglobalExchange(vm.CountryCode, data.DestinationCountryId);

                });
            });
        }

        //Update globalExchange Rate
        function UpdateglobalExchange(code, DestinationCountryId) {
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
                        var value = parseFloat(idata.currency[0].value).toFixed(2)
                        var SellSpotPrice = value;
                        var formData = JSON.parse(JSON.stringify({ "DestinationCountryId": DestinationCountryId, "SellSpotPrice": SellSpotPrice }));
                        $http({
                            method: 'POST',
                            url: baseUrl + 'updateRealfeesglobalExchangerate',
                            data: formData,
                            headers: { 'Content-Type': 'application/json; charset=utf-8' }
                        })
                        .success(function (data) {

                            var idata = data;
                        });
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
        vm.globalExchangeRateData = { GlobalExchangeId: 0, SourceCountryId: "", DestinationCountryId: "", PaymentMethodId: "-1", IsActive: true, SpotMarginUSDCurrency: '0.00' }



        if ($window.sessionStorage.authorisedUser) {

            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) {
                vm.UserId = parseInt(authorisedUser.UserId);
                vm.CompanyId = parseInt(authorisedUser.CompanyId);
            }
        }

        //Get Payment Methods
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
                   vm.globalExchangeRateData.PaymentMethodId = "" + idata.PaymentMethodId;
                   vm.globalExchangeRateData.SourceCountryId = "" + idata.SourceCountryId;
                   vm.globalExchangeRateData.DestinationCountryId = "" + idata.DestinationCountryId;
                   vm.globalExchangeRateData.BaseCurrency = idata.SpotPrice;
                   vm.TemporaryGlobalExchangeRate.SpotPrice = "1" + " " + idata.SpotPrice;
                   vm.getToCurrency(vm.globalExchangeRateData.DestinationCountryId);


                   // ConvertMoneyMargin(vm.globalExchangeRateData.DestinationCountry, amount)
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
                if (vm.globalExchangeRateData.GlobalExchangeId > 0) {
                    $('#exchnageRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                    $('#globalExchangeRate').val(vm.globalExchangeRateData.GlobalExchangeRate + ' ' + vm.globalExchangeRateData.ToCurrency);
                }
                else { ConvertMoney(vm.globalExchangeRateData.ToCurrency); }
                // 

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
                            var value = parseFloat(idata.currency[0].value).toFixed(4);
                            vm.globalExchangeRateData.SellSpotPrice = parseFloat(value);
                            $('#exchnageRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                            if (vm.globalExchangeRateData.SellingExchangeRate) {
                                var SpotMarginBaseCurrency = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                                vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + SpotMarginBaseCurrency;
                                var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                                $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                                vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + " " + vm.globalExchangeRateData.ToCurrency;

                                if (SpotMarginBaseCurrency.toString().startsWith("-")) {
                                    var SpotMarginBaseCurrency = SpotMarginBaseCurrency.toString().substr(1);
                                }
                                vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                            } else {
                                vm.globalExchangeRateData.SellingExchangeRate = "0.00";
                                vm.globalExchangeRateData.GlobalExchangeRate = vm.globalExchangeRateData.SellSpotPrice;
                                $('#globalExchangeRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                                vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.GlobalExchangeRate + " " + vm.globalExchangeRateData.ToCurrency;
                                vm.globalExchangeRateData.SpotMarginBaseCurrency = "0.00";
                            }
                            vm.globalExchangeRateData.SpotMarginBaseCurrency = "0.00";
                            ConvertMoneyMargin(code, vm.globalExchangeRateData.SpotMarginBaseCurrency);

                        }
                        else {
                            vm.globalExchangeRateData.SellingExchangeRate = "0.00";
                            vm.globalExchangeRateData.GlobalExchangeRate = "";
                            vm.globalExchangeRateData.SellSpotPrice = "";
                            vm.Error = "!Sorry we don't support this Destination country. ";
                            $('#deleteconfirm').modal('show');
                        }
                    });
            } else {
                vm.Error = "";

                vm.Error = "!Sorry we don't support this Destination country. ";
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
                        vm.globalExchangeRateData.SpotMarginUSDCurrency = '0.00';
                        var idata = data;
                        if (idata.currency[0].value > 0) {
                            var value = parseFloat(idata.currency[0].value).toFixed(4);
                            vm.globalExchangeRateData.SpotMarginUSDCurrency = value;
                        }
                        else { vm.globalExchangeRateData.SpotMarginUSDCurrency = '0.00'; }

                    });
            }
        }

        //On Add button click
        vm.AddSellingExchangeRate = function (value) {

            if (value != " " && value !== undefined && value != null) {
                var data = .10 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    if (data == 0) {
                        vm.globalExchangeRateData.GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice));
                        $('#globalExchangeRate').val(vm.globalExchangeRateData.GlobalExchangeRate + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.GlobalExchangeRate + " " + vm.globalExchangeRateData.ToCurrency;
                        //vm.globalExchangeRateData.SpotMarginBaseCurrency = "0.00" + " " + vm.globalExchangeRateData.ToCurrency;
                        vm.globalExchangeRateData.SpotMarginBaseCurrency = "0.00";
                    } else {
                        var SpotMarginBaseCurrency = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                        vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + SpotMarginBaseCurrency;
                        var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                        $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + " " + vm.globalExchangeRateData.ToCurrency;
                        if (SpotMarginBaseCurrency.toString().startsWith("-")) {
                            var SpotMarginBaseCurrency = SpotMarginBaseCurrency.toString().substr(1);
                        }

                        vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                        ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(SpotMarginBaseCurrency).toFixed(4));
                    }
                }

            } else {
                vm.globalExchangeRateData.SellingExchangeRate = "0";
                var data = .10 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    var SpotMarginBaseCurrency = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                    vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + SpotMarginBaseCurrency;
                    var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                    $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                    vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + vm.globalExchangeRateData.ToCurrency;
                    if (SpotMarginBaseCurrency.toString().startsWith("-")) {
                        var SpotMarginBaseCurrency = SpotMarginBaseCurrency.toString().substr(1);
                    }

                    vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                }

            }


        }

        //On Minus button click
        vm.LessSellingExchangeRate = function (value) {

            if (value != " " && value !== undefined && value != null) {
                var data = parseFloat(vm.globalExchangeRateData.SellingExchangeRate) - .10;
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    if (data == 0) {
                        vm.globalExchangeRateData.GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice));
                        $('#globalExchangeRate').val(vm.globalExchangeRateData.GlobalExchangeRate + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.GlobalExchangeRate + " " + vm.globalExchangeRateData.ToCurrency;
                        vm.globalExchangeRateData.SpotMarginBaseCurrency = "0.00";



                    } else {
                        var SpotMarginBaseCurrency = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                        vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + SpotMarginBaseCurrency;
                        var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                        $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + " " + vm.globalExchangeRateData.ToCurrency;


                        if (SpotMarginBaseCurrency.toString().startsWith("-")) {
                            var SpotMarginBaseCurrency = SpotMarginBaseCurrency.toString().substr(1);
                        }
                        vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                        ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(SpotMarginBaseCurrency).toFixed(4));
                    }
                }

            } else {
                vm.globalExchangeRateData.SellingExchangeRate = "0";
                var data = parseFloat(vm.globalExchangeRateData.SellingExchangeRate) - .10;
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    var SpotMarginBaseCurrency = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                    vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + SpotMarginBaseCurrency;
                    var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                    $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                    vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + vm.globalExchangeRateData.ToCurrency;
                    if (SpotMarginBaseCurrency.startsWith("-")) {
                        var SpotMarginBaseCurrency = SpotMarginBaseCurrency.substr(1);
                    }
                    vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                    ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(SpotMarginBaseCurrency).toFixed(4));
                }

            }

        }

        //On text change
        vm.AddManualSellingExchangeRate = function (value) {
            //
            //var result = parseFloat(value);
            var result = value;

            if (result != '' && result !== undefined && result != null) {
                //var data = .10 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                vm.globalExchangeRateData.SellingExchangeRate = "" + result;
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    if (result == 0) {
                        vm.globalExchangeRateData.GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice));
                        $('#globalExchangeRate').val(vm.globalExchangeRateData.GlobalExchangeRate + ' ' + vm.globalExchangeRateData.ToCurrency);
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.GlobalExchangeRate + " " + vm.globalExchangeRateData.ToCurrency;
                        vm.globalExchangeRateData.SpotMarginBaseCurrency = "0.00";
                    }
                    else {
                        var SpotMarginBaseCurrency = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                        vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + SpotMarginBaseCurrency;
                        if (!isNaN(vm.globalExchangeRateData.GlobalExchangeRate) && vm.globalExchangeRateData.GlobalExchangeRate !== undefined) {
                            var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                            $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                        }
                        else {
                            $('#globalExchangeRate').val("0.00" + ' ' + vm.globalExchangeRateData.ToCurrency);
                        }
                        vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + " " + vm.globalExchangeRateData.ToCurrency;

                        if (SpotMarginBaseCurrency.toString().startsWith("-")) {
                            var SpotMarginBaseCurrency = SpotMarginBaseCurrency.toString().substr(1);
                        }
                        if (!isNaN(SpotMarginBaseCurrency)) {
                            vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                            ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(SpotMarginBaseCurrency).toFixed(4));
                        }
                        else {
                            SpotMarginBaseCurrency = '0.00';

                            vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                            ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(SpotMarginBaseCurrency).toFixed(4));
                        }


                    }
                }

            } else {
                vm.globalExchangeRateData.SellingExchangeRate = " ";
                //var data = .10 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                // vm.globalExchangeRateData.SellingExchangeRate = "" + result;
                if (vm.globalExchangeRateData.SellSpotPrice && vm.globalExchangeRateData.SellSpotPrice != '0.00') {
                    if (vm.globalExchangeRateData.SellingExchangeRate != '' && vm.globalExchangeRateData.SellingExchangeRate != null) {
                        var SpotMarginBaseCurrency = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) * parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                        vm.globalExchangeRateData.GlobalExchangeRate = parseFloat(vm.globalExchangeRateData.SellSpotPrice) + SpotMarginBaseCurrency;
                    }
                    if (!isNaN(vm.globalExchangeRateData.GlobalExchangeRate) && vm.globalExchangeRateData.GlobalExchangeRate !== undefined) {
                        var TempValue = toFixed(vm.globalExchangeRateData.GlobalExchangeRate + "");
                        $('#globalExchangeRate').val(TempValue + ' ' + vm.globalExchangeRateData.ToCurrency);
                    }
                    else {
                        $('#globalExchangeRate').val("0.00" + ' ' + vm.globalExchangeRateData.ToCurrency);
                    }
                    vm.TemporaryGlobalExchangeRate.SellProfitMargin = vm.globalExchangeRateData.SellSpotPrice + vm.globalExchangeRateData.ToCurrency;
                    if (SpotMarginBaseCurrency.toString().startsWith("-")) {
                        var SpotMarginBaseCurrency = SpotMarginBaseCurrency.toString().substr(1);
                    }
                    if (!isNaN(SpotMarginBaseCurrency)) {
                        vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                        ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(SpotMarginBaseCurrency).toFixed(4));
                    }
                    else {
                        SpotMarginBaseCurrency = '0.00';

                        vm.globalExchangeRateData.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                        ConvertMoneyMargin(vm.globalExchangeRateData.ToCurrency, parseFloat(SpotMarginBaseCurrency).toFixed(4));
                    }
                    vm.TemporaryGlobalExchangeRate.SpotMarginBaseCurrency = "" + parseFloat(SpotMarginBaseCurrency).toFixed(4);
                }
            }

        }

        vm.getFee = function () {

            vm.getFeesDetails();
        }

        //Get Fee details
        vm.getFeesDetails = function () {

            if (vm.globalExchangeRateData.SourceCountry != "0" && vm.globalExchangeRateData.DestinationCountry != "0" && vm.globalExchangeRateData.PaymentMethod != "-1") {
                var formData = JSON.parse(JSON.stringify({ "PaymentMethodId": vm.globalExchangeRateData.PaymentMethodId, "SourceCountry": parseInt(vm.globalExchangeRateData.SourceCountryId), "DestinationCountry": parseInt(vm.globalExchangeRateData.DestinationCountryId) }));
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

        //Save Global Exchange Rate
        vm.SaveGlobalExcahangeRate = function () {

            if ($stateParams.GlobalExchangeId) {

                // var formData = JSON.parse(JSON.stringify({ "GlobalExchangeId": vm.globalExchangeRateData.GlobalExchangeId, "PaymentMethod": vm.globalExchangeRateData.PaymentMethod, "SourceCountryId": vm.globalExchangeRateData.SourceCountry, "DestinationCountryId": vm.globalExchangeRateData.DestinationCountry, "SpotPrice": vm.globalExchangeRateData.BaseCurrency, "AutoFees": vm.globalExchangeRateData.AutoFees, "SellSpotPrice": vm.globalExchangeRateData.SellSpotPrice, "SellingExchangeRate": vm.globalExchangeRateData.SellingExchangeRate, "GlobalExchangeRate": vm.globalExchangeRateData.GlobalExchangeRate, "IsActive": vm.globalExchangeRateData.IsActive }));
                var formData = JSON.parse(JSON.stringify({
                    "GlobalExchangeId": vm.globalExchangeRateData.GlobalExchangeId,
                    "PaymentMethodId": vm.globalExchangeRateData.PaymentMethodId, "SourceCountryId": vm.globalExchangeRateData.SourceCountryId, "DestinationCountryId": vm.globalExchangeRateData.DestinationCountryId,
                    "SpotPrice": vm.globalExchangeRateData.BaseCurrency, "AutoFees": vm.globalExchangeRateData.AutoFees, "SellSpotPrice": vm.globalExchangeRateData.SellSpotPrice, "SellingExchangeRate": vm.globalExchangeRateData.SellingExchangeRate, "GlobalExchangeRate": vm.globalExchangeRateData.GlobalExchangeRate, "IsActive": vm.globalExchangeRateData.IsActive
                      , "SpotMarginBaseCurrency": vm.globalExchangeRateData.SpotMarginBaseCurrency, "SpotMarginUSDCurrency": vm.globalExchangeRateData.SpotMarginUSDCurrency
                }));
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
                var formData = JSON.parse(JSON.stringify({
                    "PaymentMethodId": vm.globalExchangeRateData.PaymentMethodId, "SourceCountryId": vm.globalExchangeRateData.SourceCountryId, "DestinationCountryId": vm.globalExchangeRateData.DestinationCountryId,
                    "SpotPrice": vm.globalExchangeRateData.BaseCurrency, "AutoFees": vm.globalExchangeRateData.AutoFees, "SellSpotPrice": vm.globalExchangeRateData.SellSpotPrice, "SellingExchangeRate": vm.globalExchangeRateData.SellingExchangeRate, "GlobalExchangeRate": vm.globalExchangeRateData.GlobalExchangeRate, "IsActive": vm.globalExchangeRateData.IsActive
                    , "SpotMarginBaseCurrency": vm.globalExchangeRateData.SpotMarginBaseCurrency, "SpotMarginUSDCurrency": vm.globalExchangeRateData.SpotMarginUSDCurrency
                }));
                //var formData = JSON.stringify(vm.globalExchangeRateData);
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