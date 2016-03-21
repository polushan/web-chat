<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>"Чат"</title>
</head>
<body LINK=blue ALINK=blue VLINK=blue>
<FORM ACTION="Index" METHOD="POST">
<TABLE HEIGHT="100%" VALIGN="middle" WIDTH="100%">
<TR>
<TD><TABLE BORDER=1 CELLPADDING=4 CELLSPACING=0 WIDTH="100%" BGCOLOR="#FFFFFF" BORDERCOLOR="#000000" RULES="all" ALIGN="center" HEIGHT="300">
<TR BGCOLOR="lavender" ALIGN="center">
<TH COLSPAN=2 CLASS=title>Добро пожаловать в Чат</TH>
</TR>
<TR ALIGN="center">
<TD>Ваше имя (или ник):</TD>
<TD><INPUT TYPE="text" NAME="login" SIZE="20" VALUE=""></TD>
</TR>
<TR ALIGN="center">
<TD>Пароль (должен отличаться от ника):</TD>
<TD><INPUT TYPE="password" NAME="password" SIZE="20" VALUE=""></TD>
</TR>
<TR ALIGN="center">
<TD COLSPAN=2><INPUT TYPE="submit" VALUE="Войти в чат" STYLE="width: 300px;"></TD>
</TR>
<TR ALIGN="center">
<TD COLSPAN=2 BGCOLOR="lavender"><FONT COLOR="#6766f1"><B>Примечание:</B></FONT> если Вы заходите сюда в первый раз, то введите свой пароль, и он будет запомнен системой<BR><BR>
</TR>
</TABLE>
</TD>
</TR>
</TABLE>
</FORM>
</body>
</html>