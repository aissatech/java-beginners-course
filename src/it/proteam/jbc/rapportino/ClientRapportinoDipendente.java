package it.proteam.jbc.rapportino;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.proteam.jbc.rapportino.Dipendente;

public class ClientRapportinoDipendente {

	public ClientRapportinoDipendente() {
		
	}

	public static void main(String[] args) {
		ClientRapportinoDipendente client = new ClientRapportinoDipendente();
		
		//riempio i giorni di febbraio,
		List<GiorniRapportino> listaGiorni = new ArrayList<GiorniRapportino>();
		//listaGiorni = client.setListaGiorni("01/02/2016");
		listaGiorni = client.setListaGiorni("01/02");
		
		// test lista giorni
//		System.out.println(listaGiorni.size());
//		Iterator<GiorniRapportino> iter = listaGiorni.iterator();
//		while(iter.hasNext()){
//			GiorniRapportino gr = iter.next();
//			System.out.println( gr.getGiornoSettimana() + "-" +  gr.getData());
//		}
		
		// riempio il rapportino mensile
//		RapportinoMensile rapp = new RapportinoMensile();
//		rapp.setMese("febbraio");
//		rapp.setAnno("2016");
//		rapp.setGiorni(listaGiorni);
		RapportinoMensile rapp = client.setDatiRapportino("febbraio", "2016", listaGiorni);		
	
		// test rapportino
//		Iterator<GiorniRapportino> iter1 = rapp.getGiorni().iterator();
//		while(iter1.hasNext()){
//			GiorniRapportino gr = iter1.next();
//			System.out.println( rapp.getMese() + " " + rapp.getAnno() + " " + 
//			gr.getGiornoSettimana() + "-" +  gr.getData());
//		}
		
		// setto i vari curriculum
		Curriculum cv1 = client.setDatiCurriculum("master", "CEO");		
		Curriculum cv2 = client.setDatiCurriculum("laurea", "Analista");		
		Curriculum cv3 = client.setDatiCurriculum("diploma", "Programmatore");
		
		// rimepio i dati del dipendente
		Dipendente dip1 = client.setDatiDipendente("Anna", "Bianchi", "a@gmail.com", "Roma", "Via della Pace 31", "F", cv1, rapp);
		Dipendente dip2 = client.setDatiDipendente("Paolo", "Pugliese", "b@gmail.com", "Roma", "Via del Sole 31", "M", cv2, rapp);
		Dipendente dip3 = client.setDatiDipendente("Carol", "Neri", "c@gmail.com", "Roma", "Via Taranto 95", "F", cv3, rapp);
		
		List<Dipendente> dipendenti = new ArrayList<Dipendente>();
		dipendenti.add(dip1);
		dipendenti.add(dip2);
		dipendenti.add(dip3);
		
		client.scriviDati(dipendenti);
	}
	
	// riempio la lista dei giorni del mese 
	// partendo dal primo del mese (in questo caso febbraio)
	public List<GiorniRapportino> setListaGiorni(String data){		
		List<GiorniRapportino> giorni = new ArrayList<GiorniRapportino>();
		
		// mi prendo il numero del giorno dalla data (01, 02 ecc)
		Integer leDate = Integer.valueOf(data.substring(0, 2));
		
		// aggiungo 1 al numero del giorno
		while(leDate < 30){	
			GiorniRapportino giorno = new GiorniRapportino();
			//giorno.setData( leDate + data.substring(2, 10));
			giorno.setData( leDate + data.substring(2, 5));
			
			//aggiungo i giorni alla lista			
			if(leDate == 1 || leDate == 8 || leDate == 15 || leDate == 22 || leDate == 29){
				giorno.setGiornoSettimana("lunedi");
				giorno.setOre(8);
			}else if(leDate == 2 || leDate == 9 || leDate == 16 || leDate == 23){
				giorno.setGiornoSettimana("martedi");
				giorno.setOre(8);
			}else if(leDate == 3 || leDate == 10 || leDate == 17 || leDate == 24){
				giorno.setGiornoSettimana("mercoledi");
				giorno.setOre(8);
			}else if(leDate == 4 || leDate == 11 || leDate == 18 || leDate == 25){
				giorno.setGiornoSettimana("giovedi");
				giorno.setOre(8);
			}else if(leDate == 5 || leDate == 12 || leDate == 19 || leDate == 26){
				giorno.setGiornoSettimana("venerdi");
				giorno.setOre(8);
			}else if(leDate == 6 || leDate == 13 || leDate == 20 || leDate == 27){
				giorno.setGiornoSettimana("sabato");
				giorno.setOre(0);
			}else if(leDate == 7 || leDate == 14 || leDate == 21 || leDate == 28){
				giorno.setGiornoSettimana("domenica");
				giorno.setOre(0);
			}
			
			giorni.add(giorno);
			
			leDate++;
		}		
		
		return giorni;
	}
	
	// setto i dati del rapportino
	public RapportinoMensile setDatiRapportino(String nomeMese, String anno, List<GiorniRapportino> giorniMese){
		RapportinoMensile rapportino = new RapportinoMensile();
		rapportino.setMese(nomeMese);
		rapportino.setAnno(anno);
		rapportino.setGiorni(giorniMese);
		
		return rapportino;
	}
	
	// setto i dati del curriculum
	public Curriculum setDatiCurriculum(String titolo, String ruolo){
		Curriculum cv = new Curriculum();
		cv.setTitoloStudio(titolo);
		cv.setRuolo(ruolo);
		
		return cv;
	}
	
	// setto i dati del dipendente
	public Dipendente setDatiDipendente(String nome, String cognome, String email, String citta, String ind, String sesso, Curriculum cv, RapportinoMensile rapp){
		Dipendente dip = new Dipendente();
		
		dip.setNome(nome);
		dip.setCognome(cognome);
		dip.setEmail(email);
		dip.setCitta(citta);
		dip.setIndirizzo(ind);
		dip.setSesso(sesso);
		dip.setCv(cv);
		dip.setRappMese(rapp);
		
		return dip;
	}
	// scrivo i dati sul file
	public void scriviDati(List<Dipendente> listaDip){
		String file = "rapportino.txt";
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(writer);
			Iterator<Dipendente> iter = listaDip.iterator();
			int oreMensiliDipendente = 0;	
			int oreMensiliTotali = 0;	
			int i = 1;	
			
			bw.write("ANAGRAFICA: ");
			// scorro anagrafica
			while(iter.hasNext()){
				Dipendente dip = iter.next();
				List<GiorniRapportino> giorniMensili = dip.getRappMese().getGiorni();
				Iterator<GiorniRapportino> iterGiorni = giorniMensili.iterator();
											
				
				// scrivo i dati del dipendente
				bw.write("\n\t" + i + " - " + dip.getNome() + " , " + dip.getCognome() + " , " + dip.getEmail() + "  " + 
						dip.getCitta() + "  " + dip.getIndirizzo() + "  " + dip.getSesso() + "\n");
				// scrivo i dati del curriculum del dipendente
				bw.write("\n\t\tCURRICULUM: " + dip.getCv().getTitoloStudio() + " , " + dip.getCv().getRuolo() + "\n");
				// scorro i giorni, scrivo i dati del rapportino 
				while(iterGiorni.hasNext()){
					GiorniRapportino gr = iterGiorni.next();
					bw.write("\n\t\tRAPPORTINO: " + gr.getGiornoSettimana() + " , " + gr.getData() + " , " + gr.getOre() + "\n");
					// ore mensili per dipendente
					oreMensiliDipendente += gr.getOre();					
				}
				bw.write("\n\t\tORE MENSILI DIPENDENTE" + i + ": " + oreMensiliDipendente + "\n");
				
				bw.write("\n\t-------------------------------------------------------------" + "\n");
				oreMensiliTotali += oreMensiliDipendente;
	
				oreMensiliDipendente = 0;
				i++;
			} 
			bw.write("\n\t-------------------------------------------------------------" + "\n");
			// ore mensili totali
			bw.write("\n\t\tORE MENSILI TOTALI: " + oreMensiliTotali + "\n"); 

			bw.flush();
			bw.close();
		}catch (IOException e) {			
			e.printStackTrace();
		}
	}
}