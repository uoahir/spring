<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page ="/WEB-INF/views/common/header.jsp" >
	<jsp:param value="Home" name="title"/>
</jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<style>
	div#board-container{width:400px; margin:0 auto; text-align:center;}
    div#board-container input{margin-bottom:15px;}
</style>

<section>
	<div id="board-container">
        <form name="boardFrm" action="${path }/board/insertboard.do" method="post"  >
            <input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle" required>
            <input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="boardWriter" value="${loginMember.userId}" readonly required>
            <div class="input-group mb-3" style="padding:0px;">
                <div class="input-group-prepend" style="padding:0px;">
                    <span class="input-group-text">첨부파일1</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="upFile" id="upFile1">
                    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
                </div>
            </div>
            <textarea class="form-control" name="boardContent" placeholder="내용" required></textarea>
            <br />
            <input onclick="" type="submit" class="btn btn-outline-success" value="저장" >
        </form>
    </div>
</section>

<jsp:include page ="/WEB-INF/views/common/footer.jsp" />