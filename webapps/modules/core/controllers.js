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
			$scope.getClass = function(path) {
			    if ($location.path().split('/')[1] == path) {
			      return "active"
			    } else {
			      return ""
			    }
			}
			$scope.getMenus = function(){
				console.log('function getMenus: '+ ApplicationConfiguration.menus)
				return ApplicationConfiguration.menus;
			}
	}]
);