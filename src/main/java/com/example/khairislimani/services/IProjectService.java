package com.example.khairislimani.services;

import com.example.khairislimani.entities.Project;
import com.example.khairislimani.entities.User;

import java.util.List;

public interface IProjectService {
    public Project addProject(Project project);
    public void assignProjectToUser (Integer projectId, Integer userId);
    public void assignProjectToClient (Integer projectId,String firstName, String lastName);
    public List<Project> getAllCurrentProjects();
    public List<Project> getProjectsByScrumMaster(String fName, String lName);
    public void getNbrSprintByCurrentProject();

}
