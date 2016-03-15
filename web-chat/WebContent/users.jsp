<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="dao.Factory, java.util.List, model.User"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<!-- <META content="10; text/html; charset=utf-8" HTTP-EQUIV=Refresh> -->
<META content="text/html; charset=utf-8" > 
</HEAD>
<BODY LINK="blue" ALINK="blue" VLINK="blue" TOPMARGIN=0 LEFTMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 RIGHTMARGIN=0>
<FONT FACE="georgia" SIZE=3 COLOR="black">
<TABLE WIDTH="100%">
<TR>
<TD WIDTH="100%" ALIGN="center">
<FONT COLOR="#008080" FACE="Georgia" SIZE=3><B>Сейчас в чате:</B></FONT>
</TD>
</TR>
<%
List<User> users = Factory.getUserDAO().getActiveUsers();
for (User user: users) {
	out.print("<tr><td>" + user.getLogin().trim() + "</tr></td>");
}
%>
</TABLE>
</BODY>
</FONT>
</HTML>