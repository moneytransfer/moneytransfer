/// <reference path="../views/index.html" />

(function () {
    'use strict';
    angular
        .module('app')
        .run(['$rootScope', '$state',

      function ($rootScope, $state) {
          $rootScope.$state = $state;
          $rootScope.$on('$stateChangeSuccess', function () {
              window.scrollTo(0, 0);
          });
          FastClick.attach(document.body);
      },
        ]).config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
      function ($stateProvider, $urlRouterProvider, $locationProvider) {
          $locationProvider.hashPrefix();

          var p = getParams('layout'),

               l = p ? p + '.' : '',
               layout = 'views/common/horizontal/layout.html',
               dashboard = "";

          // For unmatched routes
          $urlRouterProvider.otherwise('/app/signin');

          $stateProvider
         .state('app', {
             abstract: true,
             url: '/app',
             views: {
                 '': {
                     templateUrl: layout
                 }
             }
         })

          // Application routes
          //$stateProvider.state('app', {
          //    abstract: true,
          //    //  templateUrl: 'views/common/layout.html',
          //    templateUrl: 'views/common/horizontal/layout.html',
          //})
              .state('horizontal', {
                  //  templateUrl: 'views/common/horizontal/layout.html',
              })


              .state('app.signin', {
                  url: '/signin',
                  templateUrl: 'views/extra/extras-signin.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/session.js');
                          });
                      }]
                  },
                  title: 'Signin',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })


            //Dashboard
            .state('app.dashboard', {
                url: '/dashboard',
                templateUrl: 'views/dashboard/dashboard.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/controllers/dashboard.js');
                    }]
                },
                title: 'Dashboard',
                controller: "authenticateController"
            })

               //Dashboard
            .state('app.Manage_Customer', {
                url: '/Manage_Customer',
                templateUrl: 'views/CRM/customer/Manage_Customer.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('scripts/controllers/appCtrls/crm.js');
                        });
                    }]
                },
                title: 'Manage Customers',
                controller: "authenticateController"
            })

               .state('app.add_Customer', {
                   url: '/Manage_Customer',
                   templateUrl: 'views/CRM/customer/addEdit_Customer.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/crm.js');
                           });
                       }]
                   },
                   title: 'Add Customer',
                   classes: 'no-padding no-footer layout-static',
                   controller: "authenticateController"
               })

              .state('app.Edit_Customer', {
                  url: '/Manage_Customer',
                  templateUrl: 'views/CRM/customer/addEdit_Customer.html',
                  params: { CustomerId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/crm.js');
                          });
                      }]
                  },
                  title: 'Update Customer',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })

              .state('app.login', {
                  url: '/customersignin',
                  templateUrl: 'views/Customer/CustomerLogin/Customer_login.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/CustomerLogin.js');
                          });
                      }]
                  },
                  title: 'Login',
                  classes: 'no-padding no-footer layout-static',
                  controller: "CustomerauthenticateController"
              })

               .state('app.register', {
                   url: '/register',
                   templateUrl: 'views/Customer/CustomerLogin/Customer_Register.html',
                   params: { CompanyId: 0 },
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/CustomerLogin.js');
                           });
                       }]
                   },
                   title: 'Register',
                   classes: 'no-padding no-footer layout-static',
                   //controller: "authenticateController"
               })

               .state('app.Customer_dashboard', {
                   url: '/Customer_dashboard',
                   templateUrl: 'views/dashboard/Customer_dashboard.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('scripts/controllers/dashboard.js');
                       }]
                   },
                   title: 'Dashboard',
                   controller: "CustomerauthenticateController"
               })

               .state('app.profile', {
                   url: '/Profile',
                   templateUrl: 'views/Customer/CustomerLogin/Customer_Profile.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/CustomerLogin.js');
                           });
                       }]
                   },
                   title: 'Customer Profile',
                   classes: 'no-padding no-footer layout-static',
                   controller: "CustomerauthenticateController"
               })


              .state('app.PaymentDetails', {
                  url: '/PaymentDetails',
                  templateUrl: 'views/Customer/PaymentSetting/PaymentMethodDetails.html',
                  params: { CompanyId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/PaymentMethod.js');
                          });
                      }]
                  },
                  title: 'Payment Process',
                  classes: 'no-padding no-footer layout-static',
                  controller: "CustomerauthenticateController"
              })

              .state('app.Beneficiary', {
                  url: '/Beneficiary',
                  templateUrl: 'views/Customer/Beneficiary/manageBeneficiary.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Beneficiary.js');
                          });
                      }]
                  },
                  title: 'Beneficiary Details',
                  classes: 'no-padding no-footer layout-static',
                  controller: "CustomerauthenticateController"
              })

              .state('app.add_Beneficiary', {
                  url: '/add_Beneficiary',
                  templateUrl: 'views/Customer/Beneficiary/addEditBeneficiary.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Beneficiary.js');
                          });
                      }]
                  },
                  title: 'Beneficiary Details',
                  classes: 'no-padding no-footer layout-static',
                  controller: "CustomerauthenticateController"
              })

              .state('app.Edit_Beneficiary', {
                  url: '/Edit_Beneficiary',
                  templateUrl: 'views/Customer/Beneficiary/addEditBeneficiary.html',
                  params: { BeneficiaryId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Beneficiary.js');
                          });
                      }]
                  },
                  title: 'Beneficiary Details',
                  classes: 'no-padding no-footer layout-static',
                  controller: "CustomerauthenticateController"
              })

              .state('app.Transaction', {
                  url: '/Transaction',
                  templateUrl: 'views/Customer/Transaction/manageTransaction.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Transaction.js');
                          });
                      }]
                  },
                  title: 'Transaction Details',
                  classes: 'no-padding no-footer layout-static',
                  controller: "CustomerauthenticateController"
              })

              //Admin: All Transactions
              .state('app.Transaction_Details', {
                  url: '/Transaction_Details',
                  templateUrl: 'views/Transactions/transactions.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Transaction.js');
                          });
                      }]
                  },
                  title: 'Transaction Details',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })

               .state('app.manage_pay_bill', {
                   url: '/Manage_PayBill',
                   templateUrl: 'views/Customer/PayBill/PaidBillList.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                           });
                       }]
                   },
                   title: '',
                   classes: 'no-padding no-footer layout-static',
                   controller: "CustomerauthenticateController"
               })

           .state('app.Pay_Bill', {
               url: '/PayBill',
               templateUrl: 'views/Customer/PayBill/payBill.html',
               resolve: {
                   deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                       return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                           return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                       });
                   }]
               },
               title: '',
               classes: 'no-padding no-footer layout-static'
               //controller: "CustomerauthenticateController"
           })

              .state('app.Thankyou', {
                  url: '/Thankyou',
                  templateUrl: 'views/Customer/PaymentSetting/ThankyouPage.html',
                  params: { CompanyId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/PaymentMethod.js');
                          });
                      }]
                  },
                  title: '',
                  classes: 'no-padding no-footer layout-static',
                  controller: "CustomerauthenticateController"
              })


              //Manage Fees
              .state('app.Fees', {
                  url: '/Fees',
                  templateUrl: 'views/fees/fees.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/fees.js');
                          });
                      }]
                  },
                  title: 'Fees',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })
          .state('app.Edit_Fees', {
              url: '/Edit_Fees',
              templateUrl: 'views/fees/addEditFees.html',
              params: { PaymentFessId: 0 },
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          return $ocLazyLoad.load('scripts/controllers/appCtrls/fees.js');
                      });
                  }]
              },
              title: 'Edit Fees',
              classes: 'no-padding no-footer layout-static',
              controller: "authenticateController"
          })
          .state('app.add_Fees', {
              url: '/add_Fees',
              templateUrl: 'views/fees/addEditFees.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          return $ocLazyLoad.load('scripts/controllers/appCtrls/fees.js');
                      });
                  }]
              },
              title: 'Add Fees',
              classes: 'no-padding no-footer',
              controller: "authenticateController"
          })
              //Manage Transaction Fee Sharing
              .state('app.TransactionFeeSharing', {
                  url: '/transactionFeeSharing',
                  templateUrl: 'views/TransactionFeeSharing/transactionFeeSharingList.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/transactionFeeSharing.js');
                          });
                      }]
                  },
                  title: 'Transaction Fee Sharing',
                  classes: 'no-padding no-footer',
                  controller: "authenticateController"
              })


              .state('app.add_Transaction_Fees_Sharing', {
                  url: '/add_TransactionFeesSharing',
                  templateUrl: 'views/TransactionFeeSharing/addEdittransactionFeeSharing.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/transactionFeeSharing.js');
                          });
                      }]
                  },
                  title: 'Add Transaction Fee Sharing',
                  classes: 'no-padding no-footer',
                  controller: "authenticateController"
              })

          .state('app.Edit_Transaction_Fees_Sharing', {
              url: '/Edit_TransactionFeesSharing',
              templateUrl: 'views/TransactionFeeSharing/addEdittransactionFeeSharing.html',
              params: { TransactionFeeSharingId: 0 },
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          return $ocLazyLoad.load('scripts/controllers/appCtrls/transactionFeeSharing.js');
                      });
                  }]
              },
              title: 'Edit Transaction Fee Sharing',
              classes: 'no-padding no-footer',
              controller: "authenticateController"
          })
              //Manage Global Exchange Rates 


               .state('app.GlobalExchangeRates', {
                   url: '/globalExchangeRates',
                   templateUrl: 'views/globalexchangerates/globalExchangeRates.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/globalExchangeRates.js');
                           });
                       }]
                   },
                   title: 'Global Exchange Rates',
                   classes: 'no-padding no-footer',
                   controller: "authenticateController"
               })
              .state('app.add_Global_Exchange_Rates', {
                  url: '/add_GlobalExchangeRates',
                  templateUrl: 'views/globalexchangerates/addEditGlobalExchangeRates.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/globalExchangeRates.js');
                          });
                      }]
                  },
                  title: 'Add Global Exchange Rates',
                  classes: 'no-padding no-footer',
                  controller: "authenticateController"
              })
              .state('app.edit_Global_Exchange_Rates', {
                  url: '/edit_GlobalExchangeRates',
                  templateUrl: 'views/globalexchangerates/addEditGlobalExchangeRates.html',
                  params: { GlobalExchangeId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/globalExchangeRates.js');
                          });
                      }]
                  },
                  title: 'Edit Global Exchange Rates',
                  classes: 'no-padding no-footer',
                  controller: "authenticateController"
              })





              //Manage User
               .state('app.Manage_User', {
                   url: '/Manage_User',
                   templateUrl: 'views/user/manageUsers.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/user.js');
                           });
                       }]
                   },
                   title: 'Manage User',
                   classes: 'no-padding no-footer layout-static',
                   controller: "authenticateController"
               })
              .state('app.add_User', {
                  url: '/add_User',
                  templateUrl: 'views/user/addEditUser.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/user.js');
                          });
                      }]
                  },
                  title: 'Add User',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })

              .state('app.Edit_User', {
                  url: '/Edit_User',
                  templateUrl: 'views/user/addEditUser.html',
                  params: { UserId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/user.js');
                          });
                      }]
                  },
                  title: 'Edit User',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })


              .state('app.Manage_Company', {
                  url: '/Manage_Company',
                  templateUrl: 'views/company/manageCompany.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Company.js');
                          });
                      }]
                  },
                  title: 'Manage Company',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })

              .state('app.add_Comapny', {
                  url: '/add_Comapny',
                  templateUrl: 'views/company/addEditCompany.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Company.js');
                          });
                      }]
                  },
                  title: 'Add Comapny',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })

              .state('app.Edit_Comapny', {
                  url: '/Edit_Comapny',
                  templateUrl: 'views/company/addEditCompany.html',
                  params: { CompanyId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Company.js');
                          });
                      }]
                  },
                  title: 'Edit Company',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })
              //Manage Agent
              .state('app.Manage_Agent', {
                  url: '/Manage_Agent',
                  templateUrl: 'views/Agent/manageAgent.html',
                  params: { CompanyId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Agent.js');
                          });
                      }]
                  },
                  title: 'Manage Agent',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })
               .state('app.add_Agent', {
                   url: '/add_Agent',
                   templateUrl: 'views/Agent/addEditAgent.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/Agent.js');
                           });
                       }]
                   },
                   title: 'Add Agent',
                   classes: 'no-padding no-footer layout-static',
                   controller: "authenticateController"
               })

              .state('app.Edit_Agent', {
                  url: '/Edit_Agent',
                  templateUrl: 'views/Agent/addEditAgent.html',
                  params: { AgentId: 0 },
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/Agent.js');
                          });
                      }]
                  },
                  title: 'Edit Agent',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })

          //manage payment Method
              .state('app.Manage_Payment', {
                  url: '/Manage_Payment',
                  templateUrl: 'views/paymentMethod/managePaymentMethod.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/PaymentMethod.js');
                          });
                      }]
                  },
                  title: 'Manage Payment Method',
                  classes: 'no-padding no-footer layout-static',
                  controller: "authenticateController"
              })


         .state('app.Manage_PaymentMethod', {
             url: '/Manage_PaymentMethod',
             templateUrl: 'views/paymentMethod/managePaymentMethod.html',
             params: { CompanyId: 0 },
             resolve: {
                 deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                     return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                         return $ocLazyLoad.load('scripts/controllers/appCtrls/PaymentMethod.js');
                     });
                 }]
             },
             title: 'Manage Payment Method',
             classes: 'no-padding no-footer layout-static',
             controller: "authenticateController"
         })

               .state('app.add_PaymentMethod', {
                   url: '/add_PaymentMethod',
                   templateUrl: 'views/paymentMethod/addEditPaymentMethod.html',
                   params: { companyId: 0 },
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/PaymentMethod.js');
                           });
                       }]
                   },
                   title: 'Add Payment Method',
                   classes: 'no-padding no-footer layout-static',
                   controller: "authenticateController"
               })
               .state('app.Edit_PaymentMethod', {
                   url: '/Edit_PaymentMethod',
                   templateUrl: 'views/paymentMethod/addEditPaymentMethod.html',
                   params: { PaymentMethodId: 0 },
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('scripts/controllers/appCtrls/PaymentMethod.js');
                           });
                       }]
                   },
                   title: 'Edit Payment Method',
                   classes: 'no-padding no-footer layout-static',
                   controller: "authenticateController"
               })


            //Dashboard
            .state('horizontal.dashboard', {
                url: '/horizontal',
                templateUrl: 'views/dashboard/dashboard.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/bower-jvectormap/jquery-jvectormap-1.2.2.css']
                        }, {
                            serie: true,
                            files: ['vendor/noty/js/noty/packaged/jquery.noty.packaged.min.js', 'scripts/helpers/noty-defaults.js', 'vendor/flot/jquery.flot.js', 'vendor/flot/jquery.flot.resize.js', 'vendor/flot/jquery.flot.stack.js', 'vendor/flot-spline/js/jquery.flot.spline.js']
                        }, {
                            name: 'angular-flot',
                            files: ['vendor/angular-flot/angular-flot.js']
                        }, {
                            serie: true,
                            name: 'vector',
                            files: ['vendor/bower-jvectormap/jquery-jvectormap-1.2.2.min.js', 'data/maps/jquery-jvectormap-us-aea.js', 'scripts/directives/vector.js']
                        }, {
                            name: 'easypiechart',
                            files: ['vendor/jquery.easy-pie-chart/dist/angular.easypiechart.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/dashboard.js');
                        });
                    }]
                },
                title: 'Dashboard'
            })

            // UI Routes
            .state('app.ui', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/ui',
            }).state('app.ui.buttons', {
                url: '/buttons',
                templateUrl: 'views/ui/ui-buttons.html',
                title: 'Buttons'
            }).state('app.ui.social-buttons', {
                url: '/social-buttons',
                templateUrl: 'views/ui/ui-social-buttons.html',
                title: 'Social buttons'
            }).state('app.ui.directives', {
                url: '/directives',
                templateUrl: 'views/ui/ui-general.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/controllers/ui-bootstrap.js');
                    }]
                },
                title: 'Directives'
            }).state('app.ui.navs', {
                url: '/navs',
                templateUrl: 'views/ui/ui-navs.html',
                title: 'Navs'
            }).state('app.ui.portlets', {
                url: '/portlets',
                templateUrl: 'views/ui/ui-portlets.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            serie: true,
                            files: ['vendor/jquery.ui/ui/core.js', 'vendor/jquery.ui/ui/widget.js', 'vendor/jquery.ui/ui/mouse.js', 'vendor/jquery.ui/ui/sortable.js', 'vendor/jqueryui-touch-punch/jquery.ui.touch-punch.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/draggable.js');
                        });
                    }]
                },
                title: 'Portlets'
            }).state('app.ui.palette', {
                url: '/palette',
                templateUrl: 'views/ui/ui-palette.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/controllers/colors.js');
                    }]
                },
                title: 'Palette'
            }).state('app.ui.fontawesome', {
                url: '/fontawesome',
                templateUrl: 'views/ui/ui-fontawesome.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/controllers/icons.js');
                    }]
                },
                title: 'Fontawesome icons'
            }).state('app.ui.material', {
                url: '/material',
                templateUrl: 'views/ui/ui-material-icons.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/controllers/icons.js');
                    }]
                },
                title: 'Material icons'
            }).state('app.ui.progressbars', {
                url: '/progressbars',
                templateUrl: 'views/ui/ui-progressbars.html',
                title: 'Progress bars'
            }).state('app.ui.sliders', {
                url: '/sliders',
                templateUrl: 'views/ui/ui-sliders.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            serie: true,
                            files: ['vendor/jquery.ui/ui/core.js', 'vendor/jquery.ui/ui/widget.js', 'vendor/jquery.ui/ui/mouse.js', 'vendor/jquery.ui/ui/slider.js', 'vendor/jqueryui-touch-punch/jquery.ui.touch-punch.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/slider.js');
                        });
                    }]
                },
                title: 'Sliders'
            }).state('app.ui.pagination', {
                url: '/pagination',
                templateUrl: 'views/ui/ui-pagination.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/controllers/ui-bootstrap.js');
                    }]
                },
                title: 'Pagination'
            }).state('app.ui.notifications', {
                url: '/notifications',
                templateUrl: 'views/ui/ui-notifications.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            serie: true,
                            files: ['vendor/noty/js/noty/packaged/jquery.noty.packaged.min.js', 'scripts/helpers/noty-defaults.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/notifications.js');
                        });
                    }]
                },
                title: 'Notifications'
            }).state('app.ui.alert', {
                url: '/alert',
                templateUrl: 'views/ui/ui-alert.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/sweetalert/dist/sweetalert.css']
                        }, {
                            name: 'oitozero.ngSweetAlert',
                            files: ['vendor/sweetalert/dist/sweetalert.min.js', 'vendor/angular-sweetalert/SweetAlert.min.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/alert.js');
                        });
                    }]
                },
                title: 'Alerts'
            }).state('app.ui.spinners', {
                url: '/spinners',
                templateUrl: 'views/ui/ui-spinners.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['styles/loaders.css']
                        }]);
                    }]
                },
                title: 'Spinners'
            })

            // Forms routes
            .state('app.ui.forms', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/forms',
            }).state('app.ui.forms.native', {
                url: '/native_forms',
                templateUrl: 'views/form/form-basic.html',
                title: 'Basic form'
            }).state('app.ui.forms.plugins', {
                url: '/plugins',
                templateUrl: 'views/form/form-plugins.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css', 'vendor/jquery.tagsinput/src/jquery.tagsinput.css', 'vendor/intl-tel-input/build/css/intlTelInput.css', 'vendor/bootstrap-daterangepicker/daterangepicker.css', 'vendor/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css', 'vendor/clockpicker/dist/bootstrap-clockpicker.min.css', 'vendor/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css', 'vendor/jquery-labelauty/source/jquery-labelauty.css', 'vendor/multiselect/css/multi-select.css', 'vendor/ui-select/dist/select.css', 'vendor/select2/select2.css', 'vendor/selectize/dist/css/selectize.css']
                        }, {
                            serie: true,
                            files: ['vendor/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js', 'vendor/jquery.tagsinput/src/jquery.tagsinput.js', 'vendor/intl-tel-input//build/js/intlTelInput.min.js', 'vendor/moment/min/moment.min.js', 'vendor/bootstrap-daterangepicker/daterangepicker.js', 'vendor/bootstrap-datepicker/dist/js/bootstrap-datepicker.js', 'vendor/bootstrap-timepicker/js/bootstrap-timepicker.js', 'vendor/clockpicker/dist/jquery-clockpicker.min.js', 'vendor/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js', 'vendor/jquery-labelauty/source/jquery-labelauty.js', 'vendor/bootstrap-maxlength/src/bootstrap-maxlength.js', 'vendor/typeahead.js/dist/typeahead.bundle.js', 'vendor/multiselect/js/jquery.multi-select.js']
                        }, {
                            name: 'ui.select2',
                            files: ['vendor/ui-select/dist/select.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/form.js');
                        });
                    }]
                },
                title: 'Form plugins'
            }).state('app.ui.forms.validation', {
                url: '/validation',
                templateUrl: 'views/form/form-validation.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js');
                    }]
                },
                title: 'Form validation'
            }).state('app.ui.forms.editors', {
                url: '/editors',
                templateUrl: 'views/form/form-editors.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/summernote/dist/summernote.css']
                        }, {
                            serie: true,
                            files: ['vendor/tether/dist/js/tether.js', 'vendor/bootstrap/js/dist/util.js', 'vendor/bootstrap/js/dist/tooltip.js', 'vendor/bootstrap/js/dist/dropdown.js', 'vendor/bootstrap/js/dist/modal.js', 'vendor/summernote/dist/summernote.min.js']
                        }, {
                            name: 'summernote',
                            files: ['vendor/angular-summernote/dist/angular-summernote.min.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/editor.js');
                        });
                    }]
                },
                title: 'Form editors'
            }).state('app.ui.forms.masks', {
                url: '/masks',
                templateUrl: 'views/form/form-masks.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery.maskedinput/dist/jquery.maskedinput.min.js').then(function () {
                            return $ocLazyLoad.load('scripts/controllers/mask.js');
                        });
                    }]
                },
                title: 'Form masks'
            }).state('app.ui.forms.upload', {
                url: '/upload',
                templateUrl: 'views/form/form-upload.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            name: 'angularFileUpload',
                            files: ['vendor/angular-file-upload/dist/angular-file-upload.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/upload.js');
                        });
                    }]
                },
                title: 'Form upload'
            }).state('app.ui.forms.wizard', {
                url: '/wizard',
                templateUrl: 'views/form/form-wizard.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['styles/gsi-step-indicator.css', 'styles/tsf-step-form-wizard.css']
                        }, {
                            serie: true,
                            files: ['vendor/parsleyjs/dist/parsley.min.js', 'scripts/helpers/tsf/js/tsf-wizard-plugin.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/wizard.js');
                        });
                    }]
                },
                title: 'Form wizard',
                classes: 'no-padding full-width'
            })

            // Tables routes
            .state('app.ui.tables', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/tables',
            }).state('app.ui.tables.basic', {
                url: '/basic',
                templateUrl: 'views/table/table-basic.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/sortable/css/sortable-theme-bootstrap.css']
                        }, {
                            files: ['vendor/sortable/js/sortable.min.js']
                        }]).then(function () {
                            Sortable.init();
                        });
                    }]
                },
                title: 'Basic table'
            }).state('app.ui.tables.responsive', {
                url: '/responsive',
                templateUrl: 'views/table/table-responsive.html',
                title: 'Responsive tables'
            }).state('app.ui.tables.datatable', {
                url: '/datatable',
                templateUrl: 'views/table/table-datatable.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/datatables/media/css/dataTables.bootstrap4.css']
                        }, {
                            serie: true,
                            files: ['vendor/datatables/media/js/jquery.dataTables.js', 'vendor/datatables/media/js/dataTables.bootstrap4.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/table.js');
                        });
                    }]
                },
                title: 'Datatables'
            }).state('app.ui.tables.xeditable', {
                url: '/xeditable',
                templateUrl: 'views/table/table-editable.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/angular-xeditable/dist/css/xeditable.css']
                        }, {
                            name: 'xeditable',
                            files: ['vendor/angular-xeditable/dist/js/xeditable.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/editable.js');
                        });
                    }]
                },
                title: 'Xeditable'
            }).state('app.ui.tables.ngtable', {
                url: '/ngtable',
                templateUrl: 'views/table/table-ngtable.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/ng-table/dist/ng-table.css']
                        }, {
                            name: 'ngTable',
                            files: ['vendor/ng-table/dist/ng-table.js', 'scripts/services/ngtable.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/ngtable.js');
                        });
                    }]
                },
                title: 'NGTable'
            })

            // Chart routes
            .state('app.charts', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/charts',
            }).state('app.charts.flot', {
                url: '/flot',
                templateUrl: 'views/chart/charts-flot.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            serie: true,
                            files: ['vendor/flot/jquery.flot.js', 'vendor/flot/jquery.flot.resize.js', 'vendor/flot/jquery.flot.categories.js', 'vendor/flot/jquery.flot.stack.js', 'vendor/flot/jquery.flot.time.js', 'vendor/flot/jquery.flot.pie.js', 'vendor/flot-spline/js/jquery.flot.spline.js', 'vendor/flot.orderbars/js/jquery.flot.orderBars.js']
                        }, {
                            name: 'angular-flot',
                            files: ['vendor/angular-flot/angular-flot.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/flot.js');
                        });
                    }]
                },
                title: 'Flots'
            }).state('app.charts.easypie', {
                url: '/easypie',
                templateUrl: 'views/chart/charts-easypie.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            name: 'easypiechart',
                            files: ['vendor/jquery.easy-pie-chart/dist/angular.easypiechart.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/easychart.js');
                        });
                    }]
                },
                title: 'Easypie'
            }).state('app.charts.chartjs', {
                url: '/chartjs',
                templateUrl: 'views/chart/charts-chartjs.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/angular-chart.js/dist/angular-chart.css']
                        }, {
                            name: 'chart.js',
                            serie: true,
                            files: ['vendor/Chart.js/Chart.js', 'vendor/angular-chart.js/dist/angular-chart.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/chartjs.js');
                        });
                    }]
                },
                title: 'Chartjs'
            }).state('app.charts.rickshaw', {
                url: '/rickshaw',
                templateUrl: 'views/chart/charts-rickshaw.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/rickshaw/rickshaw.min.css']
                        }, {
                            name: 'rickshaw',
                            files: ['vendor/d3/d3.min.js', 'vendor/rickshaw/rickshaw.min.js', 'vendor/angular-rickshaw/rickshaw.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/rickshaw.js');
                        });
                    }]
                },
                title: 'Rickshaw'
            }).state('app.charts.c3', {
                url: '/c3',
                templateUrl: 'views/chart/charts-c3.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/c3/c3.min.css']
                        }, {
                            name: 'c3',
                            files: ['vendor/d3/d3.min.js', 'vendor/c3/c3.min.js', 'scripts/directives/c3.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/c3.js');
                        });
                    }]
                },
                title: 'C3'
            })

            // Maps routes
            .state('app.maps', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/maps',
            }).state('app.maps.google', {
                url: '/google',
                templateUrl: 'views/map/map-google.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            name: 'ui.map',
                            files: ['vendor/angular-ui-map/ui-map.min.js']
                        }, {
                            name: 'ui.event',
                            files: ['vendor/angular-ui-event/dist/event.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/google.js');
                        });
                    }]
                },
                title: 'Google maps'
            }).state('app.maps.googlefull', {
                url: '/google-fullscreen',
                templateUrl: 'views/map/map-google-fullscreen.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            name: 'ui.map',
                            files: ['vendor/angular-ui-map/ui-map.min.js']
                        }, {
                            name: 'ui.event',
                            files: ['vendor/angular-ui-event/dist/event.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/google-fullscreen.js');
                        });
                    }]
                },
                title: 'Full map',
                classes: 'no-padding full-width'
            }).state('app.maps.vector', {
                url: '/vector',
                templateUrl: 'views/map/map-vector.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/bower-jvectormap/jquery-jvectormap-1.2.2.css']
                        }, {
                            serie: true,
                            name: 'vector',
                            files: ['data/maps/gdp-data.js', 'vendor/bower-jvectormap/jquery-jvectormap-1.2.2.min.js', 'data/maps/jquery-jvectormap-world-mill-en.js', 'scripts/directives/vector.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/vector.js');
                        });
                    }]
                },
                title: 'Full map',
                classes: 'no-padding full-width'
            })

            // UI cards routes
            .state('app.ui.cards', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/cards',
            }).state('app.ui.cards.basic', {
                url: '/basic',
                templateUrl: 'views/card/cards-basic.html',
                title: 'Basic cards'
            }).state('app.ui.cards.portlets', {
                url: '/portlets',
                templateUrl: 'views/card/cards-portlets.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            serie: true,
                            files: ['vendor/jquery.ui/ui/core.js', 'vendor/jquery.ui/ui/widget.js', 'vendor/jquery.ui/ui/mouse.js', 'vendor/jquery.ui/ui/sortable.js', 'vendor/jqueryui-touch-punch/jquery.ui.touch-punch.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/draggable.js');
                        });
                    }]
                },
                title: 'Portlets'
            }).state('app.ui.cards.draggable', {
                url: '/draggable',
                templateUrl: 'views/card/cards-draggable.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            serie: true,
                            files: ['vendor/jquery.ui/ui/core.js', 'vendor/jquery.ui/ui/widget.js', 'vendor/jquery.ui/ui/mouse.js', 'vendor/jquery.ui/ui/sortable.js', 'vendor/jqueryui-touch-punch/jquery.ui.touch-punch.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/draggable.js');
                        });
                    }]
                },
                title: 'Draggable'
            })

            // Apps routes
            .state('app.apps', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/apps',
            }).state('app.apps.calendar', {
                url: '/calendar',
                templateUrl: 'views/app/app-calendar.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            insertBefore: '#load_styles_before',
                            files: ['vendor/fullcalendar/dist/fullcalendar.min.css']
                        }, {
                            serie: true,
                            files: ['vendor/jquery.ui/ui/core.js', 'vendor/jquery.ui/ui/widget.js', 'vendor/jquery.ui/ui/mouse.js', 'vendor/jquery.ui/ui/draggable.js', 'vendor/moment/moment.js', 'vendor/fullcalendar/dist/fullcalendar.min.js', 'vendor/fullcalendar/dist/gcal.js', 'vendor/jqueryui-touch-punch/jquery.ui.touch-punch.js']
                        }, {
                            name: 'ui.calendar',
                            files: ['vendor/angular-ui-calendar/src/calendar.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/calendar.js');
                        });
                    }]
                },
                title: 'Calendar'
            }).state('app.apps.media', {
                url: '/media',
                templateUrl: 'views/app/app-media.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            files: ['scripts/controllers/gallery.js']
                        }]);
                    }]
                },
                title: 'Media'
            }).state('app.apps.messages', {
                url: '/messages',
                templateUrl: 'views/app/app-messages.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/controllers/messages.js').then(function () {
                            return $ocLazyLoad.load('scripts/services/messages.js');
                        });
                    }]
                },
                title: 'Messages',
                classes: 'no-padding full-width'
            }).state('app.apps.contacts', {
                url: '/contacts',
                templateUrl: 'views/app/app-contacts.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('scripts/services/contacts.js').then(function () {
                            return $ocLazyLoad.load('scripts/controllers/contacts.js');
                        });
                    }]
                },
                title: 'Contacts',
                classes: 'no-padding full-width no-footer'
            }).state('app.apps.social', {
                url: '/social',
                templateUrl: 'views/app/app-social.html',
                title: 'Social'
            })

            // Extras routes
            .state('app.extras', {
                template: '<div ui-view></div>',
                abstract: true,
                url: '/extras',
            }).state('app.extras.invoice', {
                url: '/invoice',
                templateUrl: 'views/extra/extras-invoice.html',
                title: 'Invoice'
            }).state('app.extras.timeline', {
                url: '/timeline',
                templateUrl: 'views/extra/extras-timeline.html',
                title: 'Timeline'
            }).state('app.extras.lists', {
                url: '/lists',
                templateUrl: 'views/extra/extras-lists.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([{
                            serie: true,
                            files: ['vendor/jquery.ui/ui/core.js', 'vendor/jquery.ui/ui/widget.js', 'vendor/jquery.ui/ui/mouse.js', 'vendor/jquery.ui/ui/sortable.js', 'vendor/nestable/jquery.nestable.js', 'vendor/jqueryui-touch-punch/jquery.ui.touch-punch.js']
                        }]).then(function () {
                            return $ocLazyLoad.load('scripts/controllers/sortable.js');
                        });
                    }]
                },
                title: 'Lists'
            }).state('app.extras.pricing', {
                url: '/pricing',
                templateUrl: 'views/extra/extras-pricing.html',
                title: 'Pricing tables'
            }).state('app.extras.starter', {
                url: '/starter',
                templateUrl: 'views/extra/extras-blank.html',
                title: 'Starter'
            })

            .state('user', {
                templateUrl: 'views/common/session.html',
            }).state('user.signup', {
                url: '/signup',
                templateUrl: 'views/extra/extras-signup.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('scripts/controllers/session.js');
                        });
                    }]
                },
                title: 'Signup',
                classes: 'no-padding no-footer layout-static'
            }).state('user.forgot', {
                url: '/forgot',
                templateUrl: 'views/extra/extras-forgot.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('scripts/controllers/session.js');
                        });
                    }]
                },
                title: 'Forgot',
                classes: 'no-padding no-footer layout-static'
            }).state('user.404', {
                url: '/404',
                templateUrl: 'views/extra/extras-404.html',
                title: '404',
                classes: 'error-page no-padding no-footer layout-static',
            }).state('user.500', {
                url: '/500',
                templateUrl: 'views/extra/extras-500.html',
                title: '500',
                classes: 'error-page no-padding no-footer layout-static'
            }).state('user.lockscreen', {
                url: '/lockscreen',
                templateUrl: 'views/extra/extras-lockscreen.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('scripts/controllers/session.js');
                        });
                    }]
                },
                title: 'Lockscreen',
                classes: 'no-padding no-footer layout-static'
            })

            .state('app.customerPortal', {
                url: '/customerPortal',
                templateUrl: 'views/customerPortal/customerPortal.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal',

            })

            .state('app.chooseAmount', {
                url: '/chooseAmount',
                templateUrl: 'views/customerPortal/chooseAmount.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal',
                params: { numberDetails: 0 }
                //controller: "authenticateGuestController"
            })
              .state('app.reviewAmmount', {
                  url: '/review',
                  templateUrl: 'views/customerPortal/review.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                          });
                      }]
                  },
                  title: 'customerPortal',
                  params: { numberDetails: 0 }
                  //controller: "authenticateGuestController"
              })
               .state('app.ThankuCus', {
                   url: '/ThankyouPage',
                   templateUrl: 'views/customerPortal/Thankyou_Cus.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                           });
                       }]
                   },
                   title: 'customerPortal',
                   params: { numberDetails: 0 }
                   //controller: "authenticateGuestController"
               })
            .state('app.Login', {
                url: '/Login',
                templateUrl: 'views/customerPortal/login.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal'
            })

            .state('app.userRegister', {
                url: '/userRegister',
                templateUrl: 'views/customerPortal/userRegister.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal'
            })

            .state('app.makePayment', {
                url: '/makePayment',
                templateUrl: 'views/customerPortal/makepayment.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal',
                controller: "authenticateGuestController"
            })

            .state('app.transactionDetails', {
                url: '/transactionDetails',
                templateUrl: 'views/customerPortal/transactionDetails.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                            return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal',
                controller: "authenticateGuestController"
            })

               .state('app.addKyc', {
                   url: '/CustomerProfile',
                   templateUrl: 'views/customerPortal/kyc_form.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                               return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                           });
                       }]
                   },
                   title: 'customerPortal',
                   controller: "authenticateGuestController"
               })

            .state('app.User_agreement', {
                url: '/User_agreement',
                templateUrl: 'views/customerPortal/LinkPage/user-agreement.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                            return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal',
            })
                     .state('app.privacy_policy', {
                         url: '/privacy-policy',
                         templateUrl: 'views/customerPortal/LinkPage/privacy-policy.html',
                         resolve: {
                             deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                 return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                     //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                     return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                                 });
                             }]
                         },
                         title: 'customerPortal',
                     })
                    .state('app.US_state_lcensing', {
                        url: '/US-state-lcensing',
                        templateUrl: 'views/customerPortal/LinkPage/US-state-lcensing.html',
                        resolve: {
                            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                    //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                    return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                                });
                            }]
                        },
                        title: 'customerPortal',
                    })

              .state('app.Contact_us', {
                  url: '/Contact_us',
                  templateUrl: 'views/customerPortal/LinkPage/Contact-us.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

                .state('app.Supported_Currencies', {
                    url: '/Supported_Currencies',
                    templateUrl: 'views/customerPortal/LinkPage/Supported-Currencies.html',
                    resolve: {
                        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                            return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                            });
                        }]
                    },
                    title: 'customerPortal',
                })

              .state('app.Swift_BIC_Codes', {
                  url: '/Swift_BIC_Codes',
                  templateUrl: 'views/customerPortal/LinkPage/Swift-BIC-Codes.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('app.Track_Transfers', {
                  url: '/Track_Transfers',
                  templateUrl: 'views/customerPortal/LinkPage/Track-Transfers.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                          });
                      }]
                  },
                  title: 'customerPortal',
              })


              .state('app.Rate_Alerts', {
                  url: '/Rate_Alerts',
                  templateUrl: 'views/customerPortal/LinkPage/Rate-Alerts.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('app.International_Licensing', {
                  url: '/International_Licensing',
                  templateUrl: 'views/customerPortal/LinkPage/International-Licensing.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('app.Security_Center', {
                  url: '/Security_Center',
                  templateUrl: 'views/customerPortal/LinkPage/Security-Center.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/customerPortal/customer_portal.js');
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('app.SendMoneylogin', {
                  url: '/sendmoneylogin',
                  templateUrl: 'views/SendMoney/login.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                          });
                      }]
                  },
                  title: 'sendMoney',

              })
               .state('app.SendMoneyUserRegister', {
                   url: '/sendmoneyuserRegister',
                   templateUrl: 'views/SendMoney/userRegister.html',
                   resolve: {
                       deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                           return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                               return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                           });
                       }]
                   },
                   title: 'sendMoney',

               })

              .state('app.CashPickUp', {
                  url: '/CashPickUp',
                  templateUrl: 'views/SendMoney/CashPickUp.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                          });
                      }]
                  },
                  title: 'sendMoney',
                  //controller: "authenticateSendMoneyController"
              })

              .state('app.cashPickUpLocation', {
                  url: '/cashPickUpLocation',
                  templateUrl: 'views/SendMoney/CashPickUpLocatiion.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                          });
                      }]
                  },
                  title: 'sendMoney',
                  controller: "authenticateSendMoneyController"
              })
              .state('app.Payment', {
                  url: '/MakePayment',
                  templateUrl: 'views/SendMoney/Payment.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                          });
                      }]
                  },
                  title: 'sendMoney',
                  controller: "authenticateSendMoneyController"

              })
              .state('app.SendMoneyAmount', {
                  url: '/SendMoney',
                  templateUrl: 'views/SendMoney/SendMoney.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                          });
                      }]
                  },
                  title: 'sendMoney'
              })

              .state('app.SendMoney', {
                  url: '/AmountDetails',
                  templateUrl: 'views/SendMoney/AmountDetails.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                          });
                      }]
                  },
                  title: 'sendMoney',

              })

              .state('app.addEditBeneficiary', {
                  url: '/AddBeneficiary',
                  templateUrl: 'views/SendMoney/Beneficiary.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                              return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                          });
                      }]
                  },
                  title: 'sendMoney',
                  controller: "authenticateSendMoneyController"
              })

           .state('app.SendMoneyThankyou', {
               url: '/SendMoneyThankyou',
               templateUrl: 'views/SendMoney/ThankyouPage.html',
               resolve: {
                   deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                       return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                           //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                           return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                       });
                   }]
               },
               title: 'sendMoney',
               controller: "authenticateSendMoneyController"
           })
           .state('app.SendMoneyTransaction', {
               url: '/SendMoneyTransaction',
               templateUrl: 'views/SendMoney/manageTransaction.html',
               resolve: {
                   deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                       return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                           //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                           return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                       });
                   }]
               },
               title: 'sendMoney',
               controller: "authenticateSendMoneyController"
           })
          .state('app.transaction_Details', {
              url: '/transaction_Details',
              templateUrl: 'views/SendMoney/transactionDetails.html',
              params: { TransactionId: 0 },
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          return $ocLazyLoad.load('views/SendMoney/Send_Money.js');
                      });
                  }]
              },
              title: 'sendMoney',
              controller: "authenticateSendMoneyController"
          })



          .state('app.sending_loop', {
              url: '/Sendingloop',
              templateUrl: 'views/sendimgloop/index.html',
              params: { TransactionId: 0 },
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'customerPortal',
              // controller: "authenticateSendMoneyController"
          })
          .state('app.sending_loop_login', {
              url: '/Sign_in',
              templateUrl: 'views/sendimgloop/login.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'customerPortal',
              // controller: "authenticateSendMoneyController"
          })
          .state('app.sending_loop_ragister', {
              url: '/Sign_up',
              templateUrl: 'views/sendimgloop/userRegister.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'customerPortal',
              // controller: "authenticateSendMoneyController"
          })

              //Information-pages
          .state('app.Guide', {
              url: '/Guide',
              templateUrl: 'views/information_pages/Guide.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          // return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'Guide',
          })

          .state('app.TransactionRule', {
              url: '/TransactionRule',
              templateUrl: 'views/information_pages/TransactionRule.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          //return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'Transaction Rule',
          })

          .state('app.Kyc', {
              url: '/Kyc',
              templateUrl: 'views/information_pages/Kyc.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          //  return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'KYC',
          })

            .state('app.SuspiciousTransaction', {
                url: '/SuspiciousTransaction',
                templateUrl: 'views/information_pages/SuspiciousTransaction.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                            // return $ocLazyLoad.load('views/sendimgloop/index.js');
                        });
                    }]
                },
                title: 'Suspicious Transaction Form',
            })
          .state('app.SuspiciousTransactionHistory', {
              url: '/SuspiciousTransactionHistory',
              templateUrl: 'views/information_pages/SuspiciousTransactionHistory.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          // return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'Suspicious Transaction History',
          })

          .state('app.ManageWatchlist', {
              url: '/ManageWatchlist',
              templateUrl: 'views/information_pages/ManageWatchlist.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                          //return $ocLazyLoad.load('views/sendimgloop/index.js');
                      });
                  }]
              },
              title: 'Manage Watchlist',
          })

           .state('app.SanctionSettings', {
               url: '/SanctionSettings',
               templateUrl: 'views/information_pages/SanctionSettings.html',
               resolve: {
                   deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                       return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                           //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                           //return $ocLazyLoad.load('views/sendimgloop/index.js');
                       });
                   }]
               },
               title: 'Sanction Settings',
           })

      }


        ]).config(['$ocLazyLoadProvider', function ($ocLazyLoadProvider) {
            $ocLazyLoadProvider.config({
                debug: false,
                events: false
            });
        }]);



    function getParams(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
        return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }


})();