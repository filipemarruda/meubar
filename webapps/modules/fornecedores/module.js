'use strict';

var moduleName = 'fornecedores';
var path = ApplicationConfiguration.modulesPath + '/' + moduleName;

ApplicationConfiguration.registerSubmenu({
	parent: 'estoque',
	nome: moduleName,
	url: moduleName + '.list',
	classe: 'fa fa-fw fa-truck',
	label: 'Fornecedores',
	permissoes: ['Administrador']
});

ApplicationConfiguration.includeFile(path + '/routes.js');
ApplicationConfiguration.includeFile(path + '/services.js');
ApplicationConfiguration.includeFile(path + '/filters.js');
ApplicationConfiguration.includeFile(path + '/controllers.js');
ApplicationConfiguration.registerModule(moduleName);