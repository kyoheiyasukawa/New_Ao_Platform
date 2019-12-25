package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.User;

public class RegisterDAO {
	public User findByLogin(Login login) {
		Connection conn = null;
		User user = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aoplat", "root", "1234");

			String sql = "INSERT INTO USER(NAME,TEXT) VALUES(?,?)";
			PreparedStatement go = conn.prepareStatement(sql);
			go.setString(1, user.getName());
			go.setString(2, user.getPass());

			ResultSet rs = go.executeQuery();

			if (rs.next()) {
				int userid = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("pass");

				user = new User(userid, name, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return user;
	}
}
