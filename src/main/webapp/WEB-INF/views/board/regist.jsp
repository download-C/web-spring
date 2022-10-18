<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>

<div class="box box-warning">
	<div class="box-header with-border">
		<h3 class="box-title">ITWIIL 게시판</h3>
	</div>

	<div class="box-body">
		<form role="form" action="/board/regist" method="post">

			<div class="form-group">
				<label>제목</label> <input type="text" class="form-control"
					placeholder="제목을 입력하세요" name="title">
			</div>
			<div class="form-group">
				<label>작성자</label> <input type="text" class="form-control"
					placeholder="이름을 입력하세요" name="writer">
			</div>

			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" rows="3" 
				placeholder="내용을 입력하세요" name="content" ></textarea>
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">글쓰기</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>