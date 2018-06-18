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
                     layout = 'views/common/layout.html',
                     dashboard = "";

                // For unmatched routes
                $urlRouterProvider.otherwise('/app/');

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
                  .state('app.customerPortal', {
                      url: '/',
                      templateUrl: 'views/customerPortal/customerPortal.html',
                      resolve: {
                          deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                              return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                  return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                              });
                          }]
                      },
                      title: 'customerPortal',
                      classes: 'no-padding no-footer layout-static'
                  })

                  .state('app.chooseAmount', {
                      url: '/chooseAmount',
                      templateUrl: 'views/customerPortal/chooseAmount.html',
                      resolve: {
                          deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                              return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                  return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                              });
                          }]
                      },
                      title: 'customerPortal',
                      params: { numberDetails: 0 },
                      classes: 'no-padding no-footer layout-static'
                      //controller: "authenticateGuestController"
                  })
                    .state('app.reviewAmmount', {
                        url: '/review',
                        templateUrl: 'views/customerPortal/review.html',
                        resolve: {
                            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                    return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                     return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                  return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                              });
                          }]
                      },
                      title: 'customerPortal'
                  })

                    .state('app.addKyc', {
                        url: '/CustomerProfile',
                        templateUrl: 'views/customerPortal/kyc_form.html',
                        resolve: {
                            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                    //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                    return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                                });
                            }]
                        },
                        title: 'customerPortal',
                        controller: "authenticateGuestController"
                    })

                  .state('app.userRegister', {
                      url: '/userRegister',
                      templateUrl: 'views/customerPortal/userRegister.html',
                      resolve: {
                          deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                              return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                  return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                  return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                              });
                          }]
                      },
                      title: 'customerPortal',
                      //controller: "authenticateGuestController"
                  })

                  .state('app.transactionDetails', {
                      url: '/transactionDetails',
                      templateUrl: 'views/customerPortal/transactionDetails.html',
                      resolve: {
                          deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                              return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                  //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                  return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                              });
                          }]
                      },
                      title: 'customerPortal',
                      // controller: "authenticateGuestController"
                  })

                  .state('app.User_agreement', {
                      url: '/User_agreement',
                      templateUrl: 'views/customerPortal/LinkPage/user-agreement.html',
                      resolve: {
                          deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                              return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                  //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                  //return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                              });
                          }]
                      },
                      title: 'customerPortal',
                  })
                .state('app.return_policy', {
                    url: '/return_policy',
                    templateUrl: 'views/customerPortal/LinkPage/return-policy.html',
                    resolve: {
                        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                            return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                //return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                           //return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                          // return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                                      });
                                  }]
                              },
                              title: 'customerPortal',
                          })

                    .state('app.Contact_us', {
                        url: '/Contact_us',
                        abstract: false,
                        templateUrl: 'views/customerPortal/LinkPage/Contact-us.html',
                        resolve: {
                            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                    //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                    return $ocLazyLoad.load('scripts/controllers/appCtrls/contactUs.js');
                                });
                            }]
                        },
                        title: 'customerPortal'

                    })

                      .state('app.Supported_Currencies', {
                          url: '/Supported_Currencies',
                          templateUrl: 'views/customerPortal/LinkPage/Supported-Currencies.html',
                          resolve: {
                              deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                  return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                      //return $ocLazyLoad.load('scripts/controllers/appCtrls/PayBill.js');
                                      // return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                    // return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                    // return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                    // return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                    // return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                    // return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
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
                                    return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                                });
                            }]
                        },
                        title: 'customerPortal',

                    })
                     .state('app.SendMoneyUserRegister', {
                         url: '/sendmoneyuserRegister',
                         templateUrl: 'views/SendMoney/userRegister.html',
                         resolve: {
                             deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                 return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                     return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                                 });
                             }]
                         },
                         title: 'customerPortal',

                     })

                    .state('app.CashPickUp', {
                        url: '/CashPickUp',
                        templateUrl: 'views/SendMoney/CashPickUp.html',
                        resolve: {
                            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                    return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                                });
                            }]
                        },
                        title: 'customerPortal',
                        //controller: "authenticateSendMoneyController"
                    })

                    .state('app.cashPickUpLocation', {
                        url: '/cashPickUpLocation',
                        templateUrl: 'views/SendMoney/CashPickUpLocatiion.html',
                        resolve: {
                            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                                return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                                    return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                                });
                            }]
                        },
                        title: 'customerPortal',
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
                        title: 'customerPortal',
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
                        title: 'customerPortal'
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
                        title: 'customerPortal',

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
                        title: 'customerPortal',
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
                     title: 'customerPortal',
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
                     title: 'customerPortal',
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
                    title: 'customerPortal',
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

                 .state('app.ui.pagination', {
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