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
		<script type="text/javascript" src="js/selectall.js"></script>



	</head>

	<body>
		<div>
			<div class="logo">
				<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
			</div>
			<div class="middle" style="height: 500px">
				<div class="left" style="height: 500px">
					<jsp:include page="/WEB-INF/left.jsp"></jsp:include>
				</div>
				<div class="right" style="height: 500px">
					<center>
						请选择需要输出的信息

						<form action="<%=basePath%>/dealExcelAction?flag=que" method="post">
							<table>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="姓名">
									</td>
									<td>
										姓名
									</td>
								</tr>

								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="身份证号">
									</td>
									<td>
										身份证号
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="性别">
									</td>
									<td>
										性别
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="出生日期">
									</td>
									<td>
										出生日期
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="政治面貌">
									</td>
									<td>
										政治面貌
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="民族">
									</td>
									<td>
										民族
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="籍贯">
									</td>
									<td>
										籍贯
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="学历">
									</td>
									<td>
										学历
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="学位">
									</td>
									<td>
										学位
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="健康状况">
									</td>
									<td>
										健康状况
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="工作单位">
									</td>
									<td>
										工作单位
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="所属部门">
									</td>
									<td>
										所属部门
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="任何职">
									</td>
									<td>
										任何职
									</td>
								</tr>
								
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="职称">
									</td>
									<td>
										职称
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="联系电话">
									</td>
									<td>
										联系电话
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="checkbox" value="家庭住址">
									</td>
									<td>
										家庭住址
									</td>
								</tr>
									<tr>
									<td>
										<input type="checkbox" name="checkbox" value="工作经历">
									</td>
									<td>
										工作经历
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="selectall" id="selectall"  />全选/取消全选
										
									</td>
									<td>
										<input type="submit" value="确认选择">
									</td>
								</tr>
							
							</table>
						</form>
					</center>
				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>

