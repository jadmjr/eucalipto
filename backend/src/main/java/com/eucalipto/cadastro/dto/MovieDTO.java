package com.eucalipto.cadastro.dto;

import com.eucalipto.cadastro.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;

	public MovieDTO(Movie movie) {
		id = movie.getId();
		title = movie.getTitle();
		score = movie.getScore();
		count = movie.getCount();
		image = movie.getImage();
	}

	public void sacar() {

	}

	public void sacar(String image) {

	}

}
