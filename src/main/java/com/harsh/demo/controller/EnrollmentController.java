package com.harsh.demo.controller;

import com.harsh.demo.entity.Enrollment;
import com.harsh.demo.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public Enrollment enrollStudent(@Valid @RequestBody Enrollment enrollment) {
        return enrollmentService.enrollStudent(enrollment);
    }
}
