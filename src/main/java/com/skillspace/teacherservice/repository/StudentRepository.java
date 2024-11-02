package com.skillspace.teacherservice.repository;

import com.skillspace.teacherservice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select name from student where id =:id",nativeQuery = true)
    public String getStudentNameById(@Param("id") Integer id);
}
