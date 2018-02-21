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
    manageGustCustomerController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageGustCustomerController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;

        vm.CompanyId = 0;
        vm.CustomerId = 0;
        vm.CustomerName = '';
        vm.CurrencyData = [];
        // remove default
        vm.isPayAmmount = false;
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
            $state.go('app.customerPortal')
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
                                var res = idata.internationalCodes.split(" ");
                                var codelength = res[0].length;
                                idata.internationalCodes = res[0];
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
                        if (vm.CountryDetails.phonecode != '0') {
                            if (idata.internationalCodes != vm.CountryDetails.phonecode) {
                                vm.CountryDetails.phonecode = '0';
                            }
                            if (idata.currencyCode == "MXN") {
                                var res = idata.internationalCodes.split(" ");
                                vm.CountryDetails.phonecode = res[0];
                                idata.internationalCodes = res[0];
                            }
                            else {
                                vm.CountryDetails.phonecode = idata.internationalCodes;
                            }
                        }

                        else {
                            if (idata.currencyCode == "MXN") {
                                var res = idata.internationalCodes.split(" ");
                                vm.CountryDetails.phonecode = res[0];
                                idata.internationalCodes = res[0];
                            }
                            else {
                                vm.CountryDetails.phonecode = idata.internationalCodes;
                            }//vm.CountryDetails = sData;
                        }
                        if (idata.currencyCode == "USD") {
                            $localStorage.SelectedCountry.ConvertAmount = 1.00;
                        }
                        else { ConvertMoney(idata.currencyCode); }

                        $localStorage.SelectedCountry = idata;

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
        vm.checkPayAmmount = function () {
            
            vm.isPayAmmount=false;
        }


        vm.selectAmmount = function (ammount) {
            vm.isPayAmmount=true;
            $('#amountfeild').val(ammount);
            $localStorage.Ammount = ammount;
            //vm.PaybillModel.Amount = ammount;
          
            $('#proceedButton').prop('disabled', false);
        }

        vm.proceed = function () {
      
            if ($("#from_id").valid()) {
               
                if ($localStorage.Ammount) {
                    var Amt = parseFloat($('#amountfeild').val());
                    var fareAmmount = Amt * $localStorage.SelectedCountry.ConvertAmount;
                    $localStorage.Ammount = Amt;
                    $localStorage.FareAmmount = fareAmmount;
                    setTimeout(function () {
                        $state.go('app.reviewAmmount');
                    }, 100);
                }
            } else {
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


        vm.PayAmount = [{ AmountId: '1', Amount: '10.00' }, { AmountId: '2', Amount: '20.00' },
                        { AmountId: '3', Amount: '30.00' }, { AmountId: '4', Amount: '40.00' },
                        { AmountId: '5', Amount: '50.00' }, { AmountId: '6', Amount: '60.00' },
                        { AmountId: '7', Amount: '70.00' }, { AmountId: '8', Amount: '80.00' },
                        { AmountId: '9', Amount: '90.00' }, { AmountId: '10', Amount: '100.00' },
                        { AmountId: '11', Amount: '110.00' }, { AmountId: '12', Amount: '120.00' },
                        { AmountId: '13', Amount: '130.00' }, { AmountId: '14', Amount: '140.00' },
                        { AmountId: '15', Amount: '150.00' }, { AmountId: '16', Amount: '160.00' }];

        vm.goBack = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.FareAmmount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $localStorage.ThankyouPageData = '';
            $state.go('app.customerPortal');
        }

        vm.cancel = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.FareAmmount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $localStorage.ThankyouPageData = '';
            $state.go('app.customerPortal');
        }

        vm.logoutGustCustomer = function () {

            if ($localStorage.GustCustomer) {
                vm.localStorage.Ammount = '';
                vm.localStorage.FareAmmount = '';
                vm.localStorage.GustData = '';
                vm.localStorage.MobileNumber = '';
                vm.localStorage.SelectedCountry = '';
                vm.localStorage.GustCustomer = '';
                $localStorage.GustData = '';
                $localStorage.GustCustomer = '';
                $localStorage.ThankyouPageData = '';
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
                url: 'https://currencydatafeed.com/api/converter.php?' + $.param({ token: accesstoken, from: code, to: "USD", amount: "1" }),
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
                    }
                    else {
                        $localStorage.SelectedCountry.ConvertAmount = 0.00;
                    }
                    vm.CurrencyData = idata;
                    //return 
                });
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
                    if ($localStorage.Ammount) {
                        $state.go('app.makePayment')
                        //setTimeout(function () { window.location.reload(); }, 1000);
                    } else {
                        //$state.go('app.makepayment');
                        $state.go('app.customerPortal')
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
                                $localStorage.GustData.GustCustomer = JSON.stringify(data);
                                Alert(1, "! Login successful.. ");
                                if ($localStorage.GustData.Ammount) {
                                    $state.go('app.makePayment')
                                    //setTimeout(function () { window.location.reload(); }, 1000);
                                } else {
                                    //$state.go('app.makepayment');
                                    $state.go('app.customerPortal')
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
        });


        vm.Paynow = function () {
            $('#Payconfirm').modal('toggle');
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
                    idata.Amount = vm.localStorage.FareAmmount;
                    idata.MobileNumber = vm.localStorage.SelectedCountry.MobileNumber;
                    idata.CompanyId = vm.localStorage.GustCustomer.CompanyId;
                    idata.CustomerId = vm.localStorage.GustCustomer.CustomerId;
                    idata.SenderName = vm.localStorage.GustCustomer.FirstName;
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
                        if (idata.PaymentMethodId == 12) {
                            idata.InvoiceNumber = idata.PaymentGatewayTransactionId;
                            idata.InvoiceAmount = idata.Amount;
                            idata.FaceAmount = idata.Amount;
                            $state.go('app.ThankuCus');
                        }
                        else {
                            Alert(2, idata.Error);
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


    manageGuestCustomerTransactionController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageGuestCustomerTransactionController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
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
            $window.location.assign('#/app/customerPortal');
        }
    }

})();
