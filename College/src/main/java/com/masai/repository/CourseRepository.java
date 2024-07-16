package com.masai.repository;

import com.masai.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query("from Course where name = ?1")
    Course findByCourseName(String courseName);

}
