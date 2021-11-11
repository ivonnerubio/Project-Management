package com.coffee.Coffee.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.projectName= ?1")
    Optional<Project> findProjectByProjectName(String projectName);

    @Query("SELECT p FROM Project p "+
            "where lower(p.projectName) like lower(concat('%', :searchTerm, '%'))")
    List<Project> search(@Param("searchTerm")String searchTerm);
}
