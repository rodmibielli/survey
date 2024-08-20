package com.rodmibielli.dio.survey.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(of="email")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Getter
	@Column(nullable = false)
	private @NonNull String name;
	
	@Getter
	@Column(nullable = false,unique = true)
	private @NonNull String email;
	
	@OneToMany(mappedBy = "contact",cascade = {CascadeType.ALL})
	private List<SurveyResponse> surveyResponses;
}
