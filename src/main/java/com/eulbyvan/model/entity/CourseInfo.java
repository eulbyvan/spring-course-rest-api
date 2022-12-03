package com.eulbyvan.model.entity;

import com.eulbyvan.model.UUIDBasedEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Data
@Entity
@Table(name = "tbl_course_info")
public class CourseInfo extends UUIDBasedEntity {
	@Column(name = "duration", nullable = false)
	private Integer duration;
	@Column(name = "level", nullable = false)
	private Integer level;
}
