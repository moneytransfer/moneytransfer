(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageGustCustomerController', manageGustCustomerController)
        .controller('manageGuestCustomerTransactionController', manageGuestCustomerTransactionController)
         .controller('manageCustomerLoginController', manageCustomerLoginController)
    manageGustCustomerController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageGustCustomerController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;

        vm.CompanyId = 0;
        vm.CustomerId = 0;
        vm.CustomerName = '';
        // remove default
        $('.modal-backdrop').remove();
        vm.FlagModel = [{ countryCode: '', internationalCodes: '', carrierName: '', Result: '' }];
        vm.localStorage = [{ GustData: '', GustCustomer: 0, SelectedCountry: '' }];
        vm.PaybillModel = { CompanyId: 0, CustomerId: 0, SenderName: '', PaymentMethodId: '0', Amount: '0.00', MobileNumber: '' }
        
        if ($localStorage.GustData) {
            vm.localStorage = $localStorage.GustData;
            vm.localStorage = $localStorage;
            if (vm.localStorage.GustData != '') {
                vm.PaybillModel.MobileNumber = vm.localStorage.SelectedCountry.MobileNumber;
                vm.FlagModel.countryCode = vm.localStorage.SelectedCountry.countryCode;
                vm.FlagModel.internationalCodes = vm.localStorage.SelectedCountry.internationalCodes;
                vm.FlagModel.carrierName = vm.localStorage.SelectedCountry.carrierName;
                vm.FlagModel.Result = 'Success';
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



        vm.CountryDetails = [{ phonecode: '' }];
        vm.PayDetails = { SenderName: '', FaceAmount: '', InvoiceAmount: '', MobileNumber: '', InvoiceNumber: '' };
        vm.PaybillModel = { CompanyId: 0, CustomerId: 0, SenderName: '', PaymentMethodId: '0', Amount: '0.00', MobileNumber: '' }

        vm.FlagModel = [];

        vm.getcountrydata = function (id) {
            var iCountryId = parseInt(id);
            var formData = JSON.parse(JSON.stringify({ "phonecode": iCountryId }));
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
                    Alert(2, "!" + idata.Error);
                }
            });
        }

        var timeout;
        var delay = 1000;
        vm.EnteredNumber = function () {
            if (timeout) {
                clearTimeout(timeout);
            }
            timeout = setTimeout(function () {
                Searchdata();
            }, delay);
        }



        function Searchdata() {

            var iCountryCode = JSON.stringify(vm.FlagModel.internationalCodes);
            var iNumber = vm.PaybillModel.MobileNumber;
            if (iNumber.length > 5) {
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
                        vm.PaybillModel.MobileNumber = iEnteredNumber;
                        $localStorage.GustData = iEnteredNumber;
                        idata.countryCode = idata.countryCode.toLowerCase();
                        //vm.CountryDetails.phonecode = idata.internationalCodes;
                        vm.FlagModel = idata;
                        var sData = vm.CountryDetails;
                        if (vm.CountryDetails.phonecode != '0') {
                            if (idata.internationalCodes != vm.CountryDetails.phonecode) {
                                vm.CountryDetails.phonecode = '0';
                            }
                        }

                        else {
                            if (idata.currencyCode == "MXN") {
                                var res = idata.internationalCodes.split(" ");
                                vm.CountryDetails.phonecode = res[0];
                            }
                            else {
                                vm.CountryDetails.phonecode = idata.internationalCodes;
                            }//vm.CountryDetails = sData;
                        }
                        $localStorage.SelectedCountry = idata;
                    }
                    else {
                        vm.FlagModel = [];
                        vm.CountryDetails.phonecode = '0';
                        $localStorage.GustData = '';
                        $localStorage.SelectedCountry = '';
                        Alert(2, "!" + idata.Error);
                    }
                });

            }
            else {
                vm.FlagModel = [];
                $localStorage.GustData = '';
            }

        }

        vm.submitForm = function () {
            debugger;
            if ($localStorage.GustData) {
                if ($localStorage.GustCustomer=='') {
                   vm.localStorage.GustCustomer= $localStorage.GustCustomer = 0;
                }
                $state.go('app.chooseAmount');
            }
            else {
                Alert(2, "! It is not possible to recharge on this phone number. Please check the number and try again.");
            }
        }


        vm.selectAmmount = function (ammount) {
            $('#amountfeild').val(ammount);
            $localStorage.Ammount = ammount;
            vm.PaybillModel.Amount = ammount;
            $('#proceedButton').prop('disabled', false);
        }

        vm.proceed = function () {

            if ($localStorage.Ammount) {
                $('#Payconfirm').modal('toggle');
            }
            else {
                Alert(2, "! Please select a vaild amount");
            }
        }

        vm.popupYes = function () {
            $('#Payconfirm').modal('toggle');
            $('.modal-backdrop').remove();

            if ($localStorage.GustCustomer == '') {
                $state.go('app.Login');
            } else {
                $state.go('app.makePayment');
            }
        }


        vm.PayAmount = [{ AmountId: '1', Amount: '2.00' }, { AmountId: '2', Amount: '4.00' },
                        { AmountId: '3', Amount: '6.00' }, { AmountId: '4', Amount: '8.00' },
                        { AmountId: '5', Amount: '10.00' }, { AmountId: '6', Amount: '12.00' },
                        { AmountId: '7', Amount: '14.00' }, { AmountId: '8', Amount: '16.00' },
                        { AmountId: '9', Amount: '18.00' }, { AmountId: '10', Amount: '20.00' },
                        { AmountId: '11', Amount: '22.00' }, { AmountId: '12', Amount: '24.00' },
                        { AmountId: '13', Amount: '26.00' }, { AmountId: '14', Amount: '28.00' },
                        { AmountId: '15', Amount: '30.00' }, { AmountId: '16', Amount: '32.00' }];

        vm.Paynow = function () {
            $('#Payconfirm').modal('toggle');
        }

        vm.Create = function () {
            $('#Payconfirm').modal('toggle');
            var data = vm.localStorage.GustCustomer;
            var idata = vm.PaybillModel;

            idata.Amount = vm.localStorage.Ammount;
            idata.MobileNumber = vm.localStorage.SelectedCountry.MobileNumber;
            idata.CompanyId = vm.localStorage.GustCustomer.CompanyId;
            idata.CustomerId = vm.localStorage.GustCustomer.CustomerId;
            idata.SenderName = vm.localStorage.GustCustomer.FirstName;
            var sMonth = vm.ExpireModel.ExpireMonth;
            if (sMonth < 10) {
                sMonth = '0' + sMonth
            }
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
                vm.PayDetails = idata;
                if (idata && idata.BillPayId > 0) {
                    vm.localStorage.Ammount = '';
                    vm.localStorage.GustData = '';
                    vm.localStorage.MobileNumber = '';
                    vm.localStorage.SelectedCountry = '';

                    $('#ThankyouPaybill').modal('toggle');

                    $timeout(function () {
                        //$('#ThankyouPaybill').modal('toggle');
                        $state.go('app.transactionDetails');
                    }, 4000);
                }
                else {
                    Alert(2, idata.Error);
                }
            });
        }


        vm.goBack = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $state.go('app.customerPortal');
        }

        vm.cancel = function () {
            vm.localStorage.Ammount = '';
            vm.localStorage.GustData = '';
            vm.localStorage.MobileNumber = '';
            vm.localStorage.SelectedCountry = '';
            $state.go('app.customerPortal');
        }

        vm.logoutGustCustomer = function () {

            if ($localStorage.GustCustomer) {
                vm.localStorage.Ammount = '';
                vm.localStorage.GustData = '';
                vm.localStorage.MobileNumber = '';
                vm.localStorage.SelectedCountry = '';
                vm.localStorage.GustCustomer = '';
                $localStorage.GustData = '';
                $localStorage.GustCustomer = '';
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

    }


    manageCustomerLoginController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageCustomerLoginController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerID = 0;

        vm.IsLogin = false;

        if ($localStorage.GustCustomer!=0) {
            vm.IsLogin = true;
        }
        //vm.CustomerStorage = { GustCustomer: '0' };
       
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
            var timeout = 30000;
            var message = "Time Out for login Do you want exceed your time for next 3 mintue or go back?"
            if ($location.path() == "/app/userRegister" || $location.path() == "/app/Login") {
                timeout = 50000;
                message = "Time Out for Register Do you want exceed your time for  next 5 mintue or go back?"
                setTimeout(function () { $("#loginTimeOut").modal('toggle') }, timeout);
            }
        }
        //

        vm.timer();
        // }, 1000);

        vm.exceedTime = function () {
            var timeout = 50000;
            if ($location.path() == "/app/userRegister") { timeout = 50000; }
            if ($location.path() == "/app/Login") { timeout = 30000; }

            $('#loginTimeOut').modal('hide');
            setTimeout(function () {
                var time = 30000;
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


})();
