package com.cinemille.gestione.repository;

import com.cinemille.gestione.model.Programmazione;

import jakarta.persistence.Tuple;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammazioneRepository extends CrudRepository<Programmazione, Integer>{

	@Query(value = "SELECT sale.nome_sala, film.titolo, programmazione.data_orario FROM programmazione "
			+ "INNER JOIN film ON programmazione.id_film = film.id "
			+ "INNER JOIN sale ON programmazione.id_sala = sale.id;", nativeQuery = true)
	public List<Tuple> storicoProgrammazione();

	@Query(value = "SELECT sale.nome_sala, film.titolo, programmazione.data_orario FROM programmazione "
			+ "INNER JOIN film ON programmazione.id_film = film.id "
			+ "INNER JOIN sale ON programmazione.id_sala = sale.id "
			+ "WHERE data_orario >= ? AND data_orario <= ?", nativeQuery = true)
	public List<Tuple> findByDate(String dataInizio, String dataFine);
}
