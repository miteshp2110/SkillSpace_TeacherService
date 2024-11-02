package com.skillspace.teacherservice.repository;


import com.skillspace.teacherservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {

    @Query(value = "select * from users where email =:email",nativeQuery = true)
    public Users findByEmail(String email);
}
