'use strict';

usuariosApp.controller('UsuarioCtrl', ['$scope', '$cookies', '$stateParams', '$rootScope', '$location', 'Usuario', 'Grupo',
	function($scope, $cookies, $stateParams, $rootScope , $location, Model, Grupo) {

		$scope.moduleName = usuariosApp.name;
		$scope.moduleHeader = $scope.moduleName.charAt(0).toUpperCase() + $scope.moduleName.slice(1);
		
		$scope.grupos = Grupo.query(
			{},
			function(response, headers){
				$cookies.auth_token = headers('auth_token');
			},
			function(error){
				$rootScope.errorHandle(error.status);
			}
		);
		
		
		$scope.find = function(){
			$scope.itens = Model.query(
				{},
				function(response, headers){
					$cookies.auth_token = headers('auth_token');
				},
				function(error){
					$rootScope.errorHandle(error.status);
				}
			);
		};

		$scope.findOne = function(){
			
			$scope.item = Model.get(
				{id: $stateParams.id},
				function(response, headers){
					$cookies.auth_token = headers('auth_token');
				},
				function(error){
					$rootScope.errorHandle(error.status);
				}
			);
		};

		$scope.create = function() {
			var item = new Model({
				login: this.login,
				nome: this.nome,
				cpf: this.cpf,
				telefone: this.telefone,
				grupoId: this.grupoId
			});
			if(!!this.senha == true){
				item.senha = md5(this.senha);
			}
			item.$save(
				function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$location.path( $scope.moduleName + '/list' );
				},
				function(error){
					$rootScope.errorHandle(error.status);
				}
			);
		};

		$scope.update = function() {
			var item = $scope.item;
			if(!!item.senha){
				item.senha = md5($scope.item.senha);
			}
			item.$update(
				function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$location.path( $scope.moduleName + '/list' );
				}, function(error) {
					$rootScope.errorHandle(error.status);
				}
			);
		};
		
		$scope.remove = function(id) {
			if (id) {
				var item = new Model({
					id: id
				});
				item.$remove(function(response, headers) {
					$cookies.auth_token = headers('auth_token');
				}, function(error) {
					$rootScope.errorHandle(error.status);
				});

				for (var i in $scope.itens) {
					if ($scope.itens[i].id === item.id) {
						$scope.itens.splice(i, 1);
					}
				}
			} else {
				$scope.item.$remove(function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$location.path( $scope.moduleName + '/list' );
				}, function(error) {
					$rootScope.errorHandle(error.status);
				});
			}
		};
	}]
);