package com.eulbyvan.service;

import com.eulbyvan.model.entity.CourseType;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

public interface ICourseTypeService extends IBaseService<CourseType, String> {
	Optional<CourseType> findByName(String name);
}
