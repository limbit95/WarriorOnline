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
				${i.index+1}. ${weapon.weaponName}[${weapon.avalLevel}레벨] 공격력+${weapon.weaponAttack} / ${weapon.price}골드  
				<a href="/weaponinventory?equip=${weapon.weaponNo}" onclick="return confirm('선택한 무기를 장착하시겠습니까?');" class="insert-btn">장착</a>
				<a href="/weaponinventory?sell=${weapon.weaponNo}" onclick="return confirm('선택한 무기를 판매하시겠습니까?');" class="logout-btn">판매</a>
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
	
	<c:if test="${not empty sessionScope.weaponchangemessage}">
		<script>
			// EL/JSTL 구문이 자바스크립트보다 먼저 해석되는데
			// 문자열이 들어가 있는 데이터의 경우
			// 따옴표가 없는 상태이니 붙여줘야한다
			alert('${weaponchangemessage}');
		</script>
		
		<c:remove var="weaponchangemessage" scope="session"/>
	</c:if>
	
</body>
</html>