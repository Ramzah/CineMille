package com.cinemille.gestione.repository;

import com.cinemille.gestione.model.Programmazione;

import jakarta.persistence.Tuple;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
	 * @return una List di Tuple contenenti il risultato della query
	 * @param dataInizio la data iniziale in String nel formato YYYY/MM/DD
	 * @param dataFine la data finale in String nel formato YYYY/MM/DD
	 * @see ProgrammazioneRepository
	 * @see ProgrammazioneRepository#storicoProgrammazione() storicoProgrammazione
	 */
	@Query(value = "SELECT sale.nome_sala, film.titolo, programmazione.data_orario FROM programmazione "
			+ "INNER JOIN film ON programmazione.id_film = film.id "
			+ "INNER JOIN sale ON programmazione.id_sala = sale.id "
			+ "WHERE data_orario >= ? AND data_orario <= ?", nativeQuery = true)
	public List<Tuple> findByDate(String dataInizio, String dataFine);
}
