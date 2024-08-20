package com.rodmibielli.dio.survey.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodmibielli.dio.survey.dto.SurveyDTO;
import com.rodmibielli.dio.survey.model.Survey;
import com.rodmibielli.dio.survey.service.SurveyService;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("/surveys")
@RequiredArgsConstructor
public class SurveyController {

	private final SurveyService surveyService;
	
	private final MapperFacade orikaMapperFacade;
	
	@GetMapping("/{id}")
	public ResponseEntity<SurveyDTO> findById(@PathVariable UUID id) {
		var survey = surveyService.findById(id);
		var surveyDTO = orikaMapperFacade.map(survey, SurveyDTO.class);
		return ResponseEntity.ok(surveyDTO);
	}
	
	@PostMapping
	public ResponseEntity<Survey> create(@RequestBody SurveyDTO surveyDTO) {
		var surveyToCreate = this.orikaMapperFacade.map(surveyDTO, Survey.class);
		surveyService.createSurvey(surveyToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(surveyToCreate.getId().toString())
												  .toUri();
		
		return ResponseEntity.created(location).build();
												  	
	}
}
