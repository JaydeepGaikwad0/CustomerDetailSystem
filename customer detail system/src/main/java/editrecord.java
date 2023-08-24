
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

@WebServlet("/edit")
public class editrecord extends HttpServlet {
    private final static String INSERT_QUERY = "UPDATE USERS SET FNAME=?,LNAME=?,STREET=?,ADDRESS=?,CITY=?,STATE=?,EMAIL=?,PHONE=? WHERE id=?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        //get the values
        int id = Integer.parseInt(req.getParameter("id"));
        String fname = req.getParameter("FNAME");
        String lname = req.getParameter("LNAME");
        String street = req.getParameter("STREET");
        String address = req.getParameter("ADDRESS");
        String city = req.getParameter("CITY");
        String state = req.getParameter("STATE");
        String email = req.getParameter("EMAIL");
        String phone = req.getParameter("PHONE");
        
        //load the JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///customer","root","Jaydeep@123");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
            //set the values
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, street);
            ps.setString(4, address);
            ps.setString(5, city);
            ps.setString(6, state);
            ps.setString(7, email);
            ps.setString(8, phone);
            ps.setInt(9, id);
            //execute the query
            int count = ps.executeUpdate();
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count==1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Edited Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Not Edited</h2>");
            }
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<a href='login.jsp'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("&nbsp; &nbsp;");
        pw.println("<a href='showdata'><button class='btn btn-outline-success'>Show User</button></a>");
        pw.println("</div>");
        //close the stram
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}
