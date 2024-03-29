<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To Dungeon</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

	<main>
		
		<table>
		
			<h1 style="font-size: 60px;">Dungeon Stage</h1>
		
			<h2>[캐릭터 상태<c:if test="${not empty deadwarrior}"> : 사망</c:if>]
			</h2>
			
			<hr>
			<h2>레벨 : ${selectwarrior.level} / Exp[${selectwarrior.exp}/100]</h2>
			<h2>체력 : [${selectwarrior.hp}/${selectwarrior.maxHp}]</h2>
			<h2>공격력 : ${selectwarrior.attack} [+${selectwarrior.weaponDamage}]</h2>
			<h2>장착 무기 : ${selectwarrior.weaponName}</h2>
			
			
			
			<hr>
			
			<br><br>
		
			<h2>던전을 선택해주세요</h2>
			
			<a href="/slime" class="insert-btn" 
				onclick="return slime();">슬라임 던전[Level 1 ~ 5]</a>
			
			<a href="/goblin" class="insert-btn" 
				onclick="return goblin();">고블린 던전[Level 6 ~ 10]</a>
			
			<a href="/orc" class="insert-btn" 
				onclick="return orc();">오크 던전[Level 11 ~ 15]</a>
			
			<a href="/gamestart?warriorNo=${selectwarrior.warriorNo}" 
			class="logout-btn">던전 나가기</a>
			
			<%-- 선택한 캐릭터 레벨 값 --%>
			<input type="hidden" id="warriorLevel" value="${selectwarrior.level}">
			<input type="hidden" id="isAlive" value="${deadwarrior}">
			
		</table>
		
	</main>
	
	<script src="/resources/js/dungeon.js"></script>
</body>
</html>