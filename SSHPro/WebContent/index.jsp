<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>洛天工作室</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	function AddStu() {
		$("input[name=AddStu]").bind("click", function() {
			$.ajax({
				type : "post",
				url : "stuIdJudge.action",
				dataType : "json",
				data : {
					stuId : $("input[name=stuId]").val()
				},
				success : function(data) {
					var d = eval("(" + data + ")");
					if (d.intJudge == -1) {
						alert("输入不合法，只能输入数字");
					} else if (d.intJudge == 0) {
						$("#form1").attr("action", "stuInfoAdd.action");
						$("#form1").submit();
					} else {
						alert("此学号已存在，请重新输入");
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！");
				}
			});
		});
	}
	function EditStu(){
		$EditStu = $("input[name=EditStu]");
		$EditStu.bind("click", function(){
			$.ajax({
				type : "post",
				url : "stuIdJudge.action",
				dataType : "json",
				data : {
					stuId : $("input[name=stuId]").val()
				},
				success : function(data) {
					var d = eval("(" + data + ")");
					if (d.intJudge == -1) {
						alert("输入不合法，只能输入数字");
					} else if (d.intJudge == 0) {
						alert("此学号不存在，请重新输入");
					} else {
						$("#form1").attr("action", "stuInfoModify.action");
						$("#form1").submit();
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！");
				}
			});
		});
	}
	function DelStu(){
		$DelStu = $("input[name=DelStu]");
		$DelStu.bind("click", function(){
			$.ajax({
				type : "post",
				url : "stuIdJudge.action",
				dataType : "json",
				data : {
					stuId : $("input[name=stuId]").val()
				},
				success : function(data) {
					var d = eval("(" + data + ")");
					if (d.intJudge == -1) {
						alert("输入不合法，只能输入数字");
					} else if (d.intJudge == 0) {
						alert("此学号不存在，请重新输入");
					} else {
						$("#form1").attr("action", "stuInfoDel.action");
						$("#form1").submit();
					}
				},
				error : function() {
					alert("系统异常，请稍后重试！");
				}
			});
		});
	}
	$(function() {
		AddStu();
		EditStu();
		DelStu();
	});
</script>
</head>
<body>
	<form action="" method="get" id="form1">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="stuId"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" name="AddStu" value="追加">
					<input type="button" name="EditStu" value="编辑"> <input
					type="button" name="DelStu" value="删除"></td>
			</tr>
		</table>
	</form>
	<s:if test="#session['addSucFlag']">
		<div style="color:red">添加成功</div>
	</s:if>
	<s:set name="addSucFlag" value="false" scope="session"></s:set>
	<s:if test="#session['modifySucFlag']">
		<div style="color:red">修改成功</div>
	</s:if>
	<s:set name="modifySucFlag" value="false" scope="session"></s:set>
	<s:if test="#session['delSucFlag']">
		<div style="color:red">删除成功</div>
	</s:if>
	<s:set name="delSucFlag" value="false" scope="session"></s:set>
</body>
</html>
