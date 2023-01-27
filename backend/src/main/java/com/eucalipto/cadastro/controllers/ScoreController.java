package com.eucalipto.cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eucalipto.cadastro.dto.MovieDTO;
import com.eucalipto.cadastro.dto.ScoreDTO;
import com.eucalipto.cadastro.services.ScoreService;

@RestController
@RequestMapping(value = "scores")
@CrossOrigin(origins = "*")
public class ScoreController {
		
	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}

}
