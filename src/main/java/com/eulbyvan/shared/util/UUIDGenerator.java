package com.eulbyvan.shared.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Component
public class UUIDGenerator implements IRandomStringGenerator {

	@Override
	public String get() {
		return UUID.randomUUID().toString();
	}
}