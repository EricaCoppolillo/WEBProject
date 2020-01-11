package persistence;

import java.util.ArrayList;

import model.Amministratore;
import model.Utente;
import persistence.DataSource;
import persistence.dao.AmministratoreDao;
import persistence.dao.jdbc.AmministratoreDaoJDBC;

public class DBManager {
	
	private static DBManager instance;
	private static  DataSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource = new DataSource("jdbc:postgresql://localhost:5432/Progetto","postgres","_cuoricino1999_");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	private ArrayList<Utente> utenti;
	private ArrayList<Amministratore> amministratori;
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
		amministratori = new ArrayList<Amministratore>();
	}
	
	public static DBManager getInstance() {
		if(instance == null) {
			instance = new DBManager();
		}
		return instance;
	} 
	
	public void registraUtente(Utente u) {
		if(u!=null)
			utenti.add(u);
	}
	
	public boolean utenteRegistrato(Utente utente) {
		for(Utente u : utenti) {
			if(utente.getUsername().equals(u.getUsername()) && utente.getPassword().equals(u.getPassword()))
				return true;
		}
		return false;
	}
	
	public Amministratore getAmministratore(String id, String password) {
		return getAmministratoreDao().findAdmin(id, password);
	}
	
	public AmministratoreDao getAmministratoreDao() {
		return new AmministratoreDaoJDBC(dataSource);
		
	}
	public void stampaUtenti() {
		for(Utente u : utenti) {
			System.out.println(u.getUsername() + " " + u.getPassword());
		}
	}
}
