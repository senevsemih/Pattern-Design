package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti_2 {


		static void aktar(String sql_sorgu) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/banka2?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234"); 

			Statement s = c.createStatement();
			
				try {
					
					s.executeUpdate(sql_sorgu);
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
				
			}
}
