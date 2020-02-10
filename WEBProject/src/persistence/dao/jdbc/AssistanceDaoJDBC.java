package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import model.Comment;
import persistence.DBManager;
import persistence.DataSource;
import persistence.dao.AssistanceDao;
import technicalServices.MailUtility;

public class AssistanceDaoJDBC implements AssistanceDao {

	private DataSource dataSource;
	private Connection connection;
	
	public AssistanceDaoJDBC(DataSource dataS) {
		dataSource = dataS;
		connection = null;
	}
	
	public void sendAssistanceMail(String username) {
		try {
			connection = dataSource.getConnection();
			
			String query = "select id, email from administrator";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				try {
					MailUtility.sendAssistanceMail(result.getString(2), ""+result.getInt(1), username);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			
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
	public void saveQuestion(int idUser, String username, String question) {
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into \"assistanceComment\"(\"idUser\", comment) values(?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idUser);
			statement.setString(2, question);
			
			String query2 = "insert into \"assistanceAdminQuestion\"(\"idUser\", question) values(?,?)";
			PreparedStatement statement2 = connection.prepareStatement(query2);
			statement2.setInt(1, idUser);
			statement2.setString(2, question);
			
			statement.executeUpdate();
			statement2.executeUpdate();
			
			sendAssistanceMail(username);
			
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
	public ArrayList<Comment> getComments(int idUser) {
		ArrayList<Comment> questions = new ArrayList<Comment>();
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select \"idAdmin\", comment from \"assistanceComment\" where \"idUser\" = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idUser);

			ResultSet result = statement.executeQuery();
			while(result.next()) {
				
				Comment c = new Comment();
				Integer idAdmin = result.getInt(1);
				if(idAdmin > 0) 
					c.setUsername("Amministratore "+idAdmin);
				else
					c.setUsername("Tu");
				
				c.setContent(result.getString(2));
				questions.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return questions;
	}

	@Override
	public ArrayList<Comment> getAllQuestions() {
		ArrayList<Comment> questions = new ArrayList<Comment>();
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from \"assistanceAdminQuestion\"";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Comment c = new Comment();
				
				String query2 = "select username from \"user\" where id = ?";
				PreparedStatement statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, result.getInt(1));
				
				ResultSet result2 = statement2.executeQuery();
				if(result2.next()) 
					c.setUsername(result2.getString(1));
				
				c.setContent(result.getString(2));
				
				questions.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return questions;
	}

	@Override
	public void saveAnswer(int idAdmin, int idUser, String answer) {
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into \"assistanceComment\"(\"idAdmin\", \"idUser\", comment) values(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idAdmin);
			statement.setInt(2, idUser);
			statement.setString(3, answer);
			
			statement.executeUpdate();
			
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
	public void deleteUserQuestion(int idUser, String content) {
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from \"assistanceAdminQuestion\" where \"idUser\" = ? and question = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idUser);
			statement.setString(2, content);

			statement.executeUpdate();
			
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
	public void deleteComments(int idUser) {
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from \"assistanceComment\" where \"idUser\" = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idUser);

			statement.executeUpdate();
			
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
}
