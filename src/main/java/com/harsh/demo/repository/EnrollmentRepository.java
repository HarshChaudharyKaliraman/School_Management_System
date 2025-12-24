package com.harsh.demo.repository;

import com.harsh.demo.entity.Course;
import com.harsh.demo.entity.Enrollment;
import com.harsh.demo.entity.Student;
import com.harsh.demo.enums.Grade;
import com.harsh.demo.enums.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourseId(Long courseId);

    List<Enrollment> findByStudentId(Long studentId);

    @Query("SELECT e.grade FROM Enrollment e WHERE e.course.id = :courseId")
    List<Grade> findGradesByCourseId(Long courseId);

    @Query("SELECT DISTINCT e.student FROM Enrollment e")
    List<Student> findAllEnrolledStudents();

    @Query("SELECT c FROM Course c WHERE c.teacher.id = :teacherId")
    List<Course> findCoursesByTeacher(Long teacherId);

    @Query("SELECT e.student FROM Enrollment e WHERE e.grade = 'F'")
    List<Student> findStudentsWithFailingGrades();

    @Query("SELECT e.course, e.grade, COUNT(e) FROM Enrollment e GROUP BY e.course, e.grade")
    List<Object[]> gradeDistributionPerCourse();

    List<Enrollment> findBySemester(Semester semester);

    @Query("SELECT e.course, SUM(CASE WHEN e.grade <> 'F' THEN 1 ELSE 0 END), SUM(CASE WHEN e.grade = 'F' THEN 1 ELSE 0 END) FROM Enrollment e GROUP BY e.course")
    List<Object[]> passFailCountPerCourse();
}