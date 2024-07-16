package com.masai.controller;


import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/{course}")
    private ResponseEntity<Student> registerStudentInCourseName(@PathVariable("course") String courseName, @RequestBody Student student) throws CourseException {
        Student  _student =studentService.registerStudentICourse(courseName,student);

        return new ResponseEntity<>(_student, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws StudentException {
        List<Student>students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/{roll}")
    public ResponseEntity<Student> updateStudent(@PathVariable("roll") Integer roll ,@RequestBody Student student) throws StudentException {
        Student reponseStudent= studentService.updateByStudent(roll,student);
        return new ResponseEntity<>(reponseStudent, HttpStatus.OK);
    }

    @GetMapping("/{course}")
    public ResponseEntity<List<Student>> getStudentByCourseName(@PathVariable("course") String courseName) throws StudentException {
         List<Student> students = studentService.getStudentsByCourseNme(courseName);
         return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
