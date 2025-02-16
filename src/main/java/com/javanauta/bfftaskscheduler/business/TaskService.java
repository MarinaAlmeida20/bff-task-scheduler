package com.javanauta.bfftaskscheduler.business;


import com.javanauta.bfftaskscheduler.business.dto.in.TaskDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.out.TaskDTOResponse;
import com.javanauta.bfftaskscheduler.infrastructure.client.TaskClient;
import com.javanauta.bfftaskscheduler.infrastructure.enums.NotificationStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskClient taskClient;

    public TaskDTOResponse saveTask(String token, TaskDTORequest taskDTO) {
        return taskClient.createTask(taskDTO, token);
    }

    public List<TaskDTOResponse> findTaskSchedulerByPeriod(LocalDateTime startDate,
                                                           LocalDateTime endDate,
                                                           String token) {
        return taskClient.findListTaskByPeriod(startDate, endDate, token);
    }

    public List<TaskDTOResponse> findTasksByEmail(String token) {
        return taskClient.findListByEmail(token);
    }

    public void deleteTaskById(String id, String token) {
        taskClient.deleteTask(id, token);
    }

    public TaskDTOResponse updateStatus(NotificationStatusEnum statusEnum,
                                        String id,
                                        String token) {
        return taskClient.updateStatusNotification(statusEnum, id, token);
    }

    public TaskDTOResponse updateTask(TaskDTORequest dto, String id, String token) {
        return taskClient.updateTask(dto, id, token);
    }
}
