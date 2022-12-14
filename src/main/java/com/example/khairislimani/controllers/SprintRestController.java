package com.example.khairislimani.controllers;

import com.example.khairislimani.entities.Project;
import com.example.khairislimani.entities.Sprint;
import com.example.khairislimani.services.IProjectService;
import com.example.khairislimani.services.ISprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sprint")
public class SprintRestController {
    @Autowired
    ISprintService iSprintService;

    @PutMapping("/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable(value = "idProject") Integer idProject) {
        iSprintService.addSprintAndAssignToProject(sprint, idProject);
    }


}
