package roomie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Count1 {
	
	public static int count2(){
		int count=0;
		try {
			Connection con = Database.conn();
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM prince_expense");
			ResultSet rs = ps.executeQuery();
			rs.next();
			 count = rs.getInt(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;}
	
	public static int count3(int count){
		int total = 0;
		try {
			Connection con = Database.conn();
			PreparedStatement ps = con.prepareStatement("select *from prince_expense where id = ?");
			ps.setInt(1, count);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(5);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
		
	}
	
}
