package com.eulbyvan.service.implementation;

import com.eulbyvan.model.entity.Course;
import com.eulbyvan.model.entity.CourseType;
import com.eulbyvan.repo.ICourseRepo;
import com.eulbyvan.service.ICourseService;
import com.eulbyvan.service.ICourseTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Service
public class CourseService extends BaseService<Course, String> implements ICourseService {
	private ICourseRepo courseRepo;
	private ICourseTypeService typeService;

	public CourseService(ICourseRepo repo, ICourseTypeService typeService) {
		super(repo);
		this.courseRepo = repo;
		this.typeService = typeService;
	}

	@Override
	public Course create(Course req) {
		String reqTypeName = req.getCourseType().getName();
		Optional<CourseType> existingType = typeService.findByName(reqTypeName);

		existingType.ifPresentOrElse(req::setCourseType, () -> {
			throw new RuntimeException("pake course type yg ada aja bang");
		});

		return super.create(req);
	}

	@Override
	public Optional<Course> findByTitle(String title) {
		return courseRepo.findByTitle(title);
	}
}
