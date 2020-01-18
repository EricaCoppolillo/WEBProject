package persistence.dao;

import java.util.List;

import model.User;

public interface UserDao {

	public void registerUser(User user);
	public User findUser(String username);
	public User findUserByEmail(String email);
	public List<User> findAll();     
}
