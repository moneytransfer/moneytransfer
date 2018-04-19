

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
        vm.CompanyId = 0;
        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) {
                vm.UserId = parseInt(authorisedUser.UserId);
                vm.CompanyId = parseInt(authorisedUser.CompanyId);
            }
        }
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
        //Get users
        $http({
            method: 'POST',
            url: baseUrl + 'getuserdetails',
            data:formData,
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

        //DeleteUser
        var DeleteUserID = 0;
        vm.deleteUser = function (Id) {
            DeleteUserID = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var iUserId = "";
            iUserId = JSON.stringify(DeleteUserID);

            var formData = JSON.parse(JSON.stringify({ "UserId": iUserId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deleteuser',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.UserId>0) {
                    Alert(1, "! User deleted successfully");
                    var iManageUsers = vm.ManageUsers;
                    vm.ManageUsers = [];
                    for (var i = 0; i < iManageUsers.length; i++) {
                        if (iManageUsers[i].UserId !== DeleteUserID) vm.ManageUsers.push(iManageUsers[i]);
                    }
                }
            });
        }


    }

    addEditUserController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditUserController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;

        vm.UserModel = { UserId: "0", CompanyId: "0",CountryId: "0", Password: ""};
        vm.Companies = [];

        vm.header = 'Add New';
        //Get Company
        $http({
            method: 'GET',
            url: baseUrl + 'getcompanydetails',
            headers: { 'Content-Type': 'application/json' }
        })
       .success(function (data) {
           var idata = data;
           vm.Companies = idata;

       });
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
                     idata.Phone = parseInt(idata.Phone);

                     vm.UserModel = idata;
                     vm.UserModel.CompanyId = JSON.stringify(CompanyId);

                     vm.UserModel.Password = "";

                 }
             });
        }



        vm.Create = function () {
            if ($stateParams.UserId) {
                var formData = JSON.stringify(vm.UserModel);
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
                            $state.go('app.Manage_User');
                        }, 1000);

                    }
                    else {
                        Alert(2, idata.User.Message);
                    }
                });
            }
            else {
              
                var iData = vm.UserModel;
                if (vm.UserModel.IsActive == true) {
                    iData.IsActive = "true"
                }
                else {
                    iData.IsActive = "false"
                }
               
                var formData = JSON.stringify(iData);


                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'adduser',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                 
                    var idata = data;
                    if (idata && idata.Result == "Sucess") {
                        Alert(1, "! User created successfully");
                        vm.UserModel = angular.copy(vm.UserModel);
                        setTimeout(function () {
                            $state.go('app.Manage_User');
                        }, 1000);
                    }
                    else {
                        Alert(2, idata.Error);
                    }
                });
            }
        }

        vm.cancel = function () {
            $state.go('app.Manage_User');
        }
    }


})();