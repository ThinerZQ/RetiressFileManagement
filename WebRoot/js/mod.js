$("document").ready(function() {
	
	
	
	
	
	var idcard = $("#idnumber").val();
	var year = idcard. substr(6,4);
	var month = idcard. substr(10,2);
	var day = idcard. substr(12,2);
	
	$("#year").val(year);
	$("#month").val(month);
	$("#day").val(day);
	
	
	
	
	$("#mod").click(function(){
	
		
		//$('input').attr("readonly","readonly")//将input元素设置为readonly
		
		
		
		$("input").removeAttr("disabled");//去除input元素的readonly属性
		$("textarea").removeAttr("disabled");//去除input元素的readonly属性
		
		
		
		
		
		
		var sex_now =$("#sex_now").val();
		
		if(sex_now=="男"){
			$('#man').attr("checked","checked")
		}else if(sex_now=="女"){
			$('#woman').attr("checked","checked")
		}
		$("#sex_now").remove();
		$("#sex").show();
		
		var birthplace_now =$("#birthplace_now").val();
		
		
		
		$("#birthplace_now").remove();
		$("#birthplace_province").show();
		$("#birthplace_city").show();
		var str = birthplace_now.split("省");
		var province_name=str[0]+"省";
		var city=str[1];
		
		
		var s1 = $("#birthplace_province option[value='"+province_name+"']");
		$("#birthplace_province option[index='0']").attr("selected",false);
		s1.attr("selected",true);
		
		
		
		
		
		
		var xmlDoc = xmlFunction("birthplace.xml");
		var province = xmlDoc.getElementsByTagName("province");
		for ( var i = 0; i < province.length; i++) {
			var province_name_load = province[i].attributes.getNamedItem("name").nodeValue;
			if (province_name_load == province_name) {
				// alert(111);
				var city_name_load = province[i].getElementsByTagName("city");
				// alert(city.length);
				for ( var j = 0; j < city_name_load.length; j++) {
					var city_name = city_name_load[j].attributes
							.getNamedItem("name").nodeValue;
					
					var $optionElement = $("<option></option>");
					var optionTextElement = document
							.createTextNode(city_name);
					$optionElement.attr("value", city_name);
					$optionElement.append(optionTextElement);
					$("#birthplace_city").append($optionElement);
				}
			}
		}
		var s2 = $("#birthplace_city option[value='"+city+"']");
		$("#birthplace_city option[index='0']").attr("selected",false);
		s2.attr("selected",true);
		
		
		
		
		
		
		
		
		
		
		var landscape_now =$("#landscape_now").val();
		$("#landscape_now").remove();
		$("#landscape").show();
		var s3 = $("#landscape option[value='"+landscape_now+"']");
		$("#landscape option[index='0']").attr("selected",false);
		s3.attr("selected",true);
		
		
		
		var nation_now =$("#nation_now").val();
		$("#nation_now").remove();
		$("#nation").show();
		var s4 = $("#nation option[value='"+nation_now+"']");
		$("#nation option[index='0']").attr("selected",false);
		s4.attr("selected",true);
		
		var education_now =$("#education_now").val();
		$("#education_now").remove();
		$("#education").show();
		var s5 = $("#education option[value='"+education_now+"']");
		$("#education option[index='0']").attr("selected",false);
		s5.attr("selected",true);
		
		var degree_now =$("#degree_now").val();
		$("#degree_now").remove();
		$("#degree").show();
		var s6 = $("#degree option[value='"+degree_now+"']");
		$("#degree option[index='0']").attr("selected",false);
		s6.attr("selected",true);
		
		
		
		$("#year").attr("readonly","readonly");
		$("#month").attr("readonly","readonly");
		$("#day").attr("readonly","readonly");
		
		
	
	})
	



});

function xmlFunction(filename) {
	var xmlDoc;
	try {
		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	} catch (e) {
		try {
			var oXmlHttp = new XMLHttpRequest();
			oXmlHttp.open("GET", filename, false);
			oXmlHttp.send(null);
			return oXmlHttp.responseXML;
		} catch (e) {
			alert(e.message);
			return;
		}
	}
	xmlDoc.async = false;
	xmlDoc.load(filename);
	return xmlDoc;
}
