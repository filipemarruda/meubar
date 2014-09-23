'use strict';

gruposApp.factory('Grupo', ['$resource', '$cookies',
 	function($resource, $cookies){
	    return $resource(
	    	'http://localhost:8080/meubar/api/grupos/:id',
	    	{id : '@id'},
	    	{
	      		'query': {
		      		method:'GET', 
		      		headers:{
		      			'auth_token' : $cookies.auth_token
	      			},
	      			isArray:true
	      		},
	      		'get': {
		      		method:'GET', 
		      		headers:{
		      			'auth_token' : $cookies.auth_token
	      			},
	      			isArray:false
	      		},
	      		'save': {
		      		method:'POST', 
		      		headers:{
		      			'auth_token' : $cookies.auth_token
	      			},
	      			isArray:false
	      		},
	      		'delete': {
		      		method:'DELETE', 
		      		headers:{
		      			'auth_token' : $cookies.auth_token
	      			},
	      			isArray:false
	      		},
	      		'update': {
		      		method:'PUT', 
		      		headers:{
		      			'auth_token' : $cookies.auth_token
	      			},
	      			isArray:false
	      		},
	    	}
	    );
 	}
 ]);