(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageSendMoneyController', manageSendMoneyController)
        .controller('manageSendMoneyLoginController', manageSendMoneyLoginController)
        .controller('authenticateSendMoneyController', authenticateSendMoneyController)
        .controller('addEditBeneficiaryController', addEditBeneficiaryController)
        .controller('addCashPickUpController', addCashPickUpController)

    manageSendMoneyController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageSendMoneyController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        vm.PaymentModel = [{ SendingAmount: 0, BeneficiaryId :'0'}];
        vm.localStorage = [];
        if ($localStorage.SendMoney) {
            vm.localStorage = $localStorage.SendMoney;


        }
        else {
            $state.go('app.SendMoney')
        }
        vm.validateTransaction = function () {
            var SendingAmmout = vm.PaymentModel.SendingAmount;
            
            if (SendingAmmout) {
                $localStorage.SendingAmmout = SendingAmmout;
                if (!$localStorage.GustCustomer) {
                  $state.go('app.SendMoneylogin');
                } else {
                    $state.go('app.addEditBeneficiary');
                }
              
           
            }
            else if ($localStorage.GustCustomer && SendingAmmout) {
                $localStorage.SendingAmmout = SendingAmmout;
                $state.go('app.addEditBeneficiary');
               
            }
            else {
                return 0;
            }
           

           
        }


    }




    manageSendMoneyLoginController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageSendMoneyLoginController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        debugger;
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
                debugger;
                var iCustomer = data;
                if (iCustomer.CustomerId) {
                    var GustCustomer = [];
                    vm.CustomerID = iCustomer.CustomerId;
                    $localStorage.GustCustomer = iCustomer;
                    Alert(1, "! Login successful.. ");
                    if ($localStorage.SendingAmmout) {
                        debugger;
                        $state.go('app.addEditBeneficiary')
                        //setTimeout(function () { window.location.reload(); }, 1000);
                    } else {
                        //$state.go('app.makepayment');
                        $state.go('app.SendMoney')
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
                debugger;
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
                            debugger;
                            var GustCustomer = data;
                            if (GustCustomer.CustomerId) {
                                $localStorage.GustCustomer = data;
                                Alert(1, "! Login successful.. ");
                          
                                if ($localStorage.SendingAmount) {
                                    $state.go('app.addEditBeneficiary')
                                    //setTimeout(function () { window.location.reload(); }, 1000);
                                } else {
                                    //$state.go('app.makepayment');
                                    $state.go('app.SendMoney')
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
            $localStorage.SendingAmmout = '';
            $localStorage.BeneficiaryId = '';

            $localStorage = [];
            setTimeout(function () {
                $window.location.reload();
                //$state.go('app.customerPortal');
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


        vm.CashPickUp = function (Id) {
            debugger;
            var BenificryId = parseInt(Id);
            if (BenificryId > 0) {
               
                $localStorage.BeneficiaryId = BenificryId;
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
        vm.PaymentModel = [{ SendingAmount: 0, BeneficiaryId: '0' }];
        vm.localStorage = [];
        if ($localStorage.BeneficiaryId) {
            vm.PaymentModel.BeneficiaryId = $localStorage.BeneficiaryId;
        }
        else {
            $state.go('app.SendMoney')
        }
     


    }


})();
