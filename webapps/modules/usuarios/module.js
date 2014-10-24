'use strict';

var moduleName = 'usuarios';
var path = ApplicationConfiguration.modulesPath + '/' + moduleName;

ApplicationConfiguration.registerSubmenu({
	parent: 'controleacesso',
	nome: moduleName,
	url: moduleName + '.list',
	classe: 'fa fa-fw fa-user',
	label: 'Usuarios',
	permissoes: ['Administrador']
});

ApplicationConfiguration.includeFile(path + '/routes.js');
ApplicationConfiguration.includeFile(path + '/services.js');
ApplicationConfiguration.includeFile(path + '/filters.js');
ApplicationConfiguration.includeFile(path + '/controllers.js');
ApplicationConfiguration.registerModule(moduleName);