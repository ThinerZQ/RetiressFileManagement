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
		<script type="text/javascript" src="js/loadadmin.js"></script>	

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
					 <span>日志查看</span><br>
					
					 <span>当前时间：<%=(new java.util.Date()).toLocaleString()%></span>
					 <form action="<%=path %>/queryLogAction" method="post">
					 	操作者：<select id="operator" name="operator">
						    		<option value="0">-请选择操作者-</option>
						   		</select>
						 操作时间：<select id="year" name="year">
						    		<option value="00">-年-</option>
						    		<option value="2011">2011</option>
						    		<option value="2012">2012</option>
						    		<option value="2013">2013</option>
						    		<option value="2014">2014</option>
						    		<option value="2015">2015</option>
						    		<option value="2016">2016</option>
						    		<option value="2017">2017</option>
						   		  </select>
						   		  <select id="month" name="month">
						    		<option value="00">-月-</option>
						    		<option value="01">1</option>
						    		<option value="02">2</option>
						    		<option value="03">3</option>
						    		<option value="04">4</option>
						    		<option value="05">5</option>
						    		<option value="06">6</option>
						    		<option value="07">7</option>
						    		<option value="08">8</option>
						    		<option value="09">9</option>
						    		<option value="10">10</option>
						    		<option value="11">11</option>
						    		<option value="12">12</option>
						   		  </select>
						   		  <select id="day" name="day">
						    		<option value="00">-日-</option>
						    		<option value="01">1</option>
						    		<option value="02">2</option>
						    		<option value="03">3</option>
						    		<option value="04">4</option>
						    		<option value="05">5</option>
						    		<option value="06">6</option>
						    		<option value="07">7</option>
						    		<option value="08">8</option>
						    		<option value="09">9</option>
						    		<option value="10">10</option>
						    		<option value="11">11</option>
						    		<option value="12">12</option>
						    		<option value="13">13</option>
						    		<option value="14">14</option>
						    		<option value="15">15</option>
						    		<option value="16">16</option>
						    		<option value="17">17</option>
						    		<option value="18">18</option>
						    		<option value="19">19</option>
						    		<option value="20">20</option>
						    		<option value="21">21</option>
						    		<option value="22">22</option>
						    		<option value="23">23</option>
						    		<option value="24">24</option>
						    		<option value="25">25</option>
						    		<option value="26">26</option>
						    		<option value="27">27</option>
						    		<option value="28">28</option>
						    		<option value="29">29</option>
						    		<option value="30">30</option>
						    		<option value="31">31</option>
						   		  </select>
						 <br/>
						 操作类型：<select id="type" name="type">
						    		<option value="0">--请选择操作类型--</option>
						    		<option value="添加用户">添加用户</option>
						    		<option value="添加档案">添加档案</option>
						    		<option value="修改">修改</option>
						    		<option value="查询">查询</option>
						    		<option value="登录">登录</option>
						    		<option value="Excel下载">Excel下载</option>
						    		<option value="导入Exel">导入Exel</option>
						    		<option value="数据备份">数据备份</option>
						   		  </select>
						 
						
						 
						 <input type="submit" value="确定">
					 </form>
					 </center>
					 <table border="solid 1px" >
					 	<tr>
					 		<td>操作者</td>
					 		<td>操作时间</td>
					 		<td>操作类型</td>
					 		<td>操作对象</td>
					 		<td width="200px;">备注</td>
					 		
					 		
					 	</tr>
					 	<c:forEach items="${loglist }" var="log" varStatus="s" >
							<tr>
								<td><c:out value="${log.operator }"></c:out></td>
								<td><c:out value="${log.time }"></c:out></td>
								<td><c:out value="${log.type }"></c:out></td>
								<td><a href="<%=path %>/detailInfoAction?uid=${operlist[s.index].id }"><c:out value="${operlist[s.index].realname }"></c:out></a></td>
								<td>&nbsp;<c:out value="${log.remark }"></c:out></td>
								
								
								
							</tr>
						</c:forEach>	
						<tr>
							<td colspan="6">
								<a href="<%=path%>/fenYeQueryLogAction?pageNum=1">首页</a><a
									href="<%=path%>/fenYeQueryLogAction?pageNum=${pageNowq }">上一页</a><a
									href="<%=path%>/fenyeQueryLogAction?pageNum=${pageNow }">${pageNow }</a>
								<a href="<%=path%>/fenYeQueryLogAction?pageNum=${pageNowh }">下一页</a><a href="fenYeQueryLogAction?pageNum=${lastPage }">尾页</a>
								<form action="<%=path%>/fenYeQueryLogAction" style="display: inline">
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
