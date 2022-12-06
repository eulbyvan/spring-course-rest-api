package com.eulbyvan.api;

import com.eulbyvan.model.dto.response.CommonRes;
import com.eulbyvan.model.dto.response.ErrorRes;
import com.eulbyvan.model.dto.response.SuccessRes;
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

public class BaseController<T, ID, U> {
	protected IBaseService<T, ID> service;
	protected ModelMapper mp;
	private Class<T> myClass;

	public BaseController(IBaseService<T, ID> service, ModelMapper mp, Class<T> myClass) {
		this.service = service;
		this.mp = mp;
		this.myClass = myClass;
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommonRes> findById(@PathVariable("id") ID reqId) {
		Optional<T> data = service.findById(reqId);

		if (data.isPresent()) {
			List<T> listData = data.stream().collect(Collectors.toList());

			SuccessRes<T> res = new SuccessRes<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(listData);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorRes<T> res = new ErrorRes<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}

	@GetMapping
	public ResponseEntity<CommonRes> findAll() {
		List<T> data = service.findAll();

		if (!data.isEmpty()) {
			SuccessRes<T> res = new SuccessRes<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorRes<T> res = new ErrorRes<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CommonRes> edit(@PathVariable("id") ID reqId, @RequestBody U req) {
		T mappedReq = mp.map(req, myClass);

		Object wrapper = new Object(){
			ID id = reqId;

			public ID getId() {
				return id;
			}
		};

		mp.map(wrapper, mappedReq);

		T data = service.update(reqId, mappedReq);
		List<T> listData = Optional.of(data).stream().collect(Collectors.toList());

		if (!listData.isEmpty()) {
			SuccessRes<T> res = new SuccessRes<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(listData);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorRes<T> res = new ErrorRes<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CommonRes> remove(@PathVariable("id") ID reqId) {
		ID deletedId = service.delete(reqId);

		if (!deletedId.equals(null)) {
			SuccessRes<T> res = new SuccessRes<>();

			res.setCode(HttpStatus.OK.value());
			res.setStatus(HttpStatus.OK.getReasonPhrase());
			res.setMsg("mantap bos, sukses");
			res.setData(null);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorRes<T> res = new ErrorRes<>();

		res.setCode(notFound.value());
		res.setStatus(notFound.getReasonPhrase());
		res.setMsg("gaada datanya bang");

		return ResponseEntity.status(notFound).body(res);
	}
}
