<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐릭터 생성 페이지</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	
	<main>
		
		<h1>캐릭터 생성</h1>
		
		<form action="/create" method="post" class="signup-form" onsubmit="return validate()">
			<p>이름</p>
			<input type="text" name="warriorName" id="warriorName" autocomplete="off" required>
			<span id="idMsg">한글, 영어 대/소문자, 숫자 2~10글자(특수문자 제외)</span>
			
			<br>
			
			<button>생성하기</button>
		</form>
		
	</main>
	
	<script src="/resources/js/create.js"></script>
</body>
</html>