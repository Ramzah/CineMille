package com.cinemille.gestione.model;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name="Film.findAll", query="SELECT c FROM Film c")
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequenza_film", sequenceName = "sequenza_film")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_film")
	private int id;
	private String titolo;
	private String genere;
	private String regia;
	private String cast;
	@Column(nullable = false)
	private boolean flag_3d;
	
	@OneToMany(mappedBy = "film", fetch = FetchType.EAGER)
	private Set<Programmazione> programmazione;
	
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
	
	public Set<Programmazione> getProgrammazione() {
		return programmazione;
	}
}
