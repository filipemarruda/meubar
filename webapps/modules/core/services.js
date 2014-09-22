'use strict';

coreApp.factory('Core', ['$resource', '$cookies',
 	function($resource, $cookies){
	    return $resource(
	    	'http://localhost:8080/meubar/api/acesso',
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