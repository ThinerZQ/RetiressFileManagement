$("document").ready(function() {
	
	$("#realname_tr").hide();
	$("#idnumber_tr").hide();
	$("#birthday_tr").hide();
	$("#sex_tr").hide();
	$("#birthplace_tr").hide();
	$("#landscape_tr").hide();
	$("#nation_tr").hide();
	$("#education_tr").hide();
	$("#degree_tr").hide();
	$("#workdepartment_tr").hide();
	$("#worked_tr").hide();
	$("#professionaltile_tr").hide();
	$("#phone_tr").hide();
	$("#worked_tr").hide();
	
	
	$("#choiceinfo").change(function(){
	
		var p1=$(this).children('option:selected').val();
		
		if(p1=="真实姓名")
			$("#realname_tr").show();
		else if(p1=="身份证号")
			$("#idnumber_tr").show();
		else if(p1=="出生日期")
			$("#birthday_tr").show();
		else if(p1=="性　　别")
			$("#sex_tr").show();
		else if(p1=="籍　　贯")
			$("#birthplace_tr").show();
		else if(p1=="政治面貌")
			$("#landscape_tr").show();
		else if(p1=="民　　族")
			$("#nation_tr").show();
		else if(p1=="学　　历")
			$("#education_tr").show();
		else if(p1=="学　　位")
			$("#degree_tr").show();
	    else if(p1=="工作单位")
	    	$("#workdepartment_tr").show();
		else if(p1=="职　　称")
			$("#professionaltile_tr").show();
		else if(p1=="曾任何职")
			$("#worked_tr").show();
	    else if(p1=="联系电话")
	    	$("#phone_tr").show();
		
		
	    
		
	
	})
	$("#deleteinfo").change(function(){
	
		var p1=$(this).children('option:selected').val();
		
		if(p1=="真实姓名")
			$("#realname_tr").hide();
		else if(p1=="身份证号")
			$("#idnumber_tr").hide();
		else if(p1=="出生日期")
			$("#birthday_tr").hide();
		else if(p1=="性　　别")
			$("#sex_tr").hide();
		else if(p1=="籍　　贯")
			$("#birthplace_tr").hide();
		else if(p1=="政治面貌")
			$("#landscape_tr").hide();
		else if(p1=="民　　族")
			$("#nation_tr").hide();
		else if(p1=="学　　历")
			$("#education_tr").hide();
		else if(p1=="学　　位")
			$("#degree_tr").hide();
	    else if(p1=="工作单位")
	    	$("#workdepartment_tr").hide();
		else if(p1=="职　　称")
			$("#professionaltile_tr").hide();
		else if(p1=="曾任何职")
			$("#worked_tr").hide();
	    else if(p1=="联系电话")
	    	$("#phone_tr").hide();
		
		
	    
		
	
	})
	



});

