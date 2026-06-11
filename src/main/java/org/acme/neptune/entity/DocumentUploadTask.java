package org.acme.neptune.entity;


import lombok.Getter;
import lombok.Setter;
import org.acme.neptune.constant.TaskStatus;
import org.acme.neptune.constant.TaskType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DocumentUploadTask extends Task {


    private List<Document> documents = new ArrayList<>();

    public DocumentUploadTask(Long taskId) {
        super(taskId, TaskType.DOCUMENT_UPLOAD);
    }


    @Override
    protected void processUpdate(Task task) {
        this.documents.addAll(((DocumentUploadTask) task).getDocuments());
        this.setStatus(TaskStatus.COMPLETED);
    }
}
