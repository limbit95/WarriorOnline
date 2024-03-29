<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>능력치 추가 페이지</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	
	<main>
		
		<table>
			
			<h1 style="font-size: 45px;">===== [능력치 정보] =====</h1>
			
			<h2>최대 체력 : ${selectwarrior.maxHp}</h2>
			
			<h2>공격력 : ${selectwarrior.attack}</h2>
			
			<br>
			
			<h2>현재 스탯 포인트 : ${selectwarrior.statPoint}</h2>
			
			<br>
			
			<a href="/addstat?add=maxhp" class="insert-btn" onclick="return add();">최대 체력 증가 [+10]</a>
			
			<a href="/addstat?add=attack" class="insert-btn" onclick="return add();">공격력 증가 [+3]</a>
			
			<br>
			
			<a href="/statusview" class="logout-btn">이전 메뉴로 돌아가기</a>
			
		</table>
		
		<input id="statpoint" value="${selectwarrior.statPoint}" type="hidden">
		
	</main>
	
	<script src="/resources/js/add.js"></script>
</body>
</html>