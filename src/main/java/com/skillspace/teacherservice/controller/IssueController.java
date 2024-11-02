package com.skillspace.teacherservice.controller;

import com.skillspace.teacherservice.models.Issue;
import com.skillspace.teacherservice.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IssueController {

    @Autowired
    IssueService issueService;

    @PostMapping("/getOpenIssuesCount")
    public Map<String,Integer> getOpenIssues(@RequestBody Map<String, Integer> map) {
        return issueService.getOpenIssuesCount(map.get("project_id"));
    }

    @PostMapping("getAllIssues")
    public Map<String, List<Issue>> getAllIssues(@RequestBody Map<String, Integer> map) {
        return issueService.getAllIssues(map.get("project_id"));
    }

    @PostMapping("/getIssueDetails")
    public Map<String,Issue> getIssueDetails(@RequestBody Map<String, Integer> map) {
        return issueService.getIssueDetails(map.get("issue_id"));
    }
}
