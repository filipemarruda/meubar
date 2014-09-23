'use strict';

coreApp.controller('CoreCtrl', ['$scope', '$cookies', '$stateParams', '$location', 'Core',
	function($scope, $cookies, $stateParams, $location, Core) {
			console.log("in controller of module: " + coreApp.name)

			var login_page = 'index.html';
			$scope.logout = function() {

				delete $cookies.auth_token;
				delete $cookies.user;
				window.location = login_page;

			}
			$scope.getMenuClass = function(path) {
			    if ($location.path().split('/')[1] == path) {
			      return "active"
			    } else {
			      return ""
			    }
			}
			$scope.getModuleMenuClass = function(path) {
			    if ($location.path().split('/')[2] == path) {
			      return "btn-primary"
			    } else {
			      return "btn-default"
			    }
			}

			$scope.getMenus = function(){
				console.log('function getMenus: '+ ApplicationConfiguration.menus)
				return ApplicationConfiguration.menus;
			}
	}]
);