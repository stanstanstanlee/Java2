<%@ tag language="java" pageEncoding="UTF-8"%>


<script type="text/javascript">
	function check(){
		var ans=prompt('비밀번호를 입력하세요.');
		location.href='controller.jsp?action=mypage&mpw='+ans;
	}
</script>