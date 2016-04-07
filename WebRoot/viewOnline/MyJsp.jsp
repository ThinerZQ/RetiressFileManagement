<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>BrowsenOnline</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css" media="screen"> 
			html, body	{ height:100%; }
			body { margin:0; padding:0; overflow:auto; }   
     </style> 
     <script type="text/javascript">
		var basePath = "<%=basePath%>";
	</script>
	<script type="text/javascript" src="viewOnline/js/jquery1.7.1.min.js"></script>
	<script type="text/javascript" src="viewOnline/js/flexpaper_flash.js"></script>
	
  </head>
  
 	<body>
 		<div style="position:absolute;left:110px;top:10px;">
 			<input type="button" value="显示Paper" onclick="viewFlexPaper()"/>
 		</div>
 		<div style="position:absolute;left:110px;top:30px;">
	        <a id="viewerPlaceHolder" style="width:720px;height:600px;display:block"></a>
	         <script type="text/javascript"> 
	         var fpv = new FlexPaperViewer(	
        			 basePath + 'viewOnline/FlexPaperViewer',
					 'viewerPlaceHolder', { config : {
					 SwfFile : escape(basePath + "swf/Paper.swf"),//要浏览的swf文件
					 Scale : 0.9, // 初始化缩放比例，参数值应该是大于零的整数
					 ZoomTransition : 'easeOut',//Flexpaper中缩放样式   easenone, easeout, linear, easeoutquad
					 ZoomTime : 0.5,//从一个缩放比例变为另外一个缩放比例需要花费的时间，该参数值应该为0或更大。
					 ZoomInterval : 0.2,//缩放比例之间间隔，默认值为0.1，该值为正数。
					 FitPageOnLoad : true,// 初始化得时候自适应页面，与使用工具栏上的适应页面按钮同样的效果。
					 FitWidthOnLoad : false,//初始化的时候自适应页面宽度，与工具栏上的适应宽度按钮同样的效果。
					 FullScreenAsMaxWindow : true,//全屏
					 ProgressiveLoading : false,//当设置为true的时候，展示文档时不会加载完整个文档，而是逐步加载，但是需要将文档转化为9以上的flash版本（使用pdf2swf的时候使用-T 9 标签）。
					 MinZoomSize : 0.2,//设置最小的缩放比例。
					 MaxZoomSize :2,// 最大的缩放比例。
					 SearchMatchAll : false,//设置为true的时候，单击搜索所有符合条件的地方高亮显示。
					 InitViewMode : 'Portrait',//设置启动模式如"Portrait" or "TwoPage".
					 PrintPaperAsBitmap : false,// 以位图的形式打印页面
					 
					 ViewModeToolsVisible : false,//工具栏上是否显示样式选择框。
					 ZoomToolsVisible : true,//工具栏上是否显示缩放工具。
					 NavToolsVisible : true,//工具栏上是否显示导航工具。
					 CursorToolsVisible : true,//工具栏上是否显示光标工具。
					 SearchToolsVisible : true,//工具栏上是否显示搜索。
						
					 localeChain: 'zh_CN' //设置地区（语言）
				}});
				
	        	function viewFlexPaper(){
	        		$.ajax({
	        			url:basePath + "/onlineServlet.do",
	        			type: "POST",
	        			dataType: "json",
	        			data:{"id":500},
	        			success: function(data){
	        				if(data){
	        					var path = basePath + "swf/" + data.path;
	        					alert(path);
	        					$FlexPaper().loadSwf(path);
	        				}
	        			}
	        		});
	        	}
	        </script>
	    </div>  
 	</body>
</html>
