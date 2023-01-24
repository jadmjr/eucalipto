package com.eucalipto.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucalipto.cadastro.dto.MovieDTO;
import com.eucalipto.cadastro.dto.ScoreDTO;
import com.eucalipto.cadastro.entities.Movie;
import com.eucalipto.cadastro.entities.Score;
import com.eucalipto.cadastro.entities.User;
import com.eucalipto.cadastro.repositories.MovieRepository;
import com.eucalipto.cadastro.repositories.ScoreRepository;
import com.eucalipto.cadastro.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}

		double avg = sum / movie.getScores().size();
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
