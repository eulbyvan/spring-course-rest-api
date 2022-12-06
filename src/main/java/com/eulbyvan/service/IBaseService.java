package com.eulbyvan.service;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

public interface IBaseService<T, ID> {
	Optional<T> findById(ID reqId);

	List<T> findAll();

	T create(T req);

	T update(ID reqId, T req);

	void delete(ID reqId) throws Exception;
}
