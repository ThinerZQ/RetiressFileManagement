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
		<link rel="stylesheet" type="text/css" href="css/query.css">
		<script type="text/javascript" src="js/jQuery.js"></script>	
		<script type="text/javascript" src="js/loadfile.js"></script>	
		<script type="text/javascript" src="js/fillbirthday.js"></script>	
		<script type="text/javascript" src="js/query.js"></script>	
		

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
					<div class="query_div">
					<form action="<%=basePath%>/queryUserAction" method="post">
						<table border="solid 1px;">
						<tr>
							
							<td><select id="choiceinfo" name="choiceinfo">
						    	<option value="0">--请选择需要查询的字段--</option>
						    	<option value="真实姓名">真实姓名</option>
						    	<option value="身份证号">身份证号</option>
						    	<option value="出生日期">出生日期</option>
						    	<option value="性　　别">性　　别</option>
						    	<option value="籍　　贯">籍　　贯</option>
						    	<option value="政治面貌">政治面貌</option>
						    	<option value="民　　族">民　　族</option>
						    	<option value="学　　历">学　　历</option>
						    	<option value="学　　位">学　　位</option>
						    	<option value="工作单位">工作单位</option>
						    	<option value="职　　称">职　　称</option>
						    	<option value="曾任何职">曾任何职</option>
						    	<option value="联系电话">联系电话</option>
						    	
						    </select>
						    </td>
						    <td><select id="deleteinfo" name="deleteinfo">
						    	<option value="0">--删除多余字段--</option>
						    	<option value="真实姓名">真实姓名</option>
						    	<option value="身份证号">身份证号</option>
						    	<option value="出生日期">出生日期</option>
						    	<option value="性　　别">性　　别</option>
						    	<option value="籍　　贯">籍　　贯</option>
						    	<option value="政治面貌">政治面貌</option>
						    	<option value="民　　族">民　　族</option>
						    	<option value="学　　历">学　　历</option>
						    	<option value="学　　位">学　　位</option>
						    	<option value="工作单位">工作单位</option>
						    	<option value="职　　称">职　　称</option>
						    	<option value="曾任何职">曾任何职</option>
						    	<option value="联系电话">联系电话</option>
						    	
						    </select>
						    </td>
						</tr>
						<tr id="realname_tr">
							<td><span>真实姓名：</span></td>
							<td><input type="text" name="realname" /></td>
						</tr>
						
						
						<tr id="idnumber_tr">
							<td><span>身份证号：</span></td>
							<td><input type="text" name="idnumber" id="idnumber" /></td>
						</tr>
						
						
						<tr id="birthday_tr">
							<td><span>出生日期：</span></td>
							<td>
								<input id="year"  type="text" name="year" size="4"/> 年 
								<input id="month"  type="text" name="month" size="2"/> 月
						 		<input id="day" type="text" name="day" size="2"  />日
							</td>
						</tr>
						
						
						<tr id="sex_tr">
							<td><span>性　　别：</span></td>
							<td><input type="radio" name="sex" value="男"/>男
						<input type="radio" name="sex" value="女"/>女</td>
						</tr>
						
						
						<tr id="birthplace_tr">
							<td><span>籍　　贯：</span></td>
							<td><select id="birthplace_province" name="birthplace_province">
						    	<option value="0">--请选择--</option>
						    </select>
						    <select id="birthplace_city" name="birthplace_city">
						    	<option value="0">--请选择--</option>
						    </select></td>
						</tr>
						
						 	
						<tr id="landscape_tr">
							<td><span>政治面貌：</span></td>
							<td>
							<select name="landscape">
						    	<option value="0">--请选择--</option>
						    	<option value="群众">群众</option>
						    	<option value="共青团员">共青团员</option>
						    	<option value="中共党员">中共党员</option>
						    	<option value="民主党派">民主党派</option>
						    </select></td>
						</tr>
						
						
						    
						<tr id="nation_tr">
							<td><span>民　　族：</span></td>
							<td> <select id="nation" name="nation">
						    	<option value="0">--请选择--</option>
						 
						    </select></td>
						</tr>
						
						
						<tr id="education_tr">
							<td><span>学　　历：</span></td>
							<td> <select name="education">
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
						    </select></td>
						</tr>
						
						
						<tr id="degree_tr">
							<td><span>学　　位：</span></td>
							<td> <select name="degree">
						    	<option value="0">--请选择--</option>
						    	<option value="1">无</option>
						    	<option value="学士">学士</option>
						    	<option value="硕士">硕士</option>
						    	<option value="博士">博士</option>
						    </select>
						</td>
						</tr>
						
						<tr id="workdepartment_tr">
							<td><span>工作单位：</span></td>
							<td><input type="text" name="workdepartment" /></td>
						</tr>
						
						<tr id="worked_tr">
							<td><span>曾任何职：</span></td>
							<td><input type="text" name="worked" /></td>
						</tr>
						
						
						<tr id="professionaltile_tr">
							<td><span>职　　称：</span></td>
							<td><input type="text" name="professionaltile" /></td>
						</tr>
						
						
						<tr id="phone_tr">
							<td><span>联系电话：</span></td>
							<td><input type="text" name="phone" /></td>
						</tr>
						
						
						<tr>
							<td><br></td>
							<td><input type="submit" value="" style="background: url('image/search.jpg') no-repeat; width: 100px; height: 40px; border: 0;" /></td>
						</tr>
						</table>
					</form>
					</div>
				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>

