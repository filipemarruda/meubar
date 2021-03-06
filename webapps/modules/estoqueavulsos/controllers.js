'use strict';

estoqueAvulsosApp.controller('EstoqueAvulsoCtrl', ['$filter','$scope', '$cookies', '$stateParams', '$rootScope', '$location', 'EstoqueAvulso', 'Produto',
	function($filter, $scope, $cookies, $stateParams, $rootScope , $location, Model, Produto) {

		$scope.moduleConfig = new ModuleConfig(estoqueAvulsosApp.name);
		$rootScope.moduleHeader = 'Manipulação de Estoque';
		
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
		
		$scope.changeUnidade = function(produtoId){
			$scope.unidade = $scope.produtos.filter(function(p){return p.id == produtoId;})[0].unidade;
		};
		
		$scope.clear = function(){
			$scope.unidade = '';
			$scope.error = '';
		};
		
		$scope.tipos = [
		    {
		    	id : "S",
		    	nome : "Saída"
		    },
		    {
		    	id : "E",
		    	nome : "Entrada"
		    }
		];
		
		$scope.produtos = Produto.query(
			{},
			function(response, headers){
				$cookies.auth_token = headers('auth_token');
			},
			function(error){
				$rootScope.errorHandle(error,$scope);
			}
		);
		
		$scope.find = function(){
			$scope.clear();
			$scope.itens = Model.query(
				{},
				function(response, headers){
					$scope.filteredItems = response;
					$scope.totalItems = response.length;
					$cookies.auth_token = headers('auth_token');
				},
				function(error){
					$rootScope.errorHandle(error,$scope);
				}
			);
		};
		
		$scope.findOne = function(){
			$scope.clear();
			$scope.item = Model.get(
				{id: $stateParams.id},
				function(response, headers){
					$scope.changeUnidade(response.produtoId);
					$cookies.auth_token = headers('auth_token');
				},
				function(error){
					$rootScope.errorHandle(error,$scope);
				}
			);
		};

		$scope.create = function() {
			$scope.clear();
			var item = new Model({
				motivo: this.motivo,
				tipo: this.tipo,
				preco: this.preco,
				quantidade: this.quantidade,
				produtoId: this.produtoId
			});
			item.$save(
				function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$location.path( $scope.moduleConfig.name + '/list' );
				},
				function(error){
					$rootScope.errorHandle(error,$scope);
				}
			);
		};

		$scope.update = function() {
			$scope.clear();
			var item = $scope.item;
			item.$update(
				function(response, headers) {
					$cookies.auth_token = headers('auth_token');
					$location.path( $scope.moduleConfig.name + '/list' );
				}, function(error) {
					$rootScope.errorHandle(error,$scope);
				}
			);
		};
		
		$scope.remove = function(item) {
			$scope.clear();
			if (item) {
				Utils.showConfirmDialog('Excluir Manipulação de Estoque','Deseja realmente excluir a '+ (item.tipo=='S'?'saída':'entrada') +' do produto "' + item.produto + '"?',
					function(){
						var i = new Model({
							id: item.id
						});
						
						i.$remove(function(response, headers) {
							
							for (var i in $scope.itens) {
								if ($scope.itens[i].id === item.id) {
									$scope.itens.splice(i, 1);
								}
							}
							
							$scope.setPage(1);
							$scope.totalItems--;
							$cookies.auth_token = headers('auth_token');
							
						}, function(error) {
							$rootScope.errorHandle(error,$scope);
						});
					}
				);
				$location.path( $scope.moduleConfig.name + '/list' );	
			}
		};
	}]
);