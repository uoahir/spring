<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<style>
    div#memo-container{width:60%; margin:0 auto;}
</style>

<div id="memo-container">
    <springform:form modelAttribute="memo" action="${path }/memo/insertmemo.do" class="form-inline" method="post">
        <springform:input path="memo" type="text" class="form-control col-sm-6" name="memo" placeholder="메모" />&nbsp;
        <springform:errors path="memo"/>
        <springform:input path="password" type="password" class="form-control col-sm-2" name="password" maxlength="4" placeholder="비밀번호"/>&nbsp;
        <springform:errors path="password"/>
        <button class="btn btn-outline-success" type="submit" >저장</button>
    </springform:form>
</div>


<jsp:include page="/WEB-INF/views/common/footer.jsp"/>