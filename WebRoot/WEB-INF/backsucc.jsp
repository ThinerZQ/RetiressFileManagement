<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'fileAdd.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="css/left.css">
		<link rel="stylesheet" type="text/css" href="css/head.css">
		<link rel="stylesheet" type="text/css" href="css/foot.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/middle.css">

		<script type="text/javascript" src="js/jQuery.js"></script>



		<script type="text/javascript">
		$(document).ready(function() {
	

	$("#sub").click(function(){
		var file_type = $("#file_type").val();
		if(file_type == "0"){
			alert("请选择上传的文档类型");
			return false;
		}else{
		
		var path = "D:\\Study\\tomcat-6.0.39\\webapps\\RetiressFileManagement\\pdf\\";
		var idnumber = $("#id_inp").val();
		
		var fpath =path+idnumber+"_"+file_type+".pdf";
		alert(fpath);
			
			document.getElementById('scaner1').saveAllToFile(fpath);
 				 return true;
		}
		
  		
	})					
});
		</script>

	</head>

	<body>
		<div>
			<div class="logo">
				<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
			</div>
			<div class="middle" style="height: 530px;">
				<div class="left" style="height: 530px;">
					<jsp:include page="/WEB-INF/left.jsp"></jsp:include>
				</div>
				<div class="right" style="height: 530px;">
					<center>
						备份成功
					</center>
				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
