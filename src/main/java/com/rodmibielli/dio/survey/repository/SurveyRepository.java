package com.rodmibielli.dio.survey.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodmibielli.dio.survey.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {

	boolean existsByTitle(String title);
}
