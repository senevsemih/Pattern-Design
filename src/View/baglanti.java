package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti {
	
	static Connection myConn;
	static Statement myStat;
		
		static ResultSet yap(
				
		
		) {
			ResultSet myRs = null;
			
			try {
				
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banka?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
				myStat = myConn.createStatement();
				myRs = myStat.executeQuery("select * from test,klasik,bosluk");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return myRs;
		}
		
		static void ekle(String sql_sorgu) {
			
			try {
				myStat.executeUpdate(sql_sorgu);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
		}
		
		static void update(String sql_sorgu) {
			
			try {
				myStat.executeUpdate(sql_sorgu);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public static void sil(String sql_sorgu) {
			
			try {
				myStat.executeUpdate(sql_sorgu);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		static ResultSet hazýrla(String sql_sorgu) {
			
			ResultSet myRs = null;
			
			try {
				myRs = myStat.executeQuery(sql_sorgu);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return myRs;
		}

}
