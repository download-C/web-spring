<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<h1>board/content.jsp	</h1>

<div class="box box-warning">
	<div class="box-header with-border">
		<h3 class="box-title">ITWIIL 게시판 본문</h3>
	</div>
	<!-- 수정 및 삭제 시 필요한 글번호 저장 -->
	<form role="form" method="post">
		<input type="hidden" name="bno" value=${vo.bno }>
	</form>

	<div class="box-body">

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
				<textarea class="form-control" rows="3" name="content"
					readonly="readonly">${vo.content }</textarea>
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-warning">수정</button>
				<button type="submit" class="btn btn-danger">삭제</button>
				<button type="submit" class="btn btn-success">목록</button>
			</div>
	</div>	
</div>

<script type="text/javascript">
	
	$(document).ready(function(){
// 		alert('제이쿼리 실행');

		// 글 정보 포함하는 form 태그 변수 선언
		var form = $('form[role="form"]');
// 		console.log(form);
		
		// 1. 수정버튼 클릭 시 기능 설정
		$(".btn-warning").click(function(){
// 			alert('수정 버튼 클릭');	
			// 버튼 클릭 시 action 속성 설정해서 경로 지정
			form.attr("action", "/board/modify");
			//버튼 클릭 시 method=get으로 설정하기
			form.attr("method","get");
			// form태그  submit하기
			form.submit();
		});
		
		// 2. 삭제 버튼 클릭 시 글 삭제
		$(".btn-danger").click(function(){
// 			alert('저런, 삭제하시려구요?');
// 			alert('안 돼요, 안 돼!');
			// 버튼 클릭 시 action 속성 설정해서 경로 지정
			form.attr("action", "/board/delete");
			// form태그  submit하기
			form.submit();
		});
		
		// 3. 목록 버튼 클릭 시 게시판 목록으로 이동
		$(".btn-success").click(function(){
			location.href="/board/listPage";
		});
		
	});
</script>


	<%@ include file="../include/footer.jsp"%>