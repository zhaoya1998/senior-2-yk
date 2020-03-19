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
	location.href="add"
}
   function look(cid) {
	location.href="look?cid="+cid
}
   function update(cid) {
	location.href="toUpdate?cid="+cid
}
</script>
</head>
<body>
	<h1 align="center">汽车大全</h1>
	<form action="list" method="post">
		车型:<input type="text" name="cname" value="${vo.cname }"> 上市日期:<input
			type="text" name="startDate" value="${vo.startDate }"> 到<input
			type="text" name="endDate" value="${vo.endDate }">
			价格:<input
			type="text" name="startPrice" value="${vo.startPrice }"> 到<input
			type="text" name="endPrice" value="${vo.endPrice }">
			
			类型:<select name="status">
						<option value="进口">进口</option>
						<option value="非进口">非进口</option>
						<option value="所有">所有</option>
				</select>
			<input
			type="submit" value="查询"><input type="button" value="增加"
			onclick="add()">
	</form>
	<table align="center">
		<div class="container" style="float: left" align="center">
			<c:forEach items="${info.list }" var="c">
				<div style="float: left">
					<hr>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					汽车名称:${c.cname
					}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<br>
					价格:${c.price }&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<br> 日期:${c.date }&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<br> <input type="button" value="详情" onclick="look(${c.cid})">
					<input type="button" value="修改" onclick="update(${c.cid})">
				</div>
			</c:forEach>
		</div>

		<div style="clear: both">

			<tr>
				<br>
				<td colspan="10">当前共${info.pageNum }/${info.pages }页--共${info.total }条数据
					<a href="list?pageNum=1">首页</a> <a
					href="list?pageNum=${info.prePage }">上一页</a> <a
					href="list?pageNum=${info.nextPage }">下一页</a> <a
					href="list?pageNum=${info.pages }">尾页</a>
				</td>
			</tr>
	</table>
	</div>
</body>
</html>