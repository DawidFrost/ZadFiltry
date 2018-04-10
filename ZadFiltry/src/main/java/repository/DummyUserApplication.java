package repository;

import domain.UserApplication;

import java.util.ArrayList;
import java.util.List;

public class DummyUserApplication implements UserApplicationRepository {

	private static List<UserApplication> db
			= new ArrayList<UserApplication>();

	public UserApplication getApplicationByUsername(String username) {
		for (UserApplication user : db) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public void addUser(UserApplication userApplication) {
		db.add(userApplication);
	}

	public List<UserApplication> getAll() {
		return db;
	}

	public void setPremium(String username) {
		UserApplication user = getApplicationByUsername(username);
		user.setType("premium");
	}

	public void removePremium(String username) {
		UserApplication user = getApplicationByUsername(username);
		user.setType("user");
	}

	public void addAdmin() {
		UserApplication admin = new UserApplication();
		admin.setType("admin");
		admin.setEmail("admin@admin.com");
		admin.setUsername("admin");
		admin.setPassword("admin");
		db.add(admin);
	}
}
