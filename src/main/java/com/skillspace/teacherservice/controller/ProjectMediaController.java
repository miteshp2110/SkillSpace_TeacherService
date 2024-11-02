package com.skillspace.teacherservice.controller;


import com.skillspace.teacherservice.models.ProjectMedia;
import com.skillspace.teacherservice.service.ProjectMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProjectMediaController {

    @Autowired
    private ProjectMediaService projectMediaService;

    @PostMapping("/getProjectMedia")
    public Map<String, List<ProjectMedia>> getProjectMedia(@RequestBody Map<String, Integer> projectDetails) {
        return projectMediaService.getAllProjectMedia(projectDetails.get("project_id"));
    }


}
