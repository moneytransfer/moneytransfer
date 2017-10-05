

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageCompanyController', manageCompanyController)
    .controller('addEditCompanyController', addEditCompanyController)
       




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



        vm.addcompany = function () {
            $state.go('app.add_Comapny');
        }

        vm.EditCompany = function (CompanyId) {
            $state.go('app.Edit_Comapny', { CompanyId: CompanyId });
        }


        //DeleteUser
        var DeleteCompanyID = 0;
        vm.deleteCompany = function (Id) {
            DeleteCompanyID = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var iCompanyID = "";
            iCompanyID = JSON.stringify(DeleteCompanyID);

            var formData = JSON.parse(JSON.stringify({ "CompanyId": iCompanyID }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deletecompany',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.CompanyId > 0) {
                    Alert(1, "! Company deleted successfully");
                    var iManageCompany = vm.ManageCompany;
                    vm.ManageCompany = [];
                    for (var i = 0; i < iManageCompany.length; i++) {
                        if (iManageCompany[i].CompanyId !== DeleteCompanyID) vm.ManageCompany.push(iManageCompany[i]);
                    }
                }
            });
        }

    }

    addEditCompanyController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditCompanyController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;

        vm.CompanyModel = { CompanyId: "0" };

        vm.header = 'Add New';

        if ($stateParams.CompanyId) {
            vm.header = 'Update';
            var iCompanyId = "";
            iCompanyId = JSON.stringify($stateParams.CompanyId);

            var formData = JSON.parse(JSON.stringify({ "CompanyId": iCompanyId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getcompany',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {

                 var idata = data;
                 if (idata) {
                     var CompanyId = "";
                     CompanyId = idata.CompanyId;
                     vm.CompanyModel = idata;

                 }
             });
        }



        vm.Create = function () {
       
            if ($stateParams.CompanyId) {
                var formData = JSON.stringify(vm.CompanyModel);
                $http({
                    method: 'POST',
                    url: baseUrl + 'updatecompany',
                    data: formData,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.CompanyId > 0) {
                        Alert(1, "! Company updated successfully");
                        vm.CompanyModel = angular.copy(vm.CompanyModel);
                        setTimeout(function () {
                            $state.go('app.Manage_Company');
                        }, 1000);

                    }
                    else {
                        Alert(2, idata.User.Message);
                    }
                });
            }
            else {

                var formData = JSON.stringify(vm.CompanyModel);
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'addcompany',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.Result == "Sucess") {
                        Alert(1, "! Company created successfully");
                        vm.CompanyModel = angular.copy(vm.CompanyModel);
                        setTimeout(function () {
                            $state.go('app.Manage_Company');
                        }, 1000);
                    }
                    else {
                        Alert(2, idata.Result);
                    }
                });
            }
        }

        vm.cancel = function () {
            $state.go('app.Manage_Company');
        }
    }


})();