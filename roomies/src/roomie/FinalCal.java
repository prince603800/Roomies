package roomie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FinalCal
 */
@WebServlet("/FinalCal")
public class FinalCal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalCal() {
        super();
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		Connection con;
		try {
			con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select * from suraj_exp");
			ResultSet rs = ps.executeQuery();
			 while(rs.next()){
			 
			  sum1 = sum1+ rs.getInt(4);
			  con.close(); 
		}
			 out.print(sum1);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select * from prince_expense");
			ResultSet rs = ps.executeQuery();
			 while(rs.next()){
			 
			  sum2 = sum2+ rs.getInt(4);
			  con.close(); 
		}
			 out.print(sum2);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select * from dheraj_expense");
			ResultSet rs = ps.executeQuery();
			 while(rs.next()){
			 
			  sum3 = sum3+ rs.getInt(4);
			  con.close(); 
		}out.print(sum3);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 int average = ( sum1+ sum2+ sum3)/3;
		 
		 int  suraj = sum1 - average;
		 int  prince = sum2 - average;
		 int dheraj = sum3 - average;
		
		if(suraj>average && prince>average){
			int owe1 = suraj - average;
			int owe2 = prince - average;
			int total = owe1+owe2;
			out.print("Dheeraj has to pay total sum of "+total+"in which ");
			out.print("To Suraj is : '" +owe1+"' " );
			out.print("To Prince is : '" + owe2+"'");
		}
		else if(prince>average && dheraj>average){
			int owe1 = prince - average;
			int owe2 = dheraj - average;
			int total = owe1+owe2;
			out.print("Suraj has to pay total sum of "+total+"in which ");
			out.print("To Prince is : '" +owe1+"' " );
			out.print("To Dheraj is : '" + owe2+"'");
		}
		else if(suraj>average && dheraj>average){
			int owe1 = dheraj - average;
			int owe2 = dheraj - average;
			int total = owe1+owe2;
			out.print("Prince has to pay total sum of "+total+"in which ");
			out.print("To Suraj is : '" +owe1+"' " );
			out.print("To Dheraj is : '" + owe2+"'");
		}
		else if(suraj>average && dheraj<average && prince<average){
			int owe1 = suraj - average;
			int pay1=  average - dheraj;
			int pay2 = average -prince;
			
			out.print("Suraj  will get "+owe1+"from prince and dheraj in which ");
			out.print("Dheraj has to pay is : '" +pay1+"' " );
			out.print("Prince has to  pay is : '" + pay2+"'");
		}
		else if(prince>average && dheraj<average && suraj<average){
			int owe1 = prince - average;
			int pay1=  average - dheraj;
			int pay2 = average -suraj;
			
			out.print("Prince  will get "+owe1+"from prince and dheraj in which ");
			out.print("Dheraj has to pay is : '" +pay1+"' " );
			out.print("Suraj has to  pay is : '" + pay2+"'");
		}
		else if(dheraj>average && prince<average && suraj<average){
			int owe1 = dheraj - average;
			int pay1=  average - prince;
			int pay2 = average -suraj;
			
			out.print("Dheraj  will get "+owe1+"from prince and dheraj in which ");
			out.print("Prince has to pay is : '" +pay1+"' " );
			out.print("Suraj has to  pay is : '" + pay2+"'");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		int i =0;
		int j;
		int k;
		Connection con;
		try {
			con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select count(*) from suraj_exp");
			ResultSet rs = ps.executeQuery();
			 rs.next();
			  i = rs.getInt(1);
			  out.print(i);
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select count(*) from prince_expense");
			ResultSet rs = ps.executeQuery();
			 rs.next();
			  j = rs.getInt(1);
			  out.print(j);
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select count(*) from dheraj_expense");
			ResultSet rs = ps.executeQuery();
			 rs.next();
			  k = rs.getInt(1);
			  out.print(k);
			  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select *from suraj_exp where id = ?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			 rs.next();
			  i = rs.getInt(columnIndex)
			  out.print(i);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}
}
