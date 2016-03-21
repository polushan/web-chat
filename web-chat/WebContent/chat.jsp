<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>

<script language="JavaScript">
function logout_f() { 
	window.location = "Logout";
}
</script>

<meta http-equiv="Content-Type" content="5; text/html; charset=utf-8" HTTP-EQUIV=Refresh>
<title>"Чат"</title>
</HEAD>
<BODY BGCOLOR="#8caae6" onunload="logout_f()">
<jsp:include page = "users.jsp"/>
<jsp:include page = "text.jsp"/>
<TABLE WIDTH="100%" HEIGHT="100%" CELLPADDING=0 CELLSPACING=0>
<TR VALIGN="middle">
<TD WIDTH="80%">
<FORM NAME="sendform" ACTION="AddMessage" METHOD="post">
<INPUT TYPE="hidden" VALUE="<%=session.getAttribute("login")%>" NAME="login">
<INPUT TYPE="text" NAME="who" STYLE="width:15%" STYLE="border-width:1px; border-color:black">
<INPUT TYPE="text" NAME="message" STYLE="width:75%" STYLE="border-width:1px; border-color:black"></TD>
<TD WIDTH="15%"><INPUT TYPE="submit" VALUE="Отправить" STYLE="border-width:1px; border-color:black"></TD>
</FORM>
<FORM ACTION="Logout" METHOD="get" NAME="closeform" TARGET="_parent">
<TD WIDTH="20%">
<INPUT TYPE="hidden" NAME="login">
&nbsp;<INPUT TYPE="submit" VALUE="Выход" STYLE="border-width:1px; border-color:black">
</TD>
</FORM>
</TR>
</TABLE>
</BODY>
</HTML>