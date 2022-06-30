<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>

<c:if test="${miss=='miss'}">
	<p>画面の移動に失敗しました。</p>
</c:if>

<!-- Slider main container -->
<div class="swiper">
	<!-- Additional required wrapper -->
	<div class="swiper-wrapper">
		<!-- Slides -->
		<div class="swiper-slide">
			<img src="${pageContext.request.contextPath}/img/skin1.jpg">
		</div>
		<div class="swiper-slide">
			<img src="${pageContext.request.contextPath}/img/skin2.jpg">
		</div>
		<div class="swiper-slide">
			<img src="${pageContext.request.contextPath}/img/suqqu.jpg">
		</div>



	</div>

	<div class="swiper-paginatio"></div>


	<div class="swiper-button-prev">
		<span class="allow"> <span class="material-symbols-outlined">
				arrow_circle_left </span>
		</span>
	</div>
	<div class="swiper-button-next">
		<span class="allow"> <span class="material-symbols-outlined">
				arrow_circle_right </span>
		</span>
	</div>


</div>


<%@include file="footer.html"%>