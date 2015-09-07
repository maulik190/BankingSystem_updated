import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;


public class AccountCreationServlet extends HttpServlet {
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		/*String n=request.getParameter("username");
		out.print("Welcome "+n);*/
		
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		HttpSession session = request.getSession(true);
		String userid=(String)session.getAttribute( "theName" );
		int AccNo=0;
		String AccMsg="";
		
			
		DbCommunication db_comm = new DbCommunication();
		AccNo=db_comm.accountCreation(name,dob,address,email,userid);
		//db_comm.accountCreation(name,email);
		AccMsg="Account created successfully. Account number is:"+AccNo;
		//out.println(AccMsg);
		
		String redirectURL = "accountCreationPage.jsp";
		response.sendRedirect(redirectURL);
		session.setAttribute( "AccCreationalMsgStatus", "set" );
		session.setAttribute( "AccCreationalMsg", AccMsg );
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
