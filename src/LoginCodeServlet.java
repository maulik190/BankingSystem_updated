import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class LoginCodeServlet extends HttpServlet {
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		/*String n=request.getParameter("username");
		out.print("Welcome "+n);*/
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean ans = false;
		DbCommunication db_comm = new DbCommunication();
		ans= db_comm.validateLogin(username,password);
		HttpSession session = request.getSession(true);
		out.println("User exists : " + ans);
		
		if(ans)
		{
		 String redirectURL = "welcomePage.jsp";
		 response.sendRedirect(redirectURL);
		 session.setAttribute( "theName", username );
		}
		else
		{
		String redirectURL = "loginPage.jsp";
		response.sendRedirect(redirectURL);
		session.setAttribute( "loginDetails", "invalid" );
			
		}
		
		//out.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
