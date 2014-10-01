'use strict';

coreApp.factory('Core', ['$resource', '$cookies',
 	function($resource, $cookies){
	    return $resource(
	    	'/meubar/api/acesso',
	    	{},
	    	{
	      		query: {
		      		method:'GET', 
		      		headers:{
		      			'auth_token' : $cookies.auth_token
	      			},
	      			isArray:true
	      		},
	      		get: {
		      		method:'GET', 
		      		headers:{
		      			'auth_token' : $cookies.auth_token
	      			},
	      			isArray:false
	      		},
	    	}
	    );
 	}
 ]);

coreApp.factory('Estado', ['$resource',
 	function($resource){
	    return $resource(
	    	'/meubar/api/core/estados/:id',
	    	{id : '@id'},
	    	{
	      		'query': {
		      		method:'GET', 
	      			isArray:true
	      		},
	      		'get': {
		      		method:'GET', 
	      			isArray:false
	      		},
	      		'save': {
		      		method:'POST', 
	      			isArray:false
	      		},
	      		'delete': {
		      		method:'DELETE', 
	      			isArray:false
	      		},
	      		'update': {
		      		method:'PUT', 
	      			isArray:false
	      		},
	    	}
	    );
 	}
 ]);
coreApp.factory('Unidade', ['$resource',
	function($resource){
    return $resource(
    	'/meubar/api/core/unidades/:id',
    	{id : '@id'},
    	{
      		'query': {
	      		method:'GET', 
      			isArray:true
      		},
      		'get': {
	      		method:'GET', 
      			isArray:false
      		},
      		'save': {
	      		method:'POST', 
      			isArray:false
      		},
      		'delete': {
	      		method:'DELETE', 
      			isArray:false
      		},
      		'update': {
	      		method:'PUT', 
      			isArray:false
      		},
    	}
    );
	}
]);