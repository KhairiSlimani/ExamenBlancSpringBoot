package com.example.khairislimani.controllers;

import com.example.khairislimani.entities.Project;
import com.example.khairislimani.entities.User;
import com.example.khairislimani.services.IProjectService;
import com.example.khairislimani.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("project")
public class ProjectRestController {
    @Autowired
    IProjectService iProjectService;

    @PostMapping()
    public Project addProject(@RequestBody Project project) {
        return iProjectService.addProject(project);
    }

    @PutMapping("/{projectId}/{userId}")
    public void assignProjectToUser(@PathVariable(value = "projectId") Integer projectId, @PathVariable(value = "userId") Integer userId) {
        iProjectService.assignProjectToUser(projectId, userId);
    }

    @PutMapping("/{projectId}/{firstName}/{lastName}")
    public void assignProjectToClient(@PathVariable(value = "projectId") Integer projectId, @PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName) {
        iProjectService.assignProjectToClient(projectId,firstName,lastName);
    }

    @GetMapping("/{fName}/{lName}")
    public List<Project> getProjectsByScrumMaster(@PathVariable(value = "fName") String fName, @PathVariable(value = "lName") String lName) {
        return iProjectService.getProjectsByScrumMaster(fName,lName);
    }

    @GetMapping("/getAllCurrentProjects")
    public List<Project> getAllCurrentProjects() {
        return iProjectService.getAllCurrentProjects();
    }


    @GetMapping()
    public void getNbrSprintByCurrentProject() {
        iProjectService.getNbrSprintByCurrentProject();
    }

}
