package it.proteam.jbc.rapportino;

import java.util.List;

public class RapportinoMensile {

	public RapportinoMensile() {
		
	}
	
	private String mese;
	private String anno;
	List<GiorniRapportino> giorni;
	
	
	public String getMese() {
		return mese;
	}
	public void setMese(String mese) {
		this.mese = mese;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public List<GiorniRapportino> getGiorni() {
		return giorni;
	}
	public void setGiorni(List<GiorniRapportino> giorni) {
		this.giorni = giorni;
	}
	
	
}
