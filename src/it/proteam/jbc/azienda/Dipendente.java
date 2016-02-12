package it.proteam.jbc.azienda;

public class Dipendente {
	private String nome;
	private String cognome;
	private String email;
	private String citta;
	private String indirizzo;
	private String sesso;
	private String ruolo;
	private Mezzo veicolo;
	
	public Dipendente() {
		
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

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Mezzo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Mezzo veicolo) {
		this.veicolo = veicolo;
	}

}
