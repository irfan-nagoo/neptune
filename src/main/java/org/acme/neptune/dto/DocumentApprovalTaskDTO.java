package org.acme.neptune.dto;

import lombok.Getter;
import lombok.Setter;
import org.acme.neptune.constant.TaskType;
import org.acme.neptune.entity.Task;

@Getter
@Setter
public class DocumentApprovalTaskDTO extends TaskDTO {

    private final Boolean isApproved;

    public DocumentApprovalTaskDTO(Long taskId, Boolean isApproved) {
        super(taskId, TaskType.DOCUMENT_APPROVE);
        this.isApproved = isApproved;
    }
}
