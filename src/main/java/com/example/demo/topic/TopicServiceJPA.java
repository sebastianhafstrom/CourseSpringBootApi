package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TopicServiceJPA {

    @Autowired
    private TopicRepository topicRepository;


    public void insertTopic(Topic topic){
        topicRepository.save(topic);
    }

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(UUID id){
        return topicRepository.findById(id);
    }

    public void deleteTopic(UUID id){
        topicRepository.deleteById(id);
    }

    public void updateTopic(UUID id, Topic topic){
        topicRepository.save(new Topic(id, topic.getName(), topic.getDescription()));
    }


}
