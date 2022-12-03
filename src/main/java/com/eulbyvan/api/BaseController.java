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
			SuccessResponse<T> res = new SuccessResponse<>();

			List<T> listData = data.stream().collect(Collectors.toList());

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(listData);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(HttpStatus.NOT_FOUND.value());
		res.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
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

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(HttpStatus.NOT_FOUND.value());
		res.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CommonResponse> edit(@PathVariable("id") ID reqId, @RequestBody T req) {
		T data = service.update(reqId, req);
		Optional<T> optionalData = Optional.of(data);
		List<T> listData = optionalData.stream().collect(Collectors.toList());

		if (optionalData.isPresent()) {
			SuccessResponse<T> res = new SuccessResponse<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(listData);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(HttpStatus.NOT_FOUND.value());
		res.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CommonResponse> remove(@PathVariable("id") ID reqId) {
		ID deletedId = service.delete(reqId);

		Optional<ID> optionalId = Optional.of(deletedId);

		if (optionalId.isPresent()) {
			SuccessResponse<T> res = new SuccessResponse<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(null);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		ErrorResponse<T> res = new ErrorResponse<>();

		res.setCode(HttpStatus.NOT_FOUND.value());
		res.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
}
