package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/topic")
@RestController
public class TopicController {

    @Autowired
    private TopicServiceJPA topicService;

    @PostMapping
    public void insertTopic(@Valid @NotBlank @RequestBody Topic topic){
        topicService.insertTopic(topic);
    }

    @GetMapping
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping(path = "{id}")
    public Optional<Topic> getTopic(@PathVariable UUID id){
        return topicService.getTopic(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTopic(@PathVariable UUID id){
        topicService.deleteTopic(id);
    }

    @PutMapping(path = "{id}")
    public void updateTopic(@PathVariable UUID id, @Valid @NotNull @RequestBody Topic topic){
        topicService.updateTopic(id, topic);
    }

}
