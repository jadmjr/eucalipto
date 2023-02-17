package com.eucalipto.cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eucalipto.cadastro.dto.MovieDTO;
import com.eucalipto.cadastro.entities.Movie;
import com.eucalipto.cadastro.entities.Person;
import com.eucalipto.cadastro.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	@Autowired
	private MovieService service;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(value = "/{id}")
	public MovieDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return service.saveMovie(movie);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Movie> delete(@PathVariable Long id) {
		return service.delete(id);
	}

}
