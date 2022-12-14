package com.example.khairislimani.services;

import com.example.khairislimani.entities.Sprint;

public interface ISprintService {
    public void addSprintAndAssignToProject (Sprint sprint, Integer idProject);
}
