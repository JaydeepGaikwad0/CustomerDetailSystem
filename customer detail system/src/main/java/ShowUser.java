import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showdata")
public class ShowUser extends HttpServlet {

private static final String INSERT_QUERY ="SELECT ID,FNAME,LNAME,STREET,ADDRESS,CITY,STATE,EMAIL,PHONE FROM USERS";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get printwriter
		PrintWriter pw = res.getWriter();
		//SET CONtent type
		res.setContentType("text/html");
		//read the form values
		
		  pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		  pw.println("<marquee><h2 class='text-primary'>User Data</h2></marquee>");
		
		//load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///customer","root","Jaydeep@123");
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
				
			//resultset
			ResultSet rs = ps.executeQuery();
			 
			 pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
			 pw.println("<table class='table table-hover table-striped'>");
			
			 pw.println("<tr>");
	            
			    pw.println("<th>Id</th>");
	            pw.println("<th>Firstname</th>");
	            pw.println("<th>Lastname</th>");
	            pw.println("<th>Street</th>");
	            pw.println("<th>Address</th>");
	            pw.println("<th>City</th>");
	            pw.println("<th>State</th>");
	            pw.println("<th>Email</th>");
	            pw.println("<th>Phone</th>");
	            pw.println("</tr>");
	            while(rs.next()) {
	                pw.println("<tr>");
	                
	                pw.println("<td>"+rs.getInt(1)+"</td>");
	                pw.println("<td>"+rs.getString(2)+"</td>");
	                pw.println("<td>"+rs.getString(3)+"</td>");
	                pw.println("<td>"+rs.getString(4)+"</td>");
	                pw.println("<td>"+rs.getString(5)+"</td>");
	                pw.println("<td>"+rs.getString(6)+"</td>");
	                pw.println("<td>"+rs.getString(7)+"</td>");
	                pw.println("<td>"+rs.getString(8)+"</td>");
	                pw.println("<td>"+rs.getString(9)+"</td>");
	                pw.println("<td><a href='editurl?id="+rs.getInt(1)+"'>Edit</a></td>");
	                pw.println("<td><a href='deleteurl?id="+rs.getInt(1)+"'>Delete</a></td>");
	                pw.println("</tr>");
	            }
	            pw.println("</table>");
			
			
				
				
				
				
			
		}catch (SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
			
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
			
		}
		pw.println("<a href = 'customer.jsp'><button type='button'>ADD CUSTOMER</button></a>");
		
	//System.out.println("Firstname: "+fname);
	//System.out.println("Lastname: "+lname);
		
		//close the string
		pw.println("</div>");
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet (req,resp);
	}
	

}


