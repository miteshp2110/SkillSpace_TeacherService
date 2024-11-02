package com.skillspace.teacherservice.controller;


import com.skillspace.teacherservice.models.Project;
import com.skillspace.teacherservice.models.ProjectResponse;
import com.skillspace.teacherservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/totalProject")
    public Map<String, Integer> getProjectDetails() {
        return projectService.getTotalProjectsCount();
    }


    @PostMapping("/ongoingProject")
    public Map<String,Integer> onGoingProjects() {
        return projectService.getOngoingProjectsCount();
    }

    @PostMapping("/completedProject")
    public Map<String,Integer> completedProject() {
        return projectService.getCompletedProjectsCount();
    }


    @PostMapping("/getAllProjects")
    public Map<String, List<Project>> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/getProjectDetails")
    public Map<String, ProjectResponse> getProjectDetails(@RequestBody Map<String, Integer> projectDetails) {
        return projectService.getProjectById(projectDetails.get("project_id"));
    }


}
