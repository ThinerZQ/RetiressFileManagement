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
		<script type="text/javascript" src="js/loadfile.js"></script>	
		<script type="text/javascript" src="js/fillbirthday.js"></script>	
		

	</head>

	<body>
		<div>
			<div class="logo">
				<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
			</div>
			<div class="middle">
				<div class="left">
					<jsp:include page="/WEB-INF/left.jsp"></jsp:include>
				</div>
				<div class="right">
					<form action="<%=basePath%>/addUserAction" method="post">
						<span>真实姓名：</span>
						<input type="text" name="realname" />
						<br />
						<span>身份证号：</span>
						<input type="text" name="idnumber" id="idnumber" />
						<br/>
						<span>出生日期：</span>
						<input id="year" readonly="readonly" type="text" name="year" size="4"/> 年 
						<input id="month" readonly="readonly" type="text" name="month" size="2"/> 月
						 <input id="day" type="text" name="day" size="2" readonly="readonly" />日
						<br/>
						<span>性　　别：</span>
						<input type="radio" name="sex" value="男" checked="checked"/>男
						<input type="radio" name="sex" value="女"/>女
						<br />
						<span>籍　　贯：</span>
						 	<select id="birthplace_province" name="birthplace_province">
						    	<option value="0">--请选择--</option>
						    </select>
						    <select id="birthplace_city" name="birthplace_city">
						    	<option value="0">--请选择--</option>
						    </select>
						<br />
						
						<span>政治面貌：</span>
						    <select name="landscape">
						    	<option value="0">--请选择--</option>
						    	<option value="群众">群众</option>
						    	<option value="共青团员">共青团员</option>
						    	<option value="中共党员">中共党员</option>
						    	<option value="民主党派">民主党派</option>
						    </select>
						<br />
						<span>民　　族：</span>
						 <select id="nation" name="nation">
						    	<option value="0">--请选择--</option>
						 
						    </select>
						<br />
						<span>学　　历：</span>
						 <select name="education">
						    	<option value="0">--请选择--</option>
						    	<option value="无">无</option>
						    	<option value="小学">小学</option>
						    	<option value="初中">初中</option>
						    	<option value="高中">高中</option>
						    	<option value="中专">中专</option>
						    	<option value="高职">高职</option>
						    	<option value="专科">专科</option>
						    	<option value="本科">本科</option>
						    	<option value="硕士">硕士</option>
						    	<option value="博士">博士</option>
						    </select>
						<br />
						<span>学　　位：</span>
						 <select name="degree">
						    	<option value="0">--请选择--</option>
						    	<option value="1">无</option>
						    	<option value="学士">学士</option>
						    	<option value="硕士">硕士</option>
						    	<option value="博士">博士</option>
						    </select>
						<br />
						<span>工作单位：</span>
						<input type="text" name="workdepartment" />
						<br />
						<span>主管部门：</span>
						<input type="text" name="department" />
						<br />
						<span>曾任何职：</span>
						<input type="text" name="worked" />
						<br />
						<span>职　　称：</span>
						<input type="text" name="professionaltile" />
						<br />
						<span>健康状况：</span>
						<input type="text" name="health" />
						<br />
						<span>联系电话：</span>
						<input type="text" name="phone" />
						<br />
						<span>家庭住址：</span>
						<input type="text" name="address" />
						<br />
						<span>工作经历：</span>
						<textarea rows="2" cols="2" name="experience">请填写工作经历</textarea>
						<br />
						<input type="submit" value="确定添加"/>
					</form>
				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>

