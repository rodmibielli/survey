package com.rodmibielli.dio.survey.mapping;

import org.mapstruct.Mapper;

import com.rodmibielli.dio.survey.dto.SurveyDTO;
import com.rodmibielli.dio.survey.dto.SurveyToCreateDTO;
import com.rodmibielli.dio.survey.model.Survey;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

	SurveyDTO toDTO(Survey survey);
	
	Survey toSurvey(SurveyToCreateDTO surveyToCreateDTO);
}
