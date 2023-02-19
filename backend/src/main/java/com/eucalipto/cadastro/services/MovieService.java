package com.eucalipto.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eucalipto.cadastro.dto.MovieDTO;
import com.eucalipto.cadastro.entities.Movie;
import com.eucalipto.cadastro.entities.Person;
import com.eucalipto.cadastro.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}

	@Transactional
	public ResponseEntity<Movie> saveMovie(Movie movie) {
		repository.save(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

	@Transactional
	public ResponseEntity<Movie> delete(Long id) {
		Movie movie = repository.findById(id).get();
		repository.delete(movie);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
