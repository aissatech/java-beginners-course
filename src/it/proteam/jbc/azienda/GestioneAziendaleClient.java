package it.proteam.jbc.azienda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestioneAziendaleClient {

	public GestioneAziendaleClient() {
		
	}

	public static void main(String[] args) {
		GestioneAziendaleClient client = new GestioneAziendaleClient();
		Mezzo mezzo1 = client.setDatiMezzo("macchina", "Toyota", "Aygo", "AN557BQ");
		Mezzo mezzo2 = client.setDatiMezzo("moto", "Moto Guzzi", "Norge", "QW221BT");
		Mezzo mezzo3 = client.setDatiMezzo("bicicletta", "BTwin", "Rockrider 340", "");
		Dipendente dipendente1 = client.setDatiDipendente("Anna", "Bianchi", "a@gmail.com", "Roma", "Via della Pace 31", "F", "quadro", mezzo1);
		Dipendente dipendente2 = client.setDatiDipendente("Paolo", "Pugliese", "b@gmail.com", "Roma", "Via del Sole 31", "M", "CEO", mezzo2);
		Dipendente dipendente3 = client.setDatiDipendente("Carol", "Neri", "c@gmail.com", "Roma", "Via Taranto 95", "F", "commerciale", mezzo3);
		List<Dipendente> dipendenti = new ArrayList<Dipendente>();
		dipendenti.add(dipendente1);
		dipendenti.add(dipendente2);
		dipendenti.add(dipendente3);
		Azienda az = client.setDatiAzienda("Proteam", "IT", "Roma", "Via dei Pescatori 50", "122852532", dipendenti);
		
		//call the write method
		client.scriviDati(az);

	}


	public Azienda setDatiAzienda(String ragSoc, String att, String citta, String ind, String pIVA, List<Dipendente> dip){
		Azienda az = new Azienda();
	
		az.setRagioneSociale(ragSoc);
		az.setDescAttivitta(att);
		az.setCitta(citta);
		az.setIndirizzo(ind);
		az.setpIVA(pIVA);
		az.setDipendenti(dip);
		
		return az;
	}
	public Dipendente setDatiDipendente(String nome, String cognome, String email, String citta, String ind, String sesso, String ruolo, Mezzo mezzo){
		Dipendente dip = new Dipendente();
		
		dip.setNome(nome);
		dip.setCognome(cognome);
		dip.setEmail(email);
		dip.setCitta(citta);
		dip.setIndirizzo(ind);
		dip.setSesso(sesso);
		dip.setRuolo(ruolo);
		dip.setVeicolo(mezzo);
		
		return dip;
	}
	public Mezzo setDatiMezzo(String tipo, String marca, String modello, String targa){
		Mezzo veicolo = new Mezzo();
		
		veicolo.setTipo(tipo);
		veicolo.setMarca(marca);
		veicolo.setModello(modello);
		veicolo.setTarga(targa);	
		
		return veicolo;
	}
	public void scriviDati(Azienda az){
		String file = "azienda.txt";
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(writer);
			Iterator<Dipendente> iter = az.getDipendenti().iterator();
			int i = 1;
			while(iter.hasNext()){
				Dipendente dip = iter.next();
					
					bw.write(i + ": " + az.getRagioneSociale() + "-" + az.getDescAttivitta() + "-" + az.getCitta() + "-" + 
							az.getIndirizzo() + "-" + az.getpIVA() + ", " +
							dip.getNome() + "-" + dip.getCognome() + "-" + dip.getEmail() + "-" + 
							dip.getCitta() + "-" + dip.getIndirizzo() + "-" + dip.getSesso() + "-" + dip.getRuolo() + ", " +
							dip.getVeicolo().getTipo() + "-" + dip.getVeicolo().getMarca() + 
							"-" + dip.getVeicolo().getModello()+ "-" + dip.getVeicolo().getTarga() + "\n");
					
					i++;
			} 
			bw.flush();
			bw.close();
		}catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
