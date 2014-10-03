'use strict';

var moduleName = 'estoqueentradas';
var path = ApplicationConfiguration.modulesPath + '/' + moduleName;

ApplicationConfiguration.registerMenu({
	nome: 'estoqueentradas',
	url: moduleName + '.list',
	classe: 'fa fa-fw fa-barcode',
	label: 'Entrada Estoque',
	permissoes: ['Administrador']
});


ApplicationConfiguration.includeFile(path + '/routes.js');
ApplicationConfiguration.includeFile(path + '/services.js');
ApplicationConfiguration.includeFile(path + '/filters.js');
ApplicationConfiguration.includeFile(path + '/controllers.js');
ApplicationConfiguration.registerModule(moduleName);