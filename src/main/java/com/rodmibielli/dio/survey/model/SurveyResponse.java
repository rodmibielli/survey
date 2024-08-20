package com.rodmibielli.dio.survey.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Who the survey was for?
 */
@Entity
@IdClass(SurveyResponse.PK.class)
@RequiredArgsConstructor
public class SurveyResponse {

	@Id
	@ManyToOne
	private @NonNull Survey survey;
	
	@Id
	@ManyToOne
	private @NonNull Contact contact;
	
	@Temporal(TemporalType.TIMESTAMP)
	private @NonNull Date datetime;
	
	@NoArgsConstructor
	@EqualsAndHashCode
	public static class PK implements Serializable {
		
		private @NonNull Survey survey;
		
		private @NonNull Contact contact;
	}
}
