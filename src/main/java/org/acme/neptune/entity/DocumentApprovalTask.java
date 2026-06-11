package org.acme.neptune.entity;

import lombok.Getter;
import lombok.Setter;
import org.acme.neptune.constant.TaskStatus;
import org.acme.neptune.constant.TaskType;

@Getter
@Setter
public class DocumentApprovalTask extends Task {

    private Boolean isApproved;

    public DocumentApprovalTask(Long taskId) {
        super(taskId, TaskType.DOCUMENT_APPROVE);
    }


    @Override
    protected void processUpdate(Task task) {
        this.isApproved = ((DocumentApprovalTask) task).getIsApproved();
        this.setStatus(TaskStatus.COMPLETED);
    }
}
