package org.acme.neptune.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.TaskType;
import org.acme.neptune.entity.Document;
import org.acme.neptune.entity.Task;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DocumentUploadTaskDTO extends TaskDTO {


    private List<DocumentDTO> documents;

    public DocumentUploadTaskDTO(Long taskId, List<DocumentDTO> documents) {
        super(taskId, TaskType.DOCUMENT_UPLOAD);
        this.documents = documents;
    }


}
