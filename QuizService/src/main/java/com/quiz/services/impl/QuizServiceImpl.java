package com.quiz.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizeRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	private QuizeRepository quizeRepository;

	private QuestionClient questionClient;

	public QuizServiceImpl(QuizeRepository quizeRepository, QuestionClient questionClient) {
		this.quizeRepository = quizeRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizeRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizzes = quizeRepository.findAll();

		List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());

		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz = quizeRepository.findById(id).orElseThrow(() -> new RuntimeException("Quize not found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}
