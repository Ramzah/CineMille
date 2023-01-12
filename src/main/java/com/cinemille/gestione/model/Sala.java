package com.cinemille.gestione.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToMany(mappedBy = "programmazione", cascade = CascadeType.ALL)
	private int id;
	@Column(name = "nome_sala")
	private String nomeSala;
	private String capienza;
	private String imax;

	public Sala() {
	}

	public int getId() {
		return id;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public String getCapienza() {
		return capienza;
	}
	
	public String getImax() {
		return imax;
	}

}
