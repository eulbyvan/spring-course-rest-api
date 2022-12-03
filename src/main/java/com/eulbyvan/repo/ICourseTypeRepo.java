package com.eulbyvan.repo;

import com.eulbyvan.model.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

public interface ICourseTypeRepo extends JpaRepository<CourseType, String> {
	Optional<CourseType> findByName(String name);
}
