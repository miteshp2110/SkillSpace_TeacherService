package com.skillspace.teacherservice.service;

import com.skillspace.teacherservice.models.Feedbacks;
import com.skillspace.teacherservice.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Map<String, List<Feedbacks>> getAllFeedbacks(int project_id) {
        Map<String,List<Feedbacks>> feedbacks = new HashMap<>();
        feedbacks.put("feedbacks",feedbackRepository.getAllFeedbacksByProjectId(project_id));
        return feedbacks;
    }

    public Map<String,String> postFeedback(Feedbacks feedback) {
        feedbackRepository.save(feedback);
        Map<String,String> feedbacks = new HashMap<>();
        feedbacks.put("Message","Successfully posted feedback");
        return feedbacks;
    }
}
