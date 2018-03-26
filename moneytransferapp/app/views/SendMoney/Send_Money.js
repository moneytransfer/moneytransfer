(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageSendMoneyController', manageSendMoneyController)
        .controller('manageSendMoneyLoginController', manageSendMoneyLoginController)
        .controller('authenticateSendMoneyController', authenticateSendMoneyController)
        .controller('addEditBeneficiaryController', addEditBeneficiaryController)
        .controller('addCashPickUpController', addCashPickUpController)
         .controller('makeSendMoneyPaymentController', makeSendMoneyPaymentController)
    .controller('sendMoneythankyouController', sendMoneythankyouController)
    .controller('managesendMoneyTransactionController', managesendMoneyTransactionController)


    manageSendMoneyController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageSendMoneyController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;
        vm.PaymentData = { PaymentMethodId: '0', CompanyId: 0, CustomerId: 0, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '2', BeneficiaryId: '0', ExchangeRate: '64.60', setExpirationDate: '', ReceivingAmount: '', TransactionDetail: '', DeliveryType: '', TransferPurpose: '', SendingAmount: '', };
        vm.PaymentModel = [{ PaymentMethodId: '0', CompanyId: 0, CustomerId: 0, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '2', BeneficiaryId: '0', ExchangeRate: '64.60', setExpirationDate: '', ReceivingAmount: '', TransactionDetail: '', DeliveryType: '', TransferPurpose: '', SendingAmount: '', CountryId: "", CountryName: "", iso: "", SelectedCountryState: "", SelectedState: '', BankDeposit: "", CashPickUp: "", PaymentType: "" }];
        vm.FlagModel = [];
        vm.PaybillModel = { CountryId: 0, CountryName: '', iso: "", CurrencyName: "", CurrencySymbol: "", CurrencyCode: "", Amount: '0.00' }
        vm.AmountDetails = { CurrencyCode: "", Amount: "", ExchangeRate: "", RecipientAmmount: "", SendingCurrency: "", CountryName: "", CountryId: "", iso: "", SelectedCountryState: "", SelectedState: "", PaymentType: "" };
        vm.localStorage = [];
        $localStorage.BeneficiaryModel = '';
        if ($localStorage.AmountDetails) {

            vm.PaymentModel.iso = $localStorage.AmountDetails.iso;
            vm.PaymentModel.CountryName = $localStorage.AmountDetails.CountryName;
            vm.PaymentModel.CountryId = $localStorage.AmountDetails.CountryId;
            vm.PaymentModel.SendingAmount = $localStorage.AmountDetails.Amount;
            vm.PaymentModel.ReceivingAmount = $localStorage.AmountDetails.RecipientAmmount;
            vm.PaymentModel.SendingCurrency = $localStorage.AmountDetails.SendingCurrency;
            vm.PaymentModel.ReceivingCurrency = $localStorage.AmountDetails.CurrencyCode;
            vm.PaymentModel.ExchangeRate = $localStorage.AmountDetails.ExchangeRate;
            vm.PaymentModel.Fee = $localStorage.AmountDetails.Fee;
            //vm.PaymentModel.SelectedCountryState = $localStorage.AmountDetails.SelectedCountryState;

            vm.PaymentModel.SelectedState = $localStorage.AmountDetails.SelectedState;
            $localStorage.AmountDetails = $localStorage.AmountDetails;
        } else {
            $localStorage.PaymentData = vm.PaymentData;
            $localStorage.AmountDetails = vm.AmountDetails;
            $state.go('app.SendMoneyAmount')
        }
        vm.SelectedState = "0";
        //function Begin() { $("#Processbar").fadeIn(500); }
        //function Complete() { $("#Processbar").fadeOut(1000); }
        vm.States = {
            'Alabama': 'AL',
            'Alaska': 'AK',
            'American Samoa': 'AS',
            'Arizona': 'AZ',
            'Arkansas': 'AR',
            'California': 'CA',
            'Colorado': 'CO',
            'Connecticut': 'CT',
            'Delaware': 'DE',
            'District Of Columbia': 'DC',
            'Federated States Of Micronesia': 'FM',
            'Florida': 'FL',
            'Georgia': 'GA',
            'Guam': 'GU',
            'Hawaii': 'HI',
            'Idaho': 'ID',
            'Illinois': 'IL',
            'Indiana': 'IN',
            'Iowa': 'IA',
            'Kansas': 'KS',
            'Kentucky': 'KY',
            'Louisiana': 'LA',
            'Maine': 'ME',
            'Marshall Islands': 'MH',
            'Maryland': 'MD',
            'Massachusetts': 'MA',
            'Michigan': 'MI',
            'Minnesota': 'MN',
            'Mississippi': 'MS',
            'Missouri': 'MO',
            'Montana': 'MT',
            'Nebraska': 'NE',
            'Nevada': 'NV',
            'New Hampshire': 'NH',
            'New Jersey': 'NJ',
            'New Mexico': 'NM',
            'New York': 'NY',
            'North Carolina': 'NC',
            'North Dakota': 'ND',
            'Northern Mariana Islands': 'MP',
            'Ohio': 'OH',
            'Oklahoma': 'OK',
            'Oregon': 'OR',
            'Palau': 'PW',
            'Pennsylvania': 'PA',
            'Puerto Rico': 'PR',
            'Rhode Island': 'RI',
            'South Carolina': 'SC',
            'South Dakota': 'SD',
            'Tennessee': 'TN',
            'Texas': 'TX',
            'Utah': 'UT',
            'Vermont': 'VT',
            'Virgin Islands': 'VI',
            'Virginia': 'VA',
            'Washington': 'WA',
            'West Virginia': 'WV',
            'Wisconsin': 'WI',
            'Wyoming': 'WY'
        }

        //vm.PickUpLocation = "0";
        //vm.PickUpLocation = [{ LocationId: '1', Location: 'Wallmart' }, { LocationId: '2', Location: 'Zapopan' }, { LocationId: '3', Location: 'Chihuahua' }, { LocationId: '4', Location: 'San Luis Potosí' },
        //   { LocationId: '5', Location: 'Mexicali' }
        //];
        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": 17 }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getAgentdetailsByCompanyId ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {

            var idata = data;
            vm.PickUpLocation = idata;
            $localStorage.Agents = vm.PickUpLocation;
        });


        vm.BankDeposits = [{ BankId: '1', BankName: 'KOTAK MAHINDRA BANK' }, { BankId: '2', BankName: 'DENA BANK' }, { BankId: '3', BankName: 'HDFC BANK' }, { BankId: '4', BankName: 'PNB BANK' },
         { BankId: '5', BankName: 'SBI' }
        ];

        //GetFirstIndex
        if ($localStorage.Agents) {

            var dd = ($localStorage.Agents);
            var LocationName = (dd[1].AgentFirstName + ' ' + dd[1].AgentLastName + '-' + dd[1].AgentCode);
        }


        vm.selecetdLocation = function (Name) {
            vm.validWay = false;
            var skillsSelect = document.getElementById("PayOutLocation");
            var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
            if (selectedText != "") {
                if (vm.PaymentModel.PaymentType == "BankDeposit") {
                    $localStorage.AmountDetails.PaymentType = 'BankDeposit';
                    $localStorage.CashpickLocation = LocationName;
                    $localStorage.BankLocation = 'Bank Deposit';
                }
                else if (vm.PaymentModel.PaymentType == "CashPickup") {
                    $localStorage.AmountDetails.PaymentType = 'CashPickup';
                    $localStorage.BankLocation = 'Bank Deposit';
                    $localStorage.CashpickLocation = selectedText;
                    $localStorage.CashpickLocationId = vm.PaymentModel.AgentId;
                }
                $("#SelectedBank_Location").text(selectedText);
            }
        }

        //Redio Button Changes Event
        vm.checkStuff = function (value) {

            vm.validWay = false;
            if (value == "CashPickup") {

                vm.MoneyReceived = value;
                $localStorage.CashpickLocation = LocationName;
                $localStorage.AmountDetails.PaymentType = 'CashPickup';
                $("#SelectedBank_Location").text("Cash Pickup");
            } else {
                vm.MoneyReceived = value;
                $localStorage.AmountDetails.PaymentType = 'BankDeposit';
                $localStorage.CashpickLocation = LocationName;
                $localStorage.BankLocation = "Bank Deposit";
                $("#SelectedBank_Location").text("Bank Deposit");
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

        });

        vm.getcountrydata = function (id) {
            // Begin();
            var iCountryId = parseInt(id);
            var skillsSelect = document.getElementById("CountrySelected");
            var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
            vm.FlagModel = [];
            vm.isValidData = false;
            var formData = JSON.parse(JSON.stringify({ "phonecode": iCountryId, "CountryName": selectedText }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getcountryByPhoneCode',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                vm.FlagModel.CountryName = idata.CountryName;
                vm.FlagModel.iso = idata.iso;
                vm.FlagModel.CountryId = idata.CountryId;
                vm.FlagModel.CurrencyCode = idata.CurrencyCode;
                vm.FlagModel.Result = 'Success';
                if (idata.CurrencyCode != '') {
                    UpdateglobalExchange(idata.CurrencyCode);
                }


            });
            // Complete();
        }

        //Get Decimal

        var timeout;
        var delay = 500;
        //Amount collection
        vm.isValidData = false;
        vm.EnteredNumber = function (Amount) {
            vm.validnumber = false;
            if (timeout) {
                clearTimeout(timeout);
            }
            timeout = setTimeout(function () {
                Searchdata();
            }, delay);
        }

        //Search data to convert currency
        function Searchdata() {

            var Amount = vm.FlagModel.Amount;
            if (vm.FlagModel.Amount != "0" && vm.FlagModel.CurrencyCode != "") {

                vm.FlagModel.IsData = false;
                if (vm.FlagModel.CurrencyCode == "USD") {
                    vm.FlagModel.ExchangeRate = 1.00;
                    var ReciptAmt = Math.round(vm.FlagModel.ExchangeRate * vm.FlagModel.Amount);
                    vm.FlagModel.RecipientAmmount = Math.round(ReciptAmt);
                    vm.FlagModel.IsValid = true;

                    // SelectCountyState
                    //var skillsSelect = document.getElementById("SelectCountyState");
                    //var SelectedCountryState = skillsSelect.options[skillsSelect.selectedIndex].text;

                    $localStorage.AmountDetails.iso = vm.FlagModel.iso;
                    $localStorage.AmountDetails.CountryName = vm.FlagModel.CountryName;
                    $localStorage.AmountDetails.CountryId = vm.FlagModel.CountryId;
                    $localStorage.AmountDetails.Amount = vm.FlagModel.Amount;
                    $localStorage.AmountDetails.RecipientAmmount = vm.FlagModel.RecipientAmmount;
                    $localStorage.AmountDetails.CurrencyCode = vm.FlagModel.CurrencyCode;
                    $localStorage.AmountDetails.ExchangeRate = vm.FlagModel.ExchangeRate;
                    $localStorage.AmountDetails.SendingCurrency = "USD";
                    //$localStorage.AmountDetails.SelectedCountryState = SelectedCountryState;
                    $localStorage.AmountDetails.SelectedState = vm.SelectedState;
                    $localStorage.AmountDetails.Result = vm.FlagModel.Result;
                    vm.getFeeDetails(vm.FlagModel.CountryId);
                } else {
                    vm.FlagModel.IsValid = false;

                    ConvertMoney(vm.FlagModel.CurrencyCode);
                }
            } else {
                vm.validnumber = true;
                vm.FlagModel.IsData = false;
                setTimeout(function () {
                    Alert(2, "!sorry we can't proceed! ");
                }, 100);
            }
        }

        //Convert Currency
        function ConvertMoney(code) {
            //$localStorage.SelectedCountry.ConvertAmount = 0;
            var accesstoken = 'rxv51rk8b4y1kjhasvww';
            $http({
                url: 'https://currencydatafeed.com/api/converter.php?' + $.param({ token: accesstoken, from: code, to: "USD", amount: "1" }),
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
                .success(function (data) {
                    var idata = data;
                    if (idata.currency[0].value > 0) {
                        vm.FlagModel.IsData = true;
                        var value = parseFloat(idata.currency[0].value).toFixed(2)
                        //var newvalu = value
                        vm.FlagModel.ExchangeRate = Math.round(value);

                        vm.FlagModel.RecipientAmmount = parseFloat(value * vm.FlagModel.Amount).toFixed(2);
                        vm.isValidData = true;
                        //var skillsSelect = document.getElementById("SelectCountyState");
                        //var SelectedCountryState = skillsSelect.options[skillsSelect.selectedIndex].text;

                        $localStorage.AmountDetails.iso = vm.FlagModel.iso;
                        $localStorage.AmountDetails.CountryName = vm.FlagModel.CountryName;
                        $localStorage.AmountDetails.CountryId = vm.FlagModel.CountryId;
                        $localStorage.AmountDetails.Amount = vm.FlagModel.Amount;
                        $localStorage.AmountDetails.RecipientAmmount = vm.FlagModel.RecipientAmmount;
                        $localStorage.AmountDetails.CurrencyCode = vm.FlagModel.CurrencyCode;
                        $localStorage.AmountDetails.ExchangeRate = vm.FlagModel.ExchangeRate;
                        $localStorage.AmountDetails.SendingCurrency = "USD";
                        //$localStorage.AmountDetails.SelectedCountryState = SelectedCountryState;
                        $localStorage.AmountDetails.SelectedState = vm.SelectedState;
                        $localStorage.AmountDetails.Result = vm.FlagModel.Result;
                        vm.getFeeDetails(vm.FlagModel.CountryId);
                    }
                    else {
                        vm.isValidData = false;
                        vm.FlagModel.IsValid = false;
                        setTimeout(function () {
                            Alert(2, "!sorry we can't proceed. ");
                        }, 100);
                        vm.FlagModel.ExchangeRate = 0.00;
                    }

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
                        // $localStorage.SelectedCountry.ConvertAmount = value;
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
                            if (data.Result == "Success") {

                            }
                        });
                    }

                });
        }

        vm.getFeeDetails = function (DestinationCountry) {

            var formData = JSON.parse(JSON.stringify({ "CompanyId": 17, "DestinationCountry": DestinationCountry }));
            $http({
                method: 'POST',
                url: baseUrl + 'getPaymentFeesByCompanydestinationCountry',
                data: formData,
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {

                var idata = data;
                //vm.feeData = idata;
                var FareAmount = +vm.FlagModel.Amount;
                for (var i = 0; i < idata.length; i++) {
                    if (FareAmount <= idata[i].EndAmount) {
                        $localStorage.AmountDetails.Fee = idata[i].Fees;
                        vm.FlagModel.Fee = idata[i].Fees;
                    } else {
                        $localStorage.AmountDetails.Fee = "0.00";
                        vm.FlagModel.Fee = "0.00";
                    }
                }




            });
        }

        //app.SendMoney page-2
        vm.sendMoneyClick = function () {
            vm.stateSelect = false;
            if (vm.SelectedState != '0') {
                $localStorage.AmountDetails.SelectedState = vm.SelectedState;
                $state.go('app.SendMoney');
            }
            else {
                vm.stateSelect = true;
                return false
            }
        }

        //Proceed to next tab
        vm.CashPickUp = function () {
            debugger;
            vm.validWay = false;
            if (vm.PaymentModel.PaymentType == "BankDeposit") {

                if (vm.PaymentModel.BankId != '0') {
                    //$localStorage.BankLocation = '';
                    $localStorage.AmountDetails.PaymentType = "BankDeposit";

                    if ($localStorage.GustCustomer) {
                        $state.go('app.addEditBeneficiary');
                    } else {
                        $state.go('app.SendMoneylogin');
                    }
                } else { return false; }
            }
            else if (vm.PaymentModel.PaymentType == "CashPickup") {
                var skillsSelect = document.getElementById("PayOutLocation");
                var selectedValue = skillsSelect.options[skillsSelect.selectedIndex].value;
                var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
                if (selectedValue != "0") {
                    $localStorage.AmountDetails.PaymentType = "CashPickup";
                    $localStorage.CashpickLocation = selectedText;
                    //$localStorage.AmountDetails.BeneficiaryId = '';
                    if ($localStorage.GustCustomer) {
                        $state.go('app.addEditBeneficiary');
                    } else {
                        $state.go('app.SendMoneylogin');
                    }
                }
                else {
                    vm.validWay = true;
                    return false;
                }
            }
            else {
                vm.validWay = true;
                return false;
            }
        }
        //$state.go('app.CashPickUp');

        //Back
        vm.SendBack = function () {
            $localStorage.Location = '';
            $state.go('app.SendMoneyAmount');
        }
    }




    manageSendMoneyLoginController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageSendMoneyLoginController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;

        var CompanyId = 0;
        vm.CustomerID = 0;
        vm.IsLogin = false;
        if ($localStorage.GustCustomer) {
            vm.IsLogin = true;
        }
        //vm.CustomerStorage = { GustCustomer: '0' };

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
                    if ($localStorage.AmountDetails.Amount) {
                        $state.go('app.addEditBeneficiary')
                        //if ($localStorage.AmountDetails.PaymentType == "BankDeposit") {

                        //}
                        //else if ($localStorage.AmountDetails.PaymentType == "CashPickup") {
                        //    //$state.go('app.cashPickUpLocation')
                        //    $state.go('app.addEditBeneficiary')
                        //}
                    }
                    else {
                        //$state.go('app.makepayment');
                        $state.go('app.SendMoneyAmount')
                    }
                    //setTimeout(function () { window.location.reload(); }, 1000);
                    //} else {
                    //    //$state.go('app.makepayment');
                    //    $state.go('app.SendMoneyAmount')
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
                    $localStorage.PaymentData = '';
                    $localStorage.AmountDetails = '';
                    $localStorage.MobileNumber = '';
                    $localStorage.SelectedCountry = '';
                    $state.go('app.customerPortal');
                }, time);
            }, timeout);
        }

        vm.goBack = function () {
            vm.localStorage.GustData = '';
            $localStorage.PaymentModel = '';
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

                                if ($localStorage.AmountDetails.Amount) {
                                    $state.go('app.CashPickUp')
                                    //setTimeout(function () { window.location.reload(); }, 1000);
                                } else {
                                    //$state.go('app.makepayment');
                                    $state.go('app.SendMoneyAmount');
                                }
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

        vm.logoutGustCustomer = function () {

            $localStorage.GustCustomer = '';
            $localStorage.ReceivingAmount = '';
            $localStorage.AmountDetails = '';
            $localStorage.Location = '';
            $localStorage = [];

            setTimeout(function () {
                //$window.location.reload();
                $state.go('app.sending_loop');
            }, 1000);

        }


    }

    authenticateSendMoneyController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function authenticateSendMoneyController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
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
            $window.location.assign('#/app/SendMoney');
        }
    }

    addEditBeneficiaryController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function addEditBeneficiaryController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {

        var vm = $scope;
        vm.SelectedCustomer = [];
        //Testing
        vm.BenData = [];

        vm.companyId = 0;
        vm.CustomerId = 0;
        if ($localStorage.GustCustomer) {
            vm.SelectedCustomer = $localStorage.GustCustomer;
            if (vm.SelectedCustomer.CustomerId) {
                vm.companyId = vm.SelectedCustomer.CompanyId;
                vm.CustomerId = vm.SelectedCustomer.CustomerId;
            }
        }
        var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.CustomerId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getbeneficiarydetails ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.Beneficiaries = idata;
        });

        //GetFirstIndex
        if ($localStorage.Agents) {

            var dd = ($localStorage.Agents);

            var data123 = $filter('filter')(dd, {
                AgentId: parseInt($localStorage.CashpickLocationId),
            }, true);
            if (data123.length > 0)
                var LocationName = (data123[0].AgentFirstName + ' ' + data123[0].AgentLastName + '-' + data123[0].AgentCode);
        }
        if ($localStorage.BeneficiaryModel) {
            var iBenficiaryId = $localStorage.BeneficiaryModel.BeneficiaryId;
            if (iBenficiaryId > 0) {
                //ddlBeneficiary
                //vm.PaymentModel.BeneficiaryId = iBenficiaryId;
                Beneficiary(iBenficiaryId);


                setTimeout(function () {
                    var dd = document.getElementById('ddlBeneficiary');
                    var textn = $localStorage.BeneficiaryModel.FirstName;
                    //dd.options[dd.selectedIndex].value(iBenficiaryId);
                    for (var i = 0; i < dd.options.length; i++) {
                        if (dd.options[i].text === textn) {
                            dd.selectedIndex = i;
                            break;
                        }
                    }
                }, 1000);

            }

        }

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.companyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getAgentdetailsByCompanyId ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            debugger;
            var idata = data;
            vm.PickUpLocation = idata;
        });

        vm.PaymentMethods = [];
        vm.BeneficiaryModel = { CompanyId: vm.companyId, CustomerId: vm.CustomerId, CountryId: "0", BeneficiaryTypeId: '0' };
        vm.Beneficiary = { AccountNumber: '', RoutingNumber: '', AgentId: '0', BICCode: '' }
        //Get Method Details
        //BeneficiaryModel
        $http({
            method: 'GET',
            url: baseUrl + 'getcountrydetails',
            headers: { 'Content-Type': 'application/json' }
        })
   .success(function (data) {
       var idata = data;
       vm.Countries = idata;

   });
        vm.BenData = $localStorage;
        vm.Beneficiary.AgentId = vm.BenData.CashpickLocationId;
        //Check Preffrerd Location

        if (vm.BenData.AmountDetails.PaymentType == 'BankDeposit') {
            document.getElementById("BankDepositCheck").checked = true;
            document.getElementById("CashPickUpCheck").checked = false;
        }
        else if (vm.BenData.AmountDetails.PaymentType == 'CashPickup') {
            document.getElementById("CashPickUpCheck").checked = true;
            document.getElementById("BankDepositCheck").checked = false;
        }


        $http({
            method: 'GET',
            url: baseUrl + 'getbeneficiarytypedetails',
            headers: { 'Content-Type': 'application/json' }
        })
     .success(function (data) {
         var idata = data;
         vm.BeneficiaryType = idata;

     });


        vm.addNewBeneficiary = function () {
            $('#addBeneficiaryconfirm').modal('toggle');
        }

        vm.selectedBeneficiary = function (Id) {

            var iBeneficiaryId = parseInt(Id);
            if (iBeneficiaryId > 0) {
                Beneficiary(iBeneficiaryId);
            }
        }


        function Beneficiary(Id) {

            var iBeneficiaryId = parseInt(Id);
            if (iBeneficiaryId > 0) {
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
                     if (idata) {
                         idata.ZipCode = parseInt(idata.ZipCode);
                         idata.Phone = parseInt(idata.Phone);
                         idata.CountryId = JSON.stringify(idata.CountryId);
                         idata.BeneficiaryTypeId = JSON.stringify(idata.BeneficiaryTypeId);
                         vm.BeneficiaryModel = idata;

                         if (vm.BenData.AmountDetails.PaymentType == 'BankDeposit') {
                             vm.Beneficiary.AccountNumber = vm.BeneficiaryModel.AccountNumber;
                             vm.Beneficiary.RoutingNumber = vm.BeneficiaryModel.RoutingNumber;
                             vm.Beneficiary.BICCode = vm.BeneficiaryModel.BICCode;
                             //vm.BenData.BankLocation = vm.BeneficiaryModel.BankName;
                             $localStorage.BankLocation = vm.BeneficiaryModel.BankName;
                             $localStorage.CashpickLocation = LocationName;
                             $localStorage.AmountDetails.PaymentType = "BankDeposit";
                         }

                         $localStorage.BeneficiaryModel = vm.BeneficiaryModel;
                     }
                 });
            }
        }

        vm.CreateBeneficiary = function () {
            if (!vm.BeneficiaryModel.Address2) {
                vm.BeneficiaryModel.Address2 = "";
            }
            var idata = vm.BeneficiaryModel;

            //idata.ZipCode = JSON.stringify(idata.ZipCode);
            if (idata.BeneficiaryId) {
                var formData = JSON.stringify(idata);
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'addbeneficiary',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.Result == "Sucess") {
                        $('#addBeneficiaryconfirm').modal('toggle');
                        Alert(1, "! Beneficiary created successfully");
                        vm.BeneficiaryModel = angular.copy(vm.BeneficiaryModel);
                        $window.location.reload();
                    }
                    else {
                        Alert(2, idata.Error);
                    }
                });
            }
            var formData = JSON.stringify(idata);
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'addbeneficiary',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata && idata.Result == "Sucess") {
                    $('#addBeneficiaryconfirm').modal('toggle');
                    Alert(1, "! Beneficiary created successfully");
                    vm.BeneficiaryModel = angular.copy(vm.BeneficiaryModel);
                    $window.location.reload();
                }
                else {
                    Alert(2, idata.Error);
                }
            });
        }

        //Changes Preffrence from dropdown

        vm.ChangeLocation = function (id) {
            var skillsSelect = document.getElementById("Locationpickup");
            var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
            if (selectedText != '') {
                document.getElementById("BankDepositCheck").checked = false;
                document.getElementById("CashPickUpCheck").checked = true;
                //$localStorage.BankLocation = 'Bank';
                $localStorage.CashpickLocation = selectedText;
                $localStorage.AmountDetails.PaymentType = "CashPickup";
                vm.BenData = $localStorage;
            }
        }

        //Next Page
        vm.CashPickUp = function (Id) {
            debugger;
            vm.ValidAcountRoute = false;
            var route = vm.BeneficiaryModel.RoutingNumber;
            var account = vm.BeneficiaryModel.AccountNumber;

            var e = document.getElementById("ddlBeneficiary");
            var ibenificiaryId = e.options[e.selectedIndex].value;


            var BenificryId = parseInt(ibenificiaryId);
            if (BenificryId > 0 && account != '' && route != '') {
                $localStorage.AmountDetails.BeneficiaryId = BenificryId;
                $state.go('app.Payment')
            }
            else {
                vm.ValidAcountRoute = true;
                return false;

            }

        }

        //Back
        vm.SendBack = function () {
            vm.BenData = '';
            $localStorage.AmountDetails.PaymentType = "";
            $localStorage.CashpickLocation = "";
            $localStorage.BankLocation = "";
            $state.go('app.SendMoney')
        }

        FillDropDown();
        //Set Drop-Dwon Value
        function FillDropDown() {
            if (vm.BenData.AmountDetails.PaymentType == 'CashPickup') {
                setTimeout(function () {

                    var theText = $localStorage.CashpickLocation;
                    var index = parseInt($localStorage.CashpickLocationId);
                    var dd = document.getElementById('Locationpickup');

                    for (var i = 0; i < dd.options.length; i++) {
                        if (dd.options[i].index === index) {
                            dd.selectedIndex = i;
                            break;
                        }
                    }
                }, 1000);
            }
        }



        //Change prefference by Radio button
        vm.ChangePrefered = function () {

            if (document.getElementById('BankDepositCheck').checked) {
                $localStorage.CashpickLocation = LocationName;
                $localStorage.CashpickLocationId = '0';
                $localStorage.BankLocation = 'Bank Deposit';
                $localStorage.AmountDetails.PaymentType = 'BankDeposit';
                vm.BenData = $localStorage;
                vm.Beneficiary.AccountNumber = vm.BeneficiaryModel.AccountNumber;
                vm.Beneficiary.RoutingNumber = vm.BeneficiaryModel.RoutingNumber;
                vm.Beneficiary.BICCode = vm.BeneficiaryModel.BICCode;
                vm.BenData.BankLocation = vm.BeneficiaryModel.BankName;


            }
            else if (document.getElementById('CashPickUpCheck').checked) {
                //$localStorage.BankLocation = '';
                $localStorage.AmountDetails.PaymentType = 'CashPickup';
                $localStorage.CashpickLocation = LocationName;
                $localStorage.CashpickLocationId = '0';
                vm.BenData = $localStorage;
                FillDropDown();
            }
        }


        //vm.PickUpLocation = [{ LocationId: '1', Location: 'Wallmart' }, { LocationId: '2', Location: 'Zapopan' }, { LocationId: '3', Location: 'Chihuahua' }, { LocationId: '4', Location: 'San Luis Potosí' },
        //    { LocationId: '5', Location: 'Mexicali' }
        //];
    }

    addCashPickUpController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function addCashPickUpController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        vm.MoneyReceived = "";
        vm.PaymentModel = [{ PaymentMethodId: '0', CompanyId: 0, CustomerId: 0, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '2', BeneficiaryId: '0', ExchangeRate: '64.60', setExpirationDate: '', RecipientAmmount: '', TransactionDetail: '', DeliveryType: '', TransferPurpose: '', Amount: '', CountryId: "", CountryName: "", iso: "", BankDeposit: "", CashPickUp: "", LocationId: '0' }];
        vm.localStorage = {};

        if ($localStorage.AmountDetails) {

            vm.PaymentModel = $localStorage.AmountDetails;
            vm.PaymentModel.SendingCurrencyId = $localStorage.AmountDetails.SendingCurrency;
            vm.PaymentModel.ReceivingCurrencytId = $localStorage.AmountDetails.CurrencyCode;
            vm.PaymentModel.LocationId = '0';
            if ($localStorage.GustCustomer) {
                vm.localStorage = $localStorage.GustCustomer;
            }
            console.log(vm.PaymentModel);
        }
        else {
            $state.go('app.SendMoneyAmount')
        }

        vm.checkStuff = function (value) {

            if (value == "Cash Pickup") {
                document.getElementById("BankDepositCheck").checked = false;
                document.getElementById("CashPickUpCheck").checked = true;
                vm.MoneyReceived = value;
            } else {
                document.getElementById("BankDepositCheck").checked = true;
                document.getElementById("CashPickUpCheck").checked = false;
                vm.MoneyReceived = value;
            }
        }

        //vm.PickUpLocation = [{ LocationId: '1', Location: 'Tijuana' }, { LocationId: '2', Location: 'Zapopan' }, { LocationId: '3', Location: 'Chihuahua' }, { LocationId: '4', Location: 'San Luis Potosí' },
        //    { LocationId: '5', Location: 'Mexicali' }
        //];


        vm.goToPaymentMethod = function () {
            vm.validlocation = false;
            if (vm.PaymentModel.LocationId != "0") {
                if ($localStorage.GustCustomer) {
                    $localStorage.Location = vm.PaymentModel.LocationId;
                    $localStorage.AmountDetails.MoneyReceived = vm.MoneyReceived;
                    $state.go('app.Payment');
                } else {
                    $state.go('app.SendMoneylogin');
                }
            }
            else {
                vm.validlocation = true;
                return false;
            }
        }


        vm.SendBack = function () {
            //$localStorage.AmountDetails.BeneficiaryId = '';
            $localStorage.Location = '';
            $state.go('app.SendMoney');
        }



    }

    makeSendMoneyPaymentController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function makeSendMoneyPaymentController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        vm.SelectedCustomer = [];

        vm.PaymentModel = '';

        if (($localStorage.AmountDetails.CardNumber)) {
            $localStorage.AmountDetails.CardNumber = '';
        } if ($localStorage.AmountDetails.cvv) {
            $localStorage.AmountDetails.cvv = '';
        } if ($localStorage.AmountDetails.PaymentMethodId) {
            $localStorage.AmountDetails.PaymentMethodId = '';
        }
        vm.AddressData = $localStorage;
        vm.PaymentModel = $localStorage.AmountDetails;

        vm.companyId = 0;
        vm.CustomerId = 0;
        if ($localStorage.GustCustomer) {
            vm.SelectedCustomer = $localStorage.GustCustomer;
            if (vm.SelectedCustomer.CustomerId) {
                vm.companyId = vm.SelectedCustomer.CompanyId;
                vm.CustomerId = vm.SelectedCustomer.CustomerId;
            }
        }
        vm.ModelData = { PaymentMethodId: '0', CompanyId: vm.companyId, CustomerId: vm.CustomerId, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '3', BeneficiaryId: '0', ExchangeRate: '0.00', setExpirationDate: '', ReceivingAmount: '' }

        //Checked Preffrerd Location
        if ($localStorage.Agents) {
            var dd = ($localStorage.Agents);
            var LocationName = (dd[0].AgentFirstName + ' ' + dd[0].AgentLastName + '-' + dd[0].AgentCode);
        }

        //str.replace(/.(?=.{4})/g, 'x');
        if (vm.AddressData.AmountDetails.PaymentType == 'BankDeposit') {
            document.getElementById("rdBankDeposit").checked = true;

        }
        else if (vm.AddressData.AmountDetails.PaymentType == 'CashPickup') {
            document.getElementById("redioCashPickup").checked = true;
        }



        if ($localStorage.AmountDetails) {
            vm.ModelData.BeneficiaryId = $localStorage.AmountDetails.BeneficiaryId;
            vm.ModelData.ExchangeRate = $localStorage.AmountDetails.ExchangeRate;
            vm.ModelData.ReceivingAmount = $localStorage.AmountDetails.RecipientAmmount;
            vm.ModelData.SendingAmount = (($localStorage.AmountDetails.Amount - 0) + ($localStorage.AmountDetails.Fee - 0)).toFixed(2);
            vm.ModelData.Fees = $localStorage.AmountDetails.Fee;
            var accountN = $localStorage.BeneficiaryModel.AccountNumber;
            vm.AddressData.BeneficiaryModel.AccountNumber = accountN.replace(/.(?=.{4})/g, 'x');
        }

        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.companyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompanyid ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            //vm.PaymentMethods.PaymentMethodId = idata[0].PaymentMethodId;
            vm.PaymentMethods = idata;
        });


        var cardNumber = $('#CardNumber');
        var cardNumberField = $('#card-number-field');
        var CvvNumberField = $('#cvv-Field');
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
                    if (CvvNumberField.hasClass('has-success')) {
                        CvvNumberField.removeClass('has-success');
                        CvvNumberField.addClass('has-error');
                    } else {
                        CvvNumberField.addClass('has-error');
                    }

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
        vm.PayNow = function () {
            $('#Payconfirm').modal('toggle');
            vm.alert = false;
        }


        vm.Create = function () {

            $('#Payconfirm').modal('toggle');
            var idata = vm.ModelData;
            //if ($localStorage.AmountDetails.PaymentType == "CashPickup") {
            idata.TransferPurpose = $localStorage.AmountDetails.PaymentType;
            idata.TransactionDetail = $localStorage.AmountDetails.PaymentType;
            idata.DeliveryType = $localStorage.AmountDetails.PaymentType;
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

                    var sMonth = vm.ExpireModel.ExpireMonth;
                    if (sMonth < 10) {
                        sMonth = '0' + sMonth
                    }
                    var sYear = vm.ExpireModel.ExpireYear;
                    var expiremonth = sMonth + '' + sYear;
                    idata.setExpirationDate = expiremonth;
                    var Method = '';

                    if (idata.PaymentMethodId == "1") {
                        Method = 'makePayment';
                    }
                    else if (idata.PaymentMethodId == "12") {
                        Method = 'magicPay';
                        idata.SenderName = vm.SelectedCustomer.FirstName;
                    }
                    idata.CompanyId = vm.companyId;
                    idata.CustomerId = vm.CustomerId;
                    var formData = JSON.stringify(idata);
                    $http({
                        method: 'POST',
                        data: formData,
                        url: baseUrl + Method,
                        headers: { 'Content-Type': 'application/json' },
                        dataType: "json",
                    })
                    .success(function (data) {
                        var idata = data;

                        if (idata && idata.TransactionId > 0) {
                            Alert(1, "! Payment processed successfully");
                            vm.PaymentModel = angular.copy(vm.PaymentModel);
                            $localStorage.PaymentGatewayTransactionId = idata.PaymentGatewayTransactionId;
                            //$localStorage.AmountDetails = '';

                            setTimeout(function () {
                                $state.go('app.SendMoneyThankyou');
                            }, 500);
                        }
                        else {
                            // $localStorage.Agents = '';
                            idata = [];
                            Alert(2, idata.Error);
                        }
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
            //}
            //else { $state.go('app.SendMoneyThankyou'); }
        }

        vm.cancel = function () {
            $localStorage.Location = '';
            vm.localStorage.GustData = '';
            $localStorage.AmountDetails = '';
            $localStorage.BeneficiaryModel = '';
            $localStorage.CashpickLocation = '';
            $localStorage.BankLocation = '';
            vm.localStorage.SelectedCountry = '';
            $state.go('app.SendMoneyAmount');
        }

        //Change payment method
        vm.ChangePrefered = function () {

            if (document.getElementById('rdBankDeposit').checked) {
                $localStorage.BankLocation = 'Bank Deposit';
                $localStorage.CashpickLocation = LocationName;
                $localStorage.AmountDetails.PaymentType = 'BankDeposit';


            }
            else if (document.getElementById('redioCashPickup').checked) {
                $localStorage.AmountDetails.PaymentType = 'CashPickup';
                $localStorage.CashpickLocation = LocationName;
            }
        }


        vm.MoveBack = function () {
            var data = $localStorage;

            if (data.Location != '') {
                $state.go('app.cashPickUpLocation');
            }
            else if (data.AmountDetails.BeneficiaryId > 0) {
                $state.go('app.addEditBeneficiary');
            }
        }

    }



    sendMoneythankyouController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function sendMoneythankyouController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerId = 0;
        if ($localStorage.GustCustomer) {
            vm.SelectedCustomer = $localStorage.GustCustomer;
            if (vm.SelectedCustomer.CustomerId) {
                vm.companyId = vm.SelectedCustomer.CompanyId;
                vm.CustomerId = vm.SelectedCustomer.CustomerId;
            }
        }


        vm.ThankyouDetails = $localStorage;


        vm.viewTransactions = function () {
            vm.ThankyouDetails = '';
            $localStorage.Location = '';
            $localStorage.PaymentGatewayTransactionId = '';
            $localStorage.AmountDetails = '';
            $localStorage.BeneficiaryModel = '';
            $localStorage.CashpickLocation = '';
            $localStorage.BankLocation = '';
            //vm.localStorage.SelectedCountry = '';
            if ($localStorage.GustCustomer) {
                //$state.go('app.SendMoneyTransaction');
                $state.go('app.SendMoneyAmount');
            } else {
                $state.go('app.SendMoneyAmount');
            }

        }

    }

    managesendMoneyTransactionController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function managesendMoneyTransactionController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerId = 0;


        $('body').removeClass('modal-open').css('padding-right', '0px');

        if ($localStorage.GustCustomer) {
            vm.SelectedCustomer = $localStorage.GustCustomer;
            if (vm.SelectedCustomer.CustomerId) {
                vm.companyId = vm.SelectedCustomer.CompanyId;
                vm.CustomerId = vm.SelectedCustomer.CustomerId;
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
            idata.sort(function (a, b) {
                (a.TransactionId) - (b.TransactionId);
            });
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
                 setTimeout(function () {
                     $('#transactionDetails').modal('toggle');
                 }, 1000);
             });

        }
    }



})();
