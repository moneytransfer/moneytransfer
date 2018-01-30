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


    manageSendMoneyController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageSendMoneyController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        vm.PaymentData = { PaymentMethodId: '0', CompanyId: 0, CustomerId: 0, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '2', BeneficiaryId: '0', ExchangeRate: '64.60', setExpirationDate: '', ReceivingAmount: '', TransactionDetail: '', DeliveryType: '', TransferPurpose: '', SendingAmount: '', };
        vm.PaymentModel = [{ PaymentMethodId: '0', CompanyId: 0, CustomerId: 0, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '2', BeneficiaryId: '0', ExchangeRate: '64.60', setExpirationDate: '', ReceivingAmount: '', TransactionDetail: '', DeliveryType: '', TransferPurpose: '', SendingAmount: '', CountryId: "", CountryName: "", iso: "", SelectedCountryState: "", SelectedState: '', BankDeposit: "", CashPickUp: "" }];
        vm.FlagModel = [];
        vm.PaybillModel = { CountryId: 0, CountryName: '', iso: "", CurrencyName: "", CurrencySymbol: "", CurrencyCode: "", Amount: '0.00' }
        vm.AmountDetails = { CurrencyCode: "", Amount: "", ExchangeRate: "", RecipientAmmount: "", SendingCurrency: "", CountryName: "", CountryId: "", iso: "", SelectedCountryState: "", SelectedState: "" };
        vm.localStorage = [];
        if ($localStorage.AmountDetails) {
            vm.PaymentModel.iso = $localStorage.AmountDetails.iso;
            vm.PaymentModel.CountryName = $localStorage.AmountDetails.CountryName;
            vm.PaymentModel.CountryId = $localStorage.AmountDetails.CountryId;
            vm.PaymentModel.SendingAmount = $localStorage.AmountDetails.Amount;
            vm.PaymentModel.ReceivingAmount = $localStorage.AmountDetails.RecipientAmmount;
            vm.PaymentModel.SendingCurrency = $localStorage.AmountDetails.SendingCurrency;
            vm.PaymentModel.ReceivingCurrency = $localStorage.AmountDetails.CurrencyCode;
            vm.PaymentModel.ExchangeRate = $localStorage.AmountDetails.ExchangeRate;

            vm.PaymentModel.SelectedCountryState = $localStorage.AmountDetails.SelectedCountryState;

            vm.PaymentModel.SelectedState = $localStorage.AmountDetails.SelectedState;
            $localStorage.AmountDetails = $localStorage.AmountDetails;
        } else {
            $localStorage.PaymentData = vm.PaymentData;
            $localStorage.AmountDetails = vm.AmountDetails;
            $state.go('app.SendMoneyAmount')
        }
        vm.SelectedState = "0";

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


            });
        }



        var timeout;
        var delay = 500;
        vm.isValidData = false;
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
            if (vm.FlagModel.Amount != "0" && vm.FlagModel.CurrencyCode != "") {
                vm.FlagModel.IsData = false;
                if (vm.FlagModel.CurrencyCode == "USD") {
                    vm.FlagModel.ExchangeRate = 1.00;
                    vm.FlagModel.RecipientAmmount = vm.FlagModel.ExchangeRate * vm.FlagModel.Amount;
                    vm.FlagModel.IsValid = true;
                    $localStorage.AmountDetails.iso = vm.FlagModel.iso;
                    $localStorage.AmountDetails.CountryName = vm.FlagModel.CountryName;
                    $localStorage.AmountDetails.CountryId = vm.FlagModel.CountryId;
                    $localStorage.AmountDetails.Amount = vm.FlagModel.Amount;
                    $localStorage.AmountDetails.RecipientAmmount = vm.FlagModel.RecipientAmmount;
                    $localStorage.AmountDetails.CurrencyCode = vm.FlagModel.CurrencyCode;
                    $localStorage.AmountDetails.ExchangeRate = vm.FlagModel.ExchangeRate;
                    $localStorage.AmountDetails.SendingCurrency = "USD";
                    $localStorage.AmountDetails.SelectedCountryState = vm.FlagModel.SelectedCountryState;
                    $localStorage.AmountDetails.SelectedState = vm.SelectedState;
                    $localStorage.AmountDetails.Result = vm.FlagModel.Result;
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
                        vm.FlagModel.IsData = true;
                        var value = parseFloat(idata.currency[0].value).toFixed(2)
                        //var newvalu = value
                        vm.FlagModel.ExchangeRate = value
                        vm.FlagModel.RecipientAmmount = parseFloat(value * vm.FlagModel.Amount).toFixed(2);
                        vm.isValidData = true;
                        $localStorage.AmountDetails.iso = vm.FlagModel.iso;
                        $localStorage.AmountDetails.CountryName = vm.FlagModel.CountryName;
                        $localStorage.AmountDetails.CountryId = vm.FlagModel.CountryId;
                        $localStorage.AmountDetails.Amount = vm.FlagModel.Amount;
                        $localStorage.AmountDetails.RecipientAmmount = vm.FlagModel.RecipientAmmount;
                        $localStorage.AmountDetails.CurrencyCode = vm.FlagModel.CurrencyCode;
                        $localStorage.AmountDetails.ExchangeRate = vm.FlagModel.ExchangeRate;
                        $localStorage.AmountDetails.SendingCurrency = "USD";
                        $localStorage.AmountDetails.SelectedCountryState = vm.FlagModel.SelectedCountryState;
                        $localStorage.AmountDetails.SelectedState = vm.SelectedState;
                        $localStorage.AmountDetails.Result = vm.FlagModel.Result;
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

        vm.sendMoneyClick = function () {
            $state.go('app.SendMoney');
        }






        vm.CashPickUp = function () {
           
                if (vm.PaymentModel.PaymentType == "BankDeposit") {
                    if ($localStorage.GustCustomer) {
                        $state.go('app.addEditBeneficiary');
                    } else {
                        $state.go('app.SendMoneylogin');
                    }
                }
                else if (vm.PaymentModel.PaymentType == "CashPickup") {
                    if ($localStorage.GustCustomer) {
                        $state.go('app.SendMoney');
                    } else {
                        $state.go('app.SendMoneylogin');
                    }
                }
                else {
                    return false;
                }
            }
            //$state.go('app.CashPickUp');

        
        vm.SendBack = function () {
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
                        //setTimeout(function () { window.location.reload(); }, 1000);
                    } else {
                        //$state.go('app.makepayment');
                        $state.go('app.SendMoneyAmount')
                    }

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
            $localStorage.PaymentData = '';
            $localStorage.BeneficiaryId = '';
            $localStorage.ReceivingAmount = '';
            $localStorage.AmountDetails = '';

            $localStorage = [];
            $state.go('app.SendMoney');
            //setTimeout(function () {
            //    $window.location.reload();

            //}, 1000);

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

    addEditBeneficiaryController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditBeneficiaryController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
        vm.SelectedCustomer = [];

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
        vm.PaymentMethods = [];
        vm.BeneficiaryModel = { CompanyId: vm.companyId, CustomerId: vm.CustomerId, CountryId: "0", BeneficiaryTypeId: '0' };
        vm.Beneficiary = { AccountNumber: 0, RoutingNumber: 0 }
        //Get Method Details

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
            url: baseUrl + 'getbeneficiarytypedetails',
            headers: { 'Content-Type': 'application/json' }
        })
     .success(function (data) {
         var idata = data;
         vm.BeneficiaryType = idata;

     });


        vm.addNewBeneficiary = function () {
            debugger;
            // DeleteCompanyID = Id;
            $('#addBeneficiaryconfirm').modal('toggle');
        }

        vm.selectedBeneficiary = function (Id) {
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
                 if (idata) {
                     idata.ZipCode = parseInt(idata.ZipCode);
                     idata.Phone = parseInt(idata.Phone);
                     idata.CountryId = JSON.stringify(idata.CountryId);
                     idata.BeneficiaryTypeId = JSON.stringify(idata.BeneficiaryTypeId);

                     vm.BeneficiaryModel = idata;
                 }
             });
        }
        vm.CreateBeneficiary = function () {
            if (!vm.BeneficiaryModel.Address2) {
                vm.BeneficiaryModel.Address2 = "";
            }
            var idata = vm.BeneficiaryModel;
            //idata.ZipCode = JSON.stringify(idata.ZipCode);
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



        vm.CashPickUp = function (Id) {

            var BenificryId = parseInt(Id);
            if (BenificryId > 0) {

                $localStorage.PaymentData.BeneficiaryId = BenificryId;
                $state.go('app.CashPickUp')
            }
            else {
                return false;

            }

        }
    }

    addCashPickUpController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function addCashPickUpController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        vm.MoneyReceived = "";
        vm.PaymentModel = [{ PaymentMethodId: '0', CompanyId: 0, CustomerId: 0, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '2', BeneficiaryId: '0', ExchangeRate: '64.60', setExpirationDate: '', RecipientAmmount: '', TransactionDetail: '', DeliveryType: '', TransferPurpose: '', Amount: '', CountryId: "", CountryName: "", iso: "", BankDeposit: "", CashPickUp: "" }];
        vm.localStorage = {};

        if ($localStorage.AmountDetails) {

            vm.PaymentModel = $localStorage.AmountDetails;
            vm.PaymentModel.SendingCurrencyId = $localStorage.AmountDetails.SendingCurrency;
            vm.PaymentModel.ReceivingCurrencytId = $localStorage.AmountDetails.CurrencyCode;
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
                vm.MoneyReceived = value;
            } else {
                vm.MoneyReceived = value;
            }
        }

        vm.goToPaymentMethod = function () {
            if ($localStorage.GustCustomer) {
                $localStorage.AmountDetails.MoneyReceived = vm.MoneyReceived;
            } else {
                $state.go('app.SendMoneylogin');
            }
        }
        vm.SendBack = function () {
            $state.go('app.SendMoney');
        }



    }
    makeSendMoneyPaymentController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function makeSendMoneyPaymentController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        vm.SelectedCustomer = [];

        vm.PaymentModel = '';
        if (($localStorage.PaymentData.CardNumber)) {
            $localStorage.PaymentData.CardNumber = '';
        } if ($localStorage.PaymentData.cvv) {
            $localStorage.PaymentData.cvv = '';
        } if ($localStorage.PaymentData.PaymentMethodId) {
            $localStorage.PaymentData.PaymentMethodId = '';
        }

        vm.PaymentModel = $localStorage.PaymentData;
        vm.companyId = 0;
        vm.CustomerId = 0;
        if ($localStorage.GustCustomer) {
            vm.SelectedCustomer = $localStorage.GustCustomer;
            if (vm.SelectedCustomer.CustomerId) {
                vm.companyId = vm.SelectedCustomer.CompanyId;
                vm.CustomerId = vm.SelectedCustomer.CustomerId;
            }
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
            debugger
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
                    var idata = vm.PaymentModel;

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
                            $localStorage.PaymentData = '';
                            $state.go('app.SendMoneyThankyou');
                            setTimeout(function () {
                                $state.go('app.SendMoneyThankyou');
                            }, 1000);
                        }
                        else {
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
        }

        vm.cancel = function () {
            vm.localStorage.GustData = '';
            $localStorage.PaymentData = '';
            vm.localStorage.SelectedCountry = '';
            $state.go('app.SendMoney');
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
        vm.viewTransactions = function () {
            if ($localStorage.GustCustomer) {
                $state.go('app.SendMoneyTransaction');
            } else {
                $state.go('app.SendMoney');
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

})();
