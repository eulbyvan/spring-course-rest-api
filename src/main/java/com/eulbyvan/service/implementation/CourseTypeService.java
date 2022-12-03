package com.eulbyvan.service.implementation;

import com.eulbyvan.model.entity.CourseType;
import com.eulbyvan.repo.ICourseTypeRepo;
import com.eulbyvan.service.ICourseTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Service
public class CourseTypeService extends BaseService<CourseType, String> implements ICourseTypeService {
	private ICourseTypeRepo typeRepo;

	public CourseTypeService(ICourseTypeRepo repo) {
		super(repo);
		this.typeRepo = repo;
	}

	@Override
	public Optional<CourseType> findByName(String name) {
		return typeRepo.findByName(name);
	}
}
