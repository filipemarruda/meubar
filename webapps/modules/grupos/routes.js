'use strict';
module.config(['$stateProvider',
  function($stateProvider) {
    console.log("in provider")
    $stateProvider.
      state('defaultGrupos',{
        url : '/',
        templateUrl: '/meubar/modules/grupos/tmpl/grupo-list.html'
      }).
      state('listGrupos',{
        url : '/grupos',
        templateUrl: '/meubar/modules/grupos/tmpl/grupo-list.html'
      }).
      state('viewGrupo',{
        url : '/grupos/:grupoId',
        templateUrl: '/meubar/modules/grupos/tmpl/grupo-list.html'
      })
  }]);