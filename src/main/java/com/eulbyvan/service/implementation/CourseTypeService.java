package com.eulbyvan.service.implementation;

import com.eulbyvan.model.entity.CourseType;
import com.eulbyvan.repo.ICourseTypeRepo;
import org.springframework.stereotype.Service;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Service
public class CourseTypeService extends BaseService<CourseType, String> {
	public CourseTypeService(ICourseTypeRepo repo) {
		super(repo);
	}
}
