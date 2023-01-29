package com.cinemille.gestione.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Programmazione implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_sala")
	private Sala sala;
	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film film;
	@Column(name = "data_orario")
	private Timestamp dataOrario;

	public Programmazione() {
	}

	public int getId() {
		return id;
	}

	public Sala getIdSala() {
		return sala;
	}

	public Film getFilm() {
		return film;
	}

	public Timestamp getDataOrario() {
		return dataOrario;
	}
	
}
