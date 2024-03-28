<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Warrior Online</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

	<main>
	
		<c:choose>

			<%-- 로그인 창 --%>
			<c:when test="${empty sessionScope.loginMember}">
				<h1>Warrior Online</h1>
				
				<form action="/login" method="post" class="login-form" autocomplete="off">
					<div>
						<p>ID</p>
						<input type="text" name="inputId">
					</div>
					
					<div>
						<p>Password</p>
						<input type="password" name="inputPw">
					</div>
					
					<button>로그인</button>
					
					<a href="/signup" class="signup">회원 가입</a>
				</form>
			</c:when>
			
			<%-- 로그인 후 Warrior Online 메인페이지 --%>
			<c:otherwise>
				<table>
					<h1>${sessionScope.loginMember.memberNickname}님</h1>
					<h1>Warrior Online에</h1>
					<h1>오신걸 환영합니다!!!</h1>
					
					<a href="/selectpage" class="logout-btn">게임 시작</a> 
					
					<a href="/gameinfo" class="insert-btn">게임 설명</a> 
					
					<a href="/logout" class="logout-btn">로그아웃</a> 
				</table>
				
			</c:otherwise>
			
		</c:choose>
		
	</main>
	
	
	<c:if test="${not empty sessionScope.message}">
		<script>
			// EL/JSTL 구문이 자바스크립트보다 먼저 해석되는데
			// 문자열이 들어가 있는 데이터의 경우
			// 따옴표가 없는 상태이니 붙여줘야한다
			alert('${message}');
		</script>
		
		<c:remove var="message" scope="session"/>
	</c:if>
	
</body>
</html>