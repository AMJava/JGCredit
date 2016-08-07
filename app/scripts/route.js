/**
 * Created by kolya on 8/7/16.
 */
app.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/user/login');

        $stateProvider
            .state('/', {
                abstract: true,
                resolve: {
                    loggedIn: function () {
                        return '';
                    }
                },
                views: {
                    header: {
                        templateUrl: 'header/headerView.html',
                        controller: 'HeaderCtrl'
                    },
                    content: {
                        template: '<ui-view></ui-view>'
                    },
                    footer: {
                        templateUrl: 'footer/footerView.html',
                        controller: 'FooterCtrl'
                    }
                }
            })
            .state('user', {
                url: '/user',
                template: '<ui-view></ui-view> '
            })
            .state('user.login', {
                url: '/login',
                templateUrl: 'user/loginView.html',
                controller: 'LoginCtrl'
            })
            .state('user.signup', {
                url: '/signup',
                templateUrl: 'user/signupView.html',
                controller: 'SignupCtrl'
            })
            .state('agreement', {
                url: '/agreement',
                controller: 'SignupCtrl'
            })
            .state('agreement.claim', {
                url: '/claim',
                templateUrl: 'user/agreementClaimView.html',
                controller: 'AgreementClaimCtrl'
            })
            .state('agreement.extension', {
                url: '/extension',
                templateUrl: 'user/agreementExtensionView.html',
                controller: 'AgreementExtensionCtrl'
            });
    }]);