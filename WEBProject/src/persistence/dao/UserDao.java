package persistence.dao;

import java.util.List;

import model.User;

public interface UserDao {

	public void registerUser(User user);
	public User findUser(String username, String password);
	public User findUserByEmail(String email);
	public User findUserByUsername(String username);    
	public String findSecurityQuestion(String username);
	public String findPassword(String username, String answer);
	public List<User> findAll();
	public void updatePassword(String username, String newPassword);
}
