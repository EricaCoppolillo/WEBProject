package model;

import java.util.Date;

public class Utente {

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String email;
	private Date dataNascita;
	private String domandaSicurezza;
	private String rispostaSicurezza;

	public Utente() {}

	public Utente(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getDomandaSicurezza() {
		return domandaSicurezza;
	}

	public void setDomandaSicurezza(String domandaSicurezza) {
		this.domandaSicurezza = domandaSicurezza;
	}

	public String getRispostaSicurezza() {
		return rispostaSicurezza;
	}

	public void setRispostaSicurezza(String rispostaSicurezza) {
		this.rispostaSicurezza = rispostaSicurezza;
	}
}
