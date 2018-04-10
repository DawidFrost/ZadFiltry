package repository;

import database.HSQLconnection;
import domain.UserApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HSQLrepositry implements UserApplicationRepository {

	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS user (id BIGINT GENERATED BY DEFAULT AS IDENTITY , " +
			"username VARCHAR(15), password VARCHAR(15), email VARCHAR(15),type VARCHAR(10))";
	private static final String FIND_USER = "SELECT * FROM user WHERE username=?";
	private static final String ADD_USER = "INSERT INTO user (username, password, email, type) VALUES (?,?,?,?)";
	private static final String GET_ALL = "SELECT * FROM USER ";
	private static final String SET_PREMIUM = "UPDATE user SET type=? WHERE username =?";

	private Connection connection;

	public HSQLrepositry() {
		connection = new HSQLconnection().getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(CREATE_TABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserApplication getApplicationByUsername(String username) {
		UserApplication user = new UserApplication();
		try {
			PreparedStatement statement = connection.prepareStatement(FIND_USER);
			statement.setString(1, username);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setType(rs.getString("type"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void addUser(UserApplication userApplication) {
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_USER);
			statement.setString(1, userApplication.getUsername());
			statement.setString(2, userApplication.getPassword());
			statement.setString(3, userApplication.getEmail());
			statement.setString(4, userApplication.getType());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<UserApplication> getAll() {
		List<UserApplication> users = new ArrayList<UserApplication>();
		try {
			PreparedStatement statement = connection.prepareStatement(GET_ALL);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				UserApplication user = new UserApplication();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setType(rs.getString("type"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void setPremium(String username) {
		try {
			PreparedStatement statement = connection.prepareStatement(SET_PREMIUM);
			statement.setString(1, "premium");
			statement.setString(2, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removePremium(String username) {
		try {
			PreparedStatement statement = connection.prepareStatement(SET_PREMIUM);
			statement.setString(1, "user");
			statement.setString(2, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addAdmin() {
		UserApplication admin = new UserApplication();
		admin.setType("admin");
		admin.setEmail("admin@admin.com");
		admin.setUsername("admin");
		admin.setPassword("admin");
		addUser(admin);
	}
}