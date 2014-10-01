'use strict';



var coreApp = angular.module('core');

coreApp.config(function($stateProvider, $urlRouterProvider) {
    
	var moduleConfig = new ModuleConfig(coreApp.name);

    $urlRouterProvider.otherwise('/' + moduleConfig.name);
    
    $stateProvider

  // HOME STATES AND NESTED VIEWS ========================================
    .state( moduleConfig.name , {
        url: '/' + moduleConfig.name,
        templateUrl: moduleConfig.pagesPath + '/dashboard.html'
    })
    .state( 'proibido' , {
        url: '/401',
        templateUrl: moduleConfig.pagesPath + '/unauthorized.html'
    });
    
});