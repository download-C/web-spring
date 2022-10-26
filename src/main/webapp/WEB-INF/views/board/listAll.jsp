<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>

<script type="text/javascript">
  var msg = "${msg }";
  if(msg == "OK") {
		alert('글쓰기 완료');
  }
  if(msg =="MODOK") {
	  alert('글 수정 완료');
  }
  if(msg == "DELOK") {
	  alert('글 삭제 완료');
  }
</script>

<h1>board/listAll.jsp</h1>
<button class="btn btn-primary" 
		onclick="location.href='${pageContext.request.contextPath}/board/regist'">
		글쓰기</button>
<div class="box">
	<div class="box-header">
		<h3 class="box-title">게시글</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm hidden-xs"
				style="width: 150px;">
				<input type="text" name="table_search"
					class="form-control pull-right" placeholder="Search">
				<div class="input-group-btn">
					<button type="submit" class="btn btn-default">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</div>
	</div>

	<div class="box-body table-responsive no-padding">
		<table class="table table-hover">
			<tbody>
				<tr>
					<th style="width:45px; text-align:center">번호</th>
					<th style="width:200px; text-align:center" >제목</th>
					<th style="width:100px; text-align:center">작성자</th>
					<th style="width:45px; text-align:center">조회수</th>
					<th style="width:100px; text-align:center">작성일</th>
					<th style="width:100px; text-align:center">IP</th>
				</tr>
				<c:forEach var="vo" begin="0" end="20" step="1" items="${boardList }">
				<tr>
					<th style="width:45px; text-align:center">${vo.bno }</th>
					<th style="width:200px; text-align:center" >
						<a href="${pageContext.request.contextPath}/board/content?bno=${vo.bno }">${vo.title }</a>
					</th>
					<th style="width:100px; text-align:center">${vo.writer}</th>
					<th style="width:45px; text-align:center">${vo.readcount}</th>
					<th style="width:100px; text-align:center">
						<fmt:formatDate value="${vo.regdate}" pattern="yyyy.MM.dd HH:mm"/> 
					</th>
					<th style="width:100px; text-align:center">${vo.ip }</th>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="box-footer clearfix" style="display:flex; justify-content:center;">
			<ul class="pagination pagination-sm no-margin pull-right">
				<c:if test="${pm.prev }">
					<li><a href="listPage?page=${pm.startPage-1 }">&laquo;</a></li>
				</c:if>
				<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
					<li <c:out value=""/> >
						<a href="listPage?page=${idx }">${idx }</a>
					</li>
				</c:forEach>
				<c:if test="${pm.next }">
					<li ${pm.vo.page == idx?'class=active':'' }><a href="listPage?page=${pm.endPage+1 }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	
</div>
<%@ include file="../include/footer.jsp"%>

