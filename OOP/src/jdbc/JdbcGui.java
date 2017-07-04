package jdbc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JdbcGui extends JFrame{
	JTextField id, title, p, year, price, author;
	JButton previousButton, nextButton, InsertButton, deleteButton, searchButton;
	ResultSet rs;
	Statement stmt;

	public JdbcGui() throws SQLException {
		super("Database Viewer");
		Connection con = makeConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM books");
		setLayout(new GridLayout(0, 2));
		add(new JLabel("ID", JLabel.CENTER));
		add(id = new JTextField());
		add(new JLabel("TITLE", JLabel.CENTER));
		add(title = new JTextField());
		add(new JLabel("PUBLISHER", JLabel.CENTER));
		add(p = new JTextField());
		add(new JLabel("YEAR", JLabel.CENTER));
		add(year = new JTextField());
		add(new JLabel("PRICE", JLabel.CENTER));
		add(price = new JTextField());
		add(new JLabel("���� �˻�", JLabel.CENTER));
		add(author = new JTextField());

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous();
					id.setText("" + rs.getInt("book_id"));
					title.setText("" + rs.getString("name"));
					p.setText("" + rs.getString("publisher"));
					year.setText("" + rs.getString("age"));
					price.setText("" + rs.getInt("price"));
					
				} catch (SQLException e) {
					try {
						con.close();
						stmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//e.printStackTrace();
					System.out.println("첫 번째 레코드입니다.");
				}
			}
		});

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.next();
					id.setText("" + rs.getInt("book_id"));
					title.setText("" + rs.getString("name"));
					p.setText("" + rs.getString("publisher"));
					year.setText("" + rs.getString("age"));
					price.setText("" + rs.getInt("price"));
				} catch (SQLException e) {
					try {
						con.close();
						stmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// e.printStackTrace();
					System.out.println("더 이상 출력할 레코드가 없습니다.");
				}
			}
		});
		add(nextButton);
		add(previousButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		// pack();
		setVisible(true);
	}

	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/test_ms?useSSL=false";
		String id = "root";
		String password = "0613";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 적재성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 적재 실패.");
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결 실패.");
		}
		return con;
	}
	
	public static void main(String agrs[]) throws SQLException{
		new JdbcGui();
	}
}

