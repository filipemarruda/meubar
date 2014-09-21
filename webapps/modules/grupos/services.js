'use strict';

module.factory('Grupo', ['$resource', '$cookies',
 	function($resource, $cookies){
	    return $resource(
	    	'http://localhost:8080/meubar/api/grupos/:grupoId',
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