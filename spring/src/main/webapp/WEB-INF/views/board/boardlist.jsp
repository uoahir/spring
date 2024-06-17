<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page ="/WEB-INF/views/common/header.jsp" >
	<jsp:param value="Board" name="title"/>
</jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<style>
	.pointer {
	  cursor: pointer;
	}
</style>
<section id="board-container" class="container">
        <p>총 ${totalContents }건의 게시물이 있습니다.</p>
        <button onclick="location.assign('${path}/board/boardwrite.do')">글쓰기</button>
        <table id="tbl-board" class="table table-striped table-hover">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>첨부파일</th>
                <th>조회수</th>
            </tr>
            <c:if test="${not empty boards }">
            <tbody>
            	<c:forEach var="i" items="${boards }">
            	<tr>
            		<td>${i.boardNo }</td>
            		<td class="pointer" onclick="boardDetail(event);">${i.boardTitle }</td>
            		<td>${i.boardWriter }</td>
            		<td>${i.boardDate }</td>
            		<td>첨부파일</td>
            		<td>${i.boardReadCount }</td>
            	</tr>
            	</c:forEach>
            </tbody>
            </c:if>
        </table> 
        ${pageBar }
</section>
<script>
	const boardDetail=(event)=>{
		const no = event.target.previousElementSibling.innerText;
		location.assign("<%=request.getContextPath()%>/board/boarddetail.do?boardNo="+no);		
	}
</script>

<jsp:include page ="/WEB-INF/views/common/footer.jsp" />