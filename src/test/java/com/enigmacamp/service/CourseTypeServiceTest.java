package com.enigmacamp.service;

import com.eulbyvan.model.entity.Course;
import com.eulbyvan.model.entity.CourseType;
import com.eulbyvan.repo.ICourseTypeRepo;
import com.eulbyvan.service.ICourseTypeService;
import com.eulbyvan.service.implementation.CourseTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 08/12/2022
 */

@ExtendWith(MockitoExtension.class)
public class CourseTypeServiceTest {
    @Mock
    private ICourseTypeRepo mockCourseTypeRepo;
    private ICourseTypeService courseTypeService;

    @BeforeEach
    void setup() {
        courseTypeService = new CourseTypeService(mockCourseTypeRepo);
    }

    @Test
    public void itShould_ReturnCourseType_When_CreateCourseType() {
        List<Course> courses = new ArrayList<>();
        CourseType dummyCourseType = new CourseType("test1", courses);
        when(mockCourseTypeRepo.save(dummyCourseType)).thenReturn(dummyCourseType);

        CourseType actualResult = courseTypeService.create(dummyCourseType);

        assertEquals(dummyCourseType, actualResult);
    }
}
