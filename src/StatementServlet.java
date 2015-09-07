import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.ResultSet;
import java.util.*;


public class StatementServlet extends HttpServlet {
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		/*String n=request.getParameter("username");
		out.print("Welcome "+n);*/
		
	
		String from_date=request.getParameter("from_date");
		String to_date=request.getParameter("to_date");
		
		
		HttpSession session = request.getSession(true);
		String userid=(String)session.getAttribute( "theName" );
		
		DbCommunication db_comm = new DbCommunication();
		//ResultSet rst=db_comm.statementDetails(from_date,to_date,userid);
		db_comm.statementDetails(from_date,to_date,userid);
		
		 
		
		String redirectURL = "statementPage.jsp";
		response.sendRedirect(redirectURL);
		session.setAttribute( "StatementMsgStatus", "set" ); // How to pass ResultSet?
		
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
