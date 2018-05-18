<%--
  Created by IntelliJ IDEA.
  User: lirj
  Date: 2018/4/18
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    //用户id
    String dashUserId = (String) request.getSession().getAttribute("USER_ID");
    //用户姓名
    String dashName = (String) request.getSession().getAttribute("NAME");
    //上次登录时间
    String dashLoginDate = (String) request.getSession().getAttribute("LOGIN_DATE");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
dashboard
</body>
<script src="../common/jquery/jquery.min.js"></script>
<script>
    $.ajax({
        url:"./dashboard.jsp",
        success:function(result){
            $("div").html(result);
        }
    });

    window.sessionStorage['testKey'] = '这是一个测试的value值';
    window.sessionStorage['testKey'];// => 这是一个测试的value值

    sessionStorage.setItem('testKey','这是一个测试的value值'); // 存入一个值
    // => 返回testKey对应的值

    console.log(sessionStorage.getItem('testKey'));
</script>
</html>
