package org.acme.neptune.service;

import org.acme.neptune.dto.TaskDTO;
import org.acme.neptune.request.ProjectRequest;
import org.acme.neptune.response.BaseResponse;
import org.acme.neptune.response.ProjectResponse;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest projectRequest);

    ProjectResponse getProject(Long id);

    BaseResponse updateTask(Long projectId, TaskDTO task);

    BaseResponse uploadDocuments(Long projectId, List<FileUpload> files);
}
