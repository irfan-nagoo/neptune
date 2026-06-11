package org.acme.neptune.repository;

import org.acme.neptune.entity.Project;

public interface ProjectRepository {

    Project save(Project project);

    Project findById(Long id);
}
