package org.acme.neptune.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.acme.neptune.dto.TaskDTO;
import org.acme.neptune.request.ProjectRequest;
import org.acme.neptune.response.BaseResponse;
import org.acme.neptune.response.ProjectResponse;
import org.acme.neptune.service.ProjectService;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.util.List;

@Path("/projects")
@RequiredArgsConstructor
public class ProjectResource {


    private final ProjectService projectService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        return projectService.createProject(projectRequest);
    }


    @GET
    @Path("/{id}")
    public ProjectResponse getProject(@PathParam("id") Long id) {
        return projectService.getProject(id);
    }


    @PUT
    @Path("/{id}/update-task")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse updateTask(@PathParam("id") Long projectId, TaskDTO task) {
        return projectService.updateTask(projectId, task);
    }


    @POST
    @Path("/{id}/upload-document")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse uploadDocuments(@PathParam("id") Long projectId, @RestForm("files") List<FileUpload> files) {
        return projectService.uploadDocuments(projectId, files);
    }

}
