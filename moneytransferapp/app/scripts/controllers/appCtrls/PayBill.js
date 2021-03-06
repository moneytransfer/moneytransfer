﻿

(function () {
    'use strict';
    angular
        .module('app')
        .controller('managePayBillController', managePayBillController)
        .controller('addPayBillController', addPayBillController)
        //.controller('addPayBillController', addPayBillController)

    managePayBillController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log'];
    function managePayBillController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log) {
        var vm = $scope;
        var CompanyId = 0;
        vm.CustomerId = 0;
        
        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
            }
        }

        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CustomerId": vm.CustomerId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getBillPayDetails',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            //if (idata.length > 5) {
                vm.totalItems = idata.length;
                vm.currentPage = 1;
                vm.itemsPerPage = 15;

                vm.$watch("currentPage", function () {
                    setPagingData(vm.currentPage);
                });
            //}
            //else {
            //    vm.ManagePayBill = idata;
            //}


            function setPagingData(page) {
                var pagedData = idata.slice(
                  (page - 1) * vm.itemsPerPage,
                  page * vm.itemsPerPage
                );
                vm.ManagePayBill = pagedData;
            }
            //}, 100);
        });

        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);

            return dateOut;
        };

    }

    addPayBillController.$inject = ['$scope', '$http', '$localStorage', '$location', '$rootScope', '$anchorScroll', '$timeout', '$window', '$state', '$stateParams', '$translate', '$log', '$filter'];
    function addPayBillController($scope, $http, $localStorage, $location, $rootScope, $anchorScroll, $timeout, $window, $state, $stateParams, $translate, $log, $filter) {

        var vm = $scope;
        vm.PaybillModel = { CompanyId: vm.CompanyId, CustomerId: vm.CustomerId, SenderName: vm.CustomerName, PaymentMethodId: '0', Amount: '0.00' }
        vm.CompanyId = 0;
        vm.CustomerId = 0;
        vm.CustomerName = '';
        vm.CountryId = '';
        if ($window.sessionStorage.authorisedCustomer) {
            authorisedCustomer = JSON.parse($window.sessionStorage.authorisedCustomer);
            if (authorisedCustomer.CustomerId) {
                vm.CompanyId = parseInt(authorisedCustomer.CompanyId);
                vm.CustomerId = parseInt(authorisedCustomer.CustomerId);
                vm.CustomerName = (authorisedCustomer.FirstName);
            }
        }


        vm.PaymentMethods = [];
        vm.Countries = [];
        $http({
            method: 'GET',
            url: baseUrl + 'getcountrydetails',
            headers: { 'Content-Type': 'application/json' }
        })
       .success(function (data) {
           var idata = data;
           vm.Countries = idata;

       });
        //Get Method Details
        var formData = JSON.parse(JSON.stringify({ "CompanyId": vm.CompanyId }));
        $http({
            method: 'POST',
            data: formData,
            url: baseUrl + 'getpaymentmethodbycompanyid ',
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        })
        .success(function (data) {
            var idata = data;
            vm.PaymentMethods = idata;
            if (vm.PaymentMethods[0].PaymentMethodId == 0)
                vm.PaymentMethods.splice(0, 1);
            vm.PaybillModel.PaymentMethodId = vm.PaymentMethods[0].PaymentMethodId;
        });


        vm.FlagModel = [];
        vm.Fee = "";
       
        vm.PayDetails = { SenderName: '', FaceAmount: '', InvoiceAmount: '', MobileNumber: '', InvoiceNumber: '' };
     
        
        vm.ExpireModel = {}
        //Get Method Details

        vm.EnteredNumber = function (iNumber) {
            if (iNumber.length > 9) {
                var iEnteredNumber =parseInt(iNumber);
                var formData = JSON.parse(JSON.stringify({ "MobileNumber": iEnteredNumber }));
                $http({
                    method: 'POST',
                    data: formData,
                    url: baseUrl + 'getCarrierInfoByMobileNumber ',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' }
                })
                .success(function (data) {
                    var idata = data;
                    if (idata.countryCode != null) {
                        idata.countryCode = idata.countryCode.toLowerCase();
                        
                        vm.FlagModel = idata;
                        var res = idata.internationalCodes.split(" ");
                        var PhoneCode =parseInt(res[0]);
                        var data1= data1 = $filter('filter')(vm.Countries, {
                            phonecode: PhoneCode,
                        }, true);
                        vm.CountryId = data1[0].CountryId;
                        vm.FlagModel.CountryId = vm.CountryId;
                        vm.FlagModel.PhoneCode = PhoneCode;
                        //$localStorage.numberDetails = idata;
                        //$('#shfirstbutton').prop('disabled', false);
                    }
                    else {
                        vm.FlagModel = [];
                        Alert(2, "!" + idata.Error);
                    }
                });
                
            }
          
        }


        vm.showPaymentForm = function () {

            $('#showPaymentForm').show();
        }



        //Payment Confirmation
        vm.Paynow = function () {
            //
           
            $('#PaymentConfirm').modal('toggle');
            //$('#PaymentConfirmbtn').click();
        }

        vm.Create = function () {
            $('#PaymentConfirm').modal('toggle');

            var idata = vm.PaybillModel;
            if ($location.path() != "/app/PayBill") {
                
                idata.Amount = $localStorage.numberDetails.Ammount;
                idata.PaymentMethodId = 1;
               idata.MobileNumber = $localStorage.numberDetails.MobileNumber;
            }
            idata.Amount = parseInt(idata.Amount) + vm.FlagModel.Fee;
            idata.Fees =vm.FlagModel.Fee;
            var sMonth = vm.ExpireModel.ExpireMonth;
            if (sMonth < 10) {
                sMonth = '0' + sMonth
            }
            var sYear = vm.ExpireModel.ExpireYear;
            var expiremonth = sMonth + '' + sYear;
            idata.setExpirationDate = expiremonth;
            idata.CompanyId = vm.CompanyId;
            idata.CustomerId = vm.CustomerId;
            idata.SenderName = vm.CustomerName;
            var formData = JSON.stringify(idata);

            
            $http({
                method: 'POST',
                url: baseUrl + 'billPay',
                data: formData,
                headers: {
                    'Content-Type': 'application/json'
                },
                dataType: "json",
            })
            .success(function (data) {

                var idata = data;
                if (idata.PaymentMethodId == 12) {
                    idata.InvoiceNumber = idata.PaymentGatewayTransactionId;
                    idata.InvoiceAmount = idata.Amount;
                    idata.FaceAmount = idata.Amount;
                }
                vm.PayDetails = idata;
                if (idata && idata.BillPayId > 0) {
                    $('#ThankyouPaybill').modal('toggle');

                    $timeout(function () {
                        $state.go('app.Transaction');
                    }, 4000);

                    //$timeout(function () {
                    //    //clean local storage and redirect to dashboard page.
                    //    if ($location.path() != "/app/PayBill") {
                    //        $('#ThankyouPaybill').modal('toggle');
                    //        $localStorage.numberDetails = null;
                    //        $state.go('app.transactionDetails');
                    //    }else{
                    //        $state.go('app.manage_pay_bill');
                    //    }
                        
                    //}, 5000);

                }
                else {
                    Alert(2, idata.Error);
                }
            });
        }

        //Format date
        $scope.formatDate = function (date) {
            var dateOut = new Date(date);

            return dateOut;
        };

        vm.Setamount = function (value) {
            if (value != null) {
                vm.PaybillModel.Amount = value;
                
                vm.getFeeDetails(vm.PaybillModel.Amount);
            }
        }

        vm.getFeeDetails = function (amount) {
            var DestinationCountry = vm.FlagModel.CountryId;
            var formData = JSON.parse(JSON.stringify({ "CompanyId": 17, "DestinationCountry": DestinationCountry }));
            $http({
                method: 'POST',
                url: baseUrl + 'getPaymentFeesByCompanydestinationCountry',
                data: formData,
                headers: { 'Content-Type': 'application/json; charset=utf-8' }
            })
            .success(function (data) {


                var idata = data;
                vm.feeData = idata;
             
                for (var i = 0; i < vm.feeData.length; i++) {
                    if (parseInt(amount) <= vm.feeData[i].EndAmount) {
                        vm.Fee = vm.feeData[i].Fees;
                        vm.FlagModel.Fee = vm.Fee;
                    } else {
                        vm.Fee = 0
                        vm.FlagModel.Fee = "0.00";
                    }
                }




            });
        }

        vm.PayAmount = [{ AmountId: '1', Amount: '02.00' }, { AmountId: '2', Amount: '04.00' },
        { AmountId: '3', Amount: '06.00' }, { AmountId: '4', Amount: '08.00' },
        { AmountId: '5', Amount: '10.00' }, { AmountId: '6', Amount: '12.00' },
        { AmountId: '7', Amount: '14.00' }, { AmountId: '8', Amount: '16.00' },
        { AmountId: '9', Amount: '18.00' }, { AmountId: '10', Amount: '20.00' },
        { AmountId: '11', Amount: '22.00' }, { AmountId: '12', Amount: '24.00' },
        { AmountId: '13', Amount: '26.00' }, { AmountId: '14', Amount: '28.00' },
        { AmountId: '15', Amount: '30.00' }, { AmountId: '16', Amount: '32.00' }]

        vm.cancel = function () {
            $state.go('app.manage_pay_bill');
        }

        //vm.select = function ($event) {
        //    if (vm.PaybillModel.MobileNumber == null) {
        //        $event.preventDefault();
        //    }
           
        //}

        //vm.selectTwo = function ($event) {
        //    if (vm.PaybillModel.Amount == "0.00") {
        //        $event.preventDefault();
        //    }

        //}
      
 
    }
})();