package com.eulbyvan.api;

import com.eulbyvan.service.IBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

public class BaseController<T, ID> {
	private IBaseService<T, ID> service;

	public BaseController(IBaseService<T, ID> service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public Optional<T> findById(@PathVariable("id") ID reqId) {
		return service.findById(reqId);
	}

	@GetMapping
	public List<T> findAll() {
		return service.findAll();
	}

	@PostMapping
	public T add(@RequestBody T req) {
		return service.create(req);
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
