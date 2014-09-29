'use strict';



var fornecedoresApp = angular.module('fornecedores');

fornecedoresApp.config(function($stateProvider, $urlRouterProvider) {
    
  var moduleName = fornecedoresApp.name;
  var modulePath = ApplicationConfiguration.modulesPath + '/' + moduleName;
  var pagesPath = modulePath + '/pages';

    $stateProvider

  // HOME STATES AND NESTED VIEWS ========================================
    .state( moduleName , {
        url: '/' + moduleName,
        templateUrl: pagesPath + '/index.html'
    })
    // nested list with custom controller
	 .state( moduleName + '.list', {
        url: '/list',
        templateUrl: pagesPath + '/list.html'
    })
   .state( moduleName + '.create', {
        url: '/create',
        templateUrl: pagesPath + '/create.html'
    })
    .state( moduleName + '.view', {
        url: '/view/:id',
        templateUrl: pagesPath + '/view.html'
    })
    .state( moduleName + '.edit', {
        url: '/edit/:id',
        templateUrl: pagesPath + '/edit.html'
    });
});