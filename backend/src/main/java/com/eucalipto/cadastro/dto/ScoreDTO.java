package com.eucalipto.cadastro.dto;

public class ScoreDTO {
	private Long movieId;
	private String username;
	private Double score;
	
	public ScoreDTO() {		
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
	

}
