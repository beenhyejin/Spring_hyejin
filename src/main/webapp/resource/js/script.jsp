<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Script</title>
<script type="text/javascript">
/* window.addEventListener("load", function(e) {
	var fileInput = document.querySelector("#ex3-upload input");
	fileInput.onchange = function(){
		var file = fileInput.files[0];
		alert(file.name);
		var formData = new FormData();
	 	formData.append("title","테스트");
	 	formData.append("file",file);
	 	var xhr = new XMLHttpRequest();
	 	xhr.onerror = function(e) {
	 		alert("예기치 못한 오류가 발생하였습니다.");   
	    };
	    xhr.open("POST","../../upload?${_csrf.parameterName}=${_csrf.token}", true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
	    xhr.send(formData); // 요청
	};
	
}); */
</script>
</head>
<body>
<!-- Ajax로 파일 전송하기와 트리거 그리고 파일목록뷰어 -->
   <div id="ex3-upload">
   	<hr>
      <form action="../../upload" method="post" enctype="multipart/form-data">
         <div>
            <input type="submit" value="전송" />
         </div>
         <div id="clone-container">
            <table border="1">
               <tbody>
                  <tr>
                     <td>제목</td>
                     <td><input type="text" name="title" /></td>
                  </tr>
                  <tr>
                     <td>파일</td>
                     <td><input type="file" name="file"/></td>
                  </tr>
               </tbody>
            </table>
         </div>
      </form>
      <div>
      	<ul>
      		<li></li>
      	</ul>
      </div>
   </div>
   <hr />
</body>
</html>