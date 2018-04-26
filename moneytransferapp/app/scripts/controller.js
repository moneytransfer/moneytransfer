
var baseUrl = 'http://18.221.150.151/transfermoney/api/';
//var baseUrl = 'http://192.168.1.6:8080/transfermoney/api/';

var authorisedUser = [];
var authorisedCustomer = [];



(function () {
    'use strict';
    angular
        .module('app')
        .controller('AppCtrl', AppCtrl)


    /* Process */
        .factory('httpInterceptor', ['$q', '$rootScope', '$log',
        function ($q, $rootScope, $log) {
            var loadingCount = 0;

            return {
                request: function (config) {
                    $rootScope.process = true;
                    return config;
                },
                requestError: function (rejection) {
                    $rootScope.process = false;
                    //$log.error('Request error:', rejection);
                    return $q.reject(rejection);
                },
                response: function (response) {
                    $rootScope.process = false;
                    return response;
                },
                responseError: function (rejection) {
                    $rootScope.process = false;

                    return $q.reject(rejection);
                },


            };
        }
        ]).config(['$httpProvider', function ($httpProvider) {
            $httpProvider.interceptors.push('httpInterceptor');

            //extra
            //$httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
            //$httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
        }]);

    AppCtrl.$inject = ['$scope', '$http', '$localStorage', '$timeout', '$translate', '$uibModal', '$location', '$window', '$cookies'];

    function AppCtrl($scope, $http, $localStorage, $timeout, $translate, $uibModal, $location, $window, $cookies) {

        var vm = $scope;

        vm.app = {
            name: 'Phone Reloads',
            year: (new Date()).getFullYear(),
            offcanvas: false,
            expanding: false,
            fixedHeader: false,
            boxed: false,
            static: false,
            search: true,
            options: true,
            theme: '',
            isMessageOpen: false,
            isContactOpen: false
        };

        if (angular.isDefined($localStorage.app)) {
            vm.app = $localStorage.app;
        } else {
            $localStorage.app = vm.app;
        }

        var cookies = $cookies.getAll();
        angular.forEach(cookies, function (v, k) {

            $cookies.remove(k);
        });


        $scope.$watch('app', function () {
            $localStorage.app = vm.app;
        }, true);


        //Dummy user data
        vm.user = {
            fname: 'Betty',
            lname: 'Simmons',
            jobDesc: 'Administrator',
            avatar: 'images/avatar.jpg',
        };

        //Search 
        vm.searchFocus = false;
        vm.focusOn = function () {
            vm.searchFocus = true;
        };
        vm.focusOff = function () {
            $timeout(function () {
                vm.searchFocus = false;
            }, 100);
        };

        // Localization
        vm.setLang = function (langKey) {
            $translate.use(langKey);
        };

        //Chat modal
        vm.openChat = function () {
            var chatModalInstance = $uibModal.open({
                templateUrl: 'chatModal.html',
                controller: 'chatModalInstanceCtrl',
                controllerAs: 'chatmodal',
                windowClass: 'sidebar-modal chat-panel',
                backdropClass: 'chat-backdrop'
            });
        };

        // Offcanvas and horizontal menu
        vm.menu = false;
        vm.toggleMenu = function () {
            vm.menu = !vm.menu;
        };


        //Demo purposes. These can be removed
        var searchObject = $location.search();
        if (searchObject.layout) {
            vm.app.offcanvas = false;
            vm.app.expanding = false;
            vm.app.fixedHeader = false;
            vm.app.boxed = false;
            vm.app.static = false;

            switch (searchObject.layout) {
                case "offcanvas":
                    vm.app.offcanvas = true;
                    break;
                case "expanding":
                    vm.app.expanding = true;
                    break;
                case "fixed":
                    vm.app.fixedHeader = true;
                    break;
                case "boxed":
                    vm.app.boxed = true;
                    break;
                case "static":
                    vm.app.static = true;
                    break;
            }
        };

        vm.expandingFix = function (ev) {
            if (ev) {
                vm.app.offcanvas = false;
            }
        }

        vm.offcanvasFix = function (ev) {
            if (ev) {
                vm.app.expanding = false;
            }
        }




        function getParams(name) {
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
            return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        }
        
        //vm.ConvertMoney = function () {
        //    var accesstoken = 'rxv51rk8b4y1kjhasvww';
        //    $http({
        //        url: 'https://currencydatafeed.com/api/converter.php?' + $.param({ token: accesstoken, from: "USD", to: "INR", amount: "20" }),
        //        method: 'POST',
        //        headers: { 'Content-Type': 'application/json' },
        //        dataType: "json",
        //    })
        //        .success(function (data) {
        //            var idata = data;
        //        });
        //}

        // site code
        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            vm.authorisedUser = authorisedUser;
        }

        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            vm.authorisedCustomer = authorisedCustomer;
        }




    };

    function chatModalInstanceCtrl($uibModalInstance, $uibModal) {
        var vm = this;
        vm.ok = function () {
            $uibModalInstance.close();
        };
        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        vm.openMessage = function () {
            var messageModalInstance = $uibModal.open({
                templateUrl: 'conversationModal.html',
                controller: 'chatModalInstanceCtrl',
                controllerAs: 'conversation',
                windowTopClass: 'chat-message'
            });
        };
    }


    angular.module('app').controller('chatModalInstanceCtrl', ['$uibModalInstance', '$uibModal', chatModalInstanceCtrl]);

})();
