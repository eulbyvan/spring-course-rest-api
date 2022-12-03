package com.eulbyvan.model.entity;

import com.eulbyvan.model.UUIDBasedEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Data
@Entity
@Table(name = "tbl_course")
public class Course extends UUIDBasedEntity {
	@Column(name = "title", nullable = false, length = 150, unique = true)
	private String title;
	@Column(name = "description", nullable = false, length = 250)
	private String description;
	@Column(name = "link", nullable = false, length = 200, unique = true)
	private String link;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_type_id")
	private CourseType courseType;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_info_id")
	private CourseInfo courseInfo;
}
