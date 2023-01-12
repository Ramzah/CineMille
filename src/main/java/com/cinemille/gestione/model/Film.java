package com.cinemille.gestione.model;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@NamedQuery(name="Film.findAll", query="SELECT c FROM Film c")
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String titolo;
	private String genere;
	private String regia;
	private String cast;
	private boolean flag_3d;
	
	public Film() {
	}

	public int getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getGenere() {
		return genere;
	}

	public String getRegia() {
		return regia;
	}

	public String getCast() {
		return cast;
	}

	public boolean isFlag_3d() {
		return flag_3d;
	}
}
