package persistence.dao;

import java.util.ArrayList;

import model.Comment;

public interface AssistanceDao {

	public void saveQuestion(int idUser, String question);
	public ArrayList<Comment> getComments(int idUser);
	public ArrayList<Comment> getAllQuestions();
	public void saveAnswer(int idAdmin, int idUser, String answer);
	public void deleteUserQuestion(int idUser, String content);
}
