<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="lb" class="test.LoginBean"/>
    <jsp:setProperty property="*" name="lb" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작화면</title>
</head>
<body>
<% lb.login(); %>

<form method="post">
   <input type="text" name="mid" placeholder="아이디" required> <br>
   <input type="password" name="mpw" placeholder="비밀번호" required> <br>
   <input type="submit" value="로그인">
</form>


<%= lb.getResult() %>
</body>
</html>