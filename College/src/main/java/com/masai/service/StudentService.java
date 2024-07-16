package com.masai.service;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;

import java.util.List;

public interface StudentService {
    Student registerStudentICourse(String courseName, Student student) throws CourseException;
    List<Student> getAllStudents() throws StudentException;
    Student updateByStudent(Integer roll,Student student) throws StudentException;
    List<Student> getStudentsByCourseNme(String courseName) throws StudentException;
}
