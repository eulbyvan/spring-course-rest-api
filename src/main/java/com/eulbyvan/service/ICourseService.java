package com.eulbyvan.service;

import com.eulbyvan.model.entity.Course;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

public interface ICourseService extends IBaseService<Course, String> {
	Optional<Course> findByTitle(String title);
}
