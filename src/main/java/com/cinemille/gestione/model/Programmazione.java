package com.cinemille.gestione.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Programmazione implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(name = "id_sala")
	private String idSala;
	@Column(name = "id_film")
	private String idFilm;
	@Column(name = "data_orario")
	private Date dataOrario;

	public Programmazione() {
	}

	public int getId() {
		return id;
	}

	public String getIdSala() {
		return idSala;
	}

	public String getIdFilm() {
		return idFilm;
	}

	public Date getDataOrario() {
		return dataOrario;
	}
	
}
