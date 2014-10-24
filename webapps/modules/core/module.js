'use strict';

var moduleName = 'core';
var path = ApplicationConfiguration.modulesPath + '/' + moduleName;

ApplicationConfiguration.registerMenu({
	nome: 'dashboard',
	url: '#',
	classe: 'fa fa-fw fa-tachometer',
	label: 'Dashboard',
	permissoes: ['Administrador']
});

ApplicationConfiguration.registerMenu({
	nome: 'controleacesso',
	url: '#',
	classe: 'fa fa-fw fa-lock',
	label: 'Controle de Acesso',
	permissoes: ['Administrador']
});

ApplicationConfiguration.registerMenu({
	nome: 'estoque',
	url: '#',
	classe: 'fa fa-fw fa-cubes',
	label: 'Estoque',
	permissoes: ['Administrador']
});

ApplicationConfiguration.registerSubmenu({
	parent: 'dashboard',
	nome: moduleName,
	url: moduleName + '.estoque',
	classe: 'fa fa-fw fa-pie-chart',
	label: 'Dashboard',
	permissoes: ['Administrador']
});

ApplicationConfiguration.includeFile(path + '/routes.js');
ApplicationConfiguration.includeFile(path + '/services.js');
ApplicationConfiguration.includeFile(path + '/controllers.js');
ApplicationConfiguration.registerModule(moduleName);