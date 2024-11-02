package com.skillspace.teacherservice.controller;
import com.skillspace.teacherservice.models.Teacher;
import com.skillspace.teacherservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @PostMapping("/getProfile")
    public Map<String, Teacher> getProfile() {
        return profileService.getProfile();
    }

}
