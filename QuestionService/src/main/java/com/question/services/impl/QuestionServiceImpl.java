package com.question.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionServices;

@Service
public class QuestionServiceImpl implements QuestionServices {

	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public Question create(Question question) {

		return questionRepository.save(question);
	}

	@Override
	public List<Question> get() {

		return questionRepository.findAll();
	}

	@Override
	public Question getOne(Long id) {

		return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("No Question Found"));
	}

	@Override
	public List<Question> getQuestionsOfQuizId(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
