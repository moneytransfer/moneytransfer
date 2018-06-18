(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageGustCustomerController', manageGustCustomerController)
        .controller('manageGuestCustomerTransactionController', manageGuestCustomerTransactionController)
        .controller('manageMakePaymentController', manageMakePaymentController)
         .controller('manageCustomerLoginController', manageCustomerLoginController)
         .controller('authenticateGuestController', authenticateGuestController)
    .controller('addEditkycController', addEditkycController)

    manageGustCustomerController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageGustCustomerController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;

        vm.CompanyId = 0;
        vm.CustomerId = 0;
        vm.CustomerName = '';
        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.CustomerId) {
                vm.CompanyId = authorisedUser.CompanyId;
                vm.CustomerId = authorisedUser.CustomerId;
                GetCustomerTransactionDetails(vm.CustomerId, vm.CompanyId);
            }
            //else { $state.go('app.customerPortal') }
        }
        if ($localStorage.GiftCardModel) {
            vm.localStorage = $localStorage.GiftCardModel;
        }

        vm.GiftCardModel = {}
        // $localStorage = { GiftCardModel: {} };

        //====================Get Country====================//
        $http({
            method: 'GET',
            url: baseUrl + 'getcountrydetails',
            headers: { 'Content-Type': 'application/json' }
        })
        .success(function (data) {
            var idata = data;
            vm.Countries = idata;
        });
        //====================End======================//

        //==========================Load Gift Cards========================//
        vm.GiftCards = [];
        $http({
            method: 'GET',
            url: baseUrl + 'getGiftCard ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;

            vm.GiftCards = idata;
        });
        //===============================End===============================//


        //===========================Proceed to choose Amount===============//
        vm.submitForm = function (GiftCardid) {
          
            var iGiftCardid = parseInt(vm.GiftCardModel.GiftCardid);
            if (GiftCardid > 0) {
                var GiftCardData = $filter('filter')(vm.GiftCards, {
                    GiftCardid: iGiftCardid,
                }, true);
                if (GiftCardData.length > 0) {
                    $localStorage.GiftCardModel = GiftCardData[0];
                }
                vm.localStorage = '';
                if ($localStorage.GiftCardModel) {
                    vm.localStorage = $localStorage.GiftCardModel;
                }
                setTimeout(function () {
                    $state.go('app.reviewAmmount');
                }, 100);
            }
        }
        //============================End==============================//

        //=====================Proceed to submit KYC =========================//
        vm.YesKyc = function () {
            $('#KycConfrimation').modal('toggle');
            $('.modal-backdrop').remove();
            setTimeout(function () {
                $state.go('app.addKyc');
            }, 500);
        }


        vm.popupYes = function () {
            if (!authorisedUser.CustomerId) {
                $state.go('app.Login');
            }
            else {
                if (!authorisedUser.IsDocumentUpload) {
                    vm.TotalPaidAmt = $localStorage.authorisedUserDetails.SendingAmount;
                    vm.WeekTransactions = $localStorage.authorisedUserDetails.WeekTransactionCount;
                    vm.CurrentTransactions = $localStorage.authorisedUserDetails.CurrentMonthTransactionCount;
                    vm.PreviousTransactions = $localStorage.authorisedUserDetails.PreviousMonthTransactionCount;
                    vm.PrevioustoPreviousTransactions = $localStorage.authorisedUserDetails.PrevioustoPreviousMonthTransactionCount;
                    if (isNaN(vm.TotalPaidAmt)) { vm.TotalPaidAmt = 0; }

                    if (vm.CurrentTransactions <= 0 && vm.PreviousTransactions <= 1 && vm.PrevioustoPreviousTransactions <= 1) {
                        $window.location.assign('#/app/makePayment');
                    }
                    else if (vm.WeekTransactions < 3) {
                        if ((parseFloat(vm.TotalPaidAmt) + parseFloat($localStorage.GiftCardModel.GiftCardInitialsPrice)) > 100) {
                            $('#KycConfrimation').modal('toggle');
                        }
                        else { $window.location.assign('#/app/makePayment'); }
                    }
                    else { $('#KycConfrimation').modal('toggle'); }
                }
                else {
                    $window.location.assign('#/app/makePayment');
                }
            }
        }


        vm.selectedGiftCard = function (GiftCard) {
            if (GiftCard.GiftCardid > 0) {
                //var iGiftCardid = parseInt(vm.GiftCardModel.GiftCardid);
                var GiftCardData = $filter('filter')(vm.GiftCards, {
                    GiftCardid: GiftCard.GiftCardid,
                }, true);
                if (GiftCardData.length > 0) {
                    $localStorage.GiftCardModel = '';
                    $localStorage.GiftCardModel = GiftCardData[0];
                }
                vm.localStorage = '';
                if ($localStorage.GiftCardModel) {
                    vm.localStorage = $localStorage.GiftCardModel;
                }

            }
        }



        //With Exchange rate
        vm.PayAmountWithExchange = [{ AmountId: '1', Amount: '10.00' }, { AmountId: '2', Amount: '20.00' }, { AmountId: '3', Amount: '30.00' }, { AmountId: '4', Amount: '40.00' }, { AmountId: '5', Amount: '50.00' }, { AmountId: '6', Amount: '60.00' }, { AmountId: '7', Amount: '70.00' }, { AmountId: '8', Amount: '80.00' }, { AmountId: '9', Amount: '90.00' }, { AmountId: '10', Amount: '100.00' }, { AmountId: '11', Amount: '110.00' }, { AmountId: '12', Amount: '120.00' }];

        //==========================Set amount Array======================//

        //===============================End=============================//

        vm.cancel = function () {
            $localStorage.GiftCardModel = '';
            $localStorage.authorisedUserDetails = '';
            $localStorage = [];
            $state.go('app.customerPortal');
        }

        vm.logoutGustCustomer = function () {

            if ($localStorage) {
                $localStorage.GiftCardModel = '';
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


        function GetCustomerTransactionDetails(CustomerId, CompanyId) {
            vm.CustomerID = CustomerId;
            var formData = JSON.parse(JSON.stringify({ "CustomerId": CustomerId, "CompanyId": CompanyId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getCustomerTransaction ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                if (idata.CustomerId > 0) {
                    $localStorage.authorisedUserDetails = idata;

                    GetApplicantCheckStatus(vm.CustomerID)
                }
                //setTimeout(function () { window.location.reload(); }, 1000);
            });
        }

        function GetApplicantCheckStatus(CustomerId) {
            var data = { "CustomerId": CustomerId, "CompanyId": "0", "ApplicantId": "" }
            var formData = JSON.parse(JSON.stringify(data));
            $http({
                method: 'POST',
                url: baseUrl + 'getsaveapplicantkyc',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 var idata = data[0];
                 if (idata !== undefined && idata.ApplicantCheckId) {
                     $localStorage.KYCStatus = idata.Status;
                 }
             });
        }

    }

    manageCustomerLoginController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageCustomerLoginController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;

        var CompanyId = 0;
        vm.CustomerID = 0;
        vm.IsLogin = false;

        if ($window.sessionStorage.authorisedUser) {
            vm.IsLogin = true;
            //$window.location.assign('#/app/customerPortal');
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
                    authorisedUser = iCustomer;
                    if (authorisedUser.CustomerId) {
                        $window.sessionStorage.authorisedUser = JSON.stringify(iCustomer);
                        vm.CustomerID = iCustomer.CustomerId;
                        vm.CompanyId = iCustomer.CompanyId;
                        vm.IsLogin = true;
                        Alert(1, "! Login successful.. ");
                        GetCustomerTransactionDetails(vm.CustomerID, vm.CompanyId);

                        //if ($localStorage.GiftCardid > 0) {
                        //    $window.location.assign('#/app/makePayment');
                        //}
                        //else {
                        //}
                        //window.location.reload();
                    }
                    else {

                        Alert(2, "! Invalid User Name or Password. ");
                    }

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
            $localStorage.numberDetails = '';
            $localStorage.Ammount = '';
            $localStorage.GustData = '';
            $localStorage.MobileNumber = '';
            $localStorage.SelectedCountry = '';
            //$localStorage.GustCustomer = '';
            $localStorage.AmountList = '';
            setTimeout(function () {
                $state.go('app.customerPortal');
                // $window.location.reload();
            }, 500);
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
                                vm.IsLogin = true;
                                $localStorage.GustCustomer = data;
                                Alert(1, "! Login successful.. ");
                                if ($localStorage.Ammount) {
                                    $window.location.assign('#/app/makePayment');
                                }
                                else {
                                    $window.location.assign('#/app/customerPortal');
                                }
                                //setTimeout(function () { window.location.reload(); }, 1000);
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
       
            $localStorage.GiftCardModel = '';
            $localStorage.authorisedUserDetails = '';
            $localStorage.Ammount = '';
            $localStorage = [];
            if ($window.sessionStorage.authorisedUser) {
                $window.sessionStorage.removeItem('authorisedUser');
                authorisedUser = [];

            }
            setTimeout(function () {
                $window.location.assign('#/app/Home');
            }, 1000);

        }

        vm.YesKyc = function () {
            $('#KycConfrimation').modal('toggle');
            $('.modal-backdrop').remove();
            setTimeout(function () {
                $state.go('app.addKyc');
            }, 500);
        }


        function GetApplicantCheckStatus(CustomerId) {
            var data = { "CustomerId": CustomerId, "CompanyId": "0", "ApplicantId": "" }
            var formData = JSON.parse(JSON.stringify(data));
            $http({
                method: 'POST',
                url: baseUrl + 'getsaveapplicantkyc',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 var idata = data[0];
                 if (idata !== undefined && idata.ApplicantCheckId) {
                     $localStorage.KYCStatus = idata.Status;
                 }
                 if ($localStorage.GiftCardModel.GiftCardid > 0) {
                     if (!$localStorage.authorisedUserDetails.IsDocumentUpload) {
                         vm.TotalPaidAmt = $localStorage.authorisedUserDetails.SendingAmount;
                         vm.WeekTransactions = $localStorage.authorisedUserDetails.WeekTransactionCount;
                         vm.CurrentTransactions = $localStorage.authorisedUserDetails.CurrentMonthTransactionCount;
                         vm.PreviousTransactions = $localStorage.authorisedUserDetails.PreviousMonthTransactionCount;
                         vm.PrevioustoPreviousTransactions = $localStorage.authorisedUserDetails.PrevioustoPreviousMonthTransactionCount;
                         if (isNaN(vm.TotalPaidAmt)) { vm.TotalPaidAmt = 0; }

                         if (vm.CurrentTransactions <= 0 && vm.PreviousTransactions <= 1 && vm.PrevioustoPreviousTransactions <= 1) {
                             $window.location.assign('#/app/makePayment');
                         }
                         else if (vm.WeekTransactions < 3) {
                             if ((parseFloat(vm.TotalPaidAmt) + parseFloat($localStorage.GiftCardModel.GiftCardInitialsPrice)) > 100) {
                                 $('#KycConfrimation').modal('toggle');
                             }
                             else { $window.location.assign('#/app/makePayment'); }
                         }
                         else { $('#KycConfrimation').modal('toggle'); }
                     }
                     else {
                         $window.location.assign('#/app/makePayment');
                     }
                 }
                 else if (vm.IsLogin) {
                     //    debugger;
                     $window.location.assign('#/app/customerPortal');
                 }
                 else {
                     var url = $state.current.url;
                     $window.location.assign('#/app' + url);
                 }
             });
        }


        function GetCustomerTransactionDetails(CustomerId, CompanyId) {
            vm.CustomerID = CustomerId;
            var formData = JSON.parse(JSON.stringify({ "CustomerId": CustomerId, "CompanyId": CompanyId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getCustomerTransaction ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                if (idata.CustomerId != null && idata.CustomerId > 0) {
                    $localStorage.authorisedUserDetails = idata;

                    GetApplicantCheckStatus(vm.CustomerID)
                }
                else {
                    if ($localStorage.GiftCardModel.GiftCardid > 0) {
                        if (!$localStorage.authorisedUserDetails.IsDocumentUpload) {
                            vm.TotalPaidAmt = $localStorage.authorisedUserDetails.SendingAmount;
                            vm.WeekTransactions = $localStorage.authorisedUserDetails.WeekTransactionCount;
                            vm.CurrentTransactions = $localStorage.authorisedUserDetails.CurrentMonthTransactionCount;
                            vm.PreviousTransactions = $localStorage.authorisedUserDetails.PreviousMonthTransactionCount;
                            vm.PrevioustoPreviousTransactions = $localStorage.authorisedUserDetails.PrevioustoPreviousMonthTransactionCount;

                            if (isNaN(vm.TotalPaidAmt)) { vm.TotalPaidAmt = 0; }

                            if (vm.CurrentTransactions <= 0 && vm.PreviousTransactions <= 1 && vm.PrevioustoPreviousTransactions <= 1) {
                                $window.location.assign('#/app/makePayment');
                            }
                            else if (vm.WeekTransactions < 3) {
                                if ((parseFloat(vm.TotalPaidAmt) + parseFloat($localStorage.GiftCardModel.GiftCardInitialsPrice)) > 100) {
                                    $('#KycConfrimation').modal('toggle');
                                }
                                else { $window.location.assign('#/app/makePayment'); }
                            }
                            else { $('#KycConfrimation').modal('toggle'); }
                        }
                        else {
                            $window.location.assign('#/app/makePayment');
                        }
                    }
                    else if (vm.IsLogin) {
                        $window.location.assign('#/app/Home');
                    }
                    else {
                        var url = $state.current.url;
                        $window.location.assign('#/app' + url);
                    }
                }
                //setTimeout(function () { window.location.reload(); }, 1000);
            });
        }
    }


    manageMakePaymentController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function manageMakePaymentController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
        var vm = $scope;
        vm.CompanyId = 0;
        vm.CustomerId = 0;

        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (!authorisedUser.CustomerId) {

            }
        }
        else {
            $state.go('app.Login');
        }
        if ($localStorage.GiftCardModel) {
            vm.localStorage = $localStorage.GiftCardModel;
        }
        vm.StatusApproved = false;
        if ($localStorage.GiftCardModel.GiftCardid > 0) {
            vm.TotalPaidAmt = $localStorage.authorisedUserDetails.SendingAmount;
            vm.WeekTransactions = $localStorage.authorisedUserDetails.WeekTransactionCount;
            vm.CurrentTransactions = $localStorage.authorisedUserDetails.CurrentMonthTransactionCount;
            vm.PreviousTransactions = $localStorage.authorisedUserDetails.PreviousMonthTransactionCount;
            vm.PrevioustoPreviousTransactions = $localStorage.authorisedUserDetails.PrevioustoPreviousMonthTransactionCount;
            if (isNaN(vm.TotalPaidAmt)) { vm.TotalPaidAmt = 0; }

            if (vm.CurrentTransactions <= 0 && vm.PreviousTransactions <= 1 && vm.PrevioustoPreviousTransactions <= 1) {
                LoadPaymentMethods();

            }
            else {
                if (parseFloat(vm.TotalPaidAmt) + parseFloat($localStorage.GiftCardModel.GiftCardInitialsPrice) < 100) {
                    LoadPaymentMethods();

                }
                else {
                    vm.KYCStatus = $localStorage.KYCStatus;
                    if (vm.KYCStatus == "Success") {
                        //Get Method Details
                        LoadPaymentMethods();

                    }
                    else {
                        vm.StatusApproved = true;
                    }
                }
            }
        }

        //==========================Load Payment Method======================//
        function LoadPaymentMethods() {
            vm.StatusApproved = false;
            vm.PaymentMethods = [];
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
        }
        //===============================End================================//

        //==========================Selected Payment Method/Gift Card========================//
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
                            if (vm.localStorage.GiftCardInitialsPrice >= data.StartingAmount && vm.localStorage.GiftCardInitialsPrice <= data.EndAmount) {
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


        //=================================End====================================//


        vm.Paynow = function () {
            $('#Payconfirm').modal('toggle');
        }

        //==========================Validating of Card Details========================//
        function validate(evt) {
            var theEvent = evt || window.event;
            var key = theEvent.keyCode || theEvent.which;
            key = String.fromCharCode(key);
            var regex = /[0-9]|\./;
            if (!regex.test(key)) {
                theEvent.returnValue = false;
                if (theEvent.preventDefault) theEvent.preventDefault();
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

        //=================================End====================================//


        //==========================Proceed to payment===========================//
        vm.PaybyGiftCard = { "GiftCardid": 0, "CompanyId": 0, "CustomerId": 0, "TransactionDetail": "Gift card", "SendingAmount": "0", "Charges": "0", "Fees": "0", "Tax": "0", "ReceivingAmount": "0", "BeneficiaryId": "0", "PaymentMethodId": "0", "TransferPurpose": "For g.f", "DeliveryType": "Gift Card" }

        vm.Create = function (e) {
            vm.alert = false;
            $('#Payconfirm').modal('toggle');
            var idata = vm.PaybillModel;
            //if (idata.PaymentMethodId == 18) {
            //    var GiftNumber = $('#GiftNumber').val();
            //    if (GiftNumber == "") {
            //        //setTimeout(function () {
            //        AlertKyc(2, 'Please enter a valid Gift card number');
            //        //}, 200);
            //        return
            //    }
            //    else {
            //        vm.PaybyGiftCard.SendingAmount = vm.localStorage.FareAmmount + vm.localStorage.Fees;
            //        vm.PaybyGiftCard.Fees = vm.localStorage.Fees;
            //        vm.PaybyGiftCard.GiftCardid = idata.GiftCardid;
            //        vm.PaybyGiftCard.PaymentMethodId = idata.PaymentMethodId;
            //        vm.PaybyGiftCard.CompanyId = vm.localStorage.GustCustomer.CompanyId;
            //        vm.PaybyGiftCard.CustomerId = vm.localStorage.GustCustomer.CustomerId;
            //        var formData = JSON.stringify(vm.PaybyGiftCard);
            //        $http({
            //            method: 'POST',
            //            url: baseUrl + 'payGiftCard',
            //            data: formData,
            //            headers: { 'Content-Type': 'application/json' },
            //            dataType: "json",
            //        })
            //        .success(function (data) {
            //            var idata = data;
            //            if (idata.Result == "Suceess") {
            //                AlertKyc(1, "Payment has been success");
            //                setTimeout(function () {
            //                    vm.PayDetails.InvoiceNumber = idata.GiftCardid;
            //                    vm.PayDetails.InvoiceAmount = vm.localStorage.FareAmmount + vm.localStorage.Fees;
            //                    vm.PayDetails.FaceAmount = vm.localStorage.FareAmmount;
            //                    vm.PayDetails.Fees = vm.localStorage.Fees;
            //                    vm.PayDetails.MobileNumber = vm.localStorage.SelectedCountry.MobileNumber;
            //                    vm.PayDetails.SenderName = vm.localStorage.GustCustomer.FirstName;


            //                    $localStorage.ThankyouPageData = vm.PayDetails;

            //                    $state.go('app.ThankuCus');
            //                }, 1000);
            //            }
            //            else {

            //                AlertKyc(2, idata.Error);
            //            }

            //        })
            //        .error(function (data) {
            //            AlertKyc(2, idata.Error);
            //        });
            //    }
            //}
            //else {
            //    var isCardValid = $.payform.validateCardNumber(cardNumber.val());
            //    var isCvvValid = $.payform.validateCardCVC(CVV.val());
            //    var IsValid = false;
            //    var cvvlength = CVV.val().length;
            //    if ($.payform.parseCardType(cardNumber.val()) == 'amex') {
            //        if (cvvlength < 4) {
            //            CvvNumberField.removeClass('has-success');
            //            CvvNumberField.addClass('has-error');
            //            vm.alert = true;
            //            setTimeout(function () {
            //                $("#PaymentAlertText").text('Invaild CVV number');
            //            }, 100);
            //            return
            //        }
            //        else {
            //            IsValid = true; vm.alert = false;
            //        }
            //    }
            //    else {
            //        if (cvvlength != 3) {
            //            CvvNumberField.removeClass('has-success');
            //            CvvNumberField.addClass('has-error');
            //            vm.alert = true;
            //            setTimeout(function () {
            //                $("#PaymentAlertText").text('Invaild CVV number');
            //            }, 100);
            //            return
            //        }
            //        else { IsValid = true; vm.alert = false; }
            //    }

            //    if (isCardValid && IsValid) {
            //        if (isCvvValid) {
            //            var data = vm.localStorage.GustCustomer;
            //            var idata = vm.PaybillModel;
            //            idata.Amount = vm.localStorage.FareAmmount + vm.localStorage.Fees;
            //            idata.MobileNumber = vm.localStorage.SelectedCountry.MobileNumber;
            //            idata.CompanyId = vm.localStorage.GustCustomer.CompanyId;
            //            idata.CustomerId = vm.localStorage.GustCustomer.CustomerId;
            //            idata.SenderName = vm.localStorage.GustCustomer.FirstName;
            //            idata.Fees = vm.localStorage.Fees;
            //            idata.SKUId = vm.localStorage.SelectedCountry.skuId;
            //            var sMonth = parseInt(vm.ExpireModel.ExpireMonth);
            //            if (sMonth < 10) {
            //                sMonth = '0' + sMonth
            //            }
            //            var CurrentDate = new Date();
            //            var Currentyear = CurrentDate.getYear();
            //            var sYear = vm.ExpireModel.ExpireYear;
            //            var expiremonth = sMonth + '' + sYear;
            //            idata.setExpirationDate = expiremonth;

            //            var formData = JSON.stringify(idata);
            //            $http({
            //                method: 'POST',
            //                url: baseUrl + 'billPay',
            //                data: formData,
            //                headers: {
            //                    'Content-Type': 'application/json'
            //                },
            //                dataType: "json",
            //            })
            //            .success(function (data) {

            //                var idata = data;
            //                if (idata.Result == "Success" && idata.TransactionId > 0) {
            //                    idata.InvoiceNumber = idata.PaymentGatewayTransactionId;
            //                    idata.InvoiceAmount = idata.Amount;
            //                    idata.FaceAmount = idata.Amount;
            //                    $state.go('app.ThankuCus');
            //                }
            //                else {
            //                    AlertKyc(2, idata.Error);
            //                }
            //                vm.PayDetails = idata;
            //                $localStorage.ThankyouPageData = vm.PayDetails;
            //            });
            //        }
            //        else {
            //            vm.alert = true;
            //            setTimeout(function () {
            //                $("#PaymentAlertText").text('Invaild Card');
            //            }, 100);
            //        }
            //    }
            //    else {
            //        vm.alert = true;
            //        setTimeout(function () {
            //            $("#PaymentAlertText").text('Invaild CVV number ');
            //        }, 100);
            //    }
            //}
        }
        //=================================End====================================//
        vm.cancel = function () {
            $localStorage.GiftCardModel = '';
            $localStorage.authorisedUserDetails = '';
            vm.localStorage = [];
            $state.go('app.customerPortal');
        }


    }


    manageGuestCustomerTransactionController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageGuestCustomerTransactionController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;
        vm.CompanyId = 0;
        vm.CustomerId = 0;
        vm.localStorage = 0;
        //GustData


        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.CustomerId) {
                vm.CustomerId = authorisedUser.CustomerId;
            }
        }
        else {
            $state.go('app.customerPortal')
        }

        //Remove BackDrop
        $('.modal-backdrop').remove();

        //Get Method Details
        vm.ManageTransaction = [];
        var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.CustomerId }));
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

            $localStorage = [];
            setTimeout(function () {
                $window.location.reload();
                //$state.go('app.customerPortal');
            }, 1000);
        }

    }

    authenticateGuestController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function authenticateGuestController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
        var vm = $scope;

        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (!authorisedUser.CustomerId) {
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

        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.CustomerId) {
                vm.CustomerId = authorisedUser.CustomerId;
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
                                    vm.ApplicantId = data.ApplicantId;
                                    if (vm.imageData !== undefined && vm.imageData != "" && vm.ApplicantId != '') {
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
                                                 ///AlertKyc(1, "Thanks for updating your KYC document");
                                                 if (data.ApplicantId != "") {
                                                     var formdata = { "ApplicantId": vm.ApplicantId }
                                                     $http({
                                                         method: 'POST',
                                                         url: baseUrl + 'createApplicantCheck',
                                                         data: formdata,
                                                         headers: { 'Content-Type': 'application/json' },
                                                         dataType: "json",
                                                     })
                                                      .success(function (data) {
                                                          if (data.ApplicantCheckId != '') {
                                                              AlertKyc(1, "Thanks for updating your KYC document");
                                                              setTimeout(function () {
                                                                  $state.go('app.customerPortal');
                                                              }, 500);
                                                              // GetApplicantCheckStatus(data.ApplicantCheckId);
                                                          }
                                                          else {
                                                              AlertKyc(2, data.Error);

                                                          }
                                                      });
                                                 }
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
