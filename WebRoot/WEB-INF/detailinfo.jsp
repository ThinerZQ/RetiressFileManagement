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
		<script type="text/javascript" src="js/mod.js"></script>
		<script type="text/javascript" src="js/loadfile.js"></script>	
		<script type="text/javascript" src="js/fillbirthday.js"></script>


	</head>

	<body>
		<div>
			<div class="logo">
				<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
			</div>
			<div class="middle" style="height: 550px">
				<div class="left" style="height: 550px">
					<jsp:include page="/WEB-INF/left.jsp"></jsp:include>
				</div>
				<div class="right" style="height: 550px">
				<center>
					 <span>详细信息</span><br>
					
					 <span>当前时间：<%=(new java.util.Date()).toLocaleString()%></span>
					 </center>



					<form action="<%=basePath%>/updateUserAction?flag=admin" method="post">

						<table>
							<tr>
								<td>
									<span></span>
								</td>
								<td>
									<input type="hidden" name="id" value="${requestScope.user.id }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>真实姓名：</span>
								</td>
								<td>
									<input type="text" name="realname" disabled="disabled"
										value="${requestScope.user.realname }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>身份证号：</span>
								</td>
								<td>
									<input type="text" name="idnumber" id="idnumber"
										disabled="disabled" value="${requestScope.user.idnumber }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>出生日期：</span>
								</td>
								<td>
									<input id="year" disabled="disabled" type="text" name="year"
										size="4" />
									年
									<input id="month" disabled="disabled" type="text" name="month"
										size="2" />
									月
									<input id="day" type="text" name="day" size="2"
										disabled="disabled" />
									日
								</td>
							</tr>
							<tr>
								<td>
									<span>性 别：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="sex_now"
										value="${requestScope.user.sex }" id="sex_now" />
									<span style="display: none;" id="sex"> <input
											type="radio" name="sex" value="男" id="man" />男 <input
											type="radio" name="sex" value="女" id="woman" />女 </span>
								</td>
							</tr>
							<tr>
								<td>
									<span>籍 贯：</span>
								</td>
								<td>
									<input id="birthplace_now" disabled="disabled" type="text"
										name="birthplace_now"
										value="${requestScope.user.birthplace }" />


									<select style="display: none;" id="birthplace_province"
										name="birthplace_province">

										<option value="0">
											--请选择--
										</option>
									</select>
									<select style="display: none;" id="birthplace_city"
										name="birthplace_city">
										<option value="0">
											--请选择--
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<span>政治面貌：</span>
								</td>
								<td>
									<input id="landscape_now" disabled="disabled" type="text"
										name="landscape_now"
										value="${requestScope.user.landscape }" />

									<select id="landscape" style="display: none;" name="landscape">
										<option value="0">
											--请选择--
										</option>
										<option value="群众">
											群众
										</option>
										<option value="共青团员">
											共青团员
										</option>
										<option value="中共党员">
											中共党员
										</option>
										<option value="民主党派">
											民主党派
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<span>民 族：</span>
								</td>
								<td>
									<input id="nation_now" disabled="disabled" type="text"
										name="nation_now" value="${requestScope.user.nation }" />
									<select id="nation" style="display: none;" id="nation"
										name="nation">
										<option value="0">
											--请选择--
										</option>

									</select>
								</td>
							</tr>
							<tr>
								<td>
									<span>学 历：</span>
								</td>
								<td>
									<input id="education_now" disabled="disabled" type="text"
										name="education_now"
										value="${requestScope.user.education }" />
									<select id="education" style="display: none;" name="education">
										<option value="0">
											--请选择--
										</option>
										<option value="无">
											无
										</option>
										<option value="小学">
											小学
										</option>
										<option value="初中">
											初中
										</option>
										<option value="高中">
											高中
										</option>
										<option value="中专">
											中专
										</option>
										<option value="高职">
											高职
										</option>
										<option value="专科">
											专科
										</option>
										<option value="本科">
											本科
										</option>
										<option value="硕士">
											硕士
										</option>
										<option value="博士">
											博士
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<span>学 位：</span>
								</td>
								<td>
									<input id="degree_now" disabled="disabled" type="text"
										name="degree_now" value="${requestScope.user.degress }" />

									<select id="degree" style="display: none;" name="degree">
										<option value="0">
											--请选择--
										</option>
										<option value="1">
											无
										</option>
										<option value="学士">
											学士
										</option>
										<option value="硕士">
											硕士
										</option>
										<option value="博士">
											博士
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<span>工作单位：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="workdepartment"
										value="${requestScope.user.workdepartment }" />
									<br />
								</td>
							</tr>
							<tr>
								<td>
									<span>主管部门：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="department"
										value="${requestScope.user.department }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>曾任何职：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="worked"
										value="${requestScope.user.worked }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>职 称：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="professionaltile"
										value="${requestScope.user.professionaltile }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>健康状况：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="health"
										value="${requestScope.user.health }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>联系电话：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="phone"
										value="${requestScope.user.phone }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>家庭住址：</span>
								</td>
								<td>
									<input disabled="disabled" type="text" name="address"
										value="${requestScope.user.address }" />
								</td>
							</tr>
							<tr>
								<td>
									<span>工作经历：</span>
								</td>
								<td>
									<textarea rows="1" cols="30" name="experience"
										disabled="disabled">${requestScope.user.experience }</textarea>
								</td>
							</tr>












							<tr>
								<td>
									<input type="button" value="修改" id="mod">
								</td>
								<td>
									<input type="submit" value="确认修改" />
								</td>
								<td><a href="checkDangAnInfo?uid=${requestScope.user.id }">查看档案信息</a></td>

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

