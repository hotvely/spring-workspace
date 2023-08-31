<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <style>
      h1 {
        margin-top: 70px;
      }

      .form-group {
        margin: 20px 0;
      }

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
      <form action="/board/update" method="post">
        <div class="form-group">
          <label for="title">제목</label><br />
          <input
            type="text"
            name="title"
            id="title"
            class="form-control"
            value="${board.title }"            
          />
        </div>
        <div class="form-group">
          <label for="content">내용</label>
          <textarea
            name="content"
            id="content"
            cols="30"
            rows="10"
            class="form-control"
            style="resize: none"
          >
${board.content }</textarea
          >
        </div>
        <div class="form-group">
          <label for="writer">작성자</label>
          <input
            type="text"
            id="writer"
            name="writer"
            value="${board.writer}"
            class="form-control"
            readonly="readonly"
          />
          <input type="hidden" name="no" value="${board.no}" />
        </div>
        <div class="button">
          <div class="update-delete-btn">
            <button type="submit" class="btn btn-outline-warning">수정</button>

            <a
              class="btn btn-outline-danger"
              href="/board/delete?no=${board.no }"
              >삭제</a
            >
          </div>
          <div class="back-btn">
            <a class="btn btn-outline-light" href="/board/list">뒤로</a>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
