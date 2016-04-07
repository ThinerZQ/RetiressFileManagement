<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="left_login">
	<span>欢迎你：<c:out value="${sessionScope.admin_login.AUsername }"></c:out></span><span><a href="goExitAction">退出</a>
	</span>
</div>
<div class="nav">
	<ul class="navul">
		<li>
			<span><a href="<%=path %>/fenYeAction?pageNum=1">首页</a></span>
		</li>
		<li>
			<span><a href="<%=path %>/goAddAction">人员添加</a></span>
		</li>
		
		<li>
			<span><a href="<%=path %>/goQueryAction">查询</a></span>
		</li>
		
		<li>
			<span><a href="<%=path %>/goFileUpAction">数据导入</a></span>
		</li>
		<li>
			<span><a href="<%=path %>/checkLogAction">日志查看</a></span>
		</li>
		<li>
			<span><a href="<%=path %>/backupAction">数据备份</a></span>
		</li>
		
	</ul>
</div>
