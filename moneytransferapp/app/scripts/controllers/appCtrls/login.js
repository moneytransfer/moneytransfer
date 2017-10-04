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

$(document).ready(function () {
    if (authorisedUser.access_token) {
        $("#appheader").removeClass('hide');
    }
});

function backtotop(div) {
    $("#" + div).animate({
        scrollTop: 0
    }, 800);
    return false;
}

function UnAuth($window) {
    if ($window.sessionStorage.authorisedUser) {
        $window.sessionStorage.removeItem('authorisedUser');
        authorisedUser = [];
        window.location.reload();
    }
}

var authorisedUser = [];

(function () {
    'use strict';
    angular
   .module('app')
   .controller('LoginCtrl', LoginCtrl)

    LoginCtrl.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams'];
    function LoginCtrl($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams) {
        var vm = $scope;
        vm.UserModel = { "email": "", "password": "" };
        vm.signin = function () {
            debugger;
            var idata = JSON.stringify(vm.UserModel);

            var formData = vm.UserModel;
            $http({
                url: baseUrl + 'authenticateusers',
                method: 'POST',
                data: idata,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data, status, headers, config) {
                debugger;
                authorisedUser = data;
                if (authorisedUser.access_token) {
                    $window.sessionStorage.authorisedUser = JSON.stringify(data);
                    Alert(1, "! Login successful.. ");
                    setTimeout(function () { window.location.reload(); }, 2000);
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

        vm.signUp = function () {
            debugger;
            var idata = JSON.stringify(vm.UserModel);

            var formData = vm.UserModel;
            $http({
                url: baseUrl + 'authenticateusers',
                method: 'POST',
                data: idata,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data, status, headers, config) {
                debugger;
                authorisedUser = data;
                if (authorisedUser.access_token) {
                    $window.sessionStorage.authorisedUser = JSON.stringify(data);
                    Alert(1, "! Login successful.. ");
                    setTimeout(function () { window.location.reload(); }, 2000);
                }
                else {
                    Alert(2, "! Invalid user or password. ");
                }
            })
            .error(function (data, status, headers, config) {
                Alert(2, "! " + data);
            });
        }
    };
    //vm.submit = function () {
    //    $state.go('app.dashboard');
    //};
})();
//angular.module('app').controller('sessionCtrl', ['$state', sessionCtrl]);

