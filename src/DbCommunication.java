
import java.sql.*;
import java.text.*;
import java.util.*;




import javax.servlet.http.HttpSession;
public class DbCommunication {
	Statement st;
	
	
	public DbCommunication()
	{
				
		//db_connection db_conn = db_connection.getInstance();
		//st=db_conn.create_connection();
		st=DbConnection.createConnection();
		
	      
	}
	
	public boolean validateLogin(String username,String password )
	{  
		
		
		
		try
		{   
			String str_qry = "select * from b_login_details where userid='"+username + "' AND password='"+password + "'";
			System.out.println("Given query is : " + str_qry);
			ResultSet rst=st.executeQuery(str_qry);
			
			if (rst.next())
			{
				return true;
			}
			
			
		}
		catch (Exception e)
		{
    
		}
	
		return false;
}
	public int accountCreation(String name,String dob,String address,String email,String userid )
	{  
		int AccNo=0;
		try
		{   
			
			//String ins_qry = "INSERT INTO b_account_details (name,email_id) VALUES ('"+name+"','"+email+"')";
			String ins_qry = "INSERT INTO b_account_details (userid,name,email_id,address,balance,dob) VALUES ('"+userid+"','"+name+"','"+email+"','"+address+"','5000',STR_TO_DATE('"+dob+"', '%Y-%m-%d'))";
			System.out.println("Given query is : " + ins_qry);
			st.executeUpdate(ins_qry);
					
			String acct_no_qry = "select MAX(account_no) AS AccNo from b_account_details";
			System.out.println("Given query is : " + acct_no_qry);
			ResultSet acc_no_rst=st.executeQuery(acct_no_qry);
			
			
			if (acc_no_rst.next())
			{
				return acc_no_rst.getInt("AccNo");
			}
			
			
		}
		catch (Exception e)
		{
    
		}
		return AccNo;
	
}
	public void transactionOperation(String value, int account, int amount, String userid)
	{
		
		int amt_user_himself=0,updated_amt_user_himself=0,updated_amt_another_user=0,amt_another_user=0,account_user_himself=0;	
		String descrption_user_himself="",descrption_another_user="", userid_another_user="";
		
		try
		{
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			
		String qry_another_user = "select balance, userid from b_account_details where account_no='"+account + "'";
		String qry_user_himself = "select balance,account_no from b_account_details where userid='"+userid + "'";
		
		System.out.println(qry_another_user);
		System.out.println(qry_user_himself);

		 	    
		
			ResultSet rst_user_himself=st.executeQuery(qry_user_himself);
			while(rst_user_himself.next())
				{
					amt_user_himself = rst_user_himself.getInt("balance");
					account_user_himself = rst_user_himself.getInt("account_no");
				}
			
			ResultSet rst_another_user=st.executeQuery(qry_another_user);
			while(rst_another_user.next())
				{
					amt_another_user = rst_another_user.getInt("balance");	
					userid_another_user = rst_another_user.getString("userid");
				}
			
			if(value.equals("Credit To"))
				{  
					updated_amt_user_himself=amt_user_himself-amount;
					updated_amt_another_user=amt_another_user+amount;
					descrption_user_himself="Debit";
					descrption_another_user="Cebit";
				}
			
			if(value.equals("Debit From"))
			{  
				updated_amt_user_himself=amt_user_himself+amount;
				updated_amt_another_user=amt_another_user-amount;
				descrption_user_himself="Credit";
				descrption_another_user="Debit";
			}
			
			String up_another_user = "UPDATE b_account_details SET balance= "+updated_amt_another_user +" where account_no='"+account + "'";
			System.out.println(up_another_user);
			st.executeUpdate(up_another_user);
			
			String up_user_himself = "UPDATE b_account_details SET balance= "+updated_amt_user_himself +"  where userid='"+userid + "'";
			System.out.println(up_user_himself);
			st.executeUpdate(up_user_himself);
			
			
		    String insert_user_himself = "INSERT INTO b_transactions (trans_date,trans_type,descrption,account_no,amount,available_balance,userid) VALUES ('"+ourJavaDateObject+"','Online Transaction','"+descrption_user_himself+"','"+account_user_himself+"','"+amount+"','"+updated_amt_user_himself+"','"+userid+"')";
			System.out.println(insert_user_himself);
			st.executeUpdate(insert_user_himself);
			
			String insert_another_user = "INSERT INTO b_transactions (trans_date,trans_type,descrption,account_no,amount,available_balance,userid) VALUES ('"+ourJavaDateObject+"','Online Transaction','"+descrption_another_user+"','"+account+"','"+amount+"','"+updated_amt_another_user+"','"+userid_another_user+"')";
			System.out.println(insert_another_user);
			st.executeUpdate(insert_another_user);  
    		
	}
	catch (Exception e)
	{
    
	}
		
}
	public class Row { 
	    private String trans_type;
	    private String descrption;
	    
	    public void setTransType(String value)
	    {
	   	    	trans_type = value;
	   	    	
	    }
	    
	    public void setDescription(String value)
	    {
	    		descrption = value;
	    }
	    
	}
	public void statementDetails(String from_date,String to_date,String userid )
	{  
		//List<String> bilers = new ArrayList<String>();
		//List<Row> list();
		List<Row> rows = new ArrayList<Row>();
		ResultSet rst=null;
		

		try
		{   
			String statement_qry = "select * from b_transactions where trans_date BETWEEN '"+from_date + "' AND '"+to_date + "'AND userid='"+userid + "'";
			System.out.println("Given query is : " + statement_qry);
			
			rst=st.executeQuery(statement_qry);
			while (rst.next()) {
	            Row row = new Row();
	          row.setTransType(rst.getString("trans_type"));
	          row.setDescription(rst.getString("descrption"));
	          rows.add(row);
	         
	        }
		
		}
		catch (Exception e)
		{
    
		}
		// return rst1;
	    
	
	}
	
	public void login()
	{
		System.out.println("Welcome");
	}
}
