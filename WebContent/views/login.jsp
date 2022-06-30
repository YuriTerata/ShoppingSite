<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>



<div class="login">
	<form action="${pageContext.request.contextPath}/LoginController"
		method="post">

		<p>${msg}</p>
		<br>

		<p class="text">
			■ID<br> <input type="text" name="member_id" value="${member_id}">
		</p>
		<br>
		<p class="text">
			■パスワード<br> <input type="password" name="password">
		</p>
		<p>
			<input type="submit" value="ログイン" class="loginbtn" name="menu">

		</p>

		<p>
			<br> <input type="submit" value="新規会員登録はこちら" class="loginbtn"
				name="menu">


		</p>

	</form>
</div>

<%@include file="footer.html"%>