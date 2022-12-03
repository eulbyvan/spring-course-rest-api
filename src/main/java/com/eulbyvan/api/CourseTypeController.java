package com.eulbyvan.api;

import com.eulbyvan.model.entity.CourseType;
import com.eulbyvan.service.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@RestController
@RequestMapping("/course-types")
public class CourseTypeController extends BaseController<CourseType, String> {
	public CourseTypeController(IBaseService<CourseType, String> service) {
		super(service);
	}
}
