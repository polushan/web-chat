<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.Factory, java.util.Queue, model.User, util.History"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  <meta http-equiv=Refresh content="3; text/html; charset=UTF-8">-->
<meta content="text/html; charset=UTF-8">
</head>
<body ONLOAD="scroll(0,100)" LINK="blue" ALINK="blue" VLINK="blue">
<FONT SIZE=3 FACE="Georgia">
<%
Queue<String> history = History.INSTANCE.getHistory();
for (String message: history) {
	out.print("<p>" + message + "</p>");
}
%>
</FONT>
</body>
</html>