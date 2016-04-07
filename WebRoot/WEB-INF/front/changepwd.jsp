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

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/left.css">
		<link rel="stylesheet" type="text/css" href="css/head.css">
		<link rel="stylesheet" type="text/css" href="css/foot.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/middle.css">
		
		<script type="text/javascript" src="js/jQuery.js"></script>	
		<script type="text/javascript" src="js/checkpwd.js"></script>	





	</head>

	<body>
		<div>
			<div class="logo">
				<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
			</div>
			<div class="middle">
				<div class="left">
					<jsp:include page="/WEB-INF/front/left.jsp"></jsp:include>
				</div>
				<div class="right">

					<center>
						<span style="font-family: 华文新魏;">修改密码</span>
						<br>
						<br>
						<span>时间：<%=(new java.util.Date()).toLocaleString()%></span>
					</center>
					<form action="<%=path%>/changePwdAction" method="post">
						<table border="solid 1px">
							<tr>

								<td>
									新密码：
								</td>
								<td>
									<input type="password" name="password_f" / id="p1" value="">
								</td>
								<td>
									<span></span>
								</td>

							</tr>
							<tr>

								<td>
									再次输入新密码：
								</td>
								<td>
									<input type="password" name="password_s" id="p2" value=""/>
								</td>
								<td>
									<span id="sp2" style="color: red;"> </span>
									<br>
								</td>

							</tr>
							<tr>

								<td colspan="1">
									<input type="reset" value="重置" />
								</td>
								<td colspan="2">
									<input type="submit" value="确认修改" id="sub"/>
								</td>

							</tr>


						</table>

					</form>




				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
