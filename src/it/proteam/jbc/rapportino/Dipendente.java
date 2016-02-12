package it.proteam.jbc.rapportino;

import java.util.List;

public class Dipendente {
	private String nome;
	private String cognome;
	private String email;
	private String citta;
	private String indirizzo;
	private String sesso;

	private Curriculum cv;
	//List<RapportinoMensile> rappMese;
	RapportinoMensile rappMese;
	
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

	public Curriculum getCv() {
		return cv;
	}

	public void setCv(Curriculum cv) {
		this.cv = cv;
	}

	public RapportinoMensile getRappMese() {
		return rappMese;
	}

	public void setRappMese(RapportinoMensile rappMese) {
		this.rappMese = rappMese;
	}

//	public List<RapportinoMensile> getRappMese() {
//		return rappMese;
//	}
//
//	public void setRappMese(List<RapportinoMensile> rappMese) {
//		this.rappMese = rappMese;
//	}

}
