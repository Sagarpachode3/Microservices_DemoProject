package com.quiz.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizeRepository;
import com.quiz.services.QuizService;


@Service
public class QuizServiceImpl implements QuizService {

	private QuizeRepository quizeRepository;

	public QuizServiceImpl(QuizeRepository quizeRepository) {
		this.quizeRepository = quizeRepository;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizeRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		return quizeRepository.findAll();
	}

	@Override
	public Quiz get(Long id) {
		return quizeRepository.findById(id).orElseThrow(() -> new RuntimeException("Quize not found"));
	}

}
