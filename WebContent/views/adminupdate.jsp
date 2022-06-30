<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>

<div class="logout">
	<form action="${pageContext.request.contextPath}/AdminController"
		method="post">

		<p class="text">

			<input type="submit" value="商品登録" class="adminbtn" name="admin">
			<input type="submit" value="商品更新" class="adminbtn" name="admin">
			<input type="submit" value="商品削除" class="adminbtn" name="admin">
			<br>
		</p>
	</form>

	<br>
	<p class="text">更新する商品の番号を入力してください。</p>
	<br>
	<p class="text">${msg}</p>
	<br>
	<form
		action="${pageContext.request.contextPath}/AdminProductController"
		method="post">
		<p class="text">
			商品番号 <input type="text" name="product_num" value="${product_num}">
			<input type="submit" value="検索" class="loginbtn" name="form">
			<input type="hidden" value="更新" name="se">
		</p>
		<br>

		<p class="text">
			商品名 <input type="text" name="product_name" value="${b.product_name}">
		</p>
		<br>
		<p class="text">
			商品説明
			<textarea name="description" rows="4" cols="40">${b.description}</textarea>
		</p>
		<br>
		<p class="text">
			価格 <input type="text" name="product_price" value="${b.product_price}">円
		</p>
		<br>


		<p class="text">
			グループ <select name="product_gr">
				<option value=""></option>
				<option value="洗顔">洗顔</option>
				<option value="化粧水">化粧水</option>
				<option value="乳液">乳液</option>
				<option value="下地">下地</option>
				<option value="ファンデーション">ファンデーション</option>
				<option value="BB・CCクリーム">BB・CCクリーム</option>
				<option value="コンシーラー">コンシーラー</option>
				<c:if test="${not empty b.product_gr}">
					<option value="${b.product_gr}" selected="selected">${b.product_gr}</option>
				</c:if>
			</select>
		</p>
		<br> <br> <input type="submit" value="戻る" class="adminbtn"
			name="form"> <input type="reset" value="リセット"
			class="adminbtn"> <input type="submit" class="adminbtn"
			value="更新" name="form" onClick="return Confirm()">


	</form>
</div>


<%@include file="footer.html"%>