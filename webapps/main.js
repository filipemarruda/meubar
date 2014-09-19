var meuBar = angular.module('meuBar', ['ngResource']);

meuBar.controller('AppCtrl',['$scope','$location','$http',
	function AppCtrl($scope, $location, $http){

		var app = this;
		app.http = $http;
		app.scope = $scope;

		app.scope.user = 'admin';
		app.scope.pass = '21232f297a57a5a743894a0e4a801fc3';
		app.scope.acesso = '';

		$scope.access = function() {

			console.log('Trying to acess.');
			app.http.defaults.headers.post = { 'Content-Type' : 'application/json' };
			app.http.post(
				'http://localhost:8080/meubar/api/acesso',
				{
					user: app.scope.user,
					pass: app.scope.pass
				}
			)
			.success(function(data, status, headers, config) {	
	        	app.scope.acesso = data;
	   		})
	   		.error(function(data, status, headers, config) {
	        	app.scope.error = data;
	    	});

	    }

	    $scope.getGrupos = function() {

			app.http.defaults.headers.get = { 'auth_token' : app.scope.acesso.token };
			app.http.get('http://localhost:8080/meubar/api/grupos')
			.success(function(data, status, headers, config) {
		        app.scope.grupos = data;
		        app.scope.acesso.token = headers('auth_token');
		    })
		    .error(function(data, status, headers, config) {
		        app.scope.error = data;
		    });

		}

		$scope.getUsuarios = function() {

			app.http.defaults.headers.get = { 'auth_token' : app.scope.acesso.token };
			app.http.get('http://localhost:8080/meubar/api/usuarios')
			.success(function(data, status, headers, config) {
		        app.scope.usuarios = data;
		        app.scope.acesso.token = headers('auth_token');
		    })
		    .error(function(data, status, headers, config) {
		        app.scope.error = data;
		    });

		}

	}
]);

// meuBar.service('dataService' function ($http, $q){
// 	var defferer = $q.deffer();


// 	return defferer.promise;
// });