package org.acme.neptune.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.TaskStatus;
import org.acme.neptune.constant.TaskType;

@RequiredArgsConstructor
@Getter
@Setter

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DocumentUploadTaskDTO.class, name = "DOCUMENT_UPLOAD"),
        @JsonSubTypes.Type(value = DocumentApprovalTaskDTO.class, name = "DOCUMENT_APPROVE")
})
public abstract class TaskDTO {

    private final Long id;
    private final TaskType type;
    private TaskStatus status;
}
