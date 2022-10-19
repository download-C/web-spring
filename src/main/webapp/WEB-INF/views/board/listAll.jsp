<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>

<script type="text/javascript">
  var msg = "${msg }";
  if(msg == "OK") {
		alert('글쓰기 완료');
  } 
</script>

<h1>board/listAll.jsp</h1>
<div class="box">
	<div class="box-header">
		<h3 class="box-title">Responsive Hover Table</h3>
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
				</tr>
				<c:forEach var="i" begin="1" end="5" step="1">
				<tr>
					<th style="width:45px; text-align:center">bno</th>
					<th style="width:200px; text-align:center" >title</th>
					<th style="width:100px; text-align:center">writer</th>
					<th style="width:45px; text-align:center">readcount</th>
					<th style="width:100px; text-align:center">regdate</th>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<li><a href="#">«</a></li>
					<li><a href="#">i</a></li>
				<li><a href="#">»</a></li>
			</ul>
		</div>
	</div>

</div>
<%@ include file="../include/footer.jsp"%>

