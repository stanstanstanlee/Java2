<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BoardVO" %>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="jin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>

<script type="text/javascript">
	function delBoard(){
		var ans=confirm('정말 삭제할까요?');
		if(ans==true){
			document.form.action.value='deleteBoard';
			document.form.submit();	
		}
	}
</script>

<%
//	BoardVO data=(BoardVO)request.getAttribute("data");
//	boolean flag=data.getWriter().equals(session.getAttribute("mid"));
%>

<b> <jin:board/> </b>

</body>
</html>