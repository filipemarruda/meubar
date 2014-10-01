'use strict';

gruposApp.controller('GrupoCtrl', ['$filter','$scope', '$cookies', '$stateParams', '$rootScope', '$location', 'Grupo',
	function($filter, $scope, $cookies, $stateParams, $rootScope , $location, Model) {

		$scope.moduleConfig = new ModuleConfig(gruposApp.name);
		$scope.moduleHeader = $scope.moduleConfig.header;
		
		// pagination
		$scope.currentPage = 1;
		$scope.maxSize = 10;
		$scope.itensPerPage = 5;
		$scope.bigTotalItems = 100;
		$scope.bigCurrentPage = 1;
		
		$scope.setPage = function(pageNo) {
			$scope.currentPage = pageNo;
		};
		
		// filter
		$scope.filter = function(itens, search) {
			$scope.filteredItems = $filter('filter')(itens, search);
			$scope.totalItems = $scope.filteredItems.length;
		};
		
		// order
		$scope.sortBy = function(predicate) {
			$scope.predicate = predicate;
			$scope.reverse = !$scope.reverse;
		};
		
		$scope.find = function(){
			$scope.itens = Model.query(
				{},
				function(response, headers){
					$scope.filteredItems = response;
					$scope.totalItems = response.length;
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
				nome: this.nome
			});
			item.$save(
				function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$location.path( $scope.moduleConfig.name + '/list' );
				},
				function(error){
					$rootScope.errorHandle(error.status);
				}
			);
		};

		$scope.update = function() {
			var item = $scope.item;
			item.$update(
				function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$location.path( $scope.moduleConfig.name + '/list' );
				}, function(error) {
					$rootScope.errorHandle(error.status);
				}
			);
		};
		
		$scope.remove = function(item) {
			if (item) {
				if(Utils.showConfirmDialog('Deseja realmente escluir o grupo "' + item.nome + '"?')){
					var i = new Model({
						id: item.id
					});
					
					i.$remove(function(response, headers) {
						
						for (var i in $scope.itens) {
							if ($scope.itens[i].id === item.id) {
								$scope.itens.splice(i, 1);
							}
						}
						
						$cookies.auth_token = headers('auth_token');
						
					}, function(error) {
						$rootScope.errorHandle(error.status);
					});
					
				}
				$location.path( $scope.moduleConfig.name + '/list' );
			}
		};
	}]
);