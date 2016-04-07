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

		<title>My JSP 'fileAdd.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="css/left.css">
		<link rel="stylesheet" type="text/css" href="css/head.css">
		<link rel="stylesheet" type="text/css" href="css/foot.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/middle.css">

		<script type="text/javascript" src="js/jQuery.js"></script>



		<script type="text/javascript">
		$(document).ready(function() {
	

	$("#sub").click(function(){
		var file_type = $("#file_type").val();
		if(file_type == "0"){
			alert("请选择上传的文档类型");
			return false;
		}else{
		
		var path = "D:\\Study\\tomcat-6.0.39\\webapps\\RetiressFileManagement\\pdf\\";
		var idnumber = $("#id_inp").val();
		
		var fpath =path+idnumber+"_"+file_type+".pdf";
		alert(fpath);
			
			document.getElementById('scaner1').saveAllToFile(fpath);
 				 return true;
		}
		
  		
	})					
});
		</script>

	</head>

	<body>
		<div>
			<div class="logo">
				<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
			</div>
			<div class="middle" style="height: 530px;">
				<div class="left" style="height: 530px;">
					<jsp:include page="/WEB-INF/left.jsp"></jsp:include>
				</div>
				<div class="right" style="height: 530px;">
				<input type="hidden" value="${requestScope.user.idnumber }" id="id_inp">
					<form action="" method="post">
						<table>
							<thead>
								<tr>
									<td colspan="2" align="center">
										档案添加
									</td>
									<td>
										<input type="hidden" name="user_id"
											value="${requestScope.user.id}" />

									</td>
								</tr>

								<tr>
									<td>
										<span>姓名：</span><span><c:out
												value="${requestScope.user.realname }"></c:out> </span>
									</td>
									<td>
										<span>身份证号：</span><span id="idnumber"><c:out
												value="${requestScope.user.idnumber }"></c:out> </span>
									</td>
								</tr>

							</thead>
							<!-- 		<tr>
								<td>履历材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>自传材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>鉴定考核考察材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>学历职称培训材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>政审材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>党团材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>先进个人，模范事迹材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>处分材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>工资任免，出国材料：</td>
								<td><input type="file"/></td>
							</tr>
							<tr>
								<td>其他材料：</td>
								<td><input type="file"/></td>
							</tr>
							
							 -->


















						</table>

					</form>
					<form action="<%=basePath%>/dangAnAddAction" name="form1" id="form1" method="post">
					<input type="hidden" name="user_id"
											value="${requestScope.user.id}" />
					<select id="file_type" name="file_type">
						<option value="0">
							选择扫描的文档类型
						</option>
						<option value="record_file">
							履历材料
						</option>
						<option value="autobio_file">
							自传材料
						</option>
						<option value="identify_file">
							鉴定考核考察材料
						</option>
						<option value="degree_file">
							学历职称培训材料
						</option>
						<option value="politicalexam_file">
							政审材料
						</option>
						<option value="party_file">
							党团材料
						</option>
						<option value="advanceper_file">
							先进个人，模范事迹材料
						</option>
						<option value="punish_file">
							处分材料
						</option>
						<option value="workaboard_file">
							工资任免，出国材料
						</option>
						<option value="other_file">
							其他材料
						</option>
					</select>
					<object classid="clsid:15D142CD-E529-4B01-9D62-22C9A6C00E9B"
						id="scaner1" width="100%" height="430"
						codebase="./cabs/ScanOnWeb.cab#version=1,0,0,1">
						<param name="Visible" value="0">
						<param name="AutoScroll" value="0">
						<param name="AutoSize" value="0">
						<param name="AxBorderStyle" value="1">
						<param name="Caption" value="scaner">
						<param name="Color" value="4278190095">
						<param name="Font" value="宋体">
						<param name="KeyPreview" value="0">
						<param name="PixelsPerInch" value="96">
						<param name="PrintScale" value="1">
						<param name="Scaled" value="-1">
						<param name="DropTarget" value="0">
						<param name="HelpFile" value>
						<param name="PopupMode" value="0">
						<param name="ScreenSnap" value="0">
						<param name="SnapBuffer" value="10">
						<param name="DockSite" value="0">
						<param name="DoubleBuffered" value="0">
						<param name="ParentDoubleBuffered" value="0">
						<param name="UseDockManager" value="0">
						<param name="Enabled" value="-1">
						<param name="AlignWithMargins" value="0">
						<param name="ParentCustomHint" value="-1">
					</object>
					
						<input type="submit" value="上传扫描结果" id="sub" />
					</form>
					<span id="path" style="display: none;"><%=basePath%></span>
				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
