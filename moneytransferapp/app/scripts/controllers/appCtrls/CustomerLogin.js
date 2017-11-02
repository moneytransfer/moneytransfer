function Alert(type, msg) {
    var div = "";
    switch (type) {
        case 1:
            div = "<div id='alert' class='alert alert-success pull-right col-sm-4 '><a href='#' class='close' data-dismiss='alert'>&times;</a><strong>Well done! </strong> " + msg + "</div>";
            break;
        case 2:
            div = "<div id='alert' class='alert alert-danger pull-right col-sm-4 '><a href='#' class='close' data-dismiss='alert'>&times;</a><strong>Warning! </strong> " + msg + "</div>";
            break;
    }
    jQuery('body').append(div);
    setTimeout(function () {
        jQuery('#alert').remove();
    }, 3500);
}

//$(document).ready(function () {
//    if (authorisedCustomer.access_token) {
//        $("#appheader").removeClass('hide');
//    }
//});

function backtotop(div) {
    $("#" + div).animate({
        scrollTop: 0
    }, 800);
    return false;
}

//function UnAuth($window) {
//    if ($window.sessionStorage.authorisedCustomer) {
//        $window.sessionStorage.removeItem('authorisedUser');
//        authorisedCustomer = [];
//        window.location.reload();
//    }
//}

var authorisedCustomer = [];

(function () {
    'use strict';
    angular
   .module('app')
   .controller('LoginCtrl', LoginCtrl)
   .controller('CustomerProfileController', CustomerProfileController)
   .controller('CustomerauthenticateController', CustomerauthenticateController)
   .controller('CustomerlogoutController', CustomerlogoutController)

    LoginCtrl.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function LoginCtrl($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
        var vm = $scope;
        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) { $state.go('app.Transaction'); }
        }

        vm.CompanyId = 0;
        if ($stateParams.CompanyId) {
            vm.CompanyId = parseInt($stateParams.CompanyId);
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
                authorisedCustomer = data;
                if (authorisedCustomer.CustomerId) {
                    $window.sessionStorage.authorisedCustomer = JSON.stringify(data);
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
                            authorisedCustomer = data;
                            if (authorisedCustomer.CustomerId) {
                                $window.sessionStorage.authorisedCustomer = JSON.stringify(data);
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
    };

    CustomerauthenticateController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function CustomerauthenticateController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {

        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (!authorisedCustomer.CustomerId) {
                $window.location.reload();
            }
        }
        else {
           // $state.go('app.login');
            $window.location.assign('#/app/customersignin');
        }
    }

    CustomerlogoutController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function CustomerlogoutController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {

        var vm = $scope;
        
        vm.logoutCustomer = function () {
            if ($window.sessionStorage.authorisedCustomer) {
                $window.sessionStorage.removeItem('authorisedCustomer');
                authorisedCustomer = [];
                //$window.location.assign('#/app/Customer/login');
                $window.location.reload();
            }
        }
    }

    CustomerProfileController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$filter'];
    function CustomerProfileController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $filter) {
        var vm = $scope;
        var CustomerId = 0;
        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) { CustomerId = authorisedCustomer.CustomerId }
        }

        vm.CustomerModel = { CompanyId: "0", CountryId: "0", FirstName: '', LastName: '', Address1: '', Address2: '', City: '', State: '', ZipCode: '', Phone: '', Email: '', Password: '', DOB: '', ProfileImage: '', ActivationCode: '', };

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

        var formData = JSON.stringify({"CustomerId" : CustomerId});
        $http({
            url: baseUrl + 'getcustomerdetails',
            method: 'POST',
            data: formData,
            headers: { 'Content-Type': 'application/json' },
            dataType: "json",
        })
           .success(function (data) {
               var idata = data;
               if (idata && idata.CustomerId) {
                   var CountryId = "";
                   CountryId = idata.CountryId;
                   idata.CountryId = JSON.stringify(CountryId);
                   idata.Phone = parseInt(idata.Phone);
                   idata.DOB = $filter('date')(idata.DOB, "yyyy/MM/dd");
                   vm.CustomerModel = idata;
               }

           })
         .error(function (data, status, headers, config) {
             Alert(2, "! " + data);
         });


        vm.update = function () {
            var formData = JSON.stringify(vm.CustomerModel);
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
                    Alert(1, "! Customer Details updated successfully..");
                }
                else {
                    Alert(2, "! Invalid Customer details. ");
                }
            });
        }
    }


})();


