package com.skillspace.teacherservice.service;

import com.skillspace.teacherservice.models.ProjectMedia;
import com.skillspace.teacherservice.repository.ProjectMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectMediaService {

    @Autowired
    private ProjectMediaRepository projectMediaRepository;

    public Map<String, List<ProjectMedia>> getAllProjectMedia(int project_id){
        HashMap<String,List<ProjectMedia>> map = new HashMap<>();
        map.put("media",projectMediaRepository.getProjectMediaById(project_id));
        return map;
    }

}
