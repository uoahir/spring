<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page ="/WEB-INF/views/common/header.jsp" >
	<jsp:param value="Board Detail" name="title"/>
</jsp:include>

<style>
    div#board-container{width:400px; margin:0 auto; text-align:center;}
    div#board-container input,div#board-container button{margin-bottom:15px;}
    div#board-container label.custom-file-label{text-align:left;}
</style>

<div id="board-container">
	<input value="${board.boardTitle }" type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle"  required>
	<input value="${board.boardWriter }" type="text" class="form-control" name="boardWriter"  readonly required>

	<button type="button" class="btn btn-outline-success btn-block" onclick=""></button>
	<textarea class="form-control" name="boardContent" placeholder="내용" required>${board.boardContent }</textarea>
</div>



<jsp:include page ="/WEB-INF/views/common/footer.jsp" />