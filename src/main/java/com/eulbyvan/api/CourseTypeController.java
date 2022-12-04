package com.eulbyvan.api;

import com.eulbyvan.model.dto.request.CourseTypeReq;
import com.eulbyvan.model.dto.response.CommonResponse;
import com.eulbyvan.model.dto.response.ErrorResponse;
import com.eulbyvan.model.dto.response.SuccessResponse;
import com.eulbyvan.model.entity.Course;
import com.eulbyvan.model.entity.CourseType;
import com.eulbyvan.service.IBaseService;
import com.eulbyvan.service.ICourseTypeService;
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
@RequestMapping("/course-types")
public class CourseTypeController extends BaseController<CourseType, String> {
	private ICourseTypeService typeService;

	public CourseTypeController(IBaseService<CourseType, String> service, ModelMapper mp, ICourseTypeService typeService) {
		super(service, mp);
		this.typeService = typeService;
	}

	@PostMapping
	public ResponseEntity<CommonResponse> add(@RequestBody CourseTypeReq req) {
		Optional<CourseType> existingType = typeService.findByName(req.getName());


		if (!existingType.isPresent()) {
			CourseType mappedReq = mp.map(req, CourseType.class);

			service.create(mappedReq);
			Optional<CourseType> addedData = typeService.findByName(req.getName());
			List<CourseType> listData = addedData.stream().collect(Collectors.toList());

			SuccessResponse<CourseType> res = new SuccessResponse<>();

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
		res.setMsg("udah ada course type dengan name: " + req.getName());

		return ResponseEntity.status(notAcceptable).body(res);
	}

//	@GetMapping("/")
//	public Optional<CourseType> findByName(@RequestParam(value = "name", defaultValue = "") String name) {
//		return typeService.findByName(name);
//	}
}
