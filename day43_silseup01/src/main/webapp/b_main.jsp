<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BoardVO,java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="jin" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

<script type="text/javascript">
	function check(){
		var ans=prompt('비밀번호를 입력하세요.');
		location.href='controller.jsp?action=mypage&mpw='+ans;
	}
</script>
	
	<b> <jin:login/> </b>

<hr>
	<b> <jin:showTable border="1"/></b>
<br>
		

</body>
</html>