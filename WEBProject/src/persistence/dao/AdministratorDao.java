package persistence.dao;

import java.util.ArrayList;

import model.Administrator;

public interface AdministratorDao {

	public Administrator findAdmin(String id, String password);
	public ArrayList<Administrator> findAll();
}
