<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="left_login">
	<span>欢迎你：<c:out value="${sessionScope.user_now.realname }"></c:out></span><span><a href="">退出</a>
	</span>
</div>
<div class="nav">
	<ul class="navul">
		<li>
			<span><a href="<%=path %>/checkMyInfoAction">查看个人信息</a></span>
			<span><a href="<%=path %>/checkMyDangAnAction">查看档案信息</a></span>
		</li>
		
	</ul>
</div>
