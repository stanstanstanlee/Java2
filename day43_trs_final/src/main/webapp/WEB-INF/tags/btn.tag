<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty mid}">
	<a href='controller.jsp?action=insertBoardPage'><jsp:doBody /></a>
</c:if>