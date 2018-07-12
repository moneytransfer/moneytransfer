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

          //$locationProvider.hashPrefix('');

          var p = getParams('layout'),
               l = p ? p + '.' : '',
               layout = 'views/common/layout.html',
               dashboard = "";

          $urlRouterProvider.otherwise('/');
          $stateProvider

           .state('customerPortal', {
               url: '/',
               templateUrl: 'views/customerPortal/customerPortal.html',
               resolve: {
                   deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                       return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                           return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                       });
                   }]
               },
               title: 'customerPortal'
           })

            .state('chooseAmount', {
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
              .state('reviewAmmount', {
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
              })
               .state('ThankuCus', {
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
            .state('Login', {
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

              .state('addKyc', {
                  url: '/CustomerProfile',
                  templateUrl: 'views/customerPortal/kyc_form.html',
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

            .state('userRegister', {
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

            .state('makePayment', {
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

            .state('transactionDetails', {
                url: '/transactionDetails',
                templateUrl: 'views/customerPortal/transactionDetails.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            return $ocLazyLoad.load('scripts/controllers/appCtrls/customer_portal.js');
                        });
                    }]
                },
                title: 'customerPortal'
            })

            .state('User_agreement', {
                url: '/User_agreement',
                templateUrl: 'views/customerPortal/LinkPage/user-agreement.html',
                resolve: {
                    deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                        });
                    }]
                },
                title: 'customerPortal',
            })
          .state('return_policy', {
              url: '/return_policy',
              templateUrl: 'views/customerPortal/LinkPage/return-policy.html',
              resolve: {
                  deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                      return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                      });
                  }]
              },
              title: 'customerPortal',
          })

           .state('privacy_policy', {
               url: '/privacy-policy',
               templateUrl: 'views/customerPortal/LinkPage/privacy-policy.html',
               resolve: {
                   deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                       return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                       });
                   }]
               },
               title: 'customerPortal',
           })
           .state('US_state_lcensing', {
               url: '/US-state-lcensing',
               templateUrl: 'views/customerPortal/LinkPage/US-state-lcensing.html',
               resolve: {
                   deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                       return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                       });
                   }]
               },
               title: 'customerPortal',
           })

              .state('Contact_us', {
                  url: '/Contact_us',
                  abstract: false,
                  templateUrl: 'views/customerPortal/LinkPage/Contact-us.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                              return $ocLazyLoad.load('scripts/controllers/appCtrls/contactUs.js');
                          });
                      }]
                  },
                  title: 'customerPortal'

              })

                .state('Supported_Currencies', {
                    url: '/Supported_Currencies',
                    templateUrl: 'views/customerPortal/LinkPage/Supported-Currencies.html',
                    resolve: {
                        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                            return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                            });
                        }]
                    },
                    title: 'customerPortal',
                })

              .state('Swift_BIC_Codes', {
                  url: '/Swift_BIC_Codes',
                  templateUrl: 'views/customerPortal/LinkPage/Swift-BIC-Codes.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('Track_Transfers', {
                  url: '/Track_Transfers',
                  templateUrl: 'views/customerPortal/LinkPage/Track-Transfers.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('Rate_Alerts', {
                  url: '/Rate_Alerts',
                  templateUrl: 'views/customerPortal/LinkPage/Rate-Alerts.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('International_Licensing', {
                  url: '/International_Licensing',
                  templateUrl: 'views/customerPortal/LinkPage/International-Licensing.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

              .state('Security_Center', {
                  url: '/Security_Center',
                  templateUrl: 'views/customerPortal/LinkPage/Security-Center.html',
                  resolve: {
                      deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                          return $ocLazyLoad.load('vendor/jquery-validation/dist/jquery.validate.min.js').then(function () {
                          });
                      }]
                  },
                  title: 'customerPortal',
              })

          //$locationProvider.html5Mode({
          //    enabled: true,
          //    requireBase: false
          //});

          $locationProvider.hashPrefix('');
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