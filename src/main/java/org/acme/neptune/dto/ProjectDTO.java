package org.acme.neptune.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.ProjectStatus;
import org.acme.neptune.constant.ProjectType;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ProjectDTO {

    private final Long id;
    private final String title;
    private final LocalDateTime startDate;
    private final ProjectType type;
    private ProjectStatus status;
    private List<TaskDTO> tasks;
    private List<MilestoneDTO> milestones;
}
