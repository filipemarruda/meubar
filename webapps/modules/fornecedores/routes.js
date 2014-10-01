'use strict';



var fornecedoresApp = angular.module('fornecedores');

fornecedoresApp.config(function($stateProvider, $urlRouterProvider) {
	
	var moduleConfig = new ModuleConfig(fornecedoresApp.name);

    $stateProvider

  // HOME STATES AND NESTED VIEWS ========================================
    .state( moduleConfig.name , {
        url: '/' + moduleConfig.name,
        templateUrl: moduleConfig.pagesPath + '/index.html'
    })
    // nested list with custom controller
	 .state( moduleConfig.name + '.list', {
        url: '/list',
        templateUrl: moduleConfig.pagesPath + '/list.html'
    })
   .state( moduleConfig.name + '.create', {
        url: '/create',
        templateUrl: moduleConfig.pagesPath + '/create.html'
    })
    .state( moduleConfig.name + '.view', {
        url: '/view/:id',
        templateUrl: moduleConfig.pagesPath + '/view.html'
    })
    .state( moduleConfig.name + '.edit', {
        url: '/edit/:id',
        templateUrl: moduleConfig.pagesPath + '/edit.html'
    });
});