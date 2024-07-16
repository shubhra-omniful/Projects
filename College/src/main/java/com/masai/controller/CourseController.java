package com.masai.controller;

import com.masai.model.Course;
import com.masai.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<Course>registerCourse(@RequestBody Course course) {
        Course savedCourse = courseService.registerCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

}
