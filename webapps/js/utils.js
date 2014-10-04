var Utils = (function(){
	
	var showConfirmDialog = function(title, msg, callback) {
		
		return bootbox.dialog(
			{
				locale: "pt-br",
				title: title,
				message: msg,
				
				buttons: {
				    cancel:{
				      label: "Cancelar",
				      className: "btn-danger",
				    },
					ok: {   
				      label: "Confirmar",
				      className: "btn-success",
				      callback: callback
				    }
				}
			}
		);
		
	};
	
	return {
		showConfirmDialog : showConfirmDialog
	};
	
})();