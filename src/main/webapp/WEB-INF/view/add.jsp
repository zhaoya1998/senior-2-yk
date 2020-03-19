<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/index_work.css" />
<link href="<%=request.getContextPath()%>/css/index_work.css"
	rel="stylesheet">
<!-- 引入样式 -->
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	function add() {
		var formData = new FormData($("#form1")[0]);
		$.ajax({
			type : "post",
			url : "/add",
			data : formData,
			processData : false,
			contentType : false,
			success : function(flag) {
				if (flag) {
					alert("添加成功");
					location.href = "/list";
				} else {
					alert("添加失败");
					return;
				}
			}
		})
	}

	$(
			function() {
				$.get("/getTypeList", function(list) {
					for ( var i in list) {
						$("#tid").append(
								"<option value='"+list[i].tid+"'>"
										+ list[i].tname + "</option>")
					}
				})
			})
			
			/* $(function () {
				$("#aa").blur(function(){
					//验证类型非空 失去焦点事件
					var ck=true;
			           var cname= $(this).val().length;
			           if(cname<1)
			           {
			               alert("不能为空");
			               ck=false;
			           }
			           if(!ck)
			           {
			            $(this).next(".cname").css("color","Red");
			           }     
				} 
			}); */
</script>
</head>
<body>
	<form action="/add" method="post" id="form1">
		<table class="table" align="center">
			<tr>
				<td align="center">车型:<input type="text" name="cname" id="aa"></td>
			</tr>
			<tr>
				<td align="center">类型:<input type="radio" name="status"
					value="非进口">非进口 <input type="radio" name="status"
					value="进口">进口
				</td>
			</tr>
			<tr>
				<td align="center">汽车类型: <select name="tid" id="tid">
						<option value="请选择">请选择</option>
				</select> 
				</td>
			</tr>
			<tr>
				<td align="center">上市日期:<input type="text" name="date"
					onclick="WdatePicker()"></td>
			</tr>
			<tr>
				<td align="center">价格:<input type="text" name="price" class="bb"></td>
			</tr>
			<tr>
				<td align="center">上传图片:<input type="file" name="file"></td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="增加"
					onclick="add()"></td>
			</tr>
		</table>
	</form>
</body>
</html>