<%@ tag language="java" pageEncoding="UTF-8"%>

<!-- 변수가 생겼으니 EL식을 쓸 수 있음 -->
<!-- 헷갈리니까 이름을 동일 하게 써줌 -->
<%@ attribute name = "border" %>
<%@ attribute name = "bgcolor" %> 

<jsp:useBean id="pb" class="test.ProductBean"/>
<h1><jsp:doBody/> </h1> <!-- 태그 바디에 있는 내용을 불러올 수 있어야함 -->
<hr>
<table border="${border}" bgcolor="${bgcolor}">
	<% for(String v : pb.getPdatas()){ %>
	<tr><td><%=v %></td></tr>
	<% } %>
</table>
