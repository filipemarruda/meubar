'use strict';

var gruposApp = angular.module('grupos');

gruposApp.config(function($stateProvider, $urlRouterProvider) {
    
  var path = '/meubar/modules/gruposnovo/pages';

    $urlRouterProvider.otherwise('/grupos');
    
    $stateProvider

  // HOME STATES AND NESTED VIEWS ========================================
    .state('grupos', {
        url: '/grupos',
        templateUrl: path + '/index.html'
    })
    // nested list with custom controller
	.state('grupos.list', {
        url: '/list',
        templateUrl: path + '/list.html'
    })
});