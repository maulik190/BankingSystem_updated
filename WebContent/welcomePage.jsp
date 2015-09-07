<%@ page import="java.sql.*" %>

<html>
<head>
<title>Welcome</title>
</head>
<body  bgcolor="#ebeaea">
 
 <p align="center"><b><font size="+3">Banking System</font></b></p>
 <p align="left"><b>Welcome, <%= session.getAttribute( "theName" ) %> !!</b></p>

 <table>
 <tr><td><a href="accountCreationPage.jsp">Create Account</a></td></tr>
 <tr><td>&nbsp;</td></tr>
 <tr><td><a href="transactionPage.jsp">Transactions</a></td></tr>
 <tr><td>&nbsp;</td></tr>
 <tr><td><a href="statementPage.jsp">Display Bank Statement</a></td></tr>
 <tr><td>&nbsp;</td></tr>
 <tr><td><a href="verificationPage.jsp">Authorize Credit Card Amount</a></td></tr>
 <tr><td>&nbsp;</td></tr>
 </table>
 </body>
</html>
