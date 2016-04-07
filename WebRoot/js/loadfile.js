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
function loadnation(filename) {
	
	
	var xmlDoc = xmlFunction(filename);
	var nation = xmlDoc.getElementsByTagName("nation");
	for ( var i = 0; i < nation.length; i++) {
		var $optionElement = $("<option></option>");
		var optionTextElement = document
				.createTextNode(nation[i].childNodes[0].nodeValue);
		$optionElement.attr("value", nation[i].childNodes[0].nodeValue);
		$optionElement.append(optionTextElement);
		$("#nation").append($optionElement);
	}
}
function loadbirthdplace(filename) {
	
	/** ***************************** */
	
	var xmlDoc = xmlFunction("birthplace.xml");
	var province = xmlDoc.getElementsByTagName("province");
	for ( var i = 0; i < province.length; i++) {
		var $optionElement = $("<option></option>");
		var province_name = province[i].attributes.getNamedItem("name").nodeValue;
		var optionTextElement = document.createTextNode(province_name);
		$optionElement.attr("value", province_name);
		$optionElement.append(optionTextElement);
		$("#birthplace_province").append($optionElement);
	}
	$("#birthplace_province")
			.change(function() {
				document.getElementById("birthplace_city").length = 1;
				var province_name = this.value;
				
					// alert(province.length);
					for ( var i = 0; i < province.length; i++) {
						if (province[i].attributes.getNamedItem("name").nodeValue == province_name) {
							// alert(111);
							var city = province[i].getElementsByTagName("city");
							// alert(city.length);
							for ( var j = 0; j < city.length; j++) {
								var city_name = city[j].attributes
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
				});
}
window.onload = function() {
	
	loadnation("nation.xml");
	loadbirthdplace("birthplace.xml");
};