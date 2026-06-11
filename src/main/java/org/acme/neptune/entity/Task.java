package org.acme.neptune.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.TaskStatus;
import org.acme.neptune.constant.TaskType;

@RequiredArgsConstructor
@Getter
@Setter
public abstract class Task {

    private final Long id;
    private final TaskType type;
    private TaskStatus status = TaskStatus.NOT_STARTED;
    private Project project;

    protected abstract void processUpdate(Task task);
}
