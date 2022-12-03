package com.eulbyvan.api;

import com.eulbyvan.service.IBaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
	public Optional<T> findById(@PathVariable("id") ID reqId) {
		return service.findById(reqId);
	}

	@GetMapping
	public List<T> findAll() {
		return service.findAll();
	}

	@PutMapping("/{id}")
	public T edit(@PathVariable("id") ID reqId, @RequestBody T req) {
		return service.update(reqId, req);
	}

	@DeleteMapping("/{id}")
	public ID remove(@PathVariable("id") ID reqId) {
		return service.delete(reqId);
	}
}
