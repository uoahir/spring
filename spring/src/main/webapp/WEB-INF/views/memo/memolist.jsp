<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="메모"/>
</jsp:include>

<br />
<!-- 메모목록 -->
<div>
	<button class="btn btn-outline-dark" onclick="location.assign('${path}/memo/writememo.do')">Memo 작성</button>
</div>
<table class="table">
	<tr>
		<th scope="col">번호</th>
		<th scope="col">메모</th>
		<th scope="col">날짜</th>
		<th scope="col">삭제</th>
	</tr>
	<tbody>
		<c:if test="${not empty memos }">
			<c:forEach var="i" items="${memos }">
				<tr>
					<td>${i.memoNo }</td>
					<td>${i.memo }</td>
					<td>${i.memoDate }</td>
					<td><button class="btn btn-outline-dark">삭제</button></td>
				</tr>
			</c:forEach>
		</c:if>
	
	</tbody>
</table>
<div>${pageBar }</div>


<jsp:include page="/WEB-INF/views/common/footer.jsp"/>