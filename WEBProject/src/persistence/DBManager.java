package persistence;

import java.util.ArrayList;

import model.Amministratore;
import model.Utente;

public class DBManager {
	
	private static DBManager instance;
	
	private ArrayList<Utente> utenti;
	private ArrayList<Amministratore> amministratori;
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
		amministratori = new ArrayList<Amministratore>();
		caricaAmministratori();
	}
	
	public static DBManager getInstance() {
		if(instance == null) {
			instance = new DBManager();
		}
		return instance;
	} 
	
	public void caricaAmministratori() {
		//carico dal DB tutti gli amministratori presenti 
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
	
	public boolean amministratoreRegistrato(Amministratore a) {
		return amministratori.contains(a);
	}
	
	public void stampaUtenti() {
		for(Utente u : utenti) {
			System.out.println(u.getUsername() + " " + u.getPassword());
		}
	}
}
