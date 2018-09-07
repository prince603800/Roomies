package roomie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurajExpense
 */
@WebServlet("/SurajExpense")
public class SurajExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurajExpense() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			Connection con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select *from suraj_exp"); 
			ResultSet rs = ps.executeQuery();
			out.print("<head>");
			out.print("<style>table {font-family: arial, sans-serif;border-collapse: collapse;width: 100%;}td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;}tr:nth-child(even) {background-color: #dddddd;}</style>");
			out.print("</head>");
			out.print("<h1>Expenses Suraj</h2>");
			out.print("<table>");
			out.print("<tr><th>Index</th><th>Date</th><th>Name</th><th>Cost</th><th>Total</th></tr>");
			int total = 0;
			while(rs.next()){
			int index = rs.getInt(1);
			Date date = rs.getDate(2);
			String name = rs.getString(3);
			int i = rs.getInt(4);
			 total = total +i;
		  //  arr.getData(i);
		    out.print("<tr><td>'"+index+"'</td><td>'"+date+"'</td><td>'"+name+"'</td><td>'"+i+"'</td><td>'"+total+"'</tr>");
		
		}
		out.print("</table>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}


