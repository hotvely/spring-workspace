<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous" />
<style>
h1 {
	margin-top: 30px;
}

.form-group {
	margin: 20px 0;
}

.form-group img {
	width: 15%;
	height: 15%;
}
/*
	.form-group .overimg{
	
	width: 15%;
	height:15%;
	}
*/
.button {
	display: flex;
	flex-direction: row;
	width: 100%;
	justify-content: space-between;
}

.update-delete-btn {
	display: flex;
	flex-direction: row;
}
</style>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>게시글 정보</h1>
		<form>
			<div class="form-group">
				<label for="title">제목</label>
				<br />
				<input type="text" name="title" id="title" class="form-control" readonly="readonly" value="${board.title }" />
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea name="content" id="content" cols="30" rows="10" class="form-control" style="resize: none" readonly="readonly">
					${board.content }
				</textarea>
			</div>
			<div class="form-group">
				<p>업로드 이미지</p>
				<c:if test="${board.url != null }">
					<div>
						<!-- 
			              <a
			                href="/board/download?filename=${fn:replace(board.url, '/upload/','') }"
			                ><img class="img" alt="" src="${board.url }"
			              />
			              </a> 
			              -->
						<!-- <a href="/board/download?filename=${fn:replace(vo.url, '/upload/', '')}"><img src="${vo.url}"/></a> -->
						<a href="${board.url}" download>
							<img src="${board.url}" />
						</a>
					</div>
				</c:if>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input type="text" id="writer" name="writer" value="${board.writer}" class="form-control" readonly="readonly" />
				<input type="hidden" name="no" value="${board.no}" />
			</div>
			<div class="button">
				<div>${userInfo.id }</div>
				<div>${ board.writer  }</div>
				<sec:authentication property="principal" var="userInfo" />
				<c:if test="${userInfo.id eq board.writer }">
					<div class="update-delete-btn">
						<a class="btn btn-outline-warning" href="/board/update?no=${board.no }">수정</a>
						<a class="btn btn-outline-danger" href="/board/delete?no=${board.no }">삭제</a>
					</div>
				</c:if>
				<div class="back-btn">
					<a class="btn btn-outline-light" href="/board/list">뒤로</a>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
      const overimg = document.querySelector(".overimg");
      const img = document.querySelector(".img");

      img.addEventListener("mouseover", (event) => {
        console.log(event);
        img.style.width = "25%";
        img.style.height = "25%";
        console.log("이미지 오버 !!");
      });
      img.addEventListener("mouseout", (event) => {
        img.style.width = "15%";
        img.style.height = "15%";
        console.log("이미지 오버 !!");
      });
    </script>
</body>
</html>
