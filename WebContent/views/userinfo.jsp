<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.html"%>


<form action="${pageContext.request.contextPath}/PurchaseController"
	method="post">

	<div>
		<h3>購入方法</h3>

		<label>
			<p>
				<input class="js-check" type="radio" name="rs" value="銀行振込"
					onclick="formSwitch()">銀行振込
			</p>
		</label> <label>
			<p>
				<input class="js-check" type="radio" name="rs" value="コンビニ振込"
					onclick="formSwitch()">コンビニ振込
			</p>
		</label> <label>
			<p>
				<input class="js-check" type="radio" name="rs" value="クレジットカード"
					onclick="formSwitch()">クレジットカード
			</p>
		</label> <span id="sample">
			<p>
				カード番号 <input type="text" name="othertext" value="" size="20"><br>
				有効期限 <select name="year">
					<option value=""></option>
					<c:forEach var="i" begin="2022" end="2030">
						<option value="${i}">${i}</option>年
				</c:forEach>
				</select> <select name="month">
					<option value=""></option>
					<c:forEach var="i" begin="1" end="12">
						<option value="${i}">${i}</option>月
				</c:forEach>
				</select><br> セキュリティコード <input type="text" name="othertext" value=""
					size="16">
		</span>
	</div>
	<button type="submit" name="menu" class="loginbtn" value="戻る">戻る</button>

	<button type="submit" name="menu" class="loginbtn" value="購入"
		onClick="return Confirm()">購入</button>

</form>



<%@include file="footer.html"%>