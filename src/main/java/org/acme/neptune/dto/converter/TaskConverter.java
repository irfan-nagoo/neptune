package org.acme.neptune.dto.converter;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.acme.neptune.dto.DocumentApprovalTaskDTO;
import org.acme.neptune.dto.DocumentUploadTaskDTO;
import org.acme.neptune.dto.TaskDTO;
import org.acme.neptune.entity.DocumentApprovalTask;
import org.acme.neptune.entity.DocumentUploadTask;
import org.acme.neptune.entity.Task;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class TaskConverter {

    private final DocumentConverter documentConverter;

    public Task convertToTask(TaskDTO taskDTO) {

        return switch (taskDTO.getType()) {

            case DOCUMENT_UPLOAD -> {

                var task = new DocumentUploadTask(taskDTO.getId());
                task.setStatus(taskDTO.getStatus());
                if (((DocumentUploadTaskDTO) taskDTO).getDocuments() != null) task.setDocuments(
                        ((DocumentUploadTaskDTO) taskDTO).getDocuments().stream()
                                .map(documentConverter::convertToDocument)
                                .toList()
                );
                yield task;
            }
            case DOCUMENT_APPROVE -> {

                var task = new DocumentApprovalTask(taskDTO.getId());
                task.setIsApproved(((DocumentApprovalTaskDTO) taskDTO).getIsApproved());
                task.setStatus(taskDTO.getStatus());
                yield task;
            }
            case null, default ->
                    throw new IllegalArgumentException(String.format("Invalid Task Type %s", taskDTO.getType()));
        };
    }

    public TaskDTO convertToTaskDTO(Task task) {

        return switch (task.getType()) {

            case DOCUMENT_UPLOAD -> {

                var taskDTO = new DocumentUploadTaskDTO(task.getId(), List.of());
                taskDTO.setStatus(task.getStatus());
                if (((DocumentUploadTask) task).getDocuments() != null) taskDTO.setDocuments(
                        ((DocumentUploadTask) task).getDocuments().stream()
                                .map(documentConverter::convertToDocumentDTO)
                                .toList()
                );
                yield taskDTO;
            }
            case DOCUMENT_APPROVE -> {

                var taskDTO = new DocumentApprovalTaskDTO(task.getId(), ((DocumentApprovalTask) task).getIsApproved());
                taskDTO.setStatus(task.getStatus());
                yield taskDTO;
            }
            case null, default ->
                    throw new IllegalArgumentException(String.format("Invalid Task Type %s", task.getType()));
        };
    }
}
