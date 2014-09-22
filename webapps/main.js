var meuBar = angular.module('meuBar', ['ngResource', 'ngCookies']);

meuBar.controller('AppCtrl',['$scope','$location','$http', '$cookies',
	function AppCtrl($scope, $location, $http, $cookies){

		var login_page = 'index.html';
		var app = this;
		app.http = $http;
		app.scope = $scope;
		app.cookies = $cookies;

		if(!!app.cookies.auth_token == false || !!app.cookies.user == false){
			window.location = login_page;
		}

	    $scope.getGrupos = function() {

			app.http.defaults.headers.get = { 'auth_token' : app.cookies.auth_token };
			app.http.get('http://localhost:8080/meubar/api/grupos')
			.success(function(data, status, headers, config) {
		        app.scope.grupos = data;
		        app.cookies.auth_token = headers('auth_token');
		    })
		    .error(function(data, status, headers, config) {
		        app.scope.error = data;
		    });

		}

		$scope.getUsuarios = function() {

			app.http.defaults.headers.get = { 'auth_token' : app.cookies.auth_token };
			app.http.get('http://localhost:8080/meubar/api/usuarios')
			.success(function(data, status, headers, config) {
		        app.scope.usuarios = data;
		        app.cookies.auth_token = headers('auth_token');
		    })
		    .error(function(data, status, headers, config) {
		        app.scope.error = data;
		    });

		}

		$scope.logout = function() {

			delete app.cookies.auth_token;
			delete app.cookies.user;
			window.location = login_page;

		}

	}
]);