package com.cinemille.gestione.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemille.gestione.dto.ProgrammazioneDto;
import com.cinemille.gestione.repository.ProgrammazioneRepository;
import com.cinemille.gestione.rest.ProgrammazioneController;

import jakarta.persistence.Tuple;

/**
 * Classe che si occupa della transizione dei dati tra {@link ProgrammazioneRepository} e {@link ProgrammazioneController}.
 * <p>In questa classe ci occupiamo della logica che converte i dati in un formato DTO e se necessario effettua conversioni o check sul formato dati.</p>
 * @see ProgrammazioneDto
 * @see #storicoProgrammazione
 * @see #findByDate
 */
@Service
public class ProgrammazioneService {
	/**
	 * Injection di {@link ProgrammazioneRepository}.
	 */
	@Autowired
	private ProgrammazioneRepository programmazioneRepo;
	/**
	 * Metodo che effettua la richiesta a {@link #programmazioneRepo} per lo storico della programmazione.
	 * <p>Converte la List di Tuple ricevuta in una List di {@link ProgrammazioneDto}.</p>
	 * @return la lista delle programmazioni in formato {@link ProgrammazioneDto}
	 * @see #programmazioneRepo
	 * @see #findByDate
	 */
	public List<ProgrammazioneDto> storicoProgrammazione() {
		List<Tuple> storico = programmazioneRepo.storicoProgrammazione();
		// Conversione da Tuple a ProgrammazioneDto
		List<ProgrammazioneDto> dto = storico.stream().map(t -> new ProgrammazioneDto(t.get(0, String.class), t.get(1, String.class), t.get(2, Timestamp.class))).collect(Collectors.toList());
		return (List<ProgrammazioneDto>) dto;
	}
	/**
	 * Metodo che effettua la richiesta a {@link #programmazioneRepo} per la programmazione in un intervallo di date.
	 * <p>L'intervallo di tempo è identificato tra <b>dataInizio</b> e <b>dataFine</b> e nel caso fossero null viene usata come dataInizio la data odierna e dataFine la settimana successiva.</p>
	 * <p>Converte la List di Tuple ricevuta in una List di {@link ProgrammazioneDto}.</p>
	 * @param dataInizio la data iniziale in String nel formato YYYY/MM/DD
	 * @param dataFine la data finale in String nel formato YYYY/MM/DD
	 * @return la lista delle programmazioni in formato {@link ProgrammazioneDto}
	 * @see #programmazioneRepo
	 * @see #storicoProgrammazione
	 */
	public List<ProgrammazioneDto> findByDate(String dataInizio, String dataFine) {
		/*
		 *  Se la data non è stata inserita, usa quella odierna
		 *  TODO: Avendo tempo si può migliorare la verifica in questo punto per evitare formati di data non validi
		 *  o per dare risultati diversi a seconda di combinazioni diverse di input.
		 *  Esempio: Se viene messa solo la data di inizio o solo la data di fine.
		 */
		if (dataInizio == null && dataFine == null) {
			// Data di oggi
			LocalDateTime data = LocalDateTime.now();
			// Conversione in String di oggi e +1 settimana
			dataInizio = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(data);
			dataFine = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(data.plusWeeks(1));
		}
		List<Tuple> listByDate = programmazioneRepo.findByDate(dataInizio, dataFine);
		// Conversione da Tuple a ProgrammazioneDto
		List<ProgrammazioneDto> dto = listByDate.stream().map(t -> new ProgrammazioneDto(t.get(0, String.class), t.get(1, String.class), t.get(2, Timestamp.class))).collect(Collectors.toList());
		return (List<ProgrammazioneDto>) dto;
	}

}
