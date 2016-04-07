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

		<style type="text/css" media="screen"> 
			html, body	{ height:100%; }
			body { margin:0; padding:0; overflow:auto; }   
     </style> 
     <script type="text/javascript">
		var basePath = "<%=basePath%>";
	</script>
	<script type="text/javascript" src="js/jquery1.7.1.min.js"></script>
	<script type="text/javascript" src="js/flexpaper_flash.js"></script>


	


	</head>

	<body>
		<div>
			<div class="logo">
				<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
			</div>
			<div class="middle" style="height: 650px">
				<div class="left" style="height: 650px">
					<jsp:include page="/WEB-INF/front/left.jsp"></jsp:include>
				</div>
				<div class="right" style="height: 650px">
					<center>
						<span>查看我的档案信息</span>
						<br>
						
						<span>用户名：</span><span>${sessionScope.user_now.realname }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>身份证号：</span><span>${user.idnumber }</span>
						<input type="hidden" name="uid" value="${sessionScope.user_now.id }" id="uid"/>
						<input type="hidden" name="idnum" value="${sessionScope.user_now.idnumber }" id="idnum"/>
						<select id="file_type" name="file_type">
							<option value="0">
								选择需要查看的档案类型
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

					</center>
					
					<div style="position: absolute; left: 460px; top: 150px;">
						<a id="viewerPlaceHolder"
							style="width: 700px; height: 600px; display: block"></a>
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

	
		$(document).ready(function() {
			$("#file_type").change(function() {
			var file_type= $("#file_type").val();
			
			var idnum =$("#idnum").val();
			var uid =$("#uid").val();
			alert(file_type);
			alert(idnum);
			alert(uid);
			if(file_type !=0){
				$.ajax( {
				url : basePath + "/ajaxCheckFileTypeAction",
				type : "POST",
				dataType : "json",
				data : {
					"uid" : uid,"file_type":file_type
				},
				success : function(data) {
					if (data) {
						var path = basePath + "swf/" + data.path;
						alert(path);
						$FlexPaper().loadSwf(path);
					}
				}
			});
			}else{
				alert("请选择需要查看的档案类型");
			}
		});
	});

</script>
					</div>




				</div>
			</div>

			<div class="foot">
				<jsp:include page="/WEB-INF/foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
