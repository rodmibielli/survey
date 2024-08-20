package com.rodmibielli.dio.survey.service;

import java.util.UUID;

import com.rodmibielli.dio.survey.model.Survey;

public interface SurveyService {

	Survey findById(UUID id);
	
	void createSurvey(Survey survey);
}
