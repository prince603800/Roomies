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
		
		
		int dheraj = DherajTotal.dheraj();
		out.print("Dheraj: ");
		out.print(dheraj);
		out.print("  ");
		
		int prince = PrinceTotal.prince();
		out.print("prince: ");
		out.print(prince);
		out.print(" ");
		
		int suraj = SurajTotal.suraj();
		out.print("suraj: ");
		out.print(suraj);
		out.print(" ");
		
		int sum = prince+dheraj+suraj;
		int average =  sum/3;
		
		if(prince == dheraj && dheraj == suraj){
			
		}
		
		if(prince>average && suraj>average &&dheraj<average){
			int sum1,sum2,sum3;
			out.print("Dheraj has to pay ");
			out.print(prince-average);
			out.print("to prince and ");
			out.print(suraj-average);
			out.print("to suraj");
		}
		
		else if(prince>average && suraj<average && dheraj<average){
			out.print("Suraj has to pay ");
			out.print(average-suraj);
			out.print("to prince and dheraj has to pay");
			out.print(average-dheraj);
			out.print("to prince");
		}
		else if(prince>average && dheraj>average &&suraj<average){
			out.print("Suraj has to pay");
			out.print(prince-average);
			out.print("to prince and ");
			out.print(dheraj-average);
			out.print("to dheraj");
		}
		else if(suraj>average && prince<average && dheraj<average){
			out.print("Prince has to pay ");
			out.print(average-prince);
			out.print("to suraj and dheraj has to pay ");
			out.print(average-dheraj);
			out.print("to suraj");
			
		}
		else if(suraj>average && dheraj>average && prince<average){
			out.print("prince has to pay ");
			out.print(suraj-average);
			out.print("to suraj and has to pay ");
			out.print(dheraj-average);
			out.print("to dheraj");
		}
		else if(dheraj>average && suraj<average && prince<average){
			out.print("Prince has to pay");
			out.print(average-prince);
			out.print("and suraj has to pay");
			out.print(average-suraj);
			out.print("to dheraj");
		}
		
		
		
		
}}

