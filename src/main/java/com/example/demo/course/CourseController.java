package com.example.demo.course;

import com.example.demo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CourseController {

    @Autowired
    private CourseServiceJPA courseService;

    @RequestMapping(path = "/topic/{topicId}/course", method = RequestMethod.POST)
    public void insertCourse(@Valid @NotBlank @RequestBody Course course, @PathVariable UUID topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.insertCourse(course);
    }

    @RequestMapping(path = "/topic/{topicId}/course", method = RequestMethod.GET)
    public List<Course> getAllCourses(@PathVariable UUID topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping(path = "/topic/{topicId}/course/{id}", method = RequestMethod.GET)
    public Optional<Course> getCourse(@PathVariable("id") UUID id){
        return courseService.getCourse(id);
    }

    @RequestMapping(path = "/topic/{topicId}/course/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable UUID id){
        courseService.deleteCourse(id);
    }

    @RequestMapping(path = "/topic/{topicId}/course/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable UUID topicId, @PathVariable UUID id, @Valid @NotNull @RequestBody Course course){
        course.setTopic(new Topic(topicId,"", ""));
        courseService.updateCourse(id, course);
    }

}
