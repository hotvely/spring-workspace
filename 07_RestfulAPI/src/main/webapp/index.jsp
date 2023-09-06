<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<table border="1">
		<thead>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
		</thead>
		<tbody id="list"></tbody>
	</table>
	<h1>휴대전화 정보</h1>
	<form id="phoneFrm">
		모델번호 :
		<input type="text" name="name" id="num" />
		<br /> 모델명 :
		<input type="text" name="model" id="model" />
		<br /> 가격 :
		<input type="text" name="price" id="price" />
		<br /> 제조사 :
		<select id="vcode" name="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select>
		<br />
		<input type="button" value="추가" id="insert" />
		<input type="button" value="수정" id="update" />
		<input type="button" value="삭제" id="delete" />
	</form>
	<script>
		window.onload = function e() {
			$.ajax({
				method : "get",
				url : "http://localhost:8080/api/phone",
				dataType : "json",
				success : function(datas) {
					$.each(datas, function(idx, elem) {
						$("#list").append(
								"<tr><td class='num'>" + elem.num + "</td>"
										+ "<td>" + elem.model + "</td>"
										+ "<td>" + elem.price + "</td>"
										+ "<td>" + elem.company.vendor
										+ "</td>" + "</tr>");
					});
				},
				error : function() {
					console.log("error!!!!!!!!");
				},
			});
		};

		// 상세 조회
		$("#list").on("click", ".num", function() {
			console.log(this.textContent); //얘는 정상 적으로 뜸;
			console.log($(this).text()); //에러는 안나는데 아무 값도 없음;
			$.ajax({
				method : "get",
				url : "http://localhost:8080/api/phone/" + this.textContent,
				dataType : "json",
				success : function(data) {
					$("#num").val(data.num);
					$("#model").val(data.model);
					$("#price").val(data.price);
					$('#vcode').val(data.vcode);
				},
				error : function() {
				},
			});
		});

		// 추가
		$("#insert").on("click", function() {

			const phone = {
				"num" : $("#num").val(),
				"model" : $("#model").val(),
				"price" : $("#price").val(),
				"vcode" : $('#vcode').val()
			};
			$.ajax({
				method : "post",
				url : "http://localhost:8080/api/phone",
				data : JSON.stringify(phone),
				contentType : "application/json",
				success : function() {
					location.reload();
				},
				error : function() {
					console.log("데이터 전송 실패;;");
				},
			});
		});

		// 수정
		$("#update").on("click", function() {
			const phone = {
				"num" : $("#num").val(),
				"model" : $("#model").val(),
				"price" : $("#price").val(),
				"vcode" : $('#vcode').val()
			};
			console.log("update Click!");
			$.ajax({
				method : "put",
				url : "http://localhost:8080/api/phone",
				data : JSON.stringify(phone),
				contentType : "application/json",
				success : function() {
					location.reload();
				},
				error : function() {
					console.log("데이터 전송 실패;;");
				},
			});
		});

		// 삭제
		$("#delete").on("click", function() {
			const num = $('#num').val();
			$.ajax({
				method : "delete",
				url : "http://localhost:8080/api/phone/" + num,
				data : "text",
				success : function() {
					location.reload();
				},
				error : function() {
					console.log("데이터 전송 실패;;");
				},
			});
		});
	</script>
</body>
</html>
