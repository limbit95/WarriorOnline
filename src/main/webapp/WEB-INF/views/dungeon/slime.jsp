<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Slime Dungeon</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

	<main>
		
		<c:choose>
		
			<c:when test="${empty sessionScope.slime}">
				
				<h1>몬스터가 나타났습니다!!!</h1>
				
				<h3><p>[${randomslime.slimeName} 슬라임]</p></h3>
				<h3><p>레벨 : ${randomslime.level}</p></h3>
				<h3><p>체력 : ${randomslime.hp}</p></h3>
				
				<tr>
					<td><a href="/battle?slimeno=${randomslime.slimeNo}" class="insert-btn">전투 시작</a></td>
					<td><a href="/dungeon" class="logout-btn">전투 종료</a></td>
				</tr>
				
			</c:when>
			
			<c:otherwise>
				<input id="slimeattack" value="${slime.attack}" type="hidden">
				
				<c:choose>
					<c:when test="${empty damagedslime}">
					
						<h1>${slime.slimeName} 슬라임과 전투 시작!!!</h1>
						
						<tr>
							<td><a href="/attack" class="insert-btn">공격</a></td>
							<td><a href="/giveup" class="logout-btn" 
							onclick="return giveup();">도망가기</a></td>
							<input id="warriorhp" value="${sessionScope.selectwarrior.hp}" type="hidden">
							<input id="warriormaxhp" value="${sessionScope.selectwarrior.maxHp}" type="hidden">
						</tr>	
						
					</c:when>
					
					<c:otherwise>
					
						<h1>${slime.slimeName} 슬라임과 전투 중~!!!</h1>
						
						<h2>${selectwarrior.warriorName}님이 ${slime.slimeName} 슬라임을 공격하였습니다</h2>
						<h3>${slime.slimeName} 슬라임 쳬력 : [${slime.hp}/${slime.maxHp}]</h3>
						
						<c:choose>
							<c:when test="${empty deadslime}">
								<br>
								
								<h2>${slime.slimeName} 슬라임에게 피해를 입었습니다</h2>
								<h3>${selectwarrior.warriorName} 쳬력 : [${selectwarrior.hp}/${selectwarrior.maxHp}]</h3>
								
								<tr>
									<td><a href="/attack" class="insert-btn"
									>공격</a></td>
									<td><a href="/giveup" class="logout-btn" 
									onclick="return giveup();">도망가기</a></td>
									<input id="warriorhp" value="${sessionScope.selectwarrior.hp}" type="hidden">
									<input id="warriormaxhp" value="${sessionScope.selectwarrior.maxHp}" type="hidden">
								</tr>	
							</c:when>
							
							<c:otherwise>
								<br>
								
								<h1>${slime.slimeName} 슬라임과 전투에서 승리하였습니다!!!!!</h1>
								
								<h3>경험치 ${slime.exp}이 증가하였습니다!!!</h3>
								<h3>${slime.gold}골드를 획득하였습니다!!!</h3>
								
								<br>
								
								<a href="/giveup" class="logout-btn">마을로 돌아가기</a>
							</c:otherwise>
						</c:choose>	
						
					</c:otherwise>
				</c:choose>
				
			</c:otherwise>
		
		</c:choose>
		
	</main>

	<script src="/resources/js/battle.js"></script>
</body>
</html>