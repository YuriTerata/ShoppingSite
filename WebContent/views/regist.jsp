<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>




<p>${error}</p>
<p>${success}</p>


<div class="regist">
	<form action="${pageContext.request.contextPath}/RegistController"
		method="post">

		<h2 class="rstitle">会員情報登録</h2>

		<p class="text">
			■ID<span class="required">*</span><br> <input type="text"
				name="member_id">
		</p>
		<br>

		<p class="text">
			■名前<span class="required">*</span><br> 姓 <input type="text"
				name="last_name" value="${last_name}"> 名 <input type="text"
				name="first_name">
		</p>
		<br>

		<p class="text">
			■メールアドレス<span class="required">*</span><br> <input type="text"
				name="mail_address">
		</p>
		<br>

		<p class="text">
			■電話番号<span class="required">*</span><br> <input type="tel"
				name="phone_number">
		</p>
		<br>

		<p class="text">
			■生年月日<span class="required">*</span><br> <select
				name="birth_year">
				<option value=""></option>
				<c:forEach var="i" begin="1920" end="2020">
					<option value="${i}">${i}</option>年
				</c:forEach>
			</select> <select name="birth_month">
				<option value=""></option>
				<c:forEach var="i" begin="1" end="12">
					<option value="${i}">${i}</option>月
				</c:forEach>
			</select> <select name="birth_day">
				<option value=""></option>
				<c:forEach var="i" begin="1" end="31">
					<option value="${i}">${i}</option>日
				</c:forEach>
			</select>
		</p>
		<br>

		<p class="text">
			■郵便番号<span class="required">*</span><br>（ハイフンなし）<br> <input
				type="text" name="postal_code">
		</p>
		<br>

		<p class="text">
			■都道府県<span class="required">*</span><br> <input type="text"
				name="prefectures">
		</p>
		<br>

		<p class="text">
			■市区町村・番地<span class="required">*</span><br> <input type="text"
				name="address">
		</p>
		<br>

		<p class="text">
			■建物名<br> <input type="text" name="building">
		</p>
		<br>

		<p class="text">
			■パスワード<span class="required">*</span><br> <input type="text"
				name="password">
		</p>
		<br>

		<section class=regi>

			<button type="submit" name="menu" class="loginbtn" value="戻る">戻る</button>

			<button type="reset" class="loginbtn">リセット</button>

			<button type="submit" id="regis" name="menu" class="loginbtn"
				value="登録" onClick="return Confirm()">登録</button>

		</section>

	</form>
</div>



<%@include file="footer.html"%>