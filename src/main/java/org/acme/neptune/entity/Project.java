package org.acme.neptune.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.MilestoneType;
import org.acme.neptune.constant.ProjectStatus;
import org.acme.neptune.constant.ProjectType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Project {

    private final Long id;
    private final String title;
    private final LocalDateTime startDate;
    private final ProjectType type;
    private ProjectStatus status;
    private List<Task> tasks = new ArrayList<>();
    private List<Milestone> milestones = new ArrayList<>();


    public void createRegularProject() {

        // adding tasks for regular project
        this.tasks.add(new DocumentUploadTask(0L));
        this.tasks.add(new DocumentApprovalTask(0L));
        this.tasks.forEach(t -> t.setProject(this));

        // adding milestones for regular project
        this.milestones.add(new Milestone(0L, MilestoneType.STARTED, LocalDate.now()));
        this.milestones.add(new Milestone(0L, MilestoneType.DOCUMENT_UPLOAD, null));
        this.milestones.add(new Milestone(0L, MilestoneType.DOCUMENT_APPROVAL, null));
        this.milestones.add(new Milestone(0L, MilestoneType.COMPLETED, null));
        this.milestones.forEach(m -> m.setProject(this));

        this.status = ProjectStatus.IN_PROGRESS;
    }

    public void updateTask(Task task) {

        this.tasks.stream()
                .filter(t -> t.getType() == task.getType())
                .forEach(t -> t.processUpdate(task));

        updateMilestone(task);
    }

    private void updateMilestone(Task task) {

        var milestoneType = switch (task.getType()) {

            case DOCUMENT_UPLOAD -> MilestoneType.DOCUMENT_UPLOAD;
            case DOCUMENT_APPROVE -> MilestoneType.DOCUMENT_APPROVAL;
            case DUE_DATE_APPROVAL -> null;
        };

        this.milestones.stream()
                .filter(m -> m.getType() == milestoneType)
                .forEach(m -> m.setAchievementDate(LocalDate.now()));
    }

}
