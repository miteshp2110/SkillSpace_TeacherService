package com.skillspace.teacherservice.repository;

import com.skillspace.teacherservice.models.Feedbacks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedbacks,Integer> {

    @Query(value = "select * from feedbacks where project_id =:project_id",nativeQuery = true)
    public List<Feedbacks> getAllFeedbacksByProjectId(@Param("project_id") int project_id);
}
