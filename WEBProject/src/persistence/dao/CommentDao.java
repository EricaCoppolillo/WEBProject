package persistence.dao;

import java.util.ArrayList;

import model.Comment;

public interface CommentDao {

	public void saveComment(int idProduct, String content);
	public ArrayList<Comment> getCommentForProduct(int idProduct);
}
