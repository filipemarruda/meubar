'use strict';

// Init the application configuration module for AngularJS application
var ApplicationConfiguration = (function() {
	
	var menus = [];
	var submenus = [];
	var contextPath = '/meubar';
	var modulesPath = contextPath + '/modules';
	var applicationModuleName = 'meuBar';
	var applicationModuleVendorDependencies = ['ngResource', 'ngCookies', 'ui.router', 'ui.bootstrap', 'googlechart'];

	// Add a new vertical module
	var registerModule = function(moduleName, dependencies) {
		// Create angular module
		angular.module(moduleName, dependencies || []);

		// Add the module to the AngularJS configuration file
		angular.module(applicationModuleName).requires.push(moduleName);
	};

	var includeFile = function(file){
		document.write(unescape('%3Cscript src="' + file + '"%3E%3C/script%3E'));
	};

	var registerMenu = function(menu){
		menus.push(menu);
	};
	
	var registerSubmenu = function(submenu){
		submenus.push(submenu);
	};
	
	return {
		menus: menus,
		submenus: submenus,
		contextPath: contextPath,
		modulesPath: modulesPath,
		applicationModuleName: applicationModuleName,
		applicationModuleVendorDependencies: applicationModuleVendorDependencies,
		registerModule: registerModule,
		includeFile: includeFile,
		registerMenu: registerMenu,
		registerSubmenu: registerSubmenu
	};
})();

var ModuleConfig = (function(name){
	var name = name;
	var path = ApplicationConfiguration.modulesPath + '/' + name;
	var header = name.charAt(0).toUpperCase() + name.slice(1);
	var pagesPath = path + '/pages';
	return {
		name : name,
		path : path,
		header : header,
		pagesPath : pagesPath
		
	};
	
});