<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>


<ul>

	<li class="detail"><img class="detailimg"
		src="${pageContext.request.contextPath}/img/${p.product_num}.jpg"><br>


		<p class="text">${p.product_gr}</p> <br>
		<p class="text">${p.product_name}</p> <br>
		<p class="text">${p.description}</p> <br> <span class="price">
			<p class="text">${p.product_price}円</p>
	</span><br>

		<div class="btn">

			<form action="${pageContext.request.contextPath}/CartController"
				method="post">
				<input type="hidden" value="${p.product_num}" name="product_num">


				<p>
					<br> <input type="submit" value="戻る" onclick="history.back()"
						class="cartbtn" name="cart"> <input type="submit"
						value="カート" class="cartbtn" name="cart">
				</p>

			</form>
		</div></li>



</ul>


<%@include file="footer.html"%>