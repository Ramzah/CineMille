package com.cinemille.gestione.dto;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Classe DTO utilizzata per esporre i film 
 * in programmazione in maniera semplificata.
 * @see ProgrammazioneDto#ProgrammazioneDto(String, String, Timestamp) Costruttore ProgrammazioneDto
 * @see ProgrammazioneDto#getTitolo() getTitolo
 * @see ProgrammazioneDto#getNomeSala() getNomeSala
 * @see ProgrammazioneDto#getDataOrario() getDataOrario
 */
public class ProgrammazioneDto {
	private String nomeSala;
	private String titolo;
	private String dataOrario;

	/**
	 * Costruttore per {@link ProgrammazioneDto}
	 * <p>Il valore della data viene convertito da Timestamp (formato SQL) in stringa attraverso {@link SimpleDateFormat}</p>
	 * @param nomeSala il nome della sala in cui si proietta il film
	 * @param titolo il titolo del film
	 * @param dataOrario la data e (opzionale) orario in cui si proietta il film
	 */
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
	
	/**
	 * Getter del nome della sala dove viene proiettato il film
	 * @return il nome della sala in formato String
	 * @see ProgrammazioneDto#ProgrammazioneDto(String, String, Timestamp) Costruttore ProgrammazioneDto
	 */
	public String getNomeSala() {
		return nomeSala;
	}
	/**
	 * Getter del titolo del film
	 * @return il titolo del film in formato String
	 * @see ProgrammazioneDto#ProgrammazioneDto(String, String, Timestamp) Costruttore ProgrammazioneDto
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * Getter della data e (opzionale) orario di programmazione.
	 * @return la data/orario in formato String
	 * @see ProgrammazioneDto#ProgrammazioneDto(String, String, Timestamp) Costruttore ProgrammazioneDto
	 */
	public String getDataOrario() {
		return dataOrario;
	}
}
