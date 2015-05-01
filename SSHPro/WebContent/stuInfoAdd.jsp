<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>洛天工作室</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	function addBtn(){
		$addBtn = $("input[name=addBtn]");
		$addBtn.bind("click", function(){
			$(".ErrorStyle").empty();
			var flag = true;
			if($.trim($("#stuId").val())=="")
			{
				$("#stuIdError").text("学号不能为空");
				flag = false;
			}
			if($.trim($("#stuName").val())=="")
			{
				$("#stuNameError").text("姓名不能为空");
				flag = false;
			}
			if($.trim($("#stuCellPhone").val())=="")
			{
				$("#stuCellPhoneError").text("联系电话不能为空");
				flag = false;
			}
			if($.trim($("#stuAddress").val())=="")
			{
				$("#stuAddressError").text("家庭住址不能为空");
				flag = false;
			}
			if(flag)
			{
				$("#form1").submit();
			}
		});
	}
	$(function() {
	addBtn();
	});
</script>
<style type="text/css">
	.ErrorStyle{
		color:red;
	}
</style>
</head>
<body>
<form action="stuInfoAddSuc.action" method="post" id="form1">
	<table>
		<tr>
			<th>学号：</th><td> <input type="text" id="stuId" name="stuInfo.stuId" value='<s:property value="stuId" />' readonly="readonly" > </td><td><span id="stuIdError" class="ErrorStyle"></span></td>
		</tr>
		<tr>
			<th>姓名：</th><td> <input type="text" id="stuName" name="stuInfo.stuName" > </td><td><span id="stuNameError" class="ErrorStyle"></span></td>
		</tr>
		<tr>
			<th>联系电话：</th><td> <input type="text" id="stuCellPhone" name="stuInfo.stuCellPhone" > </td><td><span id="stuCellPhoneError" class="ErrorStyle"></span></td>
		</tr>
		<tr>
			<th>家庭住址：</th><td> <input type="text" id="stuAddress" name="stuInfo.stuAddress" > </td><td><span id="stuAddressError" class="ErrorStyle"></span></td>
		</tr>
	</table>
	  <input type="button" name="addBtn" value="添加">  
</form>
</body>
</html>