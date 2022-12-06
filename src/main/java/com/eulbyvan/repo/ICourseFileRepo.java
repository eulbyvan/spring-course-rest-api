package com.eulbyvan.repo;

import com.eulbyvan.model.entity.CourseFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

public interface ICourseFileRepo extends JpaRepository<CourseFile, String> {
}
