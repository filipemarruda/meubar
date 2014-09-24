'use strict';

var moduleName = 'core';
var path = ApplicationConfiguration.modulesPath + '/' + moduleName;

ApplicationConfiguration.registerMenu({
	nome: 'core',
	classe: 'fa fa-fw fa-tachometer',
	label: 'Dashboard',
	permissoes: ['Administrador']
});


ApplicationConfiguration.includeFile(path + '/routes.js');
ApplicationConfiguration.includeFile(path + '/services.js');
ApplicationConfiguration.includeFile(path + '/controllers.js');
ApplicationConfiguration.registerModule(moduleName);