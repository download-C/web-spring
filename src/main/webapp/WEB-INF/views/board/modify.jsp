<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<h1> board/modify.jsp </h1>

<div class="box box-warning">
	<div class="box-header with-border">
		<h3 class="box-title">수정하기</h3>
	</div>

	<div class="box-body">
		<form role="form" action="/board/modify" method="post">

			<div class="form-group">
				<label>글번호</label> <input type="text" class="form-control"
					value="${vo.bno }" name="bno" readonly="readonly">
					
			</div>
			<div class="form-group">
				<label>제목</label> <input type="text" class="form-control"
					value="${vo.title }" name="title">
					
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" rows="3" 
				  name="content" >${vo.content }</textarea>
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">수정</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>