package com.javanauta.bfftaskscheduler.business.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javanauta.bfftaskscheduler.infrastructure.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTORequest {

    private String taskName;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateEvent;

}
