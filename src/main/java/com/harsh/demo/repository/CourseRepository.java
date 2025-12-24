package com.harsh.demo.repository;

import com.harsh.demo.entity.Course;
import com.harsh.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c.teacher FROM Course c GROUP BY c.teacher ORDER BY COUNT(c) DESC")
    List<Teacher> findTeacherWithMostCourses();

}
