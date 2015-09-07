<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Statement form</title>
</head>
<body  bgcolor="#ebeaea">
 <p align="center"><b><font size="+1">Bank statement</font></b></p>


<form action="SServlet" method="post">
<table align="Left">
<tr>
<td colspan="5"> Date Range: </td>
</tr>
<tr>
<td> From: </td>
<td> <input type="text" name="from_date" value="" ></td>
<td> To: </td>
<td><input type="text" name="to_date" value=""  ></td>
<td> <input name="submit" type="submit" value="Display"></td>
</tr>
</table>

<p>&nbsp;</p>
<p>&nbsp;</p>
<% 
String StatementMsgStatus=(String)session.getAttribute( "StatementMsgStatus" );
if(StatementMsgStatus=="set")
{


 %>
<table align="Left" border=1>
  <tr>
    <th>SI No</th>
    <th>Date</th>
    <th>Description</th>
	<th>Cheque No</th>
	<th>Withdraw</th>
	<th>Deposit</th>
	<th>Available Balance</th>
  </tr>
  

<c:forEach items="${rows}" var="row">
   <tr>
    <td><c:out value="${row.trans_type}" /> </td>
	<td> Mau</td>
	<td> </td>
	<td> </td>
	<td> </td>
	<td></td>
	<td></td>
  </tr>
  </c:forEach>
<% 	session.removeAttribute("StatementMsgStatus");} %>
</table>
<%
//}
%>
<p>&nbsp;</p>
 </form>
</body>
</html>

