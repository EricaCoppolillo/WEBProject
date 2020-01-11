package persistence.dao;

import java.util.ArrayList;

import model.Amministratore;

public interface AmministratoreDao {

	public Amministratore findAdmin(String id, String password);
	public ArrayList<Amministratore> findAll();
}
