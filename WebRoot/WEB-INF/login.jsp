<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>login</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">


	</head>

	<body>


		<div>
			<div class="bg_img">
				<img src="image/bg.jpg" width="800px;" height="630px;">
			</div>

			<div class="login">
				<form action="<%=path%>/adminLoginAction" method="post"
					class="login_form">
					<table>
						<tr>
							<td colspan="2" align="center">
								登录
							</td>

						</tr>
						<tr>
							<td>
								用户名：
							</td>
							<td>
								<input type="text" name="username" />
							</td>
						</tr>
						<tr>
							<td>
								密 码：
							</td>
							<td>
								<input type="password" name="password" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="radio" name="type"  value="管理员">管理员
								<input type="radio" name="type"  value="退休员工" checked="checked" >退休员工
							</td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="" class="sub"
									style="background: url('image/login.jpg') no-repeat; width: 100px; height: 38px; border: 0;" />
							</td>
							<td>
								<a href="" class="forget">忘记密码？</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
