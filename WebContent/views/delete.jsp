<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>



<div class="update">
	<form
		action="${pageContext.request.contextPath}/UpdateDeleteController"
		method="post">

		<h2 class="rstitle">会員情報削除</h2>


		<p>${msg}</p>


		<br>
		<p class="text">
			■ID<br> <input type="text" name="member_id" value="${member_id}"
				readonly="readonly"> <input type="submit" value="検索"
				class="loginbtn" name="menu"><input type="hidden" value="削除"
				name="se">
		</p>
		<br>

		<p class="text">
			■名前<br> 姓 <input type="text" name="last_name"
				value="${bean.last_name}"> 名 <input type="text"
				name="first_name" value="${bean.first_name}">
		</p>
		<br>

		<p class="text">
			■メールアドレス<br> <input type="text" name="mail_address"
				value="${bean.mail_address}">
		</p>
		<br>

		<p class="text">
			■電話番号<br> <input type="tel" name="phone_number"
				value="${bean.phone_number}">
		</p>
		<br>

		<p class="text">
			■生年月日<br> <select name="birth_year">
				<option value=""></option>
				<c:forEach var="i" begin="1920" end="2020">
					<option value="${i}">${i}</option>
				</c:forEach>
				<c:if test="${not empty bean.birth_year}">
					<option value="${bean.birth_year}" selected>${bean.birth_year}</option>
				</c:if>
			</select>年 <select name="birth_month">
				<option value=""></option>
				<c:forEach var="i" begin="1" end="12">
					<option value="${i}">${i}</option>
				</c:forEach>
				<c:if test="${not empty bean.birth_month}">
					<option value="${bean.birth_month}" selected>${bean.birth_month}</option>
				</c:if>
			</select>月 <select name="birth_day">
				<option value=""></option>
				<c:forEach var="i" begin="1" end="31">
					<option value="${i}">${i}</option>
				</c:forEach>
				<c:if test="${not empty bean.birth_day}">
					<option value="${bean.birth_day}" selected>${bean.birth_day}</option>
				</c:if>
			</select>日
		</p>
		<br>

		<p class="text">
			■郵便番号（ハイフンなし）<br> <input type="text" name="postal_code"
				value="${bean.postal_code}">
		</p>
		<br>

		<p class="text">
			■都道府県<br> <input type="text" name="prefectures"
				value="${bean.prefectures}">
		</p>
		<br>

		<p class="text">
			■市区町村・番地<br> <input type="text" name="address"
				value="${bean.address}">
		</p>
		<br>

		<p class="text">
			■建物名<br> <input type="text" name="building"
				value="${bean.building}">
		</p>
		<br>

		<p class="text">
			■パスワード<br> <input type="password" name="password"
				value="${bean.password}">
		</p>
		<br>


		<section class=regist>
			<button type="submit" name="menu" class="loginbtn" value="戻る">戻る</button>
			<button type="reset" class="loginbtn">リセット</button>
			<button type="submit" name="menu" class="loginbtn" value="削除"
				onClick="return Confirm()">削除</button>
		</section>

	</form>
</div>

<%@include file="footer.html"%>