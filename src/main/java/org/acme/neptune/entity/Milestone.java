package org.acme.neptune.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.MilestoneType;

import java.time.LocalDate;


@Getter
@Setter
public class Milestone {

    private final Long id;
    private final MilestoneType type;
    private LocalDate achievementDate;
    private Project project;

    public Milestone(Long id, MilestoneType type, LocalDate achievementDate) {
        this.id = id;
        this.type = type;
        this.achievementDate = achievementDate;
    }
}
