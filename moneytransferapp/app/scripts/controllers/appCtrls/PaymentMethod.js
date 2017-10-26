

(function () {
    'use strict';
    angular
        .module('app')
        .controller('managePaymentMethodController', managePaymentMethodController)
        .controller('addEditPaymentMethodController', addEditPaymentMethodController)

    managePaymentMethodController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function managePaymentMethodController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
        vm.CompanyId = 0;
        if ($stateParams.CompanyId) {
            vm.CompanyId = parseInt($stateParams.CompanyId);
        }
        else {
            if ($window.sessionStorage.authorisedUser) {
                authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
                if (authorisedUser.CompanyId) { vm.CompanyId = parseInt(authorisedUser.CompanyId); }
            }
        }

        //Get Customer
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
            iPaymentMethodID = JSON.stringify($stateParams.PaymentMethodId);

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
                        Alert(1, "! Payment method updated successfully");
                        vm.PaymentMethodModel = angular.copy(vm.PaymentMethodModel);
                        setTimeout(function () {
                            $state.go('app.Manage_PaymentMethod', { CompanyId: $stateParams.companyId });
                        }, 1000);

                    }
                    else {
                       // Alert(2, idata.User.Message);
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
                //vm.PaymentMethodModel.CompanyId = parseInt($stateParams.companyId);
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
                $state.go('app.Manage_PaymentMethod', { CompanyId: $stateParams.companyId });
            }
            else {
                window.location.href = "#app/Manage_Payment";
            }
        }
    }


})();