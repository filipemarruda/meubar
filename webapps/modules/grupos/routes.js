'use strict';



var gruposApp = angular.module('grupos');

gruposApp.config(function($stateProvider, $urlRouterProvider) {
    
  var moduleName = gruposApp.name;
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
    .state( moduleName + '.view', {
        url: '/view/:id',
        templateUrl: pagesPath + '/view.html'
    })
});