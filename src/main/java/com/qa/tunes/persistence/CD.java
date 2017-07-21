package com.qa.tunes.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CD {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String artistName;
	private String genre;
	private String albumName;

	public CD() {
	}

	public CD(String artistName, String genre, String albumName) {
		this.artistName = artistName;
		this.genre = genre;
		this.albumName = albumName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return artistName;
	}

	public void setTitle(String artistName) {
		this.artistName = artistName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublished() {
		return albumName;
	}

	public void setPublished(String albumName) {
		this.albumName = albumName;
	}

}
