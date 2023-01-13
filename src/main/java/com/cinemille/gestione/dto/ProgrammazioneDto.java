package com.cinemille.gestione.dto;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgrammazioneDto {
	private String nomeSala;
	private String titolo;
	private String dataOrario;

	public ProgrammazioneDto(String nomeSala, String titolo, Timestamp dataOrario) {
		this.nomeSala = nomeSala;
		this.titolo = titolo;
		
		// Conversione Timestamp (valore riportato da SQL) in un formato più leggibile dall'utente
		// TODO: Avendo più tempo sarebbe possibile aggiungere una custom exception con messaggio di errore esplicativo.
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.dataOrario = format.format(format.parse(dataOrario.toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getDataOrario() {
		return dataOrario;
	}
}
