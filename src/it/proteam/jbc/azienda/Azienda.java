package it.proteam.jbc.azienda;

import java.util.List;

public class Azienda {
	private String ragioneSociale;
	private String descAttivitta;
	private String citta;
	private String indirizzo;
	private String pIVA;
	private List<Dipendente> dipendenti;
	

	public Azienda() {
		
	}
	
	public Azienda(String ragSoc, String att, String citta, String ind, String pIVA, List<Dipendente> dip){
		this.ragioneSociale = ragSoc;
		this.descAttivitta = att;
		this.citta = citta;
		this.indirizzo = ind;
		this.pIVA = pIVA;
		this.dipendenti = dip;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	
	public String getDescAttivitta() {
		return descAttivitta;
	}

	public void setDescAttivitta(String descAttivitta) {
		this.descAttivitta = descAttivitta;
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

	public String getpIVA() {
		return pIVA;
	}

	public void setpIVA(String pIVA) {
		this.pIVA = pIVA;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

}
