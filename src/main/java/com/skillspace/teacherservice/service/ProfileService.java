package com.skillspace.teacherservice.service;


import com.skillspace.teacherservice.models.Teacher;
import com.skillspace.teacherservice.repository.TeacherRepository;
import com.skillspace.teacherservice.util.UsernameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    UsernameUtil usernameUtil;

    public Map<String, Teacher> getProfile() {
        Map<String, Teacher> profile = new HashMap<>();
        String email = usernameUtil.getUsername();
        profile.put("profile", teacherRepository.findByEmail(email));
        return profile;
    }
}
