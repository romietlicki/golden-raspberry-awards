package com.golden.raspberry.awards.goldenraspberryawards.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Award implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title_movie", nullable = false)
    private String title_movie;
    
    @Column(name = "year_movie", nullable = false)
    private int year_movie;
    
    @Column(name = "studios", nullable = false)
    private String studios;
    
    @Column(name = "winner_movie", nullable = true)
    private String winner_movie;
    
    @Column(name = "producersName", nullable = false)
    private String producersName;

	public Long getId() {
		return id;
	}

	public String getTitle_movie() {
		return title_movie;
	}

	public void setTitle_movie(String title_movie) {
		this.title_movie = title_movie;
	}

	public int getYear_movie() {
		return year_movie;
	}

	public void setYear_movie(int year_movie) {
		this.year_movie = year_movie;
	}

	public String getStudios() {
		return studios;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getWinner_movie() {
		return winner_movie;
	}

	public void setWinner_movie(String winner_movie) {
		this.winner_movie = winner_movie;
	}

	public String getProducersName() {
		return producersName;
	}

	public void setProducersName(String producers_movie) {
		this.producersName = producers_movie;
	}

	public void setId(Long id) {
		this.id = id;
	}

    

}
