package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceJPA {

    @Autowired
    private CourseRepository courseRepository;


    public void insertCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getAllCourses(UUID topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(UUID id){
        return courseRepository.findById(id);
    }

    public void deleteCourse(UUID id){
        courseRepository.deleteById(id);
    }

    public void updateCourse(UUID id, Course course){
        courseRepository.save(new Course(id, course.getName(), course.getDescription(), course.getTopic()));
    }


}
