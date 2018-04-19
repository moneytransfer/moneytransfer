

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageBeneficiaryController', manageBeneficiaryController)
        .controller('addEditBeneficiaryController', addEditBeneficiaryController)
       




    manageBeneficiaryController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function manageBeneficiaryController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
      
        vm.ManageBeneficiary = [];
        vm.CompanyId = 0;
        vm.CustomerId = 0;
        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
            }
        }
        //Get Beneficiary
        var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.CustomerId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getbeneficiarydetails ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.ManageBeneficiary = idata;

            $timeout(function () {
                $('#tblBeneficiary').trigger('footable_redraw');
            }, 100);

        });



        vm.addBeneficiary = function () {
            $state.go('app.add_Beneficiary');
        }

        vm.EditBeneficiary = function (Id) {
            $state.go('app.Edit_Beneficiary', { BeneficiaryId: Id });
        }


        //DeleteUser
        var DeleteBeneficiaryId = 0;
        vm.deleteBeneficiary = function (Id) {
            DeleteBeneficiaryId = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var iBeneficiaryId = "";
            iBeneficiaryId = JSON.stringify(DeleteBeneficiaryId);

            var formData = JSON.parse(JSON.stringify({ "BeneficiaryId": iBeneficiaryId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deletebeneficiarydetail',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.BeneficiaryId > 0) {
                    Alert(1, "! Beneficiary deleted successfully");
                    var iManageBeneficiary = vm.ManageBeneficiary;
                    vm.ManageBeneficiary = [];
                    for (var i = 0; i < iManageBeneficiary.length; i++) {
                        if (iManageBeneficiary[i].BeneficiaryId !== DeleteBeneficiaryId) vm.ManageBeneficiary.push(iManageBeneficiary[i]);
                    }
                }
            });
        }

    }

    addEditBeneficiaryController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditBeneficiaryController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;

        vm.CompanyId = 0;
        vm.CustomerId = 0;
        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
            }
        }

        var iCompanyId = JSON.stringify(vm.CompanyId);
        var iCustomerId = JSON.stringify(vm.CustomerId);
        vm.BeneficiaryModel = { CompanyId: iCompanyId, CustomerId: iCustomerId, CountryId: "0", BeneficiaryTypeId: '0' };

        vm.header = 'Add New';

        $http({
            method: 'GET',
            url: baseUrl + 'getcountrydetails',
            headers: { 'Content-Type': 'application/json' }
        })
      .success(function (data) {
          var idata = data;
          vm.Countries = idata;

      });


        $http({
            method: 'GET',
            url: baseUrl + 'getbeneficiarytypedetails',
            headers: { 'Content-Type': 'application/json' }
        })
     .success(function (data) {
         var idata = data;
         vm.BeneficiaryType = idata;

     });

        if ($stateParams.BeneficiaryId) {
            vm.header = 'Update';
            var iBeneficiaryId = "";
            iBeneficiaryId = JSON.stringify($stateParams.BeneficiaryId);

            var formData = JSON.parse(JSON.stringify({ "BeneficiaryId": iBeneficiaryId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getbeneficiarydetailsbyId',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 
                 var idata = data;
                 if (idata) {
                     idata.ZipCode = parseInt(idata.ZipCode);
                     idata.Phone = parseInt(idata.Phone);
                     idata.CountryId = JSON.stringify(idata.CountryId);
                     idata.BeneficiaryTypeId = JSON.stringify(idata.BeneficiaryTypeId);

                     vm.BeneficiaryModel = idata;
                 }
             });
        }



        vm.Create = function () {
      
            var idata = vm.BeneficiaryModel;
            
            if ($stateParams.BeneficiaryId) {

                var formData = JSON.stringify(idata);
                $http({
                    method: 'POST',
                    url: baseUrl + '',
                    data: formData,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.BeneficiaryId > 0) {
                        Alert(1, "! Beneficiary updated successfully");
                        vm.BeneficiaryModel = angular.copy(vm.BeneficiaryModel);
                        setTimeout(function () {
                            $state.go('app.Beneficiary');
                        }, 1000);

                    }
                    else {
                        Alert(2, idata.User.Message);
                    }
                });
            }
            else {

                //idata.ZipCode = JSON.stringify(idata.ZipCode);
                var formData = JSON.stringify(idata);
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'addbeneficiary',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
    
                    var idata = data;
                    if (idata && idata.Result == "Sucess") {
                        Alert(1, "! Beneficiary created successfully");
                        vm.BeneficiaryModel = angular.copy(vm.BeneficiaryModel);
                        setTimeout(function () {
                            $state.go('app.Beneficiary');
                        }, 1000);
                    }
                    else {
                        Alert(2, idata.Result);
                    }
                });
            }
        }

        vm.cancel = function () {
            $state.go('app.Beneficiary');
        }
    }


})();