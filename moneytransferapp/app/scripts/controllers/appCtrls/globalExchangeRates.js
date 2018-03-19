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
        vm.globalExchangeRateDataList = [{ GlobalExchangeId:0,Company: "", PaymentMethod: "", SourceCountryName: "", DestinationCountryName: "", SpotPrice: "", AutoFees: "", SellSpotPrice: "", SellingExchangeRate: "", GlobalExchangeRate: "", CreatedDate: "", Code: "" }]
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
            url: baseUrl + 'getpaymentmethodbycompanyid',
            data: formData,
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
         .success(function (data1) {

             var idata1 = data1;
             vm.PaymentMethodType = idata1;


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
   });


       

        vm.getOtherData = function (data, i) {
            var PaymethodData = $filter('filter')(vm.PaymentMethodType, {
                PaymentMethodId: data.PaymentMethodId,
            }, true);
            if (PaymethodData.length > 0)
                vm.globalExchangeRateDataList[i].PaymentMethod = PaymethodData[0].Title;
            

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
            debugger
            var DestinationCountry = $filter('filter')(vm.Countries, {
                CountryId: data.DestinationCountryId,
            }, true);
            if (DestinationCountry.length > 0)
                vm.globalExchangeRateDataList[i].DestinationCountryName = DestinationCountry[0].CountryName;



        }





        vm.addfees = function () {
            debugger
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
                debugger;
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







    }

    addEditGlobalExchangeRatesController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function addEditGlobalExchangeRatesController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {
        var vm = $scope;
        vm.header = 'Add New';
        vm.Companies = [];
        vm.Countries = [];
        vm.Error = "";
        vm.globalExchangeRateData = { GlobalExchangeId:0, CompanyId: "", SourceCountry: "", DestinationCountry: "", PaymentMethodId: "" }
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
            var iComapnyId = parseInt(companyId);

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
        vm.getFeesDetails();
      });

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
               debugger
               var idata = data;
               if (idata && idata.Result == "Sucess") {
                   vm.globalExchangeRateData = idata;
                   vm.globalExchangeRateData.GlobalExchangeId = idata.GlobalExchangeId;
                   vm.globalExchangeRateData.CompanyId = "" + idata.CompanyId;
                   vm.selectedCompany(vm.globalExchangeRateData.CompanyId);
                   vm.globalExchangeRateData.PaymentMethodId = "" + idata.PaymentMethodId;
                   vm.globalExchangeRateData.SourceCountry = "" + idata.SourceCountryId;
                   vm.globalExchangeRateData.DestinationCountry = "" + idata.DestinationCountryId;
                   vm.globalExchangeRateData.BaseCurrency = idata.SpotPrice;
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
                            vm.globalExchangeRateData.SellSpotPrice = Math.round(value);
                            $('#exchnageRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);

                        }
                        else {


                            setTimeout(function () {
                                Alert(2, "!sorry we can't proceed. ");
                            }, 100);
                            vm.globalExchangeRateData.SellSpotPrice = "0.00";
                            $('#exchnageRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                        }
                    });
            } else {

                setTimeout(function () {
                    Alert(2, "!sorry we can't proceed. ");
                }, 100);
                vm.globalExchangeRateData.SellSpotPrice = "0.00";
                $('#exchnageRate').val(vm.globalExchangeRateData.SellSpotPrice + ' ' + vm.globalExchangeRateData.ToCurrency);
                return 0;
            }
            
        }
        vm.AddSellingExchangeRate = function (value) {
          
            if (value) {
                var data = .01 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
            } else {
                vm.globalExchangeRateData.SellingExchangeRate = "0";
                var data = .01 + parseFloat(vm.globalExchangeRateData.SellingExchangeRate);
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);

            }

           
        }
        vm.LessSellingExchangeRate = function (value) {

            if (value) {
                var data = parseFloat(vm.globalExchangeRateData.SellingExchangeRate) - .01;
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);
            } else {
                vm.globalExchangeRateData.SellingExchangeRate = "0";
                var data = parseFloat(vm.globalExchangeRateData.SellingExchangeRate) - .01;
                vm.globalExchangeRateData.SellingExchangeRate = "" + data.toFixed(2);

            }

        }

        vm.getFee = function () {
            vm.getFeesDetails();
        }

        vm.getFeesDetails = function () {
            debugger;
            if (vm.globalExchangeRateData.CompanyId != "0" && vm.globalExchangeRateData.SourceCountry != "0" && vm.globalExchangeRateData.DestinationCountry != "0" && vm.globalExchangeRateData.PaymentMethodId != "-1") {
                var formData = JSON.parse(JSON.stringify({ "CompanyId": parseInt(vm.globalExchangeRateData.CompanyId), "PaymentMethodId": parseInt(vm.globalExchangeRateData.PaymentMethodId), "SourceCountry": parseInt(vm.globalExchangeRateData.SourceCountry), "DestinationCountry": parseInt(vm.globalExchangeRateData.DestinationCountry) }));
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
             vm.globalExchangeRateData.AutoFees = "";
             Alert(2, "No fee record found for this destination country !");
         }
        
       
     });
               
            } else {
                vm.globalExchangeRateData.AutoFees = "";
                return 0;
            }
        }
        vm.SaveGlobalExcahangeRate = function () {
            if ($stateParams.GlobalExchangeId) {
                var GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) + parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                vm.globalExchangeRateData.GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) + GlobalExchangeRate).toFixed(2);
                var formData = JSON.parse(JSON.stringify({"GlobalExchangeId":vm.globalExchangeRateData.GlobalExchangeId, "PaymentMethodId": vm.globalExchangeRateData.PaymentMethodId, "CompanyId": vm.globalExchangeRateData.CompanyId, "SourceCountryId": vm.globalExchangeRateData.SourceCountry, "DestinationCountryId": vm.globalExchangeRateData.DestinationCountry, "SpotPrice": vm.globalExchangeRateData.BaseCurrency, "AutoFees": vm.globalExchangeRateData.AutoFees, "SellSpotPrice": vm.globalExchangeRateData.SellSpotPrice, "SellingExchangeRate": vm.globalExchangeRateData.SellingExchangeRate, "GlobalExchangeRate": vm.globalExchangeRateData.GlobalExchangeRate, "IsActive": vm.globalExchangeRateData.IsActive }));
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
                         Alert(2, idata.Error);
                     }
                 });
            }else{
                var GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) + parseFloat(vm.globalExchangeRateData.SellingExchangeRate)) / 100;
                vm.globalExchangeRateData.GlobalExchangeRate = (parseFloat(vm.globalExchangeRateData.SellSpotPrice) + GlobalExchangeRate).toFixed(2);
            
                var formData = JSON.parse(JSON.stringify({ "PaymentMethodId": vm.globalExchangeRateData.PaymentMethodId, "CompanyId": vm.globalExchangeRateData.CompanyId, "SourceCountryId": vm.globalExchangeRateData.SourceCountry, "DestinationCountryId": vm.globalExchangeRateData.DestinationCountry, "SpotPrice": vm.globalExchangeRateData.BaseCurrency, "AutoFees": vm.globalExchangeRateData.AutoFees, "SellSpotPrice": vm.globalExchangeRateData.SellSpotPrice, "SellingExchangeRate": vm.globalExchangeRateData.SellingExchangeRate, "GlobalExchangeRate": vm.globalExchangeRateData.GlobalExchangeRate, "IsActive": vm.globalExchangeRateData.IsActive }));
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


    }
})();