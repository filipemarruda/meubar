'use strict';



var coreApp = angular.module('core');

coreApp.config(function($stateProvider, $urlRouterProvider) {
    
  var moduleName = coreApp.name;
  var modulePath = ApplicationConfiguration.modulesPath + '/' + moduleName;
  var pagesPath = modulePath + '/pages';

    $urlRouterProvider.otherwise('/' + moduleName);
    
    $stateProvider

  // HOME STATES AND NESTED VIEWS ========================================
    .state( moduleName , {
        url: '/' + moduleName,
        templateUrl: pagesPath + '/dashboard.html'
    })
    .state( 'proibido' , {
        url: '/401',
        templateUrl: pagesPath + '/unauthorized.html'
    });
    
});