package com.rodmibielli.dio.survey.service.impl;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rodmibielli.dio.survey.model.Survey;
import com.rodmibielli.dio.survey.repository.SurveyRepository;
import com.rodmibielli.dio.survey.service.SurveyService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

	private @NonNull final SurveyRepository surveyRepository;

	@Override
	public Survey findById(final @NonNull UUID id) {
		return surveyRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public void createSurvey(final @NonNull Survey survey) {
		
		if (surveyRepository.existsByTitle(survey.getTitle())) {
			throw new IllegalArgumentException("This survey title already exists.");
		}
		
		log.info("Creating new survey {}...",survey);
		
		surveyRepository.save(survey);
		
		log.info("Survey {} saved.");
		
	}

	
	
}
