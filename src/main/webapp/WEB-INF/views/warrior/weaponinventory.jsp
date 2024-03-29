<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무기 인벤토리 페이지</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	
	<main>
		
		<table>
			
			<h1 style="font-size: 45px;">*** ${selectwarrior.warriorName}님의 무기 인벤토리 ***</h1>
			
			<c:if test="${not empty weaponList}">
				<c:forEach var="weapon" items="${weaponList}" varStatus="i">
				
				<h2>
				<a style="text-decoration-line: none; color: black;
				hover {text-decoration: underline; color: rgb(157, 120, 120);}"
				href="/weaponinventory?weaponNo=${weapon.weaponNo}" onclick="return confirm('선택한 무기를 장착하시겠습니까?');">
				${i.index+1} . ${weapon.weaponName}[공격력+${weapon.weaponAttack}] 사용 가능 레벨[${weapon.avalLevel}] / ${weapon.price}골드
				</a>
				</h2>
				
				<br>
				
				</c:forEach>
			</c:if>	
			
			<c:if test="${empty weaponList}">
				<h1>보유한 무기가 없습니다!!!</h1>
			</c:if>			
			
			<br>
			
			<a href="/statusview" class="logout-btn">이전 메뉴로 돌아가기</a>
			
		</table>
		
	</main>
	
</body>
</html>