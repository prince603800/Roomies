package roomie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurajTotal {

	public static int suraj() {
		
			int sum =0;
			try {
				Connection con = Database.conn();
				PreparedStatement ps = con.prepareStatement("select *from suraj_exp");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int i = rs.getInt(4);
					sum += i;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sum;
		}
	}


