package com.eucalipto.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eucalipto.cadastro.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
