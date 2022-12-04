package com.eulbyvan.api;

import com.eulbyvan.model.dto.request.CourseReq;
import com.eulbyvan.model.dto.response.CommonResponse;
import com.eulbyvan.model.dto.response.ErrorResponse;
import com.eulbyvan.model.dto.response.SuccessResponse;
import com.eulbyvan.model.entity.Course;
import com.eulbyvan.service.IBaseService;
import com.eulbyvan.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@RestController
@RequestMapping("/courses")
public class CourseController extends BaseController<Course, String, CourseReq> {
	private ICourseService courseService;

	public CourseController(IBaseService<Course, String> service, ModelMapper mp, ICourseService courseService, Class<Course> courseClass) {
		super(service, mp, courseClass);
		this.courseService = courseService;
	}

	@PostMapping
	public ResponseEntity<CommonResponse> add(@RequestBody CourseReq req) {
		Optional<Course> existingCourse = courseService.findByTitle(req.getTitle());

		if (!existingCourse.isPresent()) {
			Course mappedReq = mp.map(req, Course.class);

			service.create(mappedReq);
			Optional<Course> addedData = courseService.findByTitle(req.getTitle());
			List<Course> listData = addedData.stream().collect(Collectors.toList());

			SuccessResponse<Course> res = new SuccessResponse<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(listData);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notAcceptable = HttpStatus.NOT_ACCEPTABLE;

		ErrorResponse<Course> res = new ErrorResponse<>();

		res.setCode(notAcceptable.value());
		res.setStatus(notAcceptable.getReasonPhrase());
		res.setMsg("udah ada course dengan title: " + req.getTitle());

		return ResponseEntity.status(notAcceptable).body(res);
	}

//	@GetMapping("/title")
//	public Optional<Course> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
//		return courseService.findByTitle(title);
//	}
}
