<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<%
    String path = request.getContextPath();

    String basePath = request.getScheme() + "://"

           + request.getServerName() + ":" + request.getServerPort()

           + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

    <head>

       <base href="<%=basePath%>">

       <title>My JSP 'tagUpload.jsp' starting page</title>

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
	  <h3>多个文件上传实例</h3>
       <form action="<%=path %>/fileUp" enctype="multipart/form-data" method="post">
          
           上传名称<input name="name"/>
           <input type="file" name="upload" accept="image/gif, image/jpeg"/>
           <input type="file" name="upload" accept="image/gif, image/jpeg"/>
           <input type="file" name="upload" accept="image/gif, image/jpeg"/>
          	<input type="submit" value="上传"/>
           
       </form>
    </body>
</html>