

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageCustomerController', manageCustomerController)
        .controller('addEditCustomerController', addEditCustomerController)

    //Customer Login site
    manageCustomerController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function manageCustomerController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerId = 0;


        // $('body').removeClass('modal-open').css('padding-right', '0px');

        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
            }
        }
        //Remove BackDrop
        // $('.modal-backdrop').remove();

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": 0 }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getcustomerbycompanyid',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            idata = $filter('orderBy')(idata, 'CustomerId', $scope.reverse);
            vm.totalItems = idata.length;
            vm.currentPage = 1;
            vm.itemsPerPage = 15;
            vm.$watch("currentPage", function () {
                setPagingData(vm.currentPage);
            });

            function setPagingData(page) {
                var pagedData = idata.slice(
                  (page - 1) * vm.itemsPerPage,
                  page * vm.itemsPerPage
                );
                vm.ManageCustomers = pagedData;
            }
        });
        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);

            return dateOut;
        };

        //------------------Delete Customer----------------------//
        //DeleteUser
        var DeleteCustomerID = 0;
        vm.deleteCustomer = function (Id) {
            DeleteCustomerID = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');

            $('.modal-backdrop').remove();
            var iCustomerId = "";
            iCustomerId = JSON.stringify(DeleteCustomerID);

            var formData = JSON.parse(JSON.stringify({ "CustomerId": iCustomerId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deletecustomer',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.CustomerId > 0) {
                    Alert(1, "! Customer deleted successfully");
                    var iManageCustomers = vm.ManageCustomers;
                    vm.ManageCustomers = [];

                    for (var i = 0; i < iManageCustomers.length; i++) {
                        if (iManageCustomers[i].CustomerId !== DeleteCustomerID) vm.ManageCustomers.push(iManageCustomers[i]);
                    }
                }
            });
        }

        vm.adduser = function () {
            $state.go('app.add_Customer');
        }

        vm.EditUser = function (CustomerId) {
            $state.go('app.Edit_Customer', { CustomerId: CustomerId });
        }


        //-------------------- Get details------------------------//
        vm.pagination = { totalItems: 0, currentPage: 1, itemsPerPage: 8 }
        vm.CustomerTransactions = [];
        vm.GetDetails = function (id) {
            var iCustomerId = id;
            if (iCustomerId > 0) {
                vm.CustomerDetails = [];
                angular.forEach(vm.ManageCustomers, function (customer, index) {
                    if (customer.CustomerId == iCustomerId) {
                        vm.CustomerDetails.push(customer);
                    }
                });

                GetCustomerTransaction(iCustomerId);
            }
        }

        function GetCustomerTransaction(id) {
            var iCustomerId = id;

            $('#transactionDetails').modal('toggle');
            //Get Method Details
            var formData = JSON.parse(JSON.stringify({ "CustomerId": iCustomerId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'gettranscationdetails',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                vm.SourceData = idata;
                idata = $filter('orderBy')(idata, 'CustomerId', $scope.reverse);

                vm.pagination.totalItems = idata.length;
                // vm.pagination.currentPage = 1;
                //  itemsPerPage : 8

                vm.$watch("currentPage", function () {
                    setPagingData(vm.pagination.currentPage);
                });

                function setPagingData(page) {
                    var pagedData = idata.slice(
                      (page - 1) * vm.pagination.itemsPerPage,
                      page * vm.pagination.itemsPerPage
                    );
                    vm.CustomerTransactions = pagedData;
                }
            });
        }

        vm.pageChange = function () {

            vm.$watch("currentPage", function () {
                setPagingData(vm.pagination.currentPage);
            });

            function setPagingData(page) {
                var pagedData = vm.SourceData.slice(
                  (page - 1) * vm.pagination.itemsPerPage,
                  page * vm.pagination.itemsPerPage
                );
                vm.CustomerTransactions = pagedData;
            }
        }
    }


    addEditCustomerController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditCustomerController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;

        vm.CustomerModal = { CompanyId: "0", CountryId: "0", FirstName: '', LastName: '', Address1: '', Address2: '', City: '', State: '', ZipCode: '', Phone: '', Email: '', Password: '', DOB: '', ProfileImage: '' };
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

        if ($stateParams.CustomerId) {
            vm.header = 'Update';
            var iCustomerId = "";
            iCustomerId = JSON.stringify($stateParams.CustomerId);

            var formData = JSON.parse(JSON.stringify({ "CustomerId": iCustomerId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getcustomerdetails',
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
                     vm.CustomerModal = idata;
                     vm.CustomerModal.CompanyId = JSON.stringify(CompanyId);
                     vm.CustomerModal.CountryId = JSON.stringify(vm.CustomerModal.CountryId);
                 }
             });
        }



        vm.Create = function () {
            if ($stateParams.CustomerId) {
                var idata = vm.CustomerModal;
                vm.Customer = { "CustomerId": '', "CompanyId": "17", "CountryId": "12", "FirstName": ' ', "LastName": '', "Address1": '', "Address2": '', "City": '', "State": '', "ZipCode": '', "Phone": '', "Email": '', "Password": '', "DOB": '', "ProfileImage": '' };

                vm.Customer.CustomerId = idata.CustomerId;
                vm.Customer.CompanyId = idata.CompanyId;
                vm.Customer.CountryId = idata.CountryId;
                vm.Customer.FirstName = idata.FirstName;
                vm.Customer.LastName = idata.LastName;
                vm.Customer.Address1 = idata.Address1;
                vm.Customer.Address2 = idata.Address2;
                vm.Customer.City = idata.City;
                vm.Customer.State = idata.State;
                vm.Customer.ZipCode = idata.ZipCode;
                vm.Customer.Phone = idata.Phone;
                vm.Customer.Email = idata.Email;
                if (idata.Password != null && idata.Password != "") {
                    vm.Customer.Password = idata.Password;
                }
                else {
                    vm.Customer.Password = "";
                }
                vm.Customer.DOB = idata.DOB;
                vm.Customer.ProfileImage = idata.ProfileImage;
                var formData = JSON.stringify(vm.Customer);
                $http({
                    url: baseUrl + 'savecustomer',
                    method: 'POST',
                    data: formData,
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                    var rdata = data;
                    if (rdata.Result = "Sucess" && rdata.CustomerId > 0) {
                        Alert(1, "! Customer updated successfully");
                        vm.CustomerModal = angular.copy(vm.CustomerModal);
                        setTimeout(function () {
                            $state.go('app.Manage_Customer');
                        }, 1000);

                    }
                    else {
                        Alert(2, idata.User.Message);
                    }
                });
            }
            else {

                var iData = vm.CustomerModal;

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
                    if (idata && idata.Result == "Sucess") {
                        Alert(1, "! User created successfully");
                        vm.UserModel = angular.copy(vm.UserModel);
                        setTimeout(function () {
                            $state.go('app.Manage_Customer');
                        }, 1000);
                    }
                    else {
                        Alert(2, idata.Error);
                    }
                });
            }
        }

        vm.cancel = function () {
            $state.go('app.Manage_Customer');
        }
    }

})();