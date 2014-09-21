'use strict';

module.controller('GrupoCtrl', ['$scope', '$cookies', '$stateParams','Grupo',
	function($scope, $cookies, $stateParams, Grupo) {
		console.log("in controller")
		$scope.find = function(){
			$scope.grupos = Grupo.query({}, function(grupos, headers){
				$cookies.auth_token = headers('auth_token');
			});
		}

		$scope.findOne = function(){
			$scope.grupo = Grupo.get({grupoId: $stateParams.grupoId}, function(grupo, headers){
			$cookies.auth_token = headers('auth_token');
		});
		}
	}]
);