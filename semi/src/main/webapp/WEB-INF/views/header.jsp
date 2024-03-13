<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="top-bar">
	<img alt="로고" src="resources/images/1-removebg-preview.png"
		class="logo" onclick="location.href='./main'">
</div>
<div>
	<h4 class="title">소소한 심부름</h4>
	
	 <div class="logged-in">
  <h1>로그인 후에만 보이는 문구</h1>
  <p>로그인 후에만 볼 수 있는 정보</p>
</div>
	 	<span>logining</span>
	
	 <div>
	 <form action = "logout" method = "post">
	 <button>로그아웃</button>
	</form>
	
	</div>
</div>
	
	
	<script>
	$(document).ready(function() {
		  // 로그인 여부를 확인하는 코드
		  var isLoggedIn = <%= session.getAttribute("isLoggedIn") %>;

		  if (isLoggedIn) {
		    $(".logged-in").show();
		  } else {
		    $(".logged-in").hide();
		  }
		});
	</script>

