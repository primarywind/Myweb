<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%
    String rand = (String) session.getAttribute("rand");
    String input = request.getParameter("rand");
    if (rand.equals(input)) {
        out.print("<script>alert('��֤ͨ����');</script>");
    } else {
        out.print("<script>alert('��������ȷ����֤�룡');location.href='Dregister.jsp';</script>");
    }
%>
