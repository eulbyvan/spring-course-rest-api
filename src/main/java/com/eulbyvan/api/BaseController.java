package com.eulbyvan.api;

import com.eulbyvan.model.dto.response.CommonResponse;
import com.eulbyvan.model.dto.response.ErrorResponse;
import com.eulbyvan.model.dto.response.SuccessResponse;
import com.eulbyvan.service.IBaseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

public class BaseController<T, ID> {
	protected IBaseService<T, ID> service;

	protected ModelMapper mp;

	public BaseController(IBaseService<T, ID> service, ModelMapper mp) {
		this.service = service;
		this.mp = mp;
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommonResponse> findById(@PathVariable("id") ID reqId) {
		Optional<T> data = service.findById(reqId);

		if (data.isPresent()) {
			List<T> listData = data.stream().collect(Collectors.toList());

			SuccessResponse<T> res = new SuccessResponse<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(listData);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}

	@GetMapping
	public ResponseEntity<CommonResponse> findAll() {
		List<T> data = service.findAll();

		if (!data.isEmpty()) {
			SuccessResponse<T> res = new SuccessResponse<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CommonResponse> edit(@PathVariable("id") ID reqId, @RequestBody T req) {
		T data = service.update(reqId, req);
		List<T> listData = Optional.of(data).stream().collect(Collectors.toList());

		if (!listData.isEmpty()) {
			SuccessResponse<T> res = new SuccessResponse<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(listData);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CommonResponse> remove(@PathVariable("id") ID reqId) {
		ID deletedId = service.delete(reqId);

		if (deletedId.equals(null)) {
			SuccessResponse<T> res = new SuccessResponse<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(null);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}
}
