package com.skillspace.teacherservice.repository;


import com.skillspace.teacherservice.models.ProjectMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMediaRepository extends JpaRepository<ProjectMedia,Integer> {
    @Query(value = "select * from project_media where project_id =:project_id",nativeQuery = true)
    public List<ProjectMedia> getProjectMediaById(@Param("project_id") int project_id);
}
