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

@WebServlet("/editurl")
public class editscreen extends HttpServlet {
    private final static String INSERT_QUERY = "SELECT FNAME,LNAME,STREET,ADDRESS,CITY,STATE,EMAIL,PHONE FROM USERS WHERE id=?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");

        //get the id
        //get the values
        int id = Integer.parseInt(req.getParameter("id"));
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///customer","root","Jaydeep@123");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
            //set value 
            ps.setInt(1, id);
            //resultSet
            ResultSet rs = ps.executeQuery();
            rs.next();
            pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
            pw.println("<form action='edit?id="+id+"' method='post'>");
            pw.println("<table class='table table-hover table-striped'>");
            pw.println("<tr>");
            pw.println("<td>Firstname</td>");
            pw.println("<td><input type='text' name='FNAME' value='"+rs.getString(1)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Lastname</td>");
            pw.println("<td><input type='text' name='LNAME' value='"+rs.getString(2)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Street</td>");
            pw.println("<td><input type='text' name='STREET' value='"+rs.getString(3)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Address</td>");
            pw.println("<td><input type='text' name='ADDRESS' value='"+rs.getString(4)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>City</td>");
            pw.println("<td><input type='text' name='CITY' value='"+rs.getString(5)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>State</td>");
            pw.println("<td><input type='text' name='STATE' value='"+rs.getString(6)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Email</td>");
            pw.println("<td><input type='text' name='EMAIL' value='"+rs.getString(7)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Phone</td>");
            pw.println("<td><input type='text' name='PHONE' value='"+rs.getString(8)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
            pw.println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>");
            pw.println("</tr>");
            pw.println("</table>");
            pw.println("</form>");
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<a href='login.jsp'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
        //close the stream
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}
