package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTest {

	public static void main(String agrs[]) {
		Statement stmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test_ms?useSSL=false";

			con = DriverManager.getConnection(url, "root", "0613");

			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			stmt = con.createStatement();

			boolean result = stmt.execute("show tables");
			if (result) {
				System.out.println("SQL command was executed sucessfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
