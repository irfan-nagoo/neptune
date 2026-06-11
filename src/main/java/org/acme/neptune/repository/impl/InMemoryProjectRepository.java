package org.acme.neptune.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.neptune.entity.Project;
import org.acme.neptune.repository.ProjectRepository;

import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class InMemoryProjectRepository implements ProjectRepository {

    private static final Map<Long, Project> DATA_STORE = new HashMap<>();

    @Override
    public Project save(Project project) {
        DATA_STORE.put(project.getId(), project);
        return project;
    }

    @Override
    public Project findById(Long id) {
        return DATA_STORE.get(id);
    }
}
