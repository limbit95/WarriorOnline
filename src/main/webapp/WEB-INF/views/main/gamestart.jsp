<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 시작 메인 페이지</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

	<main>
		
		<h1>${sessionScope.selectwarrior.warriorName}님 환영합니다!!!</h1>
		
		<table>
		
			<a href="/dungeon" class="insert-btn">던전 입장</a>
			
			<a href="" class="insert-btn">무기 상점 (구현못함)</a>
			
			<a href="" class="insert-btn">물약 상점 (구현못함)</a>
			
			<a href="/statusview" class="insert-btn">캐릭터 상태</a>

			<a href="/gamestart?save=save" class="logout-btn" onclick="return confirm('게임을 저장하시겠습니까?');">게임 저장</a>
			
			<a href="/selectpage" class="logout-btn" 
				onclick="return confirm('정말 게임을 종료하시겠습니까? \n저장하지 않은 데이터는 손실됩니다!');">게임 종료</a>
			
		</table>
		
	</main>

</body>
</html>