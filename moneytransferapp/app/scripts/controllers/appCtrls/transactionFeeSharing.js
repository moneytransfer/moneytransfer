(function () {
    'use strict';
    angular.module('app')
      .controller('transactionFeeSharingController', transactionFeeSharingController)
     .controller('addEditTransactionFeesController', addEditTransactionFeesController)

    //Manage Fee sharing
    transactionFeeSharingController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function transactionFeeSharingController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {

        var vm = $scope;
        var IsAdmin = false;
        vm.UserId = 0;
        vm.CompanyId = 0;
        vm.Companies = [];
        vm.PaymentMethodType = [];
        vm.TransactionFeeDetails = [{ TransactionFeeSharingId: 0, PaymentMethod: "", CreatedDate: "", Code: "", YourShare: "", PayInAgentPer: "", PayOutAgentPer: "", TransactionFeeType: "", PayInAgentName: "", PayOutAgentName: "", CompanyName: "" }];
        if ($window.sessionStorage.authorisedUser) {

            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) {
                vm.UserId = parseInt(authorisedUser.UserId);
                vm.CompanyId = parseInt(authorisedUser.CompanyId);
            }
        }

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompany ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.PaymentMethods = idata;
        });


        //get Company
        $http({
            method: 'GET',
            url: baseUrl + 'getcompanydetails',
            headers: { 'Content-Type': 'application/json' }
        })
      .success(function (data) {
          var idata = data;
          vm.Companies = idata;

          //Get PaymentMethod
          var formData = JSON.parse(JSON.stringify({ "CompanyId": 0 }));
          //Get TransactionFee Sharing Details
          $http({
              method: 'POST',
              url: baseUrl + 'getTransactionFeeSharingByComapny',
              data: formData,
              headers: { 'Content-Type': 'application/json; charset=utf-8' }
          }).success(function (data2) {
             
              var idata2 = data2;

              vm.TransactionFeeDetails = idata2;
              angular.forEach(vm.TransactionFeeDetails, function (fee, index) {
                  vm.getOtherData(fee, index);
              });

          });

      });
       

        vm.getOtherData = function (fee, i) {
            var formData = JSON.parse(JSON.stringify({ "CompanyId": fee.CompanyId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getAgentdetailsByCompanyId ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
         .success(function (data) {

             vm.ManageAgent = data;
             if (vm.ManageAgent.length == 0 && fee.PayInAgent == 0 && fee.PayOutAgent == 0) {
                 vm.TransactionFeeDetails[i].PayInAgentName = "All";
                 vm.TransactionFeeDetails[i].PayOutAgentName = "All";

             } else {
                 var data12 = $filter('filter')(vm.ManageAgent, {
                     AgentId: fee.PayInAgent,
                 }, true);
                 if (data12.length > 0) {
                     vm.TransactionFeeDetails[i].PayInAgentName = data12[0].AgentFirstName;
                 }
                 var data123 = $filter('filter')(vm.ManageAgent, {
                     AgentId: fee.PayOutAgent,
                 }, true);

                 if (data123.length > 0) {
                     vm.TransactionFeeDetails[i].PayOutAgentName = data123[0].AgentFirstName;
                 }
             }


             var companydetil = $filter('filter')(vm.Companies, {
                 CompanyId: fee.CompanyId,
             }, true);
             if (companydetil.length > 0)
                 vm.TransactionFeeDetails[i].CompanyName = companydetil[0].CompanyName;

             var Payment = $filter('filter')(vm.PaymentMethods, {
                 PaymentMethodId: fee.PaymentMethodId,
             }, true);

             if (Payment.length > 0)
                 vm.TransactionFeeDetails[i].Payment = Payment[0].Title;
         });


        }

        vm.AddFeeSharing = function () {
            $state.go('app.add_Transaction_Fees_Sharing');
        }

        vm.EditFee = function (Id) {
            $state.go('app.Edit_Transaction_Fees_Sharing', { TransactionFeeSharingId: Id });
        }
        //Deletetransaction
        var DeleteUserID = 0;
        vm.deleteTransactionFeeSharing = function (Id) {

            DeleteUserID = Id;
            $('#deleteconfirm').modal('toggle');
        }



        vm.deleteconfirm = function () {
            $('#deleteconfirm').modal('toggle');
            var TransactionFeeSharingId = 0;
            TransactionFeeSharingId = +DeleteUserID;

            var formData = JSON.parse(JSON.stringify({ "TransactionFeeSharingId": TransactionFeeSharingId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'deleteTransactionFeeSharingById',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {

                var idata = data;
                if (idata.TransactionFeeSharingId > 0 && idata.Result == "Sucess") {
                    Alert(1, "! Transaction Fee  deleted successfully");
                    var iManageUsers = vm.TransactionFeeDetails;
                    vm.TransactionFeeDetails = [];
                    for (var i = 0; i < iManageUsers.length; i++) {
                        if (iManageUsers[i].TransactionFeeSharingId !== DeleteUserID) vm.TransactionFeeDetails.push(iManageUsers[i]);
                    }
                }
            });
        }
        vm.setDisabled = function (id, IsActive) {


            var formData = JSON.parse(JSON.stringify({ "TransactionFeeSharingId": id, "IsSpecific": IsActive }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'enableDisableTransactionFeeSharing',
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            }).success(function (data) {
                var idata = data;
                if (idata.Result == "Success") {
                    angular.forEach(vm.TransactionFeeDetails, function (item) {
                        if (item.TransactionFeeSharingId == idata.TransactionFeeSharingId) {
                            item.IsSpecific = idata.IsSpecific
                        }
                    });
                } else {
                    alert(2, idata.Result);
                }

            });
        }

        vm.Feesfilter = { FeesCategory: "-1" };
        vm.FilterFeeSharing = function (value) {

            var FeeType = value;
            var formData = JSON.parse(JSON.stringify({ "CompanyId": 0 }));
            $http({
                method: 'POST',
                url: baseUrl + 'getTransactionFeeSharingByComapny',
                data: formData,
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
           .success(function (data) {

               var idata = data;
               if (FeeType != "All") {
                   vm.TransactionFeeDetails = [];
                   angular.forEach(idata, function (fee, index) {
                       if (fee.TransactionFeeType == FeeType) {
                       vm.TransactionFeeDetails.push(fee);
                       }
                   });
                   angular.forEach(vm.TransactionFeeDetails, function (fee, index) {
                       vm.getOtherData(fee, index);
                   });
               }
               else {
                   vm.TransactionFeeDetails = idata;
                   angular.forEach(vm.TransactionFeeDetails, function (fee, index) {
                       vm.getOtherData(fee, index);
                   });
               }
           });
        }

    }

    //Add/Edit Fee Sharing
    addEditTransactionFeesController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$filter'];
    function addEditTransactionFeesController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $filter) {
        var vm = $scope;
        vm.Error = "";
        vm.TransactionFeeSharingDetails = { TransactionFeeSharingId: 0 };

        vm.SelectedCompnay = "";
        vm.UserId = 0;
        vm.CompanyId = 0;
        vm.DeliveryMethod = [];
        vm.Companies = [];
        vm.header = 'Add New';
        vm.CustomizeTransactionFeeData = { TransactionFeeSharingId: 0, PaymentMethodId: "-1", PayInAgent: "-1", PayOutAgent: "-1", IsSpecific: true };
        if ($window.sessionStorage.authorisedUser) {

            authorisedUser = JSON.parse($window.sessionStorage.authorisedUser);
            if (authorisedUser.UserId) {
                vm.UserId = parseInt(authorisedUser.UserId);
                vm.CompanyId = parseInt(authorisedUser.CompanyId);
            }
        }

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

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompany ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.PaymentMethods = idata;
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



        if ($stateParams.TransactionFeeSharingId) {
            vm.header = 'Update';
            var iTransactionFeeSharingId = 0;
            iTransactionFeeSharingId = $stateParams.TransactionFeeSharingId;
            var formData = JSON.parse(JSON.stringify({ "TransactionFeeSharingId": iTransactionFeeSharingId }));
            $http({
                method: 'POST',
                url: baseUrl + 'getTransactionFeeSharingById',
                data: formData,
                headers: { 'Content-Type': 'application/json' },
                dataType: "json",
            })
            .success(function (data) {
                var idata = data;
                if (idata && idata.Result == "Sucess") {
                    if (idata.TransactionFeeType == 'Universal') {
                        vm.TransactionFeeSharingDetails.TransactionFeeSharingId = idata.TransactionFeeSharingId;
                        vm.CustomizeTransactionFeeData.TransactionFeeSharingId = idata.TransactionFeeSharingId;
                        vm.TransactionFeeSharingDetails.PayInAgentPer = parseFloat(idata.PayInAgentPer);
                        vm.TransactionFeeSharingDetails.PayOutAgentPer = parseFloat(idata.PayOutAgentPer);
                        vm.TransactionFeeSharingDetails.YourShare = parseFloat(idata.YourShare);

                        vm.TransactionFeeSharingDetails.SourceCountryId = "" + idata.SourceCountryId;
                        vm.TransactionFeeSharingDetails.DestinationCountryId = "" + idata.DestinationCountryId;
                        vm.SelectedCompnay = "" + idata.CompanyId;
                        vm.selectedCompany(idata.CompanyId);
                    } else {

                        vm.TransactionFeeSharingDetails.TransactionFeeType = idata.TransactionFeeType;
                        vm.TransactionFeeSharingDetails.TransactionFeeSharingId = idata.TransactionFeeSharingId;
                        vm.CustomizeTransactionFeeData.TransactionFeeSharingId = idata.TransactionFeeSharingId;;
                        var id = document.getElementById("cust_radio");
                        vm.CustomizeTransactionFeeData = idata;
                        vm.CustomizeTransactionFeeData.IsSpecific = idata.IsSpecific;
                        vm.CustomizeTransactionFeeData.PaymentMethodId = idata.PaymentMethodId;
                        vm.CustomizeTransactionFeeData.PayInAgentPer = parseFloat(idata.PayInAgentPer);
                        vm.CustomizeTransactionFeeData.PayOutAgentPer = parseFloat(idata.PayOutAgentPer);
                        vm.CustomizeTransactionFeeData.YourShare = parseFloat(idata.YourShare);
                        vm.TransactionFeeSharingDetails.SourceCountryId = "" + idata.SourceCountryId;
                        vm.TransactionFeeSharingDetails.DestinationCountryId = "" + idata.DestinationCountryId;
                        vm.SelectedCompnay = "" + idata.CompanyId;
                        vm.SetCustomizeData(idata.CompanyId, idata);
                    }
                } else {
                    alert(2, idata.Result);
                }
            });
        }







        vm.selectedCompany = function (CompanyId) {
            //PaymentMethod
            var iComapnyId = parseInt(CompanyId);
            var formData = JSON.parse(JSON.stringify({ "CompanyId": iComapnyId }));
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getpaymentmethodbycompanyid ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
             .success(function (data) {
                 var idata = data;
                 vm.DeliveryMethod = idata;
             });


            //Agent
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getAgentdetailsByCompanyId ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
                  .success(function (data) {
                      var idata = data;
                      vm.ManageAgent = idata;
                  });


        }
        vm.SetCustomizeData = function (companyId, data1) {
            var iComapnyId = parseInt(companyId);
            var formData = JSON.parse(JSON.stringify({ "CompanyId": iComapnyId }));
            //$http({
            //    method: 'POST',
            //    data: formData,
            //    url: baseUrl + 'getpaymentmethodbycompanyid ',
            //    headers: { 'Content-Type': 'application/json; charset=utf-8' }
            //})
            //  .success(function (data) {
            //      var idata = data;
            //  });
            //Agent
            $http({
                method: 'POST',
                data: formData,
                url: baseUrl + 'getAgentdetailsByCompanyId ',
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
                  .success(function (data) {
                      var idata = data;
                      vm.ManageAgent = idata;
                      var AgentData = $filter('filter')(vm.ManageAgent, {
                          AgentId: parseInt(data1.PayInAgent),
                      }, true);
                      if (AgentData.length > 0)
                          vm.CustomizeTransactionFeeData.PayInAgent = "" + AgentData[0].AgentId;
                      AgentData = $filter('filter')(vm.ManageAgent, {
                          AgentId: parseInt(data1.PayOutAgent),
                      }, true);
                      if (AgentData.length > 0)
                          vm.CustomizeTransactionFeeData.PayOutAgent = "" + AgentData[0].AgentId;
                  });
        }

        //Save Universal Fee
        vm.SaveUnivarsalFee = function () {


            var TotalShare = vm.TransactionFeeSharingDetails.PayInAgentPer + vm.TransactionFeeSharingDetails.PayOutAgentPer + vm.TransactionFeeSharingDetails.YourShare;
            if (TotalShare == 100) {
                if ($stateParams.TransactionFeeSharingId) {
                    vm.TransactionFeeSharingDetails.CompanyId = vm.SelectedCompnay;
                    vm.TransactionFeeSharingDetails.PayInAgent = "0";
                    vm.TransactionFeeSharingDetails.PayOutAgent = "0";
                    vm.TransactionFeeSharingDetails.PaymentMethodId = "0";
                    var iData = vm.TransactionFeeSharingDetails;
                    var formData = JSON.stringify(iData);
                    $http({
                        method: 'POST',
                        data: formData,
                        url: baseUrl + 'addTransactionFeeSharing',
                        headers: { 'Content-Type': 'application/json' },
                        dataType: "json",
                    })
                  .success(function (data) {

                      var idata = data;
                      if (idata && idata.Result == "Success") {
                          Alert(1, "! Transaction Fee Sharing Updated successfully");
                          setTimeout(function () {
                              $state.go('app.TransactionFeeSharing');
                          }, 1000);



                      }
                      else {
                          vm.Error = idata.Error;
                          $('#deleteconfirm').modal('show');
                      }
                  });


                } else {
                    vm.TransactionFeeSharingDetails.CompanyId = vm.SelectedCompnay;
                    vm.TransactionFeeSharingDetails.PayInAgent = "0";
                    vm.TransactionFeeSharingDetails.PayOutAgent = "0";
                    vm.TransactionFeeSharingDetails.PaymentMethodId = "0";
                    var iData = vm.TransactionFeeSharingDetails;
                    var formData = JSON.stringify(iData);
                    $http({
                        method: 'POST',
                        data: formData,
                        url: baseUrl + 'addTransactionFeeSharing',
                        headers: { 'Content-Type': 'application/json' },
                        dataType: "json",
                    })
                   .success(function (data) {

                       var idata = data;
                       if (idata && idata.Result == "Success") {
                           Alert(1, "! Transaction Fee Sharing created successfully");
                           setTimeout(function () {
                               $state.go('app.TransactionFeeSharing');
                           }, 1000);
                       }
                       else {
                           vm.Error = idata.Error;
                           $('#deleteconfirm').modal('show');
                       }
                   });
                }

            } else {
                Alert(2, "! Please correct the Share Amount!");
            }
        }

        //Save Specific Fee
        vm.SaveSpecificfee = function () {

            if (vm.CustomizeTransactionFeeData.PaymentMethodId == "13" || vm.CustomizeTransactionFeeData.PaymentMethodId == "17" || vm.CustomizeTransactionFeeData.PaymentMethodId == "18" || vm.CustomizeTransactionFeeData.PaymentMethodId == "19" || vm.CustomizeTransactionFeeData.PaymentMethodId == "20") {
                vm.CustomizeTransactionFeeData.PayInAgent = '-1';
                vm.CustomizeTransactionFeeData.PayInAgentPer = 0;
            }

            var TotalShare = vm.CustomizeTransactionFeeData.PayInAgentPer + vm.CustomizeTransactionFeeData.PayOutAgentPer + vm.CustomizeTransactionFeeData.YourShare;
            if (TotalShare == 100) {
                if ($stateParams.TransactionFeeSharingId) {
                    vm.CustomizeTransactionFeeData.CompanyId = vm.SelectedCompnay;
                    vm.CustomizeTransactionFeeData.TransactionFeeType = vm.TransactionFeeSharingDetails.TransactionFeeType;
                    var iData = vm.CustomizeTransactionFeeData;
                    var formData = JSON.stringify(iData);
                    $http({
                        method: 'POST',
                        data: formData,
                        url: baseUrl + 'addTransactionFeeSharing',
                        headers: { 'Content-Type': 'application/json' },
                        dataType: "json",
                    })
                   .success(function (data) {

                       var idata = data;
                       if (idata && idata.Result == "Success") {
                           Alert(1, "! Transaction Fee Sharing Updated successfully");
                           setTimeout(function () {
                               $state.go('app.TransactionFeeSharing');
                           }, 1000);



                       }
                       else {
                           vm.Error = idata.Error;
                           $('#deleteconfirm').modal('show');
                       }
                   });
                } else {

                    vm.CustomizeTransactionFeeData.TransactionFeeType = vm.TransactionFeeSharingDetails.TransactionFeeType;
                    vm.CustomizeTransactionFeeData.CompanyId = vm.SelectedCompnay;
                    var iData = vm.CustomizeTransactionFeeData;
                    var formData = JSON.stringify(iData);
                    $http({
                        method: 'POST',
                        data: formData,
                        url: baseUrl + 'addTransactionFeeSharing',
                        headers: { 'Content-Type': 'application/json' },
                        dataType: "json",
                    })
                   .success(function (data) {

                       var idata = data;
                       if (idata && idata.Result == "Success") {
                           Alert(1, "! Transaction Fee Sharing created successfully");
                           setTimeout(function () {
                               $state.go('app.TransactionFeeSharing');
                           }, 1000);


                       }
                       else {
                           vm.Error = idata.Error;
                           $('#deleteconfirm').modal('show');
                       }
                   });

                }


            } else {
                Alert(2, "! Please correct the Share Amount!");
            }
        }

        vm.cancel = function () {
            $state.go('app.TransactionFeeSharing');
        }

        vm.setDisabled = function () {
            vm.CustomizeTransactionFeeData.IsSpecific = false;
            $('#disabledBtn').addClass('cm-stackingorder');
        }
        vm.setEnabled = function () {

            vm.CustomizeTransactionFeeData.IsSpecific = true;
            $('#disabledBtn').removeClass('cm-stackingorder');

        }

    }


})();