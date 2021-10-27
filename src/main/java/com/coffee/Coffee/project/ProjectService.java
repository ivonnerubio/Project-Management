package com.coffee.Coffee.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    private static ProjectRepository projectRepository;


    @Autowired
    public ProjectService(ProjectRepository projectRepository){this.projectRepository = projectRepository;}

    public static void addNewProject(Project project){
        Optional<Project> projectOptional = projectRepository.findProjectByProjectName(project.getProjectName());

        if(projectOptional.isPresent()){
            throw new IllegalStateException("project name taken");
        }
        projectRepository.save(project);
        System.out.println(project);
    }

    public List<Project> getProjects(){return projectRepository.findAll();}

    public void deleteProject(Long projectId){
        boolean exists = projectRepository.existsById(projectId);
        if(!exists){
            throw new IllegalStateException("student with id: " + projectId + " does not exist");
        }
        projectRepository.deleteById(projectId);
    }

    @Transactional
    public void updateProject(Long projectId, String projectName, String status){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalStateException("project with id: " + projectId + " does not exist"));

        if(status != null && status.length() >0 && !Objects.equals(project.getStatus(),status)){
            project.setStatus(status);
        }

        if(projectName != null && projectName.length()>0 && !Objects.equals(project.getProjectName(),projectName)){
            Optional <Project>projectOptional =projectRepository.findProjectByProjectName(projectName);
            if(projectOptional.isPresent()){
                throw new IllegalStateException("project name taken");
            }
            project.setProjectName(projectName);
        }


    }
}
