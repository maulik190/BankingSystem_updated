import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;


public class TransactionServlet extends HttpServlet {
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		/*String n=request.getParameter("username");
		out.print("Welcome "+n);*/
		
		String value=request.getParameter("submit");
		int account=Integer.parseInt(request.getParameter("account_no"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		
		
		HttpSession session = request.getSession(true);
		String userid=(String)session.getAttribute( "theName" );
		
		DbCommunication db_comm = new DbCommunication();
		db_comm.transactionOperation(value,account,amount,userid);
		//out.print("Transaction executed successfully");
		
		String redirectURL = "transactionPage.jsp";
		response.sendRedirect(redirectURL);
		session.setAttribute( "TransactionMsgStatus", "set" );
		
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
