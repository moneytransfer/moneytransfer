

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageUsersController', manageUsersController)
        .controller('addEditUserController', addEditUserController)




    manageUsersController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function manageUsersController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
        var IsAdmin = false;
        vm.ManageUsers = [];
        vm.UserId = 0;
        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) { vm.UserId = parseInt(authorisedUser.UserId); }
        }

        //Get users
        $http({
            method: 'GET',
            url: baseUrl + 'getuserdetails',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.ManageUsers = idata;

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

    addEditUserController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditUserController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;

        vm.UserModel = { UserId: 0, CompanyId: "0", Password: "", ConfirmPassword: "" };
        vm.Companies = [];

        vm.header = 'Add New';

        $http({
            method: 'GET',
            url: baseUrl + 'getcompanydetails',
            headers: { 'Content-Type': 'application/json' }
        })
       .success(function (data) {
           var idata = data;
           vm.Companies = idata;

       });


        if ($stateParams.UserId) {
            vm.header = 'Update';
            var iUserId = "";
            iUserId = JSON.stringify($stateParams.UserId);
           
            var formData = JSON.parse(JSON.stringify({ "UserId": iUserId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getuser',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 var idata = data;
                 if (idata) {
                     var CompanyId = "";
                     CompanyId = idata.CompanyId;
                     vm.UserModel = idata;
                     vm.UserModel.CompanyId = JSON.stringify(CompanyId);

                     vm.UserModel.Password = "";
                     vm.UserModel.ConfirmPassword = "";

                 }
             });
        }



        vm.Create = function () {
            if ($stateParams.UserId) {
                var formData = JSON.stringify(vm.UserModel);
                debugger;
                $http({
                    method: 'POST',
                    url: baseUrl + 'updateuser',
                    data: formData,
                    headers: {
                        'Content-Type': 'application/json'
                       },
                    dataType: "json",
                })
                .success(function (data) {
                  
                    var idata =data;
                    if (idata && idata.UserId > 0) {
                        Alert(1, "! User updated successfully");
                        vm.UserModel = angular.copy(vm.UserModel);
                        setTimeout(function () {
                            $state.go('app.manage_Users');
                        }, 1000);

                    }
                    else {
                        Alert(2, idata.User.Message);
                    }
                });
            }
            else {
                
                var formData = JSON.stringify(vm.UserModel);
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'adduser',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                 
                    var idata = data;
                    if (idata && idata.UserId > 0) {
                        Alert(1, "! User created successfully");
                        vm.UserModel = angular.copy(vm.UserModel);
                        setTimeout(function () {
                            $state.go('app.manage_Users');
                        }, 1000);
                    }
                    else {
                        Alert(2, idata.Result);
                    }
                });
            }
        }

        vm.cancel = function () {
            $state.go('app.Manage_User');
        }
    }


})();