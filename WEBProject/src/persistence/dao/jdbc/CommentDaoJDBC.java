package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comment;
import persistence.DataSource;
import persistence.dao.CommentDao;

public class CommentDaoJDBC implements CommentDao {

	private DataSource dataSource;
    private Connection connection;

    public CommentDaoJDBC(DataSource dataSource){
        this.dataSource = dataSource;
    }

	@Override
	public void saveComment(int idProduct, String content) {
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into comment(\"idProduct\", content) values(?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idProduct);
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
	public ArrayList<Comment> getCommentForProduct(int idProduct) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			connection = dataSource.getConnection();
			
			String query = "select content from comment where \"idProduct\" = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idProduct);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String s = result.getString(1);
				
				String[] parts = s.split("  ");
				Comment c = new Comment(parts[0], parts[1]);
				comments.add(c);
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
		
		return comments;
	}
}
