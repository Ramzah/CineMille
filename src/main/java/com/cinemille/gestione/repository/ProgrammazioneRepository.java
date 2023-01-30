package com.cinemille.gestione.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemille.gestione.model.Programmazione;

/**
 * Classe che effettua le operazioni CRUD sul database.
 * @see ProgrammazioneRepository#storicoProgrammazione() storicoProgrammazione
 * @see ProgrammazioneRepository#findByDate(String, String) findByDate
 */
@Repository
public interface ProgrammazioneRepository extends JpaRepository<Programmazione, Integer> {
	/**
	 * Effettua una query per recuperare i titoli, i nomi delle sale e le date/orari di programmazione in un intervallo di tempo specifico
	 * <p>L'intervallo di tempo è identificato tra <b>dataInizio</b> e <b>dataFine</b></p>
	 * @return una List di {@link Programmazione} contenenti il risultato della query
	 * @param dataInizio la data iniziale in String nel formato YYYY/MM/DD (Ore, minuti e secondi opzionali)
	 * @param dataFine la data finale in String nel formato YYYY/MM/DD (Ore, minuti e secondi opzionali)
	 * @see ProgrammazioneRepository
	 * @see ProgrammazioneRepository#storicoProgrammazione() storicoProgrammazione
	 */	
	public List<Programmazione> findByDataOrarioBetween(Timestamp dataInizio, Timestamp dataFine);
}
