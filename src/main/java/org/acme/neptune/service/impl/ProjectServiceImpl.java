package org.acme.neptune.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.acme.neptune.dto.TaskDTO;
import org.acme.neptune.dto.converter.ProjectConverter;
import org.acme.neptune.dto.converter.TaskConverter;
import org.acme.neptune.repository.ProjectRepository;
import org.acme.neptune.request.ProjectRequest;
import org.acme.neptune.response.BaseResponse;
import org.acme.neptune.response.ProjectResponse;
import org.acme.neptune.service.ProjectService;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.File;
import java.util.List;


@ApplicationScoped
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;
    private final ProjectConverter projectConverter;
    private final TaskConverter taskConverter;


    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {

        var project = projectConverter.convertToProject(projectRequest.getProject());

        project.createRegularProject();

        project = projectRepository.save(project);

        return new ProjectResponse("SUCCESS",
                "Project created successfully",
                projectConverter.convertToProjectDTO(project));
    }

    @Override
    public ProjectResponse getProject(Long id) {

        var project = projectRepository.findById(id);

        return new ProjectResponse("SUCCESS",
                "Project retrieved successfully",
                projectConverter.convertToProjectDTO(project));
    }


    @Override
    public BaseResponse updateTask(Long projectId, TaskDTO task) {

        var project = projectRepository.findById(projectId);

        project.updateTask(taskConverter.convertToTask(task));

        return new BaseResponse("SUCCESS",
                "Task updated successfully");
    }

    @Override
    public BaseResponse uploadDocuments(Long projectId, List<FileUpload> files) {

        // dummy implementation

        return new BaseResponse("SUCCESS",
                "Documents uploaded successfully");
    }
}
