'use strict';

gruposApp.controller('GrupoCtrl', ['$scope', '$cookies', '$stateParams', '$location', 'Grupo',
	function($scope, $cookies, $stateParams, $location, Grupo) {

		console.log("in controller: " + coreApp.name)
		$scope.find = function(){
			console.log('find')
			$scope.grupos = Grupo.query(
				{},
				function(grupos, headers){},
				function(error){
					if(error.status === 401){
						$scope.logout();
					}else{
						$scope.error = error.data.message;
					}
				}
			);
		}

		$scope.findOne = function(){
			$scope.grupo = Grupo.get(
				{id: $stateParams.id},
				function(grupo, headers){
					$cookies.auth_token = headers('auth_token');
				},
				function(error){
					if(error.status === 401){
						$scope.logout();
					}else{
						$scope.error = error.data.message;
					}
				}
			);
		}

		$scope.create = function() {
			var grupo = new Grupo({
				grupo: this.grupo
			});
			grupo.$save(
				function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$scope.grupo = '';
					$location.path('grupos/list');
				},
				function(error){
					if(error.status === 401){
						$scope.logout();
					}else{
						$scope.error = error.data.message;
					}
				}
			);
		}

		$scope.update = function() {
			var grupo = $scope.grupo;
			grupo.$update(function() {
				$location.path('grupos/list');
			}, function(errorResponse) {
				$scope.error = errorResponse.data.message;
			});
		};
		
		$scope.remove = function(id) {
			if (id) {
				var grupo = new Grupo({
					id: id
				});
				grupo.$remove();

				for (var i in $scope.grupos) {
					if ($scope.grupos[i].id === grupo.id) {
						$scope.grupos.splice(i, 1);
					}
				}
			} else {
				$scope.grupo.$remove(function() {
					$location.path('grupos/list');
				});
			}
		};


	}]
);