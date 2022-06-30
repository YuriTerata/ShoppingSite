<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>


<div id="column" class="column04">


	<c:if test="${title=='商品一覧'}">
		<h3>商品一覧</h3>
	</c:if>

	<c:if test="${title=='検索結果'}">
		<h3>${a}検索結果</h3>
	</c:if>

	<form action="${pageContext.request.contextPath}/AllSortController"
		method="post">
		<p class="text">
			<select name="sort">
				<option value=""></option>
				<option value="安い順">安い順</option>
				<option value="高い順">高い順</option>
			</select>
			<button type="submit" name="sort" class="loginbtn" value="並び替え">並び替え</button>
		</p>
	</form>
	<br>

	<c:if test="${result=='0件'}">
		<p class="text">該当する商品はありません</p>
	</c:if>



	<ul>
		<c:forEach var="p" items="${list}">


			<li><form
					action="${pageContext.request.contextPath}/ProductController"
					method="post">
					<input type="hidden" value="${p.product_num}" name="product_num">
					<input type="image" class="productimg" alt="${p.product_num}"
						src="${pageContext.request.contextPath}/img/${p.product_num}.jpg">
				</form>
				<form action="${pageContext.request.contextPath}/CartController"
					method="post">
					<input type="hidden" value="${p.product_num}" name="product_num">

					<p class="text">${p.product_name}</p>
					<span class="price"><p class="text">${p.product_price}円</span>


					<button type="submit" name="cart" value="カート" class="subbtn">
						<span class="sublogo"><span
							class="material-symbols-outlined"> shopping_cart </span></span>
					</button>
				</form></li>

		</c:forEach>
	</ul>
</div>


<%@include file="footer.html"%>