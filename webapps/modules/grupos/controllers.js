'use strict';

gruposApp.controller('GrupoCtrl', ['$scope', '$cookies', '$stateParams', '$location', 'Grupo',
	function($scope, $cookies, $stateParams, $location, Grupo) {


			console.log("in controller: " + coreApp.name)
			$scope.find = function(){
				console.log('find')
				$scope.grupos = Grupo.query(
					{},
					function(grupos, headers){
						$cookies.auth_token = headers('auth_token');
					},
					function(error){
						if(error.status === 401){
							$scope.logout();
						}
					}
				);
			}

			$scope.findOne = function(){
				$scope.grupo = Grupo.get(
					{grupoId: $stateParams.id},
					function(grupo, headers){
						$cookies.auth_token = headers('auth_token');
					},
					function(error){
						if(error.status === 401){
							$scope.logout();
						}
					}
				);
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