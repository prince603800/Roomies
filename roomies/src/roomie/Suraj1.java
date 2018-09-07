package roomie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Suraj1")
public class Suraj1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Suraj1() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String name = request.getParameter("name");
		int cost = Integer.parseInt(request.getParameter("cost"));
		
	
		
		try{
			Connection con = Database.conn();
			 PreparedStatement ps = con.prepareStatement("insert into prince_expense(date,name,cost)values(curdate(),?,?)");
			ps.setString(1, name);
			ps.setInt(2, cost);
			
			int i = ps.executeUpdate();
			if(i>0){
				RequestDispatcher rd = request.getRequestDispatcher("suraj1.html");
				rd.forward(request, response);
			}
			else{
				out.print("last entry was not successful  TRY AGAIN");
				RequestDispatcher rd = request.getRequestDispatcher("suraj1.html");
				rd.include(request, response);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
