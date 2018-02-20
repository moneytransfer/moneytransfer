(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageIndexController', manageIndexController)
        
    manageIndexController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function manageIndexController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
       
        $state.go('app.sending_loop')
        if ($localStorage.AmountDetails) {
           
        } else {
            
            $state.go('app.sending_loop')
        }      

        vm.MoveToSendMoney = function () {
            debugger;
            $state.go('app.SendMoneyAmount')
        }
      

    }

})();
