package com.eulbyvan.model.entity;

import com.eulbyvan.model.UUIDBasedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Data
@Entity
@Table(name = "tbl_course_type")
public class CourseType extends UUIDBasedEntity {
	@Column(name = "type_name", nullable = false, unique = true, length = 100)
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy = "courseType")
	private List<Course> courses;
}
