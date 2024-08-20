package com.rodmibielli.dio.survey.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@IdClass(SurveyQuestion.PK.class)
@RequiredArgsConstructor
public class SurveyQuestion {

	@Id
	@ManyToOne
	private @NonNull Survey survey;
	
	@Id
	@ManyToOne
	private @NonNull Question question;
	
	@Getter
	private @NonNull Integer sequence;

	@NoArgsConstructor
	@Getter
	@EqualsAndHashCode
	public static class PK implements Serializable {
		
		private @NonNull Survey survey;
		
		private @NonNull Question question;
	}
}
