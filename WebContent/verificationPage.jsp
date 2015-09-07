

<html>
<head>
<title>Account creation form</title>
</head>
<body  bgcolor="#ebeaea">
 <p align="center"><b><font size="+1">Authorize Credit Card Transaction</font></b></p>
<% 

  %>
  <p align="left"><b>Authorize !!</b></p>
<% /*}else { */%>
    <p align="left"><b>Unauthorize !!</b></p> 
<% /* }

    }*/ %>
<form action="ValidateServlet" method="post">
<table align="Left">
<tr>
<td>Name</td>
<td>:</td>
<td><input type="text" name="name"/></td>
</tr><tr>
<td>Card Number </td>
<td>:</td>
<td><input type="text" name="card_number"/></td>
</tr><tr>
<td>CVV2/CVC2</td>
<td>:</td>
<td><input type="text" name="cvv"/></td>
</tr><tr>
<td>Amount</td>
<td>:</td>
<td><input type="text" name="amount"/></td>
</tr><tr>
<td colspan="3" align="center"><input name="submit" type="submit" value="Create Account"></td>
</tr>
</table>
</form>
</body>
</html>

