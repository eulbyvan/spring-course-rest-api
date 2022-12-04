package com.eulbyvan.repo;

import com.eulbyvan.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

public interface ICourseRepo extends JpaRepository<Course, String> {
	Optional<Course> findByTitle(String title);
}
