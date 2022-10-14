<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
		String agree = (String)request.getAttribute("agree");
	
		String mId = request.getParameter("inputId"); 
	%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH 로그인 화면</title>
    <style>
    	#container{
    		width : 400px;
            border : 1px solid black;
            margin : auto;
    	}
	</style>
</head>
<body>
    <%if(agree.equals("Y")) {%>
        <div id = "container">
            <%= mId %> 님이 로그인하셔습니다.
        </div>
    <%} else {%>
        <div id = "container">
            회원이 아닙니다.
        </div>
    <%} %>
</body>
</html>