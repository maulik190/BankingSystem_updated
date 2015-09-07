<html>
<head>
<title>Login form</title>
</head>
<body  bgcolor="#ebeaea">
 <p align="center"><b><font size="+3">Banking System</font></b></p>
<form action="LoginServlet" method="post">
<table align="center">
<% String loginDetails=(String)session.getAttribute( "loginDetails" );
if(loginDetails=="invalid")
{%>
	<p align="center"><b><font size="+1" color="#FF0000">Invalid login!! Please try again</font></b></p>
<%
session.removeAttribute("loginDetails");
}

%>
<tr>
<td>User Name</td>
<td>:</td>
<td><input type="text" name="username"/></td>
</tr><tr>
<td>Password</td>
<td>:</td>
<td><input type="password" name="password"/></td>
</tr><tr>
<td colspan="3" align="center"><input type="submit" value="login"></td>
</tr>
</table>
</form>
</body>
</html>
