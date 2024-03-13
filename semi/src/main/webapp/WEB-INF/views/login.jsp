<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            background-color: #FFDEDE; /* 배경색 설정 */
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column; /* 컨테이너의 주축 방향을 세로로 변경 */
            align-items: center;
            justify-content: center; /* 화면 수직 중앙 정렬 */
            height: 100vh;
        }
        .login-container {
            text-align: center; /* 로그인 폼 가운데 정렬 */
        }
        .login-form input[type="text"],
        .login-form input[type="password"],
        .login-form input[type="submit"] {
            width: 314px;
            height: 53px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            box-sizing: border-box;
        }
        .login-form input[type="submit"] {
            background-color: #FFA800; /* 로그인 버튼 색상 */
            color: white;
            font-weight: bold;
            cursor: pointer;
        }
    </style>
</head>
<body>

<!-- 로고 추가 -->
<img onclick="location.href='./main'" src="resources/images/1-removebg-preview.png" alt="이미지가 로드되지 않았습니다." width="70" height="80" margin-bottom: 60px;>
<!-- 문구 추가 -->
<h1 style="text-align: center; margin-bottom: 120px;">펑크난 자리, 검증된 인원이 채워드립니다</h1>

<!-- 로그인 폼 -->
<div class="login-container">
    <form action="login" method="post" class="login-form">
        <input type="text" name="m_id" placeholder="아이디를 입력해주세요."><br>
        <input type="password" name="m_pass" placeholder="비밀번호를 입력해주세요."><br>
        <input type="submit" value="로그인">
    </form>
</div>
<%-- 나머지 코드 --%>

<!-- 회원가입으로 가는 하이퍼링크 -->
<div style="position: fixed; bottom: 10%; width: 100%; text-align: center;">
    <h2 id="join-link"><a onclick="location.href='./join'" style="color: grey; text-decoration: none;">회원이 아니신가요?</a></h2>
</div>

</body>
<script>

</script>
</html>