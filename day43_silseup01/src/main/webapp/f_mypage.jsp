<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.MemberVO" %>
     <%@ taglib tagdir="/WEB-INF/tags" prefix="jin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
	function remove(){
		var ans=confirm("정말로 탈퇴하시겠습니까???");
		if(ans==true){
			document.form.action.value='deleteMember';
			document.form.submit();
		}
	}
</script>

<b><jin:fMyPage/></b>

</body>
</html>