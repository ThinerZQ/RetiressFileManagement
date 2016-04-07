$(document).ready(function() {
	$("#selectall").click(function() {
		
		if ($(this).attr("checked")) { // 全选
				$("input[name='checkbox']").each(function() {
					$(this).attr("checked", true);
				});
			} else { // 取消全选
				$("input[name='checkbox']").each(function() {
					$(this).attr("checked", false);
				});
			}
		});
});
