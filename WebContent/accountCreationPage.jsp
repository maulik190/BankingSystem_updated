<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Account creation form</title>
</head>
<body  bgcolor="#ebeaea">
 <p align="center"><b><font size="+1">Account Creation</font></b></p>

<% 

String AccCreationalMsgStatus=(String)session.getAttribute( "AccCreationalMsgStatus" );
if(AccCreationalMsgStatus=="set")
{
	String AccCreationalMsg=(String)session.getAttribute( "AccCreationalMsg" );
	out.println("<b><font size='+1' color='#00CC33'>"+AccCreationalMsg+"</font></b>");

session.removeAttribute("AccCreationalMsgStatus");
session.removeAttribute("AccCreationalMsg");
}

 %>
<form action="AccountServlet" method="post">
<table align="Left">
<tr>
<td>Name</td>
<td>:</td>
<td><input type="text" name="name"/></td>
</tr><tr>
<td>Date of Birth</td>
<td>:</td>
<td><input type="date" name="dob"/></td>
</tr><tr>
<td>Address</td>
<td>:</td>
<td><textarea name="address" rows="4" cols="30"></textarea></td>
</tr><tr>
</tr><tr>
<td>Email</td>
<td>:</td>
<td><input type="text" name="email"/></td>
</tr><tr>
<td colspan="3" align="center"><input name="submit" type="submit" value="Create Account"></td>
</tr>
</table>
</form>
</body>
</html>

