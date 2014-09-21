'use strict';

gruposApp.controller('GrupoCtrl', ['$scope', '$cookies', '$stateParams', '$location', 'Grupo',
	function($scope, $cookies, $stateParams, $location, Grupo) {
			console.log("in controller")
			$scope.find = function(){
				console.log('find')
				$scope.grupos = Grupo.query({}, function(grupos, headers){
					$cookies.auth_token = headers('auth_token');
				});
			}

			$scope.findOne = function(){
				$scope.grupo = Grupo.get({grupoId: $stateParams.grupoId}, function(grupo, headers){
					$cookies.auth_token = headers('auth_token');
				});
			}
			$scope.getClass = function(path) {
			    if ($location.path().substr($location.path().lastIndexOf('/')) == path) {
			      return "btn-primary"
			    } else {
			      return "btn-default"
			    }
			}
	}]
);