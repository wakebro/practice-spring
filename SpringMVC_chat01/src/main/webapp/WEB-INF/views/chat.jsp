<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="col-6">
			<label><b>채팅방</b></label>
		</div>
		<div>
			<div id="msgArea" class="col"></div>
			<div class="col-6">
				<div class="input-group mb-3">
					<input type="text" id="msg" class="form-control">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-6"></div>
	
	</div>
</body>
</html>