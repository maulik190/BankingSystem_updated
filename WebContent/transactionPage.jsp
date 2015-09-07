<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<title>Transaction form</title>
</head>
<body  bgcolor="#ebeaea">
 <p align="center"><b><font size="+1">Transaction</font></b></p>

<% 

String TransactionMsgStatus=(String)session.getAttribute( "TransactionMsgStatus" );
if(TransactionMsgStatus=="set")
{
	out.println("<b><font size='+1' color='#00CC33'>Transaction executed successfully</font></b>");

session.removeAttribute("AccCreationalMsgStatus");

}

 %>
<form action="TServlet" method="post">
<table align="Left">
<tr>
<td>Account No</td>
<td>:</td>
<td><input type="text" name="account_no"/></td>
</tr><tr>
<td>Amount</td>
<td>:</td>
<td><input type="text" name="amount"/></td>
</tr><tr>
<td colspan="3" align="center"><input name="submit" type="submit" value="Debit From">&nbsp;&nbsp;
<input name="submit" type="submit" value="Credit To"></td>
</tr>
</table>
</form>
</body>
</html>

