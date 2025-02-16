package com.javanauta.bfftaskscheduler.business;


import com.javanauta.bfftaskscheduler.business.dto.TaskDTO;
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

    public TaskDTO saveTask(String token, TaskDTO taskDTO) {
        return taskClient.createTask(taskDTO, token);
    }

    public List<TaskDTO> findTaskSchedulerByPeriod(LocalDateTime startDate,
                                                   LocalDateTime endDate,
                                                   String token) {
        return taskClient.findListTaskByPeriod(startDate, endDate, token);
    }

    public List<TaskDTO> findTasksByEmail(String token) {
        return taskClient.findListByEmail(token);
    }

    public void deleteTaskById(String id, String token) {
        taskClient.deleteTask(id, token);
    }

    public TaskDTO updateStatus(NotificationStatusEnum statusEnum,
                                String id,
                                String token) {
        return taskClient.updateStatusNotification(statusEnum, id, token);
    }

    public TaskDTO updateTask(TaskDTO dto, String id, String token) {
        return taskClient.updateTask(dto, id, token);
    }
}
