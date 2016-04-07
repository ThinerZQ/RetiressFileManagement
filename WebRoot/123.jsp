<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zq.util.JspFileUpload"%>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP '123.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<div class="media">
			2
			<object width="450" height="250" attr1="attrValue1"
				attr2="attrValue2"
				3         codebase="http://www.apple.com/qtactivex/qtplugin.cab"
				4         classid="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B">
				5
				<param name="src" value="myBetterMovie.mov">
				6
				<param name="autoplay" value="true">
				7
				<param name="param1" value="paramValue1">
				8
				<param name="param2" value="paramValue2">
				9
				<embed width="450" height="250" src="myBetterMovie.mov"
					autoplay="true" 10             attr1="attrValue1"
					attr2="attrValue2" param1="paramValue1" param2="paramValue2"
					11             pluginspage="http://www.apple.com/quicktime/download/">
				</embed>
				12
			</object>
			13
		</div>


		<script type="text/javascript">
			function scan(){
			  document.getElementById('scaner1').scan();
			}
			function upload(){
			  var status=document.getElementById('scaner1').uploadAllAsTIFFormatToServer(
			  '<%=basePath%>/upload.jsp','123456','');
			  alert(status);
			}
		</script>
		<object classid="clsid:15D142CD-E529-4B01-9D62-22C9A6C00E9B"
			id="scaner1" name="scaner1" width="100%" height="600"
			codebase="../cabs/ScanOnWeb.cab#version=1,0,0,10">
		</object>
		<%
	    //初始化
	    JspFileUpload jfu = new JspFileUpload();
	    //设定request对象
	    jfu.setRequest(request);
	    //设定上传的文件路径 
	    jfu.setUploadPath(basePath+"pdf\\");
	    //上传处理
	    int rtn = jfu.process();
	    //取得form中其他input控件参数的值
	    String str = jfu.getParameter("imageCount");
	    str=jfu.getParameter("id");
	    System.out.println("客户端传递的id值:"+str);
	    //取得上传的文件的名字
	    String[] fileArr = jfu.getUpdFileNames();
	    for (int i=0;i<fileArr.length;i++){
	    	System.out.println(fileArr[i]);
	    } 
		%>
	</body>
</html>
