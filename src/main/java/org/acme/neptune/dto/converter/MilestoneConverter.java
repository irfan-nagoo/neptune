package org.acme.neptune.dto.converter;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.neptune.dto.MilestoneDTO;
import org.acme.neptune.entity.Milestone;

@ApplicationScoped
public class MilestoneConverter {

    public Milestone convertToMilestone(MilestoneDTO milestoneDTO) {
        return new Milestone(milestoneDTO.getId(), milestoneDTO.getType(), milestoneDTO.getAchievementDate());
    }

    public MilestoneDTO convertToMilestoneDTO(Milestone milestone) {
        return new MilestoneDTO(milestone.getId(), milestone.getType(), milestone.getAchievementDate());
    }
}
