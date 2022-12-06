package com.eulbyvan.service.implementation;

import com.eulbyvan.model.exception.NotFoundException;
import com.eulbyvan.service.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

public class BaseService<T, ID> implements IBaseService<T, ID> {
	private JpaRepository<T, ID> repo;

	public BaseService(JpaRepository<T, ID> repo) {
		this.repo = repo;
	}

	@Override
	public Optional<T> findById(ID reqId) {
		Optional<T> res = repo.findById(reqId);
		if (res.isEmpty()) throw new NotFoundException();
		return res;
	}

	@Override
	public List<T> findAll() {
		return repo.findAll();
	}

	@Override
	public T create(T req) {
		return repo.save(req);
	}

	@Override
	public T update(ID reqId, T req) {
		Optional<T> existingData = findById(reqId);
		if (existingData.isPresent()) return repo.save(req);

		return null;
	}

	@Override
	public void delete(ID reqId) throws Exception {
		Optional<T> existingData = findById(reqId);
		repo.deleteById(reqId);
	}
}
