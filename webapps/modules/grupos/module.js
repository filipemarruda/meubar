'use strict';

var moduleName = 'grupos';
var path = ApplicationConfiguration.modulesPath + '/' + moduleName;

ApplicationConfiguration.registerMenu({
	nome: 'grupos',
	classe: 'fa fa-fw fa-group',
	label: 'Grupos',
	permissoes: ['Administrador']
});

ApplicationConfiguration.registerMenu({
	nome: 'usuarios',
	classe: 'fa fa-fw fa-user',
	label: 'Usuarios',
	permissoes: ['Garcons']
});


ApplicationConfiguration.includeFile(path + '/routes.js');
ApplicationConfiguration.includeFile(path + '/services.js');
ApplicationConfiguration.includeFile(path + '/controllers.js');
ApplicationConfiguration.registerModule(moduleName);