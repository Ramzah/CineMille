package com.cinemille.gestione.service;

import java.sql.Timestamp;
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
		// Tuple to ProgrammazioneDto conversion
		List<ProgrammazioneDto> storicoDto = storico.stream().map(t -> new ProgrammazioneDto(t.get(0, String.class), t.get(1, String.class), t.get(2, Timestamp.class))).collect(Collectors.toList());
		return (List<ProgrammazioneDto>) storicoDto;
	}

}
