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

import jakarta.persistence.Tuple;

@Service
public class ProgrammazioneService {
	
	@Autowired
	private ProgrammazioneRepository programmazioneRepo;
	
	public List<ProgrammazioneDto> storicoProgrammazione() {
		List<Tuple> storico = programmazioneRepo.storicoProgrammazione();
		// Conversione da Tuple a ProgrammazioneDto
		List<ProgrammazioneDto> dto = storico.stream().map(t -> new ProgrammazioneDto(t.get(0, String.class), t.get(1, String.class), t.get(2, Timestamp.class))).collect(Collectors.toList());
		return (List<ProgrammazioneDto>) dto;
	}
	
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
