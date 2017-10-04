

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageCompanyController', manageCompanyController)
       




    manageCompanyController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function manageCompanyController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
        var IsAdmin = false;
        vm.ManageCompany = [];
        vm.UserId = 0;
        
        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) { vm.UserId = parseInt(authorisedUser.UserId); }
        }
        //Get users
        $http({
            method: 'GET',
            url: baseUrl + 'getcompanydetails ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.ManageCompany = idata;

            $timeout(function () {
                $('#tblUsers').trigger('footable_redraw');
            }, 100);

        });



        vm.adduser = function () {
            $state.go('app.add_User');
        }

        vm.EditUser = function (UserId) {
            $state.go('app.Edit_User', { UserId: UserId });
        }


        //var DeleteUserID = 0;
        //vm.deleteUser = function (Id) {

        //    DeleteUserID = Id;
        //    $('#deleteconfirm').modal('toggle');
        //}

        //vm.deleteconfirm = function () {
        //    $('#deleteconfirm').modal('toggle');

        //    var formData = $.param({ FamUserId: DeleteUserID });
        //    $http({
        //        method: 'POST',
        //        data: formData,
        //        url: baseUrl + 'DeleteUser',
        //        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        //    })
        //    .success(function (data) {

        //        var x2js = new X2JS();
        //        var idata = x2js.xml_str2json(data);
        //        if (idata.int.__text == "1") {
        //            Alert(1, "! User deleted successfully");
        //            var iManageUsers = vm.ManageUsers;
        //            vm.ManageUsers = [];
        //            for (var i = 0; i < iManageUsers.length; i++) {
        //                if (iManageUsers[i].FamUserId !== DeleteUserID) vm.ManageUsers.push(iManageUsers[i]);
        //            }
        //        }
        //    });
        //}


    }

   

})();