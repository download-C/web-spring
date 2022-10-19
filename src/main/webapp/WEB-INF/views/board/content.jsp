<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<h1>board/content.jsp</h1>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">내용</h3>
		<div class="box-tools"></div>
	</div>

	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Quick Example</h3>
		</div>



			<div class="box box-warning">
	<div class="box-header with-border">
		<h3 class="box-title">ITWIIL 게시판</h3>
	</div>

	<div class="box-body">
		<form role="form" action="/board/regist" method="post">

			<div class="form-group">
				<label>제목</label> <input type="text" class="form-control"
					value="${vo.title }" name="title" readonly="readonly">
			</div>
			<div class="form-group">
				<label>작성자</label> <input type="text" class="form-control"
					value="${vo.writer }" name="writer" readonly="readonly">
			</div>

			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" rows="3" 
				 name="content" readonly="readonly">${vo.content }</textarea>
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">수정하기</button>
			</div>
		</form>
	</div>
</div>

</div>

<%@ include file="../include/footer.jsp"%>