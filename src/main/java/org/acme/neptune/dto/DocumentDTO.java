package org.acme.neptune.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.DocumentType;
import org.acme.neptune.entity.Task;

import java.io.File;

@RequiredArgsConstructor
@Getter
public class DocumentDTO {

    private final Long id;
    private final DocumentType type;
    private final File file;
    private final Task task;
}
