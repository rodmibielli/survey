package com.rodmibielli.dio.survey.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Particular user answers.
 */
@Entity
@IdClass(SurveyResponseQuestion.PK.class)
@RequiredArgsConstructor
public class SurveyResponseQuestion {

	@Id
	@ManyToOne
	private @NonNull SurveyResponse surveyResponse;
	
	@Id
	@ManyToOne
	private @NonNull Question question;

	@Column(length = 500)
	private @NonNull String responseText;
	
	private Date responseDate;
	
	private Long responseInteger;
	
	private Double responseReal;
	
	private Boolean responseBoolean;
	
	@Transient
	public Object getResponse() {
		
		switch (question.getResponseType()) {
		
		case BOOLEAN: {
			return responseBoolean;
		}
		case DATE: {
			return responseDate;
		}
		case INTEGER: {
			return responseInteger;
		}
		case REAL: {
			return responseReal;
		}
		case TEXT: {
			return responseText;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + question.getResponseType());
		}
		
	}
	
	@NoArgsConstructor
	@EqualsAndHashCode
	public static class PK implements Serializable {
		
		private @NonNull SurveyResponse surveyResponse;
		
		private @NonNull Question question;
	}
}
