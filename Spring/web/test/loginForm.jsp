<%--
  Created by IntelliJ IDEA.
  User: dgtazm9513
  Date: 2020-04-17
  Time: 오전 9:27
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로긴폼</title>
</head>
<body>
<form id="loginForm" action="${pageContext.request.contextPath}/test/login.do">
    <label>
        ID <input type="text" name="id" value=""/>
        PW <input type="text" name="pw" value=""/>
    </label>
    <input type="submit" value="전송">
    <input type="reset"  value="취소">
</form>
</body>
</html>
