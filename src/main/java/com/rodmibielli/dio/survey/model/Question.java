package com.rodmibielli.dio.survey.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Pool of questions.
 */
@Entity
@Getter
@EqualsAndHashCode(of="text")
@ToString
@RequiredArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private @NonNull String text;
	
	@Enumerated(EnumType.STRING)
	private @NonNull ResponseType responseType;
	
}
