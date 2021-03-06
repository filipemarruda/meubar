var meuBar = angular.module('meuBar', ['ngResource', 'ngCookies']);

meuBar.controller('AppCtrl',['$scope','$location','$http', '$cookies',
	function AppCtrl($scope, $location, $http, $cookies){

		var main_page = 'main.html';

		var app = this;
		app.http = $http;
		app.scope = $scope;
		app.cookies = $cookies;

		if(!!app.cookies.auth_token == true && !!app.cookies.user == true){
//			delete app.cookies.auth_token;
//			delete app.cookies.user;
			window.location = main_page;
		}else{
			app.scope.user = '';
			app.scope.pass = '';	
		}
		
		$scope.access = function() {
			app.scope.error = false;
			console.log('Trying to acess.');
			app.http.defaults.headers.post = { 'Content-Type' : 'application/json' };
			app.http.post(
				'/meubar/api/acesso',
				{
					user: app.scope.user,
					pass: md5(app.scope.pass)
				}
			)
			.success(function(data, status, headers, config) {	
	        	app.cookies.auth_token = data.token;
	        	app.cookies.user_id = data.id;
	        	app.cookies.user = data.usuario;
	        	app.cookies.grupo = data.grupo;
	        	window.location = main_page;
	   		})
	   		.error(function(data, status, headers, config) {
	   			console.log(status);
	   			if(status === 403){
	        		app.scope.error = 'Usuário e/ou senha inválidos!';
	   			}
	    	});


	    };

	}
]);
