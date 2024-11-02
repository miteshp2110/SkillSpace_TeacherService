package com.skillspace.teacherservice.repository;


import com.skillspace.teacherservice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = "select * from teacher where email =:email",nativeQuery = true)
    public Teacher findByEmail(@Param("email") String email);
}
