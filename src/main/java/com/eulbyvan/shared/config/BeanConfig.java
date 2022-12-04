package com.eulbyvan.shared.config;

import com.eulbyvan.model.entity.Course;
import com.eulbyvan.model.entity.CourseType;
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

	@Bean
	Class<Course> getCourseClass() {
		return Course.class;
	}

	@Bean
	Class<CourseType> getCourseTypeClass() {
		return CourseType.class;
	}
}
