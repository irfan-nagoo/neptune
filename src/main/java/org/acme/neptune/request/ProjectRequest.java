package org.acme.neptune.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.acme.neptune.dto.ProjectDTO;

@RequiredArgsConstructor
@Getter
public class ProjectRequest {

    private final ProjectDTO project;
}
