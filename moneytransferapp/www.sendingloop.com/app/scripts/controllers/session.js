function Alert(type, msg) {
    var div = "";
    switch (type) {
        case 1:
            div = "<div id='alert' class='alert alert-success pull-right col-sm-4 '><a class='close' data-dismiss='alert'>&times;</a><strong>Well done! </strong> " + msg + "</div>";
            break;
        case 2:
            div = "<div id='alert' class='alert alert-danger'><a class='close' data-dismiss='alert'>&times;</a><strong>Warning! </strong> " + msg + "</div>";
            break;
        case 3:
            div = "<div id='alert' class='alert alert-success'><a class='close' data-dismiss='alert'>&times;</a><strong>Well done! </strong> " + msg + "</div>";
            break;
    }
    jQuery('#viewAlert').append(div);
    setTimeout(function () {
        jQuery('#alert').remove();
    }, 3500);
}

$(document).ready(function () {
    if (authorisedUser.UserId) {
        $("#appheader").removeClass('hide');
    }
});

function backtotop(div) {
    $("#" + div).animate({
        scrollTop: 0
    }, 800);
    return false;
}

//function UnAuth($window) {
//    if ($window.sessionStorage.authorisedUser) {
//        $window.sessionStorage.removeItem('authorisedUser');
//        authorisedUser = [];
//        window.location.reload();
//    }
//}

var authorisedUser = [];

(function () {
    'use strict';
    angular
   .module('app')
   .controller('sessionCtrl', sessionCtrl)
   .controller('authenticateController', authenticateController)
   .controller('logoutController', logoutController)

    sessionCtrl.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function sessionCtrl($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
        var vm = $scope;

        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) { $state.go('app.dashboard'); }
        }
       
        //Login
        vm.signin = function () {
            var idata = JSON.stringify(vm.UserModel);

            $http({
                url: baseUrl + 'authenticateuser',
                method: 'POST',
                data: idata,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data, status, headers, config) {
                
                authorisedUser = data;
                if (authorisedUser.UserId) {
                    $window.sessionStorage.authorisedUser = JSON.stringify(data);
                    Alert(1, "! Login successful.. ");
                    setTimeout(function () { window.location.reload(); }, 1000);
                }
                else {
                    Alert(2, "! Invalid user or password. ");
                }
            })
            .error(function (data, status, headers, config) {
                Alert(2, "! " + data);
            });
        }
        //$state.go('user.signin');


    };
    //vm.submit = function () {
    //    $state.go('app.dashboard');
    //};

    authenticateController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function authenticateController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {

        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (!authorisedUser.UserId) {
                $window.location.reload();
            }
        }
       
        else if ($state.current.url == '/customersignin') {
            $window.location.assign('#/app/customersignin');
        }
        else if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (!authorisedCustomer.CustomerId) {
                $window.location.reload();
            }
        }
        else {
            $window.location.assign('#/app/signin');
    }
    }

    logoutController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function logoutController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {

        var vm = $scope;
        vm.logout = function () {
            if ($window.sessionStorage.authorisedUser) {
                $window.sessionStorage.removeItem('authorisedUser');
                authorisedUser = [];
                window.location.reload();

            }
        }

        vm.logoutCustomer = function () {
            if ($window.sessionStorage.authorisedCustomer) {
                $window.sessionStorage.removeItem('authorisedCustomer');
                authorisedCustomer = [];
                $window.location.assign('#/app/Customer/login');

            }
        }
    }

})();
//angular.module('app').controller('sessionCtrl', ['$state', sessionCtrl]);

