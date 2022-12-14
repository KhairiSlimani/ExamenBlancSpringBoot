package com.example.khairislimani.services;

import com.example.khairislimani.entities.Project;
import com.example.khairislimani.entities.Sprint;
import com.example.khairislimani.repositories.ProjectRepository;
import com.example.khairislimani.repositories.SprintRepository;
import com.example.khairislimani.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ISprintServiceIMP implements ISprintService{

    SprintRepository sprintRepository;
    ProjectRepository projectRepository;

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, Integer idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        if(project!=null){

            sprint.setProject(project);
            sprintRepository.save(sprint);
        }
    }

}
