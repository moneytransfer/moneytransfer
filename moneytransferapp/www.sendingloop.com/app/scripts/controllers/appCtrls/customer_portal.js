(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageGustCustomerController', manageGustCustomerController)
        .controller('manageGuestCustomerTransactionController', manageGuestCustomerTransactionController)
        .controller('manageMakePaymentController', manageMakePaymentController)
         .controller('manageCustomerLoginController', manageCustomerLoginController)
         .controller('customerPortalthankyouController', customerPortalthankyouController)
         .controller('authenticateGuestController', authenticateGuestController)
             .controller('addEditkycController', addEditkycController)

    manageGustCustomerController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageGustCustomerController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;

        vm.CompanyId = 0;
        vm.CustomerId = 0;
        vm.CustomerName = '';
        vm.CurrencyData = [];
        vm.feeData = [];
        vm.Fee = "";
        vm.DestinationCountry = "";
        // remove default
        vm.isPayAmmount = false;
        vm.isAmmount = false;
        vm.Amount = "";
        $('.modal-backdrop').remove();
        vm.FlagModel = [{ countryCode: '', internationalCodes: '', carrierName: '', Result: '' }];
        vm.localStorage = [{ GustData: '', GustCustomer: 0, SelectedCountry: '' }];
        // vm.PaybillModel = { CompanyId: 0, CustomerId: 0, SenderName: '', PaymentMethodId: '0', Amount: '0.00', MobileNumber: '' }
        vm.fare_amount = "";
        if ($localStorage.GustData) {
            vm.localStorage = $localStorage.GustData;
            vm.localStorage = $localStorage;

            if (vm.localStorage.GustData != '') {
                if (vm.localStorage.SelectedCountry) {
                    // vm.PaybillModel.MobileNumber = vm.localStorage.SelectedCountry.MobileNumber;
                    vm.FlagModel.countryCode = vm.localStorage.SelectedCountry.countryCode;
                    vm.FlagModel.internationalCodes = vm.localStorage.SelectedCountry.internationalCodes;
                    vm.FlagModel.carrierName = vm.localStorage.SelectedCountry.carrierName;
                    vm.FlagModel.Result = 'Success';
                }
            }
        } else {
            if (vm.localStorage.SelectedCountry) {
                $localStorage.SelectedCountry = [];
                $state.go('app.customerPortal')
            }
            else { $state.go('app.customerPortal') }
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

        });

        vm.CountryDetails = [{ phonecode: '' }];

        vm.PaybillModel = { CompanyId: 0, CustomerId: 0, SenderName: '', PaymentMethodId: '0', Amount: '0.00', MobileNumber: '' }

        vm.FlagModel = [];

        vm.getcountrydata = function (id) {

            var iCountryId = parseInt(id);
            var data1 = $filter('filter')(vm.Countries, {
                phonecode: iCountryId,
            }, true);
            vm.DestinationCountry = data1[0].CountryId;

            var skillsSelect = document.getElementById("CountrySelected");
            var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;

            var formData = JSON.parse(JSON.stringify({ "phonecode": iCountryId, "CountryName": selectedText }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getcountryByPhoneCode',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                if (idata.CountryCode != '') {
                    vm.PaybillModel.MobileNumber = '';
                    vm.FlagModel.countryCode = idata.iso.toLowerCase();
                    vm.FlagModel.internationalCodes = idata.phonecode;
                    vm.FlagModel.carrierName = idata.CountryName;

                    vm.FlagModel.Result = 'Success';
                }
                else {
                    vm.FlagModel = [];
                    $localStorage.GustData = '';
                    vm.FlagModel.Result = 'Failed';
                    //Alert(2, "!" + idata.Error);
                    setTimeout(function () {
                        $("#AlertText").text(idata.Error);
                    }, 100);
                }
            });
        }

        var timeout;
        var delay = 500;
        vm.EnteredNumber = function () {
            vm.validnumber = false;
            if (timeout) {
                clearTimeout(timeout);
            }
            timeout = setTimeout(function () {
                Searchdata();
            }, delay);
        }


        function Searchdata() {
            //vm.FlagModel.internationalCodes = '';
            $localStorage.GustData = '';
            var iCountryCode = vm.FlagModel.internationalCodes;
            var iNumber = vm.PaybillModel.MobileNumber;
            if (iNumber.length > 9) {

                if (iCountryCode) {
                    var iEnteredNumber = parseInt(iCountryCode + iNumber);
                }
                else {
                    var iEnteredNumber = parseInt(iNumber);
                }
                var formData = JSON.parse(JSON.stringify({ "MobileNumber": iEnteredNumber }));
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'getCarrierInfoByMobileNumber ',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' }
                })
                .success(function (data) {
               
                    var idata = data;
                    if (idata.countryCode != null) {
                        var SelectedCountry = [];
                        vm.PaybillModel.MobileNumber = iNumber;
                        if (!iCountryCode) {
                            if (idata.currencyCode == "MXN") {
                                var res = idata.internationalCodes;
                                var codelength = res;
                                idata.internationalCodes = res;
                                $localStorage.GustData = idata.MobileNumber.replace(/\D/g, '').substr(codelength);
                                vm.PaybillModel.MobileNumber = $localStorage.GustData;
                            }
                            else {
                                var codelength = idata.internationalCodes.length;
                                $localStorage.GustData = idata.MobileNumber.replace(/\D/g, '').substr(codelength);
                                vm.PaybillModel.MobileNumber = $localStorage.GustData;
                            }
                        }
                        else {
                            $localStorage.GustData = iNumber;
                            vm.PaybillModel.MobileNumber = iNumber;
                        }
                        idata.countryCode = idata.countryCode.toLowerCase();
                        vm.FlagModel = idata;
                        var sData = vm.CountryDetails;
                        if (!vm.DestinationCountry)
                            
                            var PhoneCode = '';
                        if (idata.currencyCode == "MXN") {
                            PhoneCode = res;
                        }
                        else {
                            PhoneCode = idata.internationalCodes;
                        }
                        //var PhoneCode = '';
                        if (vm.CountryDetails.phonecode != '0') {
                            if (idata.internationalCodes != vm.CountryDetails.phonecode) {
                                vm.CountryDetails.phonecode = '0';
                            }
                            if (idata.currencyCode == "MXN") {
                                var res = idata.internationalCodes;
                                vm.CountryDetails.phonecode = res;

                                idata.internationalCodes = res;
                            }
                            else {
                                vm.CountryDetails.phonecode = idata.internationalCodes;
                            }
                        }

                        else {
                            if (idata.currencyCode == "MXN") {
                                var res = idata.internationalCodes;
                                vm.CountryDetails.phonecode = res;
                                idata.internationalCodes = res;
                            }
                            else {
                                vm.CountryDetails.phonecode = idata.internationalCodes;
                            }//vm.CountryDetails = sData;
                        }

                        $localStorage.SelectedCountry = idata;

                        if (idata.currencyCode == "USD") {
                            $localStorage.SelectedCountry.ConvertAmount = 1.00;
                            $localStorage.SelectedCountry.GlobalExchangesRate = 1.00;
                            $localStorage.SelectedCountry.DestinationCountry = "" + vm.DestinationCountry;
                        }
                        else { ConvertMoney(idata.currencyCode); }

                       
                        if (!vm.DestinationCountry) {
                            var iCountryId = parseInt(PhoneCode);
                            var data1 = $filter('filter')(vm.Countries, {
                                phonecode: iCountryId,
                            }, true);
                            vm.DestinationCountry = data1[0].CountryId;

                        }
                        $localStorage.SelectedCountry.DestinationCountry = "" + vm.DestinationCountry;
                        setAmountArray();

                    }
                    else {
                        //vm.FlagModel = [];
                        //vm.CountryDetails.phonecode = '0';
                        $localStorage.GustData = '';
                        //$localStorage.SelectedCountry = '';

                        vm.validnumber = true;
                        setTimeout(function () {
                            $("#AlertText").text("Sorry, the mobile network is not supported or the number is incorrect. Please check and try again.");
                        }, 100);
                    }
                });
            }
            else {
                //vm.FlagModel = [];
                $localStorage.GustData = '';
            }

        }

        vm.submitForm = function () {
            if ($localStorage.GustData) {
                if ($localStorage.GustCustomer == '') {
                    vm.localStorage.GustCustomer = $localStorage.GustCustomer = 0;
                }
                $state.go('app.chooseAmount');
            }
            //else {
            //    Alert(2, "! It is not possible to recharge on this phone number. Please check the number and try again.");
            //}
        }


        vm.checkPayAmmount = function (Ammount) {
            vm.accessAmount = false;
            vm.isPayAmmount = false;
            if (Ammount <= 100) {
                if (Ammount != null) {
                    if (Ammount) {
                        vm.isAmmount = true;
                        $localStorage.Ammount = Ammount;
                        vm.getFeeDetails();
                        $('#proceedButton').prop('disabled', false);
                    } else {
                        vm.isAmmount = false;
                        $localStorage.Ammount = "";
                        $('#proceedButton').prop('disabled', false);
                    }
                } else {
                    vm.isAmmount = false;
                    $('#proceedButton').prop('disabled', false);
                    return 0;
                }
            }
            else {
                vm.accessAmount = true;
                vm.isAmmount = false;
                $('#proceedButton').prop('disabled', true);
            }
        }


        vm.selectAmmount = function (ammount) {
            var dAmount = parseFloat(ammount).toFixed(2)
            //amountfeild
            $('#amountfeild').val(dAmount);
            $localStorage.Ammount = dAmount;
            // $localStorage.AmountGer = 0;
            vm.getFeeDetails();
            vm.isPayAmmount = true;

            vm.isAmmount = false;
            //vm.PaybillModel.Amount = ammount; * $localStorage.SelectedCountry.ConvertAmount

            $('#proceedButton').prop('disabled', false);
        }

        //Set amont with Global exchanges rate
        vm.selectAmmountWithGER = function (ammount, usd) {
            var dAmount = parseFloat(ammount).toFixed(2)
            //amountfeild
            $('#amountfeild').val(dAmount);
            $localStorage.Ammount = dAmount;
            $localStorage.AmountGer = usd;
            vm.getFeeDetails();
            vm.isPayAmmount = true;

            vm.isAmmount = false;
            //vm.PaybillModel.Amount = ammount; * $localStorage.SelectedCountry.ConvertAmount

            $('#proceedButton').prop('disabled', false);
        }

        vm.getFeeDetails = function () {
            var DestinationCountry = vm.localStorage.SelectedCountry.DestinationCountry;
            var formData = JSON.parse(JSON.stringify({ "CompanyId": 17, "DestinationCountry": DestinationCountry }));
            $http({
                method: 'POST',
                url: baseUrl + 'getPaymentFeesByCompanydestinationCountry',
                data: formData,
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                vm.feeData = idata;
                //var FareAmount = vm.localStorage.Ammount * vm.localStorage.SelectedCountry.ConvertAmount;
                var FareAmount = vm.localStorage.Ammount;
                for (var i = 0; i < vm.feeData.length; i++) {
                    if (FareAmount <= vm.feeData[i].EndAmount) {
                        vm.Fee = vm.feeData[i].Fees;
                    } else {
                        vm.Fee = 0
                    }
                }
            });
        }


        vm.proceed = function () {
          
            vm.accessAmount = false;
            vm.validAmount = false;
            if ($("#from_id").valid()) {
                if ($localStorage.Ammount) {
                    var fareAmmount = 0;
                    //fareAmmount = parseFloat($localStorage.Ammount * $localStorage.SelectedCountry.ConvertAmount);
                    var minAmount = parseInt($localStorage.SelectedCountry.minAmount);
                    var maxAmount = parseInt($localStorage.SelectedCountry.maxAmount);
                    fareAmmount = parseFloat($localStorage.Ammount);
                    if (fareAmmount <= maxAmount && fareAmmount >= minAmount) {
                        $localStorage.FareAmmount = fareAmmount;
                        $localStorage.Fees = vm.Fee;
                        setTimeout(function () {
                            $state.go('app.reviewAmmount');
                        }, 100);
                    }
                    else {
                        vm.accessAmount = true;
                    }

                }
                else {

                    vm.validAmount = true;
                    return 0;
                }
            } else {
              
                vm.validAmount = true;
                return 0;
            }


        }

        vm.popupYes = function () {
            $('#Payconfirm').modal('toggle');
            $('.modal-backdrop').remove();
            if (!$localStorage.GustCustomer) {
                $state.go('app.Login');
            } else {
                $window.location.assign('#/app/makePayment');
                //$state.go('app.makePayment');
            }
        }

        if ($localStorage.Ammount) {
          
            var dAmount = parseFloat($localStorage.Ammount).toFixed(2)
            $('#amountfeild').val(dAmount);
           
        }

        vm.BackChooseamount = function () {
            if ($localStorage.Ammount) {
                $localStorage.Ammount = '';
                $state.go('app.chooseAmount');
            }
            else { $state.go('app.chooseAmount'); }

        }

        //With Exchange rate
        vm.PayAmountWithExchange = [{ AmountId: '1', Amount: '1.00' }, { AmountId: '2', Amount: '2.00' },{ AmountId: '3', Amount: '3.00' }, { AmountId: '4', Amount: '4.00' },{ AmountId: '5', Amount: '5.00' }, { AmountId: '6', Amount: '6.00' }, { AmountId: '7', Amount: '7.00' }, { AmountId: '8', Amount: '8.00' }, { AmountId: '9', Amount: '9.00' }, { AmountId: '10', Amount: '10.00' }, { AmountId: '11', Amount: '11.00' }, { AmountId: '12', Amount: '12.00' }];

        //Without exchange rate
       
        //vm.PayAmount = $localStorage.SelectedCountry.AmountList;
        //vm.PayAmount = [{ AmountId: '1', Amount: '10.00' }, { AmountId: '2', Amount: '20.00' },
        //                { AmountId: '3', Amount: '30.00' }, { AmountId: '4', Amount: '40.00' },
        //                { AmountId: '5', Amount: '50.00' }, { AmountId: '6', Amount: '60.00' },
        //                { AmountId: '7', Amount: '70.00' }, { AmountId: '8', Amount: '80.00' },
        //                { AmountId: '9', Amount: '90.00' }, { AmountId: '10', Amount: '100.00' },
        //                { AmountId: '11', Amount: '110.00' }, { AmountId: '12', Amount: '120.00' },
        //                { AmountId: '13', Amount: '130.00' }, { AmountId: '14', Amount: '140.00' },
        //                { AmountId: '15', Amount: '150.00' }, { AmountId: '16', Amount: '160.00' }];

        //----------------Set amount Array--------------------//
        function setAmountArray() {
          
            if ($localStorage.SelectedCountry.minAmount == $localStorage.SelectedCountry.maxAmount) {
                vm.PayAmountList = [{ AmountId: '1', Amount: $localStorage.SelectedCountry.minAmount }];
            }
            else {
                var iAmount = 0;
                vm.PayAmountList = [];
                var j = 0;
                var amt = parseInt($localStorage.SelectedCountry.minAmount);
                var i = parseInt($localStorage.SelectedCountry.minAmount);
                var Total = parseInt($localStorage.SelectedCountry.maxAmount);
                for (i; i <= Total; i += 5) {
                    if (i == parseInt($localStorage.SelectedCountry.minAmount)) {
                        vm.PayAmountList.push({ AmountId: 0, Amount: parseInt($localStorage.SelectedCountry.minAmount) });
                    }
                    else {
                        amt += 5;
                        vm.PayAmountList.push({ AmountId: j += 1, Amount: amt });
                    }

                }
            }
            $localStorage.AmountList = vm.PayAmountList;
        }

        vm.goBack = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.AmountGer = '';
            vm.localStorage.FareAmmount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $localStorage.ThankyouPageData = '';
            $localStorage.AmountList = '';
            $state.go('app.customerPortal');
        }

        vm.cancel = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.AmountGer = '';
            vm.localStorage.FareAmmount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $localStorage.ThankyouPageData = '';
            $localStorage.AmountList = '';
            $state.go('app.customerPortal');
        }

        vm.logoutGustCustomer = function () {

            if ($localStorage.GustCustomer) {
                vm.localStorage.Ammount = '';
                vm.localStorage.AmountGer = '';
                vm.localStorage.FareAmmount = '';
                vm.localStorage.GustData = '';
                vm.localStorage.MobileNumber = '';
                vm.localStorage.SelectedCountry = '';
                vm.localStorage.GustCustomer = '';
                $localStorage.GustData = '';
                $localStorage.GustCustomer = '';
                $localStorage.ThankyouPageData = '';
                $localStorage.AmountList = '';
                $localStorage = [];
                setTimeout(function () {
                    //$state.go('app.customerPortal');
                    $window.location.reload();
                }, 1000);
            }
        }

        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);
            return dateOut;
        };


        function ConvertMoney(code) {
            //$localStorage.SelectedCountry.ConvertAmount = 0;

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
                        //var newvalu = value
                        $localStorage.SelectedCountry.ConvertAmount = value;
                        var DestinationCountryId = "";
                        var SellSpotPrice = value;
                        var data1 = $filter('filter')(vm.Countries, {
                            CurrencyCode: code,
                        }, true);
                        if (data1.length > 0) {
                            DestinationCountryId = data1[0].CountryId;
                        }

                        UpdateglobalExchange(code);
                    }
                    else {
                        $localStorage.SelectedCountry.ConvertAmount = 0.00;
                    }
                    vm.CurrencyData = idata;
                    //return 
                });
        }


        function UpdateglobalExchange(code) {
         
            //$localStorage.SelectedCountry.ConvertAmount = 0;
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
                        //var newvalu = value
                      
                        var DestinationCountryId = "";
                        var SellSpotPrice = value;
                        var data1 = $filter('filter')(vm.Countries, {
                            CurrencyCode: code,
                        }, true);
                        if (data1.length > 0) {
                            DestinationCountryId = data1[0].CountryId;
                        }

                        var formData = JSON.parse(JSON.stringify({ "DestinationCountryId": DestinationCountryId, "SellSpotPrice": SellSpotPrice }));
                        $http({
                            method: 'POST',
                            url: baseUrl + 'updateRealfeesglobalExchangerate',
                            data: formData,
                            headers: { 'Content-Type': 'application/json; charset=utf-8' }
                        })
                        .success(function (data) {

                            $localStorage.SelectedCountry.IsGlobalExchangeRate = false;
                            if (data.Result == "Success") {
                                var iconvert = (parseFloat(data.GlobalExchangeRate) - parseFloat(data.SellSpotPrice)).toFixed(2);
                                $localStorage.SelectedCountry.IsGlobalExchangeRate = true;
                                //$localStorage.SelectedCountry.ConvertAmount = iconvert;
                                ConvertMoneyMargin(code, iconvert);
                                $localStorage.SelectedCountry.GlobalExchangesRate = parseFloat(data.GlobalExchangeRate).toFixed(2);
                            } else {
                                $localStorage.SelectedCountry.IsGlobalExchangeRate = false;
                                $localStorage.SelectedCountry.GlobalExchangesRate = parseFloat(data.SellSpotPrice).toFixed(2);
                            }
                        });

                    }

                    //return 
                });
        }

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
                            var convertAmt = $localStorage.SelectedCountry.ConvertAmount;
                            $localStorage.SelectedCountry.ConvertAmount = (parseFloat(convertAmt) + parseFloat(value));

                            //vm.TemporaryGlobalExchangeRate.MarginAmount = value + " " + "USD";
                        }
                        else { //vm.TemporaryGlobalExchangeRate.MarginAmount = '0.00' + " " + "USD";
                        }

                    });
            }
        }

    }

    manageCustomerLoginController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageCustomerLoginController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;

        var CompanyId = 0;
        vm.CustomerID = 0;
        vm.IsLogin = false;
        if ($localStorage.GustCustomer) {
            vm.IsLogin = true;
        }
        //vm.CustomerStorage = { GustCustomer: '0' };
        //if ($localStorage.Ammount) {
        //    $window.location.assign('#/app/makePayment');
        //}
        //if (vm.IsLogin) {
        //    $window.location.assign('#/app/customerPortal');
        //}

        if ($localStorage.Ammount) {
          
            if (vm.IsLogin) {
                $window.location.assign('#/app/makePayment');
            }
            else {
                var url = $state.current.url;
                $window.location.assign('#/app' + url);
            }
        }
        else if (vm.IsLogin) {
            $window.location.assign('#/app/customerPortal');
        }
        else {  var url = $state.current.url;
                $window.location.assign('#/app' + url);}



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


        if ($localStorage.GustCustomer) {

            vm.localStorage = $localStorage;
        }
        //Login gustCustomer
        vm.CustomerModel = { "Email": "", "Password": "" };
        vm.customerlogin = function () {
            var formData = JSON.stringify(vm.CustomerModel);
            $http({
                url: baseUrl + 'authenticatecustomer',
                method: 'POST',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data, status, headers, config) {

                var iCustomer = data;
                if (iCustomer.CustomerId) {
                    var GustCustomer = [];
                    vm.CustomerID = iCustomer.CustomerId;
                    $localStorage.GustCustomer = iCustomer;
                    Alert(1, "! Login successful.. ");

                    setTimeout(function () { window.location.reload(); }, 1000);

                    //if ($localStorage.Ammount) {
                    //    $state.go('app.makePayment')
                    //    //setTimeout(function () { window.location.reload(); }, 1000);
                    //} else {
                    //    //$state.go('app.makepayment');
                    //    $state.go('app.customerPortal')
                    //}

                }
                else {
                    Alert(2, "! Invalid Customer or password. ");
                }
            })
            .error(function (data, status, headers, config) {
                Alert(2, "! " + data);
            });
        }


        vm.timer = function () {
            var timeout = 180000;
            var message = "Time Out for login Do you want exceed your time for next 3 mintue or go back?"
            if ($location.path() == "/app/Login") {
                timeout = 180000;
                message = "Time Out for Register Do you want exceed your time for  next 3 mintue or go back?"
                setTimeout(function () { $("#loginTimeOut").modal('toggle') }, timeout);
            }
            else if ($location.path() == "/app/userRegister") {
                timeout = 300000;
                message = "Time Out for Register Do you want exceed your time for  next 5 mintue or go back?"
                setTimeout(function () { $("#loginTimeOut").modal('toggle') }, timeout);
            }
        }
        //

        vm.timer();
        // }, 1000);

        vm.exceedTime = function () {
            var timeout = 300000;
            if ($location.path() == "/app/userRegister") { timeout = 300000; }
            if ($location.path() == "/app/Login") { timeout = 180000; }

            $('#loginTimeOut').modal('hide');
            setTimeout(function () {
                var time = 180000;
                $("#loginTimeOut").modal('toggle')
                setTimeout(function () {
                    $localStorage.numberDetails = null;
                    $localStorage.Ammount = '';
                    $localStorage.GustData = '';
                    $localStorage.MobileNumber = '';
                    $localStorage.SelectedCountry = '';
                    $state.go('app.customerPortal');
                }, time);
            }, timeout);
        }

        vm.goBack = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $localStorage.AmountList = '';
            $state.go('app.customerPortal');
        }


        vm.CustomerRegister = { CompanyId: "0", CountryId: "0", FirstName: '', LastName: '', Address1: '', Address2: '', City: '', State: '', ZipCode: '', Phone: '', Email: '', Password: '', DOB: '', ProfileImage: '', ActivationCode: '', };

        vm.register = function () {
            var iData = vm.CustomerRegister;
            iData.CompanyId = "17";
            var formData = JSON.stringify(iData);
            $http({
                url: baseUrl + 'savecustomer',
                method: 'POST',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.CustomerId) {
                    Alert(1, "! Customer registered successfully..");
                    setTimeout(function () {
                        vm.CustomerModel.Email = vm.CustomerRegister.Email;
                        vm.CustomerModel.Password = vm.CustomerRegister.Password;
                        var formData = JSON.stringify(vm.CustomerModel);
                        $http({
                            url: baseUrl + 'authenticatecustomer',
                            method: 'POST',
                            data: formData,
                            headers: { 'Content-Type': 'application/json' },
                            dataType: "json",
                        })
                        .success(function (data, status, headers, config) {
                            var GustCustomer = data;
                            if (GustCustomer.CustomerId) {

                                $localStorage.GustCustomer = data;
                                Alert(1, "! Login successful.. ");
                                setTimeout(function () { window.location.reload(); }, 1000);
                            }
                            else {
                                Alert(2, "! Invalid Customer or password. ");
                            }
                        })
                        .error(function (data, status, headers, config) {
                            Alert(2, "! " + data);
                        });
                    }, 1000);
                }
                else {
                    Alert(2, "! Invalid Customer details. ");
                }
            })
        }

        vm.ReloadGustCustomer = function () {
            $localStorage.numberDetails = '';
            $localStorage.Ammount = '';
            $localStorage.GustData = '';
            $localStorage.MobileNumber = '';
            $localStorage.SelectedCountry = '';
            $localStorage.AmountList = '';
            $localStorage = [];
            setTimeout(function () {
                $window.location.reload();
                //$state.go('app.customerPortal');
            }, 1000);

        }


        vm.logoutGustCustomer = function () {
            $localStorage.numberDetails = '';
            $localStorage.GustCustomer = '';
            $localStorage.Ammount = '';
            $localStorage.GustData = '';
            $localStorage.MobileNumber = '';
            $localStorage.SelectedCountry = '';
            $localStorage.GustCustomer = '';
            $localStorage.AmountList = '';
            $localStorage = [];
            setTimeout(function () {
                $window.location.reload();
                //$state.go('app.customerPortal');
            }, 1000);

        }


    }


    manageMakePaymentController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function manageMakePaymentController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
        var vm = $scope;
        vm.CompanyId = 0;
        vm.CustomerId = 0;
        vm.CustomerName = '';
        vm.localStorage = [{ GustData: '', GustCustomer: 0, SelectedCountry: '' }];
        vm.PayDetails = { SenderName: '', FaceAmount: '', InvoiceAmount: '', MobileNumber: '', InvoiceNumber: '' };
        vm.PaybillModel = { CompanyId: 0, CustomerId: 0, SenderName: '', PaymentMethodId: '0', Amount: '0.00', MobileNumber: '' }
        if ($localStorage.GustCustomer) {
            vm.localStorage = $localStorage;
            if (vm.localStorage.GustCustomer.CustomerId) {
                vm.CompanyId = vm.localStorage.GustCustomer.CompanyId;
                vm.CustomerId = vm.localStorage.GustCustomer.CustomerId;
                vm.CustomerName = vm.localStorage.GustCustomer.FirstName;
                vm.PaybillModel.Amount = vm.localStorage.Ammount;
            }
        }
        else {
            $state.go('app.Login');
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
            if (vm.PaymentMethods[0].PaymentMethodId == 0)
                vm.PaymentMethods.splice(0, 1);
            setTimeout(function () {
                vm.selectedMethod(vm.PaymentMethods[0].PaymentMethodId);
            }, 500);

        });

        vm.selectedMethod = function (PaymentId) {
            if (PaymentId > 0) {
                var formData = JSON.parse(JSON.stringify({ "PaymentMethodId": PaymentId, "FeesCategoryId": 2 }));
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'getPaymentFeesDetailsByPaymentMethod ',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' }
                })
                .success(function (data) {
                    var idata = data;
                    if (idata.length) {
                        angular.forEach(idata, function (data, index) {
                            var val = data;
                            if (vm.localStorage.FareAmmount >= data.StartingAmount && vm.localStorage.FareAmmount <= data.EndAmount) {
                                $localStorage.Fees = data.Fees;
                                vm.PaymentFee = data.Fees;
                            }
                            else { $localStorage.Fees = 0.00; }
                        });
                    }
                    else {
                        $localStorage.Fees = 0.00;
                    }
                });

            }
        }




        vm.Paynow = function () {
            $('#Payconfirm').modal('toggle');

            //$('.modal-backdrop').remove();
            //$('#Payconfirm').modal('show');


        }

        function validate(evt) {
         var theEvent = evt || window.event;
         var key = theEvent.keyCode || theEvent.which;
         key = String.fromCharCode( key );
         var regex = /[0-9]|\./;
             if( !regex.test(key) ) {
             theEvent.returnValue = false;
            if(theEvent.preventDefault) theEvent.preventDefault();
         }
       }

        var cardNumber = $('#CardNumber');
        var cardNumberField = $('#card-number-field');
        var CvvNumberField = $('#field-cvv');
        var CVV = $("#cvv");
        vm.isCardValid = false;
        cardNumber.keyup(function () {
            if ($.payform.validateCardNumber(cardNumber.val()) == false) {
                cardNumberField.addClass('has-error');
                vm.isCardValid = false;
            } else {
                cardNumberField.removeClass('has-error');
                cardNumberField.addClass('has-success');
                vm.isCardValid = $.payform.validateCardNumber(cardNumber.val());
            }

        });

        vm.isCvvValid = false;
        CVV.keyup(function () {
            var cvvlength = CVV.val().length;
            if ($.payform.parseCardType(cardNumber.val()) == 'amex') {
                if (cvvlength < 4) {
                    CvvNumberField.removeClass('has-success');
                    CvvNumberField.addClass('has-error');
                    vm.isCvvValid = false;
                }
                else {
                    CvvNumberField.removeClass('has-error');
                    CvvNumberField.addClass('has-success');
                    vm.isCvvValid = $.payform.validateCardCVC(CVV.val());
                    $("#alertDiv").hide();
                }
            }
            else {
                if (cvvlength == 3) {
                    CvvNumberField.removeClass('has-error');
                    CvvNumberField.addClass('has-success');
                    vm.isCvvValid = $.payform.validateCardCVC(CVV.val());
                    $("#alertDiv").hide();
                }
                else {
                    CvvNumberField.removeClass('has-success');
                    CvvNumberField.addClass('has-error');
                    vm.isCvvValid = false;
                }
            }
        });

        vm.ExpireModel = { ExpireMonth: '0', ExpireYear: '0' }

        vm.CheckYear = function (year) {
            vm.alert = false;
            var sYear = year;
            var CurrentDate = new Date().getFullYear();
            var Currentyear = CurrentDate.toString().replace(/\D/g, '').substr(2);

            if (parseInt(sYear) > parseInt(Currentyear)) {
                vm.alert = false;
            }
            else {
                vm.alert = true;
                setTimeout(function () {
                    $("#PaymentAlertText").text("Your card is expired");
                }, 100);
            }
        }


        vm.Create = function (e) {

            $('#Payconfirm').modal('toggle');
            vm.alert = false;
            var isCardValid = $.payform.validateCardNumber(cardNumber.val());
            var isCvvValid = $.payform.validateCardCVC(CVV.val());
            var IsValid = false;
            var cvvlength = CVV.val().length;
            if ($.payform.parseCardType(cardNumber.val()) == 'amex') {
                if (cvvlength < 4) {
                    CvvNumberField.removeClass('has-success');
                    CvvNumberField.addClass('has-error');
                    vm.alert = true;
                    setTimeout(function () {
                        $("#PaymentAlertText").text('Invaild CVV number');
                    }, 100);
                    return
                }
                else {
                    IsValid = true; vm.alert = false;
                }
            }
            else {
                if (cvvlength != 3) {
                    CvvNumberField.removeClass('has-success');
                    CvvNumberField.addClass('has-error');
                    vm.alert = true;
                    setTimeout(function () {
                        $("#PaymentAlertText").text('Invaild CVV number');
                    }, 100);
                    return
                }
                else { IsValid = true; vm.alert = false; }
            }

            if (isCardValid && IsValid) {
                if (isCvvValid) {
                    var data = vm.localStorage.GustCustomer;
                    var idata = vm.PaybillModel;
                    idata.Amount = vm.localStorage.FareAmmount + vm.localStorage.Fees;
                    idata.MobileNumber = vm.localStorage.SelectedCountry.MobileNumber;
                    idata.CompanyId = vm.localStorage.GustCustomer.CompanyId;
                    idata.CustomerId = vm.localStorage.GustCustomer.CustomerId;
                    idata.SenderName = vm.localStorage.GustCustomer.FirstName;
                    idata.Fees = vm.localStorage.Fees;
                     idata.SKUId=vm.localStorage.SelectedCountry.skuId;
                    var sMonth = parseInt(vm.ExpireModel.ExpireMonth);
                    if (sMonth < 10) {
                        sMonth = '0' + sMonth
                    }
                    var CurrentDate = new Date();
                    var Currentyear = CurrentDate.getYear();
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
                        if (idata.Result == "Success" && idata.TransactionId > 0) {
                            idata.InvoiceNumber = idata.PaymentGatewayTransactionId;
                            idata.InvoiceAmount = idata.Amount;
                            idata.FaceAmount = idata.Amount;
                            $state.go('app.ThankuCus');
                        }
                        else {
                            AlertKyc(2, idata.Error);
                        }
                        vm.PayDetails = idata;
                        $localStorage.ThankyouPageData = vm.PayDetails;
                        //if (idata && idata.BillPayId > 0) {
                        //    vm.localStorage.Ammount = '';
                        //    vm.localStorage.FareAmmount = '';
                        //    vm.localStorage.GustData = '';
                        //    vm.localStorage.MobileNumber = '';
                        //    vm.localStorage.SelectedCountry = '';



                        //} 


                    });
                }
                else {
                    vm.alert = true;
                    setTimeout(function () {
                        $("#PaymentAlertText").text('Invaild Card');
                    }, 100);
                }
            }
            else {
                vm.alert = true;
                setTimeout(function () {
                    $("#PaymentAlertText").text('Invaild CVV number ');
                }, 100);
            }
        }

        vm.cancel = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.FareAmmount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $state.go('app.customerPortal');
        }
    }


    manageGuestCustomerTransactionController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageGuestCustomerTransactionController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;
        var CompanyId = 0;
        vm.localStorage = 0;
        //GustData

        if ($localStorage.GustCustomer.CustomerId) {
            vm.localStorage = [];
            vm.localStorage = $localStorage;
        } else {
            $state.go('app.customerPortal')
        }

        //Remove BackDrop
        $('.modal-backdrop').remove();

        //Get Method Details
        vm.ManageTransaction = [];
        var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.localStorage.GustCustomer.CustomerId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'gettranscationdetails',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {

            var idata = data;
            $scope.reverse = true;
            idata = $filter('orderBy')(idata, 'TransactionId', $scope.reverse);

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

        vm.logoutGustCustomer = function () {
            if ($localStorage.GustCustomer) {
                $localStorage.numberDetails = '';
                $localStorage.GustCustomer = '';
                $localStorage.Ammount = '';
                $localStorage.GustData = '';
                $localStorage.MobileNumber = '';
                $localStorage.SelectedCountry = '';
                $localStorage.GustCustomer = '';

                $localStorage = [];
                setTimeout(function () {
                    $window.location.reload();
                    //$state.go('app.customerPortal');
                }, 1000);
            }
        }



    }


    customerPortalthankyouController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function customerPortalthankyouController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerId = 0;
        vm.localStorage = "";
        if ($localStorage.GustCustomer) {


            vm.localStorage = $localStorage.ThankyouPageData;
            vm.localStorage.Fees = $localStorage.Fees;
        } else {
            $state.go('app.Login');
        }








    }

    authenticateGuestController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function authenticateGuestController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
        var vm = $scope;
        if ($localStorage.GustCustomer) {
            vm.localStorage = $localStorage.GustCustomer;

            if (!vm.localStorage.CustomerId) {
                $window.location.reload();
            }
            else {
                var url = $state.current.url;
                $window.location.assign('#/app' + url);
            }
        }
        else {
            $window.location.assign('#/app/Home');
        }
    }

    addEditkycController.$inject = ['$scope', '$q', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$filter'];
    function addEditkycController($scope, $q, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $filter) {
        var vm = $scope;
        vm.CustomerId = 0;
        vm.CompanyId = 0;
        vm.CountryId = 0;
        vm.ProfileModal = { AccountNumber: "", ActivationCode: "", Address1: "", Address2: "", BuildingNumber: 0, City: "", CompanyId: 0, CountryId: 0, CustomerId: 0, DOB: "", Email: " ", FileName: "", FileType: "", FirstName: "", Gender: "", LastName: "", Password: "", Phone: "", ProfileImage: "", Side: "Front", State: " ", Street: "", Title: "Mr", Town: "", ZipCode: "" }
        vm.localStorage = [{ GustData: '', GustCustomer: 0, SelectedCountry: '' }];
        if ($localStorage.GustCustomer) {
            vm.localStorage = $localStorage;
            if (vm.localStorage.GustCustomer.CustomerId) {
                vm.CompanyId = vm.localStorage.GustCustomer.CompanyId;
                vm.CustomerId = vm.localStorage.GustCustomer.CustomerId;
            }
        }
        else {
            $state.go('app.Login');
        }
        //Get Customer Details
        if (vm.CustomerId) {

            var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.CustomerId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getcustomerdetails',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 var idata = data;
                 if (idata) {
                     idata.Phone = parseInt(idata.Phone);
                     idata.CountryId = JSON.stringify(idata.CountryId);
                     vm.ProfileModal = idata;
                     if (vm.ProfileModal.IsDocumentUpload) {
                         $('#submitkycbutton').prop('disabled', false);
                     }
                     if (vm.ProfileModal.Title == null)
                         vm.ProfileModal.Title = "Mr";
                     if (vm.ProfileModal.Gender == null)
                         vm.ProfileModal.Gender = "";
                     if (vm.ProfileModal.FileName == null)
                         vm.ProfileModal.FileName = "passport";
                     if (vm.ProfileModal.Side == null)
                         vm.ProfileModal.Side = "front";
                     vm.ProfileModal.Password = "";
                 }
             });
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

        });


        //------------------Image Uploader-----------------//

        $("#upload").change(function ($event) {
            $('#submitkycbutton').prop('disabled', true);
            var fileReader = new FileReader();
            var file = $event.target.files[0];
            fileReader.readAsDataURL(file);
            setTimeout(function () {
                var filename = file.name;
                var extn = filename.split(".").pop();
                var strToReplace = fileReader.result;
                var strImage = strToReplace.replace(/^data:image\/[a-z]+;base64,/, "");
                vm.FileName = filename.replace("." + extn, "");
                vm.FileExt = extn;
                vm.imageData = strImage;
                if (vm.imageData != "") {
                    if ((extn == "jpg" || extn == "jpeg") || (extn == "png" || extn == "PNG")) {
                        move();
                    }
                }
            }, 2000);
        });


        function move() {
            var elem = document.getElementById("myBar");
            var width = 2;
            var id = setInterval(frame, 100);

            function frame() {
                if (width >= 100) {
                    clearInterval(id);
                    $('#submitkycbutton').prop('disabled', false);
                }
                else {
                    width++;
                    elem.style.width = width + '%';
                    elem.innerHTML = width * 1 + '%';
                }
            }
        }
        //------------Image Reader-------------//

        vm.Create = function () {
            //CustomerGenger
            // var file = document.getElementById('upload').files[0];
            if (vm.ProfileModal) {
                var formData = JSON.parse(JSON.stringify(vm.ProfileModal));
                $http({
                    method: 'POST',
                    url: baseUrl + 'savecustomer',
                    data: formData,
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.Result == "Sucess") {
                        var DataResult = angular.copy(vm.ProfileModal);
                        var Country = $filter('filter')(vm.Countries, { CountryId: parseInt(vm.ProfileModal.CountryId) }, true
                        );
                        var data = { CustomerId: vm.ProfileModal.CustomerId, CompanyId: vm.ProfileModal.CompanyId, Title: vm.ProfileModal.Title, FirstName: vm.ProfileModal.FirstName, LastName: vm.ProfileModal.LastName, Gender: vm.ProfileModal.Gender, DOB: vm.ProfileModal.DOB, Country: Country[0].CountryName.substr(0, 3).toUpperCase(), FlatNumber: vm.ProfileModal.Address1, BuildingName: vm.ProfileModal.BuildingNumber, BuildingNumber: vm.ProfileModal.Address2, Street: vm.ProfileModal.Street, State: vm.ProfileModal.State, Town: vm.ProfileModal.Town, PostalCode: vm.ProfileModal.ZipCode, Phone: vm.ProfileModal.Phone };
                        var formData = JSON.parse(JSON.stringify(data));
                        $http({
                            method: 'POST',
                            url: baseUrl + 'addApplicant',
                            data: formData,
                            headers: { 'Content-Type': 'application/json' },
                            dataType: "json",
                        })
                            .success(function (data) {
                                if (data.ApplicantId != "") {
                                    if (vm.imageData !== undefined && vm.imageData != "") {
                                        var formdata = { "ApplicantId": data.ApplicantId, "Type": vm.ProfileModal.FileName, "Side": vm.ProfileModal.Side, "ImageName": vm.FileName, "ImageExt": "." + vm.FileExt, "ImageString": vm.imageData }
                                        $http({
                                            method: 'POST',
                                            url: baseUrl + 'uploadDocumentKYC',
                                            data: formdata,
                                            headers: { 'Content-Type': 'application/json' },
                                            dataType: "json",
                                        })
                                         .success(function (data) {
                                             if (data.Result == "Sucess") {
                                                 AlertKyc(1, "Thanks for updating your KYC document");
                                             }
                                             else {
                                                 AlertKyc(2, data.Error);
                                             }
                                         });
                                    }
                                    else { AlertKyc(1, "Thanks for updating your KYC details"); }
                                }
                                else { AlertKyc(2, data.Error); }

                            });
                    }
                    else {
                        AlertKyc(2, idata.Error);
                    }
                });
            }

        }

        vm.cancel = function () {
            $state.go('app.customerPortal');
        }
    }

})();
