<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%
    String rand = (String) session.getAttribute("rand");
    String input = request.getParameter("rand");
    if (rand.equals(input)) {
        out.print("<script>alert('验证通过！');</script>");
    } else {
        out.print("<script>alert('请输入正确的验证码！');location.href='Dregister.jsp';</script>");
    }
%>
