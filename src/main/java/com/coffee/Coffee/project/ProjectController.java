package com.coffee.Coffee.project;


import org.atmosphere.config.service.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){this.projectService = projectService;}

    @GetMapping
    public List<Project> getProjects(){return projectService.getProjects();}

    @PostMapping
    public void registerNewProject(@RequestBody Project project){projectService.addNewProject(project);}

    @DeleteMapping(path="{projectId}")
    public void deleteProject(@PathVariable("projectId")Integer projectId){
        projectService.deleteProject(projectId);
    }

    @PutMapping(path="{projectId}")
    public void updateProject(
        @PathVariable("projectId") Integer projectId,
        @RequestParam(required = false) String projectName,
        @RequestParam(required = false) String status
    ){
        projectService.updateProject(projectId, projectName, status);
    }







}
