'use strict';

var moduleName = 'usuarios';
var path = ApplicationConfiguration.modulesPath + '/' + moduleName;

ApplicationConfiguration.registerMenu({
	nome: 'usuarios',
	url: moduleName + '.list',
	classe: 'fa fa-fw fa-user',
	label: 'Usuarios',
	permissoes: ['Administrador', 'Gerente']
});


ApplicationConfiguration.includeFile(path + '/routes.js');
ApplicationConfiguration.includeFile(path + '/services.js');
ApplicationConfiguration.includeFile(path + '/controllers.js');
ApplicationConfiguration.registerModule(moduleName);