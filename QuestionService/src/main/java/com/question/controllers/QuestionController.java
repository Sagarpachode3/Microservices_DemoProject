package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionServices;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionServices questionServices;
	
	//create
	
	@PostMapping
	public Question create(@RequestBody Question question) {
		return questionServices.create(question);
	}
	
	//get All
	
	@GetMapping
	public List<Question> getAll(){
		return questionServices.get();
	}
	
	//get single question
	
	@GetMapping("/{questionId}")
	public Question getSingle(@PathVariable Long questionId) {
		
		return questionServices.getOne(questionId);
	}
	
	
	//get all questions of specific quiz
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuizById(@PathVariable Long quizId){
		return questionServices.getQuestionsOfQuizId(quizId);
	}
	
	
}
