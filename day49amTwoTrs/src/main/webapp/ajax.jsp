
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 실습 (사진바꾸기: 좋아요 누를때 하트 색갈 바뀜)</title>
<style type="text/css">
	img{
		cursor: pointer;
	}

</style>

</head>
<body>
	
<img id="photo" alt="실습용 이미지" src="">
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$("#photo").prop("src","images/gora.jpg");//내가원하는이미지
	
	var res = '1';
	$("#photo").on("click",function(){//이벤트연결 : 클릭을 했을때
		$.ajax({//비동기처리 할겁니다 ajax할겁니다
			url: 'test.do?result='+res, //요청을 post방식으로 test.do로 보내기
			type: 'POST', //CUD 할 생각이 있으면 POST를 하기도 함
			success: function(result){ //결과값을 받아올 수도 있음
				console.log('result ['+result+']');
				if(result=='2'){
					$("#photo").prop("src","images/paduck.jpg");
					res = '2';
				}
				if(result=='1'){
					$("#photo").prop("src","images/gora.jpg");
					res='1';
				}
			},
			error: function(error){
				alert('error ['+error+']');
			}
		}); 
	});
</script>
	
</body>
</html>

<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 실습</title>
<style type="text/css">
   img {
      cursor: pointer;
   }
</style>
</head>
<body>

<img id="photo" alt="실습용 이미지" src="">

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script type="text/javascript">
   $("#photo").prop("src","images/gora.jpg");
   
   $("#photo").on("click",function(){
      $.ajax({
         url: 'test.do?banana=1234',
         type: 'POST',
         success: function(result){
            console.log('result ['+result+']');
            if(result=='apple'){
               $("#photo").prop("src","images/paduck.jpg");
            }
         },
         error: function(error){
            alert('error ['+error+']');
         }
      });
   });
</script>

</body>
</html>
--%>