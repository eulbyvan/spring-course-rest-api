package com.eulbyvan.api;

import com.eulbyvan.model.entity.Course;
import com.eulbyvan.service.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@RestController
@RequestMapping("/courses")
public class CourseController extends BaseController<Course, String> {
	public CourseController(IBaseService<Course, String> service) {
		super(service);
	}
}
