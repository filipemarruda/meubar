'use strict';

coreApp.controller('CoreCtrl', ['$rootScope', '$cookies', '$stateParams', '$location', '$state','Core',
	function($rootScope, $cookies, $stateParams, $location, $state, Core) {
		console.log("in controller of module: " + coreApp.name);
		
		$rootScope.moduleConfig = new ModuleConfig(coreApp.name);
		$rootScope.moduleHeader = $rootScope.moduleConfig.header;

		$rootScope.logout = function() {
			
			var login_page = 'index.html';
			delete $cookies.auth_token;
			delete $cookies.user;
			window.location = login_page;

		};
		
		$rootScope.errorHandle = function(error, escopo){
			if(error.status === 401){
				$state.transitionTo('proibido');
			}else if(error.status === 403){
				$rootScope.logout();
			}else{
				if(!!error.data && !!error.data.message){
					escopo.error = error.data.message;					
				}else{
					escopo.error = "Erro desconhecido!";
				}
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