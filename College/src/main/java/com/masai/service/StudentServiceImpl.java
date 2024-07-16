package com.masai.service;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseRepository;
import com.masai.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student registerStudentICourse(String courseName, Student student) throws CourseException {

        Course course  = courseRepository.findByCourseName(courseName);
        if ( course == null) throw  new CourseException("Course not found with name " + courseName);

        course.getStudents().add(student);
        student.getCourses().add(course);

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() throws StudentException {
        return studentRepository.findAll();
    }

    @Override
    public Student updateByStudent(Integer roll,Student student) throws StudentException {
        Student foundStudent = studentRepository.findByRollNo(roll);
        if (foundStudent == null) throw new StudentException("Student not found with roll no " + student.getRoll());
        student.setRoll(roll);
        studentRepository.save(student);
        return foundStudent;
    }

    @Override
    public List<Student> getStudentsByCourseNme(String courseName) throws StudentException {
        Course _course = courseRepository.findByCourseName(courseName);
        if (_course == null) throw new StudentException("Course not found with name " + courseName);

        Set<Student> students = _course.getStudents();
        if ( students.isEmpty()) throw new StudentException("Student not found with name " + courseName);

        return new ArrayList<>(students);
    }
}
