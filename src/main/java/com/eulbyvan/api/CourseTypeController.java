package com.eulbyvan.api;

import com.eulbyvan.model.dto.request.CourseTypeReq;
import com.eulbyvan.model.entity.CourseType;
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
@RequestMapping("/course-types")
public class CourseTypeController extends BaseController<CourseType, String> {

	public CourseTypeController(IBaseService<CourseType, String> service, ModelMapper mp) {
		super(service, mp);
	}

	@PostMapping
	public CourseType add(@RequestBody CourseTypeReq req) {
		CourseType mappedReq = mp.map(req, CourseType.class);

		return service.create(mappedReq);
	}
}
