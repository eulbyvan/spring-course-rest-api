package com.eulbyvan.api;

import com.eulbyvan.model.dto.CourseReq;
import com.eulbyvan.model.entity.Course;
import com.eulbyvan.service.IBaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public CourseController(IBaseService<Course, String> service, ModelMapper mp) {
		super(service, mp);
	}

	@PostMapping
	public Course add(@RequestBody CourseReq req) {
		Course mappedReq = mp.map(req, Course.class);

		return service.create(mappedReq);
	}
}
