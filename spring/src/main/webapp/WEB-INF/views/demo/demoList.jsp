<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="Demo 리스트"/>
</jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
	<table class="table">
		<tr>
			<th scope="col">번호</th>
			<th scope="col">이름</th>
			<th scope="col">나이</th>
			<th scope="col">이메일</th>
			<th scope="col">성별</th>
			<th scope="col">개발가능언어</th>
			<th scope="col">수정</th>
		</tr>
		<tbody>
			<c:if test="${not empty demo }">
				<c:forEach var="i" items="${demo }">
					<tr>
						<td>${i.devNo }</td>
						<td>${i.devName }</td>
						<td>${i.devAge }</td>
						<td>${i.devEmail }</td>
						<td>${i.devGender }</td>
						<td>
							<c:if test="${not empty i.devLang }">
								<ul>
									<c:forEach var="l" items="${i.devLang }">
										<li>${l }</li>
									</c:forEach>
								</ul>
							</c:if>
						</td>
						<td>
							<button onclick="update();" class ="btn btn-outline-success">수정</button>
							<button onclick="delete();" class ="btn btn-outline-danger">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>	
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>