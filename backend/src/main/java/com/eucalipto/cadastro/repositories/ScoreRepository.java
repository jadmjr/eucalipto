package com.eucalipto.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eucalipto.cadastro.entities.Score;
import com.eucalipto.cadastro.entities.ScorePK;
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
