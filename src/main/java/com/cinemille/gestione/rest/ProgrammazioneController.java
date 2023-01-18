package com.cinemille.gestione.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinemille.gestione.dto.ProgrammazioneDto;
import com.cinemille.gestione.service.ProgrammazioneService;

/**
 * Classe dove vengono implementati i servizi REST.
 * @see #getStorico
 * @see #findByDate
 */
// TODO assegnare un valore a CrossOrigin 
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("programmazione")
public class ProgrammazioneController {
	
	/**
	 * Injection di {@link ProgrammazioneService}.
	 */
	@Autowired
	private ProgrammazioneService programmazioneService;
	
	/**
	 * Servizio REST che restituisce l'intero storico della programmazione del cinema.
	 * @return una List di {@link ProgrammazioneDto}.
	 * @see #programmazioneService
	 */
	@GetMapping("/storico")
	public List<ProgrammazioneDto> getStorico() {
		return (List<ProgrammazioneDto>) programmazioneService.storicoProgrammazione();
	}
	/**
	 * Servizio REST che restituisce la programmazione in un intervallo di tempo compreso tra <b>dataInizio</b> e <b>dataFine</b>.
	 * <p><b>Esempio di richiesta dal client:</b> <br> <code><ul><li>dataInizio=2023/1/1&dataFine=2023/10/25</ul></li></code></p>
	 * @param dataInizio la data iniziale in String nel formato YYYY/MM/DD
	 * @param dataFine la data finale in String nel formato YYYY/MM/DD
	 * @return una List di {@link ProgrammazioneDto}.
	 * @see #programmazioneService
	 */
	@GetMapping("/lista")
	public List<ProgrammazioneDto> findByDate(@RequestParam String dataInizio, @RequestParam String dataFine) {
		return programmazioneService.findByDate(dataInizio, dataFine);
	}

}
