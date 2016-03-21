<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.User, util.History, util.Message"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  <meta http-equiv=Refresh content="3; text/html; charset=UTF-8">-->
<meta content="text/html; charset=UTF-8">
</head>
<body ONLOAD="scroll(0,100)" LINK="blue" ALINK="blue" VLINK="blue">
<FONT SIZE=3 FACE="Georgia">
<%
String login = session.getAttribute("login").toString();
List<Message> history = History.INSTANCE.getHistory();
for (Message message: history) {
	if ("".equals(message.getWho())) {
		out.print(message);
	} else if (login.equals(message.getWho()) || login.equals(message.getFrom())){
		out.print(message);
	}
}
%>
</FONT>
</body>
</html>