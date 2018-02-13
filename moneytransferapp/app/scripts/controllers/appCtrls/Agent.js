

(function () {
    'use strict';
    angular
        .module('app')
        .controller('manageAgentController', manageAgentController)
    .controller('addEditAgentController', addEditAgentController)





    manageAgentController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function manageAgentController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;
        var IsAdmin = false;
        vm.ManageAgent = [];
        vm.UserId = 0;

        var CompanyId = 0;
        //vm.CompanyId = 0;
        if ($stateParams.CompanyId) {
            vm.CompanyId = parseInt($stateParams.CompanyId);
            $window.localStorage.setItem('CompanyId', JSON.stringify($stateParams.CompanyId));
        }
        else {
            if ($window.sessionStorage.authorisedUser) {
                authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
                if (authorisedUser.CompanyId) { vm.CompanyId = parseInt(authorisedUser.CompanyId); }
            }
        }

        //Get Auth
        if ($window.sessionStorage.authorisedUser) {
            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) { vm.UserId = parseInt(authorisedUser.UserId); }
        }
        //Get Agent
        var iComapnyId = $window.localStorage.getItem('CompanyId');

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": iComapnyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getAgentdetailsByCompanyId ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.ManageAgent = idata;

            $timeout(function () {
                $('#tblAgent').trigger('footable_redraw');
            }, 100);

        });



        vm.addagent = function () {
            $state.go('app.add_Agent');
        }

        //vm.EditAgent = function (agentId) {
        //    $state.go('app.Edit_Agent', { AgentId: agentId });
        //}

        vm.BackToCompany = function () {
            $state.go('app.Manage_Company');
        }
        //DeleteUser
        var DeleteAgentID = 0;
        vm.deleteAgent = function (Id) {
            DeleteAgentID = Id;
            $('#deleteconfirm').modal('toggle');
        }

        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var iAgentID = "";
            iAgentID = JSON.stringify(DeleteAgentID);

            var formData = JSON.parse(JSON.stringify({ "AgentId": iAgentID }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deleteAgent',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata.AgentId > 0) {
                    Alert(1, "! Agent deleted successfully");
                    var iManageAgent = vm.ManageAgent;
                    vm.ManageAgent = [];
                    for (var i = 0; i < iManageAgent.length; i++) {
                        if (iManageAgent[i].AgentId !== DeleteAgentID) vm.ManageAgent.push(iManageAgent[i]);
                    }
                }
            });
        }

    }

    addEditAgentController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate'];
    function addEditAgentController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate) {

        var vm = $scope;

        vm.AgentModel = { AgentId: 0, CompanyId: iCompanyId, CountryId: "0", IsAllowedCreateAgent: false, AllowedCasiherTellerApproval: false, ApproveeachTransByCashierTeller: false, CreateComplianceGroup: false, AssignAdminToAgent: false, IsActive: true, BureauDeChange: '0' };
        vm.BureauDeChange = { TrueStatus: '0', FalseStatus: '0' };
        vm.header = 'Add New';
        var iCompanyId = $window.localStorage.getItem('CompanyId');
        $http({
            method: 'GET',
            url: baseUrl + 'getcountrydetails',
            headers: { 'Content-Type': 'application/json' }
        })
      .success(function (data) {
          var idata = data;
          vm.Countries = idata;

      });

        vm.CountryCode = [{ phonecode: '0' }];

        vm.getcountrydata = function (id) {
            var iCountryId = parseInt(id);
            var formData = JSON.parse(JSON.stringify({ "CountryId": iCountryId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getcountry',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {
                var idata = data;
                vm.CountryCode = idata;
            });
        }




        if ($stateParams.AgentId) {
            vm.header = 'Update';
            var iAgentId = "";
            iAgentId = JSON.stringify($stateParams.AgentId);

            var formData = JSON.parse(JSON.stringify({ "AgentId": iAgentId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getAgentdetailsById',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
             .success(function (data) {
                 var idata = data[0];

                 if (idata) {
                     //var CompanyId = "";
                     //CompanyId = idata.CompanyId;
                     vm.getcountrydata(idata.CountryId);
                     //if (idata.AllowedCasiherTellerApproval == true) {
                     //    idata.AllowedCasiherTellerApproval = "true";
                     //}
                     //if (idata.ApproveeachTransByCashierTeller == true) {
                     //    idata.ApproveeachTransByCashierTeller = "true";
                     //}
                     //if (idata.AssignAdminToAgent == true) {
                     //    idata.AssignAdminToAgent = "true";
                     //}
                     //if (idata.CreateComplianceGroup == true) {
                     //    idata.CreateComplianceGroup = "true";
                     //}
                     //if (idata.IsAllowedCreateAgent == true) {
                     //    idata.IsAllowedCreateAgent = "true";
                     //}
                     if (idata.BureauDeChange == true) {
                         document.getElementById("BureauDeChangetrue").checked = true;
                         document.getElementById("BureauDeChangefalse").checked = false;
                     }
                     else {
                         document.getElementById("BureauDeChangetrue").checked = false;
                         document.getElementById("BureauDeChangefalse").checked = true;
                     }
                     idata.CountryId = JSON.stringify(idata.CountryId);
                     idata.SerialNumberLength = parseInt(idata.SerialNumberLength);

                     vm.AgentModel = idata;

                 }
             });
        }




        vm.Create = function () {
            var idata = vm.AgentModel;
            var sdata = vm.BureauDeChange;
            if (vm.BureauDeChange.TrueStatus == "true") {
                idata.BureauDeChange = true;
            }
            else { idata.BureauDeChange = false; }
            idata.CompanyId = $window.localStorage.getItem('CompanyId');
            if ($stateParams.AgentId) {
                var formData = JSON.stringify(idata);
                $http({
                    method: 'POST',
                    url: baseUrl + 'agent',
                    data: formData,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    dataType: "json",
                })
                .success(function (data) {

                    var idata = data;
                    if (idata && idata.AgentId > 0) {
                        Alert(1, "! Agent updated successfully");
                        vm.AgentModel = angular.copy(vm.AgentModel);
                        setTimeout(function () {
                            $state.go('app.Manage_Agent');
                        }, 1000);

                    }
                    else {
                        Alert(2, idata.Agent.Message);
                    }
                });
            }
            else {

                var formData = JSON.stringify(idata);
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'agent',
                    headers: { 'Content-Type': 'application/json' },
                    dataType: "json",
                })
                .success(function (data) {
                    var idata = data;
                    if (idata && idata.AgentId > 0) {
                        Alert(1, "! Agent created successfully");
                        vm.AgentModel = angular.copy(vm.AgentModel);
                        setTimeout(function () {
                            $state.go('app.Manage_Agent');
                        }, 1000);
                    }
                    else {
                        Alert(2, idata.Result);
                    }
                });
            }
        }

        vm.cancel = function () {
            $state.go('app.Manage_Agent');
        }
    }


})();