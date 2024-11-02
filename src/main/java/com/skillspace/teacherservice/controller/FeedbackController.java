package com.skillspace.teacherservice.controller;


import com.skillspace.teacherservice.models.Feedbacks;
import com.skillspace.teacherservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;


    @PostMapping("/getFeedback")
    public Map<String, List<Feedbacks>> getFeedbacks(@RequestBody Map<String,Integer> map) {
        return feedbackService.getAllFeedbacks(map.get("project_id"));
    }

    @PostMapping("/postFeedback")
    public Map<String,String> postFeedback(@RequestBody Feedbacks feedbacks) {
        return feedbackService.postFeedback(feedbacks);
    }
}
