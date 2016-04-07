$("document").ready(function() {
        $.post("ajaxAction",function(data,textStatus){
			var dataObj = eval("("+data+")");
			for(var i=0;i<dataObj.length;i++){
				
				$option = $("<option></option>");
				$option.attr("value",dataObj[i].id);
				$option.text(dataObj[i].ARealname);
				
				$("#operator").append($option);
			}
		});
		
	
        
        
});