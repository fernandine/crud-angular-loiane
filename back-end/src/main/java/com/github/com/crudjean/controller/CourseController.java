package com.github.com.crudjean.controller;

import com.github.com.crudjean.model.Course;
import com.github.com.crudjean.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    @Autowired
    private final CourseRepository courseRepository;

    @GetMapping
    public @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        Course dto = courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
