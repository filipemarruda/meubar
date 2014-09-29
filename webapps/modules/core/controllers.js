'use strict';

coreApp.controller('CoreCtrl', ['$rootScope', '$cookies', '$stateParams', '$location', '$state','Core',
	function($rootScope, $cookies, $stateParams, $location, $state, Core) {
		console.log("in controller of module: " + coreApp.name);
		
		$rootScope.moduleName = coreApp.name;
		$rootScope.moduleHeader = $rootScope.moduleName.charAt(0).toUpperCase() + $rootScope.moduleName.slice(1);
		
		function logout() {
			
			var login_page = 'index.html';
			delete $cookies.auth_token;
			delete $cookies.user;
			window.location = login_page;

		}
		
		$rootScope.logout = logout;
		
		$rootScope.errorHandle = function(status, msg){
			if(status === 401){
				$state.transitionTo('proibido');
			}else if(status === 403){
				logout();
			}else{
				$rootScope.error = msg;
			}
		};
		
		$rootScope.getMenuClass = function(path) {
		    if ($location.path().split('/')[1] == path) {
		      return "active";
		    } else {
		      return "";
		    }
		};
		
		$rootScope.getModuleMenuClass = function(path) {
		    if ($location.path().split('/')[2] == path) {
		      return "btn-primary";
		    } else {
		      return "btn-default";
		    }
		};

		$rootScope.getMenus = function(){
			var menus = [];
			
			ApplicationConfiguration.menus.forEach(function(item){
				if($.inArray($cookies.grupo, item.permissoes) != -1){
					menus.push(item);
				}
			});

			return menus;
		};
	}]
);