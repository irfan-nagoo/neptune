package org.acme.neptune.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.DocumentType;

import java.io.File;

@RequiredArgsConstructor
@Getter
public class Document {

    private final Long id;
    private final DocumentType type;
    private final File file;
    private final Task task;
}
