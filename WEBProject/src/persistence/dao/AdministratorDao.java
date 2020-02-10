package persistence.dao;

import java.util.ArrayList;

import model.Administrator;

public interface AdministratorDao {

	public Administrator findAdmin(int id, String password);
	public ArrayList<Administrator> findAll();
}
