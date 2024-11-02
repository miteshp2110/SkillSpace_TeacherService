package com.skillspace.teacherservice.service;


import com.skillspace.teacherservice.models.Users;
import com.skillspace.teacherservice.repository.UserRepository;
import com.skillspace.teacherservice.util.UsernameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UsernameUtil usernameUtil;

    public boolean allowHome(){
        String email = usernameUtil.getUsername();
        Users user = userRepository.findByEmail(email);

        if(user.isProfileStatus() && user.isEmailStatus()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean emailStatus(){
        String email = usernameUtil.getUsername();
        Users user = userRepository.findByEmail(email);
        return user.isEmailStatus();
    }

    public boolean profileStatus(){
        String email = usernameUtil.getUsername();
        Users user = userRepository.findByEmail(email);
        return user.isProfileStatus();
    }

}
