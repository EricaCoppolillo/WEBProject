package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.User;
import persistence.DataSource;
import persistence.dao.UserDao;

public class UserDaoJDBC implements UserDao {

	private DataSource dataSource;
	private Connection connection;
	
	public UserDaoJDBC(DataSource dataS) {
		dataSource = dataS;
		connection = null;
	}
	
	@Override
	public void registerUser(User user) {
		try {
			connection = dataSource.getConnection();
			
			String registration = "insert into user(surname, name, birthDate, email, username, password, securityQuestion, securityAnswer) values (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(registration);
			statement.setString(1, user.getSurname());
			statement.setString(2, user.getName());
			statement.setDate(3, (java.sql.Date) user.getBirthDate());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getSecurityQuestion());
			statement.setString(8, user.getSecurityAnswer());
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public User findUser(String username) {
		User user = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "Select * from user where username=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	@Override
	public User findUserByEmail(String email) {
		User user = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from user where email=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

	@Override
	public List<User> findAll() {
		return null;
	}
}
