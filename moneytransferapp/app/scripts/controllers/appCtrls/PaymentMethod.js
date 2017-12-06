

(function () {
    'use strict';
    angular
        .module('app')
        .controller('managePaymentMethodController', managePaymentMethodController)
        .controller('addEditPaymentMethodController', addEditPaymentMethodController)
     .controller('PaymentMethodController', PaymentMethodController)
    .controller('thankyouController', thankyouController)

    managePaymentMethodController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function managePaymentMethodController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {
        var vm = $scope;
        var CompanyId = 0;
        //vm.CompanyId = 0;
        if ($stateParams.CompanyId) {
            vm.CompanyId = parseInt($stateParams.CompanyId);
            $window.localStorage.setItem('CompanyId', JSON.stringify($stateParams.CompanyId));
        }
        else {
            if ($window.sessionStorage.authorisedUser) {
                authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
                if (authorisedUser.CompanyId) { vm.CompanyId = parseInt(authorisedUser.CompanyId); }
            }
        }

        var iComapnyId = $window.localStorage.getItem('CompanyId');

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": iComapnyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompanyid ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.PaymentMethods = idata;

            $timeout(function () {
                $('#tblPayment').trigger('footable_redraw');
            }, 100);

        });

        vm.addmethod = function (Id) {
            $state.go('app.add_PaymentMethod', { companyId: Id });
        }

        vm.EditPaymentMethod = function (Id) {
            $state.go('app.Edit_PaymentMethod', { PaymentMethodId: Id });
        }

        vm.BackToCompany = function () {
            $state.go('app.Manage_Company');
        }

        //DeleteUser
        var PaymentMethodID = 0;
        vm.deletePaymentMethod = function (Id) {
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

    addEditPaymentMethodController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditPaymentMethodController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
        vm.companyId = 0;
        vm.PaymentMethodModel = { CompanyId: 0, PaymentMethodId: "0", PaymentTypeId: "0" };
        vm.AuthorizePaymentModel = { AuthorizePaymentSettingsId: 0, PaymentMethodId: 0, IsActive: '' }
        vm.header = 'Add';

        $http({
            method: 'GET',
            url: baseUrl + 'getpaymenttypedetails',
            headers: { 'Content-Type': 'application/json' }
        })
      .success(function (data) {
          var idata = data;
          vm.PaymentTypes = idata;

      });
        if ($stateParams.PaymentMethodId) {
            vm.header = 'Update';
            var iPaymentMethodID = "";
            iPaymentMethodID = parseInt($stateParams.PaymentMethodId);

            var formData = JSON.parse(JSON.stringify({ "PaymentMethodId": iPaymentMethodID }));
            $http({
                method: 'POST',
                url: baseUrl + 'getpaymentmethoddetails',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 var idata = data;
                 vm.PaymentMethodModel = idata;
                 var paymenttypeId = "";
                 paymenttypeId = idata.PaymentTypeId;
                 vm.PaymentMethodModel.PaymentTypeId = JSON.stringify(paymenttypeId);
                 //vm.PaymentMethodModel = idata;
                 var iPaymentId = parseInt(idata.PaymentMethodId);

                 var formData = JSON.parse(JSON.stringify({ "PaymentMethodId": iPaymentId }));
                 $http({
                     method: 'POST',
                     data: formData,
                     url: baseUrl + 'getauthorizepaymentdsettingsbypaymentmethodid',
                     headers: { 'Content-Type': 'application/json' }
                 })
              .success(function (data) {
                  var idata = data;
                  vm.AuthorizePaymentModel = idata;

              });
             });
        }

        if ($stateParams.CompanyId) {
            vm.companyId = parseInt($stateParams.companyId);
        }


        vm.Create = function () {
            var idata = vm.PaymentMethodModel;
            if (vm.PaymentMethodModel.IsActive == true) {
                idata.IsActive = "true"
            }
            else {
                idata.IsActive = "false"
            }
            if ($stateParams.PaymentMethodId) {

                var formData = JSON.stringify(idata);
                $http({
                    method: 'POST',
                    url: baseUrl + 'savepaymentmethod',
                    data: formData,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.PaymentMethodId > 0) {
                        vm.PaymentMethodModel = angular.copy(vm.PaymentMethodModel);
                        vm.AuthorizePaymentModel.PaymentMethodId = idata.PaymentMethodId;
                        vm.AuthorizePaymentModel.IsActive = idata.IsActive;

                        var formData = JSON.stringify(vm.AuthorizePaymentModel);
                        $http({
                            method: 'POST',
                            data: formData,
                            url: baseUrl + 'saveauthorizepayment',
                            headers: { 'Content-Type': 'application/json' },
                            dataType: "json",
                        })
                        .success(function (data) {
                            var idata = data;
                            if (idata && idata.AuthorizePaymentSettingsId > 0) {
                                Alert(1, "! Payment method updated successfully");
                                setTimeout(function () {
                                    $state.go('app.Manage_PaymentMethod', { CompanyId: $stateParams.companyId });
                                }, 1000);
                            }
                        });
                    }
                    else {
                        Alert(2, idata.Result);
                    }
                });
            }
            else {

                var iData = vm.PaymentMethodModel;
                iData.CompanyId = parseInt($stateParams.companyId);
                if (vm.PaymentMethodModel.IsActive == true) {
                    iData.IsActive = "true"
                }
                else {
                    iData.IsActive = "false"
                }
                var formData = JSON.stringify(iData);
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'savepaymentmethod',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.Result == "Sucess") {
                        vm.PaymentMethodModel = angular.copy(vm.PaymentMethodModel);
                        vm.AuthorizePaymentModel.PaymentMethodId = idata.PaymentMethodId;
                        vm.AuthorizePaymentModel.IsActive = idata.IsActive;

                        var formData = JSON.stringify(vm.AuthorizePaymentModel);
                        $http({
                            method: 'POST',
                            data: formData,
                            url: baseUrl + 'saveauthorizepayment',
                            headers: { 'Content-Type': 'application/json' },
                            dataType: "json",
                        })
                        .success(function (data) {
                            var idata = data;
                            if (idata && idata.AuthorizePaymentSettingsId > 0) {

                            }
                        });
                        Alert(1, "! Payment method created successfully");
                        vm.PaymentMethodModel = angular.copy(vm.PaymentMethodModel);
                        setTimeout(function () {
                            $state.go('app.Manage_PaymentMethod', { CompanyId: $stateParams.companyId });
                        }, 1000);
                    }
                    else {
                        // Alert(2, idata.Result);
                    }
                });
            }
        }

        vm.cancel = function () {
            //$state.go('app.Manage_PaymentMethod');
            if (authorisedUser.CompanyId == 0) {
                $state.go('app.Manage_PaymentMethod', { CompanyId: parseInt(window.localStorage.getItem('CompanyId')) });
                window.localStorage.$reset('');
            }
            else {
                window.location.href = "#app/Manage_Payment";
            }
        }
    }

    PaymentMethodController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function PaymentMethodController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;

        vm.companyId = 0;
        vm.CustomerId = 0;
        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.companyId = authorisedCustomer.CompanyId;
                vm.CustomerId = authorisedCustomer.CustomerId;
            }
        }
        vm.PaymentMethods = [];
        //Get Method Details
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

        $http({
            method: 'GET',
            url: baseUrl + 'getcurrencydetails',
            headers: { 'Content-Type': 'application/json' }
        })
    .success(function (data) {
        var idata = data;
        vm.Currencydetails = idata;
    });


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



        vm.PaymentModel = { PaymentMethodId: '0', CompanyId: vm.companyId, CustomerId: vm.CustomerId, Charges: "0", Fees: "0", Tax: "0", SendingCurrencyId: '1', ReceivingCurrencytId: '2', BeneficiaryId: '0',ExchangeRate:'64.60', setExpirationDate: '',ReceivingAmount:'' }
        vm.Message = '';
        vm.ExpireModel = {}
        vm.selectedMethod = function (Id) {
            var iPaymentId = parseInt(Id);
            var formData = JSON.parse(JSON.stringify({ "PaymentMethodId": iPaymentId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getauthorizepaymentdsettingsbypaymentmethodid',
                headers: { 'Content-Type': 'application/json' }
            })
         .success(function (data) {
             var idata = data;
             if (idata.AuthorizePaymentSettingsId > 0) {
                 vm.AuthorizePaymentdetails = idata;
                 vm.Message = '';
             }
             else {
                 vm.Message = "Payment setting not found";
                 vm.AuthorizePaymentdetails = [];
             }
         });
        }


        //Get Beneficiary Details
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

        //Swap Tabs
        vm.selected = '';
        vm.updatetabs = function () {
            var idata = vm.PaymentModel;
            if (idata != null) {
                vm.selected = true;
                var sss = $('#tabs');
                var deactive = $(sss).find('#CashPickUp');
                $(deactive).removeClass('active');
                var sd = $(sss).find('#PAYMENT');
                $(sd).addClass('active');

            }
        }

        //Add Beneficiary
        vm.addNewBeneficiary = function () {
            // DeleteCompanyID = Id;
            $('#addBeneficiaryconfirm').modal('toggle');
        }

        var iCompanyId = JSON.stringify(vm.companyId);
        var iCustomerId = JSON.stringify(vm.CustomerId);
        vm.BeneficiaryModel = { CompanyId: iCompanyId, CustomerId: iCustomerId, CountryId: "0", BeneficiaryTypeId: '0' };
        vm.CreateBeneficiary = function () {
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
                }
                else {
                    Alert(2, idata.Error);
                }
            });
        }

        //Amount Conversion
        vm.convertAmount = function () {
            var exrate = 64.60;
            var amount = parseInt(document.getElementById('SendingAmount').value);

            var ReceivingAm = (exrate * amount).toFixed(2);
            vm.PaymentModel.ReceivingAmount = parseFloat(ReceivingAm);
        }

       
        vm.Create = function () {
            var idata = vm.PaymentModel;

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
                data: formData,
                url: baseUrl + 'makePayment',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata && idata.Result == "Sucess") {
                    Alert(1, "! Payment processed successfully");
                    vm.PaymentModel = angular.copy(vm.PaymentModel);
                    $state.go('app.Thankyou');
                    setTimeout(function () {
                        $state.go('app.Thankyou');
                    }, 1000);
                }
                else {
                    idata = [];
                    Alert(2, idata.Error);
                }
            });
        }


        vm.cancel = function () {
            window.location.reload();
            //$state.go('app.PaymentDetalis');
        }

    }

    thankyouController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function thankyouController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {
        var vm = $scope;
        setTimeout(function () {
            $state.go('app.Transaction');
        }, 3000);
    }
})();