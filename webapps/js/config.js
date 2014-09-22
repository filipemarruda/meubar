'use strict';

// Init the application configuration module for AngularJS application
var ApplicationConfiguration = (function() {
	
	var menus = [];
	var contextPath = '/meubar';
	var modulesPath = contextPath + '/modules';
	var applicationModuleName = 'meuBar';
	var applicationModuleVendorDependencies = ['ngResource', 'ngCookies', 'ui.router', 'ui.bootstrap'];

	// Add a new vertical module
	var registerModule = function(moduleName, dependencies) {
		// Create angular module
		angular.module(moduleName, dependencies || []);

		// Add the module to the AngularJS configuration file
		angular.module(applicationModuleName).requires.push(moduleName);
	};

	var includeFile = function(file){
		document.write(unescape('%3Cscript src="' + file + '"%3E%3C/script%3E'));
	}

	var registerMenu = function(menu){
		menus.push(menu);
	}
	return {
		menus: menus,
		contextPath: contextPath,
		modulesPath: modulesPath,
		applicationModuleName: applicationModuleName,
		applicationModuleVendorDependencies: applicationModuleVendorDependencies,
		registerModule: registerModule,
		includeFile: includeFile,
		registerMenu: registerMenu
	};
})();