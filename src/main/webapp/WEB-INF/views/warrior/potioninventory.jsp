<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물약 인벤토리 페이지</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	
	<main>
		
		<table>
			
			<h1 style="font-size: 45px;">*** ${selectwarrior.warriorName}님의 물약 인벤토리 ***</h1>
			
			<c:if test="${not empty potionList}">
				<c:forEach var="potion" items="${potionList}" varStatus="i">
				
				<h2>
				<a style="text-decoration-line: none; color: black;"
				href="/potioninventory?potionNo=${potion.potionNo}" onclick="return confirm('해당 물약을 사용하시겠습니까?');">
				${i.index+1}. ${potion.potionName}[hp+${potion.heal}] / ${potion.quantity}개
				</a>
				</h2>
				
				<br>
				
				</c:forEach>
			</c:if>	
			
			<c:if test="${empty potionList}">
				<h1>보유한 물약이 없습니다!!!</h1>
			</c:if>			
			
			<br>
			
			<a href="/statusview" class="logout-btn">이전 메뉴로 돌아가기</a>
			
		</table>
		
	</main>
	
	<c:if test="${not empty sessionScope.potionmessage}">
		<script>
			alert('${potionmessage}');
		</script>
		
		<c:remove var="potionmessage" scope="session"/>
	</c:if>
	
</body>
</html>