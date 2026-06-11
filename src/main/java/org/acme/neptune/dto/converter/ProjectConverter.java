package org.acme.neptune.dto.converter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.acme.neptune.dto.ProjectDTO;
import org.acme.neptune.entity.Project;

@ApplicationScoped
@RequiredArgsConstructor
public class ProjectConverter {

    @Inject
    private final TaskConverter taskConverter;

    @Inject
    private final MilestoneConverter milestoneConverter;

    public Project convertToProject(ProjectDTO projectDTO) {

        var project = new Project(projectDTO.getId(), projectDTO.getTitle(),
                projectDTO.getStartDate(), projectDTO.getType());

        project.setStatus(projectDTO.getStatus());
        if (projectDTO.getTasks() != null) project.setTasks(
                projectDTO.getTasks().stream().map(taskConverter::convertToTask).toList()
        );

        if (projectDTO.getMilestones() != null) project.setMilestones(
                projectDTO.getMilestones().stream().map(milestoneConverter::convertToMilestone).toList()
        );

        return project;
    }

    public ProjectDTO convertToProjectDTO(Project project) {

        var projectDTO = new ProjectDTO(project.getId(), project.getTitle(),
                project.getStartDate(), project.getType());

        projectDTO.setStatus(project.getStatus());
        projectDTO.setTasks(
                project.getTasks().stream().map(taskConverter::convertToTaskDTO).toList()
        );

        projectDTO.setMilestones(
                project.getMilestones().stream().map(milestoneConverter::convertToMilestoneDTO).toList()
        );

        return projectDTO;
    }
}
