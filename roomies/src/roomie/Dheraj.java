package roomie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dheraj
 */
@WebServlet("/Dheraj")
public class Dheraj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dheraj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String name = request.getParameter("name");
		int cost = Integer.parseInt(request.getParameter("cost"));
		
		
		try {
			Connection con = Database.conn();
			PreparedStatement ps = con.prepareStatement("insert into dheraj_expense(date,name,cost)values(curdate(),?,?)");
			ps.setString(1, name);
			ps.setInt(2, cost);
			
			int i = ps.executeUpdate();
			if(i>0){
				RequestDispatcher rd = request.getRequestDispatcher("dheraj.html");
				rd.forward(request, response);
			}
			else{
				out.print("last entry was not successful  TRY AGAIN");
				RequestDispatcher rd = request.getRequestDispatcher("dheraj.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
