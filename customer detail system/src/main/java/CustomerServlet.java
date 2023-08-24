

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	//create query
	private static final String INSERT_QUERY ="INSERT INTO USERS(FNAME,LNAME,STREET,ADDRESS,CITY,STATE,EMAIL,PHONE) VALUES(?,?,?,?,?,?,?,?)";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get printwriter
		PrintWriter pw = res.getWriter();
		//SET CONtent type
		res.setContentType("text/html");
		 pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
		
		//read the form values
		String firstname = req.getParameter("Firstname");
		String lastname = req.getParameter("Lastname");
		String street = req.getParameter("Street");
		String address = req.getParameter("Address");
		String city = req.getParameter("City");
		String state = req.getParameter("State");
		String  email  = req.getParameter("Email");
		String phone = req.getParameter("Phone");
		
		//load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///customer","root","Jaydeep@123");
			PreparedStatement ps =con.prepareStatement(INSERT_QUERY);){
				
				//SET THE VALUES
				
				ps.setString(1,firstname );
				ps.setString(2,lastname );
				ps.setString(3,street );
				ps.setString(4,address );
				ps.setString(5, city);
				ps.setString(6,state );
				ps.setString(7,email );
				ps.setString(8,phone );
				
				//execute the query
				int count = ps.executeUpdate();
				if (count==0) {
					pw.println("Record Not Registered");
					
				}else {
					pw.println("Record Registered");
				}
			
		}catch (SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
			
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
			
		}
		pw.println("<a href = 'customer.jsp'><button type='button'>ADD CUSTOMER</button></a>");
		
	//System.out.println("Firstname: "+fname);
	//System.out.println("Lastname: "+lname)
	
		//close the string
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet (req,resp);
	}
	

}
