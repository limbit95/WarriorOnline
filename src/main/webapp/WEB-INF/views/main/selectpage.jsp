<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐릭터 선택</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	
	<main>
	
		<c:choose>
		
			<c:when test="${empty warriorList}">
				
				<h2>생성된 캐릭터가 없습니다</h2>
				
				<a href="/create" class="insert-btn">캐릭터 생성하기</a>
				<a href="/" class="insert-btn">메인메뉴로 돌아가기</a>
				
			</c:when>
			
			<c:otherwise>
			
				<table>
					<c:forEach var="warrior" items="${warriorList}">
						<tr>
							<td>${warrior.warriorName}</td>
							<td>[Level ${warrior.level}]</td>
							<td>${warrior.createDate}</td>
							<td><a href="/gamestart?warriorNo=${warrior.warriorNo}" class="insert-btn">선택</a></td>
							<td><a href="/delete?warriorNo=${warrior.warriorNo}" class="logout-btn" 
							onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a></td>
						</tr>
						
						<tr><br></tr>
					</c:forEach>
					
				</table>
				
				<a href="/create" class="insert-btn">캐릭터 생성하기</a>
				<a href="/" class="insert-btn">메인메뉴로 돌아가기</a>
			
			</c:otherwise>
		
		</c:choose>
		
		${test}
	
	</main>
	
	<c:if test="${not empty sessionScope.message2}">
		<script>
			// EL/JSTL 구문이 자바스크립트보다 먼저 해석되는데
			// 문자열이 들어가 있는 데이터의 경우
			// 따옴표가 없는 상태이니 붙여줘야한다
			alert('${message2}');
		</script>
		
		<c:remove var="message2" scope="session"/>
	</c:if>
	
</body>
</html>