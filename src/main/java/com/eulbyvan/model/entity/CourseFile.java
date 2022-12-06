package com.eulbyvan.model.entity;

import com.eulbyvan.model.UUIDBasedEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@Data
@Entity
@Table(name = "tbl_course_file")
public class CourseFile extends UUIDBasedEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "file_path", nullable = false)
    private String filePath;
}

