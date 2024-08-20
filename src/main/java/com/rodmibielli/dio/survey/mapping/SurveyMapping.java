package com.rodmibielli.dio.survey.mapping;

import org.springframework.stereotype.Component;

import com.rodmibielli.dio.survey.dto.SurveyDTO;
import com.rodmibielli.dio.survey.model.Survey;

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;

@Component
public class SurveyMapping implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(SurveyDTO.class, Survey.class)
						  .byDefault()
						  .register();
	}

}
