package com.harsh.demo.service;

import com.harsh.demo.entity.Enrollment;
import com.harsh.demo.entity.Student;
import com.harsh.demo.enums.Grade;
import com.harsh.demo.repository.EnrollmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Transactional
    public Enrollment enrollStudent(Enrollment enrollment) {
        enrollment.setEnrollmentDate(LocalDate.now());
        return enrollmentRepository.save(enrollment);
    }


    public double calculateAverageGrade(Long courseId) {
        List<Grade> grades =
                enrollmentRepository.findGradesByCourseId(courseId);

        if (grades.isEmpty()) return 0.0;

        int sum = 0;
        for (Grade g : grades) {
            sum += g.getScore();
        }
        return (double) sum / grades.size();
    }

    public List<Student> findTopPerformingStudents() {

        List<Student> students = enrollmentRepository.findAllEnrolledStudents();

        return students.stream()
                .sorted((s1, s2) -> {
                    double avg1 = averageForStudent(s1);
                    double avg2 = averageForStudent(s2);
                    return Double.compare(avg2, avg1); // descending
                })
                .toList();
    }

    private double averageForStudent(Student student) {

        List<Enrollment> enrollments =
                enrollmentRepository.findByStudentId(student.getId());

        if (enrollments.isEmpty()) return 0.0;

        int sum = 0;
        for (Enrollment e : enrollments) {
            sum += e.getGrade().getScore();
        }
        return (double) sum / enrollments.size();
    }

}