package com.rodmibielli.dio.survey.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class SurveyDTO implements Serializable {

	UUID id;
	String title;
}
