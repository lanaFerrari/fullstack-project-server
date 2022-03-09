package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CourseController {

    @Autowired
    CourseRepository repository;

    private List<Course> courses = new ArrayList<Course>();

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
            return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
        }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(Integer.parseInt(id)));
    }


    @PostMapping("/course")
    public String createCourse(@RequestBody Course course) {
        repository.save(course);
        return "Success, course has been added to the list";
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") int courseId, @RequestBody Course course){

        Course foundCourse = repository.findById(courseId);
        foundCourse.setName(course.getName());
        foundCourse.setDuration(course.getDuration());
        foundCourse.setLocation(course.getLocation());
        foundCourse.setPrice(course.getPrice());
        foundCourse.setSummary(course.getSummary());

        final Course updatedCourse = repository.save(foundCourse);
        return ResponseEntity.ok(updatedCourse);
    }


    @DeleteMapping("/course/{id}")
    @Transactional // allows us to carry stuff out where 2 things happen at once
    public ResponseEntity<String> deleteCourse(@PathVariable String id ) {
        repository.deleteById(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Course Deleted");
    }

}
