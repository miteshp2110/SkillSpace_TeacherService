package com.skillspace.teacherservice.service;


import com.skillspace.teacherservice.models.Project;
import com.skillspace.teacherservice.models.ProjectResponse;
import com.skillspace.teacherservice.repository.ProjectRepository;
import com.skillspace.teacherservice.repository.StudentRepository;
import com.skillspace.teacherservice.util.UsernameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private UsernameUtil usernameUtil;


    public Map<String,List<Project>> getAllProjects() {
        String email = usernameUtil.getUsername();
        Map<String,List<Project>> projects = new HashMap<>();
        projects.put("projects",projectRepository.getAllProjects(email));
        return projects;
    }

    public Map<String,Integer> getTotalProjectsCount() {
        String email = usernameUtil.getUsername();
        Map<String,Integer> map = new HashMap<>();
        map.put("count",projectRepository.getTotalProjectCount(email));
        return map;
    }

    public Map<String,Integer> getCompletedProjectsCount() {
        String email = usernameUtil.getUsername();
        Map<String,Integer> map = new HashMap<>();
        map.put("count",projectRepository.getCompletedProjectsCount(email));
        return map;
    }

    public Map<String,Integer> getOngoingProjectsCount() {
        String email = usernameUtil.getUsername();
        Map<String,Integer> map = new HashMap<>();
        map.put("count",projectRepository.getongoingProjectsCount(email));
        return map;
    }

    public Map<String, ProjectResponse> getProjectById(int id) {
        Map<String,ProjectResponse> map = new HashMap<>();
        Project project = projectRepository.getProjectById(id);
        String studentName = studentRepository.getStudentNameById((int) project.getStudent_id());
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setStudentName(studentName);
        projectResponse.setProject(project);
        map.put("projects",projectResponse);
        return map;
    }


}
