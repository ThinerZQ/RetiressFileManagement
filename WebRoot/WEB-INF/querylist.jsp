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
					<center>
					 <span>查询列表</span><br>
					 <span>共查找到<c:out value="${sessionScope.querycount }"></c:out>人</span><br>
					 <span>系统时间：<%=(new java.util.Date()).toLocaleString()%></span><br/>
					 <a href="<%=path %>/goChoiceOutputColsAction">输出到Excel</a>
					 </center>
					 <table border="solid 1px" >
					 	<tr>
					 		<td>姓名</td>
					 		<td>身份证号</td>
					 		<td>性别</td>
					 		<td>出生日期</td>
					 		<td>民族</td>
					 		<td>政治面貌</td>
					 		<td>籍贯</td>
					 		<td>档案添加</td>
					 		<td>详细信息</td>
					 	</tr>
					 	<c:forEach items="${requestScope.queryuserlist }" var="user" varStatus="s" >
							<tr>
								<td><c:out value="${user.realname }"></c:out></td>
								<td><c:out value="${user.idnumber }"></c:out></td>
								<td><c:out value="${user.sex }"></c:out></td>
								<td><c:out value="${user.birthday }"></c:out></td>
								<td><c:out value="${user.nation }"></c:out></td>
								<td><c:out value="${user.landscape }"></c:out></td>
								<td><c:out value="${user.birthplace }"></c:out></td>
								<td><a href="<%=path %>/dangAnAction?uid=${user.id }">档案添加</a></td>
								<td><a href="<%=path %>/detailInfoAction?uid=${user.id }">详细信息</a></td>
								
								
								
								
							</tr>
						</c:forEach>	
						<tr>
							<td colspan="8">
								<a href="<%=path%>/fenYeQueryAction?pageNum=1">首页</a><a
									href="<%=path%>/fenYeQueryAction?pageNum=${pageNowq }">上一页</a><a
									href="<%=path%>/fenyeQueryAction?pageNum=${pageNow }">${pageNow }</a>
								<a href="<%=path%>/fenYeQueryAction?pageNum=${pageNowh }">下一页</a><a href="fenYeQueryAction?pageNum=${lastPage }">尾页</a>
								<form action="<%=path%>/fenYeQueryAction" style="display: inline">
									<input type="text" name="pageNum" />
									<input type="submit" value="确定" />
								</form>
							</td>
						</tr>	 	
					 </table>
				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
