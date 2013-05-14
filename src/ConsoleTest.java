/**
 * 
 * @author Alec
 *
 */
import java.sql.*;
public class ConsoleTest {

	 
		public static void main(String[] argv) {
	 
			System.out.println("-------- Oracle JDBC Connection Testing ------");	 
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 
					System.out.println("Oracle JDBC Driver Registered!");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver not found");
					e.printStackTrace();
				}
				try {
					String url = "jdbc:oracle:thin:@Akira:1521:xe";
					String username = "areyna";
					String password = "slash";
					Connection connection = null;
					connection = DriverManager.getConnection(url, username, password);	
					System.out.println("Connected! You can query the database now.");
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM solsun_staff";
					ResultSet rs = statement.executeQuery(query);
					System.out.println("Executed query into resultSet");
					while(rs.next()){
						System.out.println("S_NUM:" + rs.getString(1) + "\t First Name:" + rs.getString(2) + "\t Last Name: " + rs.getString(3) + "\t Hire Date: " + rs.getString(4));
						
					}
					rs.close();
					connection.close();
					
				} catch (Exception e) {
					e.printStackTrace();
			}
		
		}
	 
}