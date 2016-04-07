





$("document").ready(function() {
	
	$('#idnumber').blur(function() { 
		
		var idcard = $("#idnumber").val();
		var year = idcard. substr(6,4);
		var month = idcard. substr(10,2);
		var day = idcard. substr(12,2);
		
		$("#year").val(year);
		$("#month").val(month);
		$("#day").val(day);
		
		
		
		}); 
	



});

