package com.cinemille.gestione.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemille.gestione.dto.ProgrammazioneDto;
import com.cinemille.gestione.model.Programmazione;
import com.cinemille.gestione.repository.ProgrammazioneRepository;
import com.cinemille.gestione.rest.ProgrammazioneController;

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
	 * <p>Converte la List di {@link Programmazione} ricevuta in una List di {@link ProgrammazioneDto}.</p>
	 * @return la lista delle programmazioni in formato {@link ProgrammazioneDto}
	 * @see #programmazioneRepo
	 * @see #findByDate
	 */
	public List<ProgrammazioneDto> storicoProgrammazione() {
		List<Programmazione> storico = programmazioneRepo.findAll();
		List<ProgrammazioneDto> listaFilm = new ArrayList<ProgrammazioneDto>();
		Set<String> listaTitoli = new HashSet<String>();
		storico.forEach(p -> {
			if (!listaTitoli.contains(p.getFilm().getTitolo())) {
				listaTitoli.add(p.getFilm().getTitolo());
				listaFilm.add(new ProgrammazioneDto(p.getIdSala().getNomeSala(), p.getFilm().getTitolo(), p.getDataOrario()));
			}
		});
		return listaFilm;
	}
	
	/**
	 * Metodo che effettua la richiesta a {@link #programmazioneRepo} per la programmazione in un intervallo di date.
	 * <p>L'intervallo di tempo è identificato tra <b>dataInizio</b> e <b>dataFine</b>.</p>
	 * <p>Converte la List di Tuple ricevuta in una List di {@link ProgrammazioneDto}.</p>
	 * @param dataInizio la data iniziale in String nel formato YYYY/MM/DD
	 * @param dataFine la data finale in String nel formato YYYY/MM/DD
	 * @return la lista delle programmazioni in formato {@link ProgrammazioneDto}
	 * @see #programmazioneRepo
	 * @see #storicoProgrammazione
	 */
	public List<ProgrammazioneDto> findByDate(String dataInizio, String dataFine) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dataInizioFormattata = null;
		Date dataFineFormattata = null;
		Timestamp timestampDataInizio = null;
		Timestamp timestampDataFine = null;
		Calendar calendario = Calendar.getInstance();
		// Proviamo prima a formattare con l'orario preciso (ore, minuti e secondi)
		try {
			dataInizioFormattata = dataFormat.parse(dataInizio);
			dataFineFormattata = dataFormat.parse(dataFine);
			timestampDataInizio = new Timestamp(dataInizioFormattata.getTime());
			timestampDataFine = new Timestamp(dataFineFormattata.getTime());
		} catch (ParseException e) {
			// Se le date fornite in input non hanno l'orario, usiamo il formatter meno preciso
			dataFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				dataInizioFormattata = dataFormat.parse(dataInizio);
				dataFineFormattata = dataFormat.parse(dataFine);
				timestampDataInizio = new Timestamp(dataInizioFormattata.getTime());
				timestampDataFine = new Timestamp(dataFineFormattata.getTime());
				calendario.setTime(dataFineFormattata);
				calendario.set(Calendar.HOUR_OF_DAY, 24);
				timestampDataFine.setTime(calendario.getTimeInMillis());
			} catch (ParseException e2) {
				e2.printStackTrace();
				System.out.println("La data non ha un formato valido.");
			}
		}
		List<ProgrammazioneDto> result = new ArrayList<ProgrammazioneDto>();
		programmazioneRepo.findByDataOrarioBetween(timestampDataInizio, timestampDataFine).forEach(p -> result.add(new ProgrammazioneDto(p.getIdSala().getNomeSala(), p.getFilm().getTitolo(), p.getDataOrario())));
		return result;
	}

}
