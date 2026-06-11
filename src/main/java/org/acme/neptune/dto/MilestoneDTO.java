package org.acme.neptune.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.acme.neptune.constant.MilestoneType;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class MilestoneDTO {

    private final Long id;
    private final MilestoneType type;
    private final LocalDate achievementDate;
}
