package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertTest {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/test_ms?useSSL=false";
		String id = "root";
		String password = "0613";
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버적재");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 적재 실패.");
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결 실패.");
		}

		return con;
	}

	private static void addBook(String name, String publisher, String age, int price) {
		Statement stmt = null;
		Connection con = makeConnection();
		try {
			stmt = con.createStatement();
			String query = "INSERT INTO books (name, publisher, age, price) VALUES ";
			query += "('" + name + "','" + publisher + "','" + age + "','" + price + "')";
			System.out.println(query);
			int i = stmt.executeUpdate(query);
			if (i != 0)
				System.out.println("레코드 출력 성공");
			else
				System.out.println("레코드 추가 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
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

	public static void main(String arg[]) {
		addBook("Artificial Intellegence", "Addison Wesley", "2002", 35000);
	}
}
