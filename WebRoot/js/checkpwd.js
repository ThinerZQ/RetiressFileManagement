$(document).ready(function() {
	
	
			
		$("#p2").blur(function() {
			var p2 = $("#p2").val();
			var p1= $("#p1").val();
			
			if(p1!=p2){
				$("#sp2").text("");
				$("#sp2").append("两次密码不一致");
			}else{
				$("#sp2").text("");
			}
			
			
		});
		$("#p1").blur(function() {
			var p2 = $("#p2").val();
			var p1= $("#p1").val();
			
			if(p1!=p2){
				$("#sp2").text("");
				$("#sp2").append("两次密码不一致");
			}else{
				$("#sp2").text("");
			}
			
			
		});
		
		$("#sub").click(function(){
		
			var p2 = $("#p2").val();
			var p1= $("#p1").val();
			
			if(p1=="" || p2==""){
				alert("密码不能为空");
				return false;
			}
		
		
			var p2 = $("#sp2").text();
			
			
			if(p2!=""){
				alert("请确保密码一致");
				return false;
			}else{
				return true;
			}
			
			
		})
		
	});