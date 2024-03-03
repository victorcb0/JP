package lab;

import java.sql.*;

public class Ex {
	public static void main(String[]args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/test";
		Statement sql;
		ResultSet rs;
		Connection con = DriverManager.getConnection (url, "root", "root");
		sql = con.createStatement();
		rs = sql.executeQuery("select * from persoane");
		while (rs.next())
			System.out.println("id = "+rs.getInt("Id")+", nume = " + rs.getString("nume")
			+ ", varsta = "+rs.getInt(3));
		con.close();
		sql.close();
		rs.close();
	}
}
