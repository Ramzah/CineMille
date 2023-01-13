package com.cinemille.gestione.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemille.gestione.dto.ProgrammazioneDto;
import com.cinemille.gestione.service.ProgrammazioneService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("programmazione")
public class ProgrammazioneController {
	
	@Autowired
	private ProgrammazioneService programmazioneService;
	
	@GetMapping("/storico")
	public List<ProgrammazioneDto> getStorico() {
		return (List<ProgrammazioneDto>) programmazioneService.storicoProgrammazione();
	}

}
