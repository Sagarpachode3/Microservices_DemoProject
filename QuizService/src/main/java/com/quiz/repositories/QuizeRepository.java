package com.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entities.Quiz;


public interface QuizeRepository extends JpaRepository<Quiz,Long> {

	
}
