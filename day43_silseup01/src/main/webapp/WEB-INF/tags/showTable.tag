<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name = "border" %>

<%-- 

v는 forEach안에서 선언이 되는것임. 외부에서 안가져옴;
	↓↓↓↓↓ 필요 없음 
	
<%@ attribute name = "v" %>
<%@ attribute name = "num" %>
<%@ attribute name = "title" %>
<%@ attribute name = "writer" %>

↓↓↓↓↓ 필요 없음 
<%@ attribute name = "datas" %> //ctrl에서 foward로 넘어옴 (데이타 정보 유지)


ctrl에서 어떤 값이 넘어오는지 어떤 타입인지

--%>

<table border="${border}">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th>
	</tr>
	<%-- 
	for(BoardVO v : datas){ //datas안에는 BoardVO의 객체들이 들어있기 때문에
							//BoardVO 타입의 저장소(v)로 받아야함
							//ArrayList<BoardVO> <<--이걸로 못받음
	}
	--%>
	
	<c:forEach var="v" items="${datas}"> <!--  -->
		<tr> <!-- xxx.getAttribute() / request.getParameter() 는 param.어쩌구 -->
		<td><a href="controller.jsp?action=board&num=${v.num}">${v.num}</a></td>
		<td>${v.title}</td>
		<td>${v.writer}</td>
	</tr>
	</c:forEach>

</table>












