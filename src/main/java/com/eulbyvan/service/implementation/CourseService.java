package com.eulbyvan.service.implementation;

import com.eulbyvan.model.entity.Course;
import com.eulbyvan.repo.ICourseRepo;
import org.springframework.stereotype.Service;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Service
public class CourseService extends BaseService<Course, String> {
	public CourseService(ICourseRepo repo) {
		super(repo);
	}
}
