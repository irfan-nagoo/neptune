package org.acme.neptune.response;

import lombok.Getter;
import org.acme.neptune.dto.ProjectDTO;

@Getter
public class ProjectResponse extends BaseResponse {

    private final ProjectDTO project;


    public ProjectResponse(String code, String message, ProjectDTO project) {
        super(code, message);
        this.project = project;
    }
}
