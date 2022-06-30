<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>
<div id="column" class="column04">


	<p class="cartremove">
		ご購入ありがとうございました。<br> 今回の購入商品は以下の通りです。
	</p>

	<ul>
		<c:forEach var="b" items="${cart}">

			<li><img
				src="${pageContext.request.contextPath}/img/${b.productbean.product_num}.jpg"
				height="200">
				<p>${b.productbean.product_name}</p>
				<p>${b.productbean.product_price}円</p>
				<p>${b.count}個</p></li>
		</c:forEach>
	</ul>
	<br>
	<form action="${pageContext.request.contextPath}/CartController"
		method="post" class="cartremove">
		<input type="submit" value="カートから購入した商品を削除" class="loginbtn"
			name="cart">
	</form>

</div>

<%@include file="footer.html"%>