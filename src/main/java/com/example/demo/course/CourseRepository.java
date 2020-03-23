package com.example.demo.course;

import com.example.demo.topic.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends CrudRepository<Course, UUID> {
    public List<Course> getCoursesByTopic(UUID topicId);
    public List<Course> findByTopicId(UUID topicId);
}
