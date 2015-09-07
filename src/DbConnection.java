
import java.sql.*;


public class DbConnection
{
	
	private static Statement st;
	private static Connection con;
		   
	   
		   public static Statement createConnection()
		   {
		      		  
			   if (null == st)
		       	{
		    	    	  
				   try
				   {
					   Class.forName("com.mysql.jdbc.Driver");
					   System.out.println("Driver loaded...");

					   con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","root");
					   System.out.println("Connected to the database");

					   st=con.createStatement();
		  			
		  		 	}
				   catch (Exception e)
				   {
		  	    
				   }
		       	}
				return st;
		    
		    
		   }

	}
