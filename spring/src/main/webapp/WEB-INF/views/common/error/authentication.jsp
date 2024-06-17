<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="Error Page"/>
</jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath }"/>

<section>
	
	<h3 style="color:red;"><%=exception.getMessage() %></h3>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>