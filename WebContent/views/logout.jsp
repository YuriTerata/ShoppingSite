<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>



<div class="logout">
	<form action="${pageContext.request.contextPath}/LoginController"
		method="post">

		<p class="text">ようこそ、${member_id}さん！</p>
		<br>

		<p class="text">
			<br>  <input type="submit" value="更新"
				class="loginbtn" name="menu"> <input type="submit" id="save"
				value="ログアウト" class="loginbtn" name="menu"
				onClick="return Confirm()"> <span id="saveResult"></span> <input
				type="submit" value="削除" class="loginbtn" name="menu">
		</p>
	</form>

	<c:if test="${admin=='管理者'}">
		<form action="${pageContext.request.contextPath}/SubMenuController"
			method="post">
			<p>
				<input type="submit" value="商品入れ替え" class="loginbtn" name="submenu">
			</p>
		</form>
	</c:if>


</div>

<%@include file="footer.html"%>