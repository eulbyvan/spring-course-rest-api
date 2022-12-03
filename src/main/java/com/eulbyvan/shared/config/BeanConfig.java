package com.eulbyvan.shared.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Configuration
public class BeanConfig {
	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
