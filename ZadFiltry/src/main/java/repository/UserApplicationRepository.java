package repository;

import domain.UserApplication;

import java.util.List;

public interface UserApplicationRepository {

	UserApplication getApplicationByUsername(String username);

	void addUser(UserApplication userApplication);

	List<UserApplication> getAll();

	void setPremium(String username);

	void removePremium(String usnername);

	void addAdmin();
}
