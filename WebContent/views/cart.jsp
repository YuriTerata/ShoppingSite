<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>



<h2>カート</h2>


<hr>

<c:choose>
	<c:when test="${cart.size()>0}">
		<p>${cart.size()}種類の商品があります。</p>
	</c:when>

	<c:otherwise>
		<p>カートに商品がありません。</p>
	</c:otherwise>
</c:choose>

<table class="cart" border="1">
	<c:forEach var="b" items="${cart}">


		<tr>
			<td><img
				src="${pageContext.request.contextPath}/img/${b.productbean.product_num}.jpg"
				height="200"></td>
			<td><p>${b.productbean.product_name}</p></td>
			<td><p>${b.productbean.product_price}円</p></td>
			<td><p>${b.count}個</p></td>


			<td>
				<form action="${pageContext.request.contextPath}/CartController"
					method="post">
					<input type="hidden" value="${b.productbean.product_num}"
						name="product_num"> <input type="submit" value="削除"
						class="loginbtn" name="cart">
				</form>
			</td>

		</tr>
	</c:forEach>
</table>
<p>
	TOTAL:
	<%=session.getAttribute("total")%>円
</p>



<form action="${pageContext.request.contextPath}/CartController"
	method="post">
	<input type="submit" value="購入" class="loginbtn" name="cart"
		onClick="return Confirm()">
</form>



<%@include file="footer.html"%>