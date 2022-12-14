package com.example.khairislimani.services;

import com.example.khairislimani.entities.Project;
import com.example.khairislimani.entities.Sprint;
import com.example.khairislimani.entities.User;
import com.example.khairislimani.repositories.ProjectRepository;
import com.example.khairislimani.repositories.SprintRepository;
import com.example.khairislimani.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class IProjectServiceIMP implements IProjectService{

    ProjectRepository projectRepository;
    UserRepository userRepository;

    SprintRepository sprintRepository;
    @Override
    public Project addProject(Project project) {
        List<Sprint> sprints = project.getSprints();
        sprints.stream().forEach(sprint -> sprint.setProject(project));
        project.setSprints(project.getSprints());
        projectRepository.save(project);
        sprintRepository.saveAll(project.getSprints());
        return project;
    }


    @Override
    public void assignProjectToUser(Integer projectId, Integer userId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if(project!=null && user!=null){
            user.getProjects().add(project);
            userRepository.save(user);
        }

    }

    @Override
    public void assignProjectToClient(Integer projectId, String firstName, String lastName) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findUserByRoleAndFNameAndLName("Client", firstName, lastName);
        if ( (project != null) && (user!=null) )
        {
            user.getProjects().add(project);
            userRepository.save(user);
        }

    }

    @Override
    public List<Project> getAllCurrentProjects() {
        return projectRepository.findAll().stream()
                .filter(project -> project.getSprints().stream()
                        .anyMatch(sprint -> sprint.getStartDate().before(new Date()))
                ).collect(Collectors.toList());
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {

        User user = userRepository.findUserByFNameAndLName(fName, lName);
        if (user != null) {
            List<Project> projects = user.getProjects();
            List<User> users = new ArrayList<User>();
            projects.stream().forEach(project -> project.getUsers().forEach(user1 -> users.add(user1)));
            users.stream().filter(user1 -> user.getRole().equals("SCRUM_MASTER"));
            return projects;
        } else {
            return null;
        }

    }

    @Override
    @Scheduled(fixedRate = 30)
    public void getNbrSprintByCurrentProject(){
        List<Project> list = getAllCurrentProjects();
        list.stream().forEach(e -> log.info(String.valueOf(e.getSprints().size())));
    }
}
