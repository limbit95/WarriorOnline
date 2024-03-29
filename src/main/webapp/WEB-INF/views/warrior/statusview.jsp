<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐릭터 상태 조회 페이지</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	
	<main>
		
		<table>
			
			<h1 style="font-size: 45px;">*** ${selectwarrior.warriorName}님의 상태창 ***</h1>
			
			<h2>레벨 : ${selectwarrior.level} │ 경험치 : ${selectwarrior.exp}/100</h2>
			
			<h2>체력 : ${selectwarrior.hp}/${selectwarrior.maxHp}</h2>
			
			<h2>공격력 : ${selectwarrior.attack} │ 장착 무기 : ${selectwarrior.weaponName} [+${selectwarrior.weaponDamage}]</h2>
			
			<h2>스탯포인트 : ${selectwarrior.statPoint}</h2>
			
			<h2>골드 : ${selectwarrior.gold}</h2>
			
			<h2>사망여부 : 
			<c:if test="${empty deadwarrior}">생존</c:if>
			<c:if test="${not empty deadwarrior}">사망</c:if>
			</h2>
			
			<br>
			
			<a href="/addstat" class="insert-btn" >능력치 추가</a>
			
			<a href="/weaponinventory" class="insert-btn" >무기 인벤토리</a>
			
			<a href="/potioninventory" class="insert-btn" >물약 인벤토리 (구현못함)</a>
			
			<br>
			
			<a href="/gamestart?warriorNo=${selectwarrior.warriorNo}" class="logout-btn">이전 메뉴로 돌아가기</a>
			
		</table>
		
	</main>
	
</body>
</html>