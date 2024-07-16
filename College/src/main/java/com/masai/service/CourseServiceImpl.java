package com.masai.service;

import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course registerCourse(Course course) {
        Set<Student> students = course.getStudents();
        students.forEach(student -> student.getCourses().add(course));
        return courseRepository.save(course);
    }
}
