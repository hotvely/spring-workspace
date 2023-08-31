<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous" />

<style>
.container {
	margin-top: 10%;
	margin-bottom: 10%;
}

.header {
	margin: 20px;
	display: flex;
	flex-direction: column;
}

.header h1 {
	
}

.header div {
	display: flex;
	align-items: center;
	justify-content: end;
}

.pagination {
	display: flex;
	align-items: center;
	justify-content: center;
}

.title-click {
	text-decoration-line: none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>List Page</h1>
			<div>
				<a href="/board/insert" class="btn btn-outline-warning">게시글
					등록</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.num}</td>
						<td><a class="title-click" href="/board/view?no=${board.no}">${board.title}</a>
						</td>
						<td>${board.writer}</td>
						<td><fmt:formatDate value="${board.regdate}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nva aria-label="Page navigation">
		<ul class="pagination">
			<c:if test="${paging.prev }">

				<li class="paging-item"><a class="page-link"
					href="/board/list?page=${paging.startPage - 1} ">Prev</a>
				</li>
				<a class="page-link" href="/board/list?page=${paging.startPage -1 } ">${paging.startPage - 1 }</a>
				<li class="paging-item"><a class="page-link" href="#pagination">...</a></li>
				<li class="paging-item">
			</c:if>
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
				var="pageIdx">
				<li class="page-item"><a
					class="page-link ${paging.cri.page == num ? 'active' : '' }"
					href="/board/list?page=${pageIdx }">${pageIdx}</a>
				</li>
			</c:forEach>

			<c:if test="${paging.next }">
				<li class="paging-item"><a class="page-link" href="#pagination">...</a></li>
				<li class="paging-item"><a class="page-link"
					href="/board/list?page=${paging.endPage + 1 } ">${paging.endPage+1}</a>
				</li>
				<li class="paging-item"><a class="page-link"
					href="/board/list?page=${paging.endPage + 1 } ">Next</a>
				</li>
			</c:if>
		</ul>
		</nva>
	</div>
</body>
</html>
