package com.javanauta.bfftaskscheduler.infrastructure.client;

import com.javanauta.bfftaskscheduler.business.dto.TaskDTO;
import com.javanauta.bfftaskscheduler.infrastructure.enums.NotificationStatusEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "task-scheduler", url = "${task-scheduler.url}")
public interface TaskClient {

    @PostMapping
    TaskDTO createTask(@RequestBody TaskDTO taskDTO,
                       @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping("/events")
    List<TaskDTO> findListTaskByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateCreated,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateUpdated,
//            @RequestParam NotificationStatusEnum statusEnum,
            @RequestHeader(value = "Authorization", required = false) String token
    );

    @GetMapping
    List<TaskDTO> findListByEmail(
            @RequestHeader(value = "Authorization", required = false) String token);

    @DeleteMapping
    void deleteTask(@RequestParam("id") String id,
                    @RequestHeader(value = "Authorization", required = false) String token);

    @PatchMapping
    TaskDTO updateStatusNotification(
            @RequestParam("status") NotificationStatusEnum statusEnum,
            @RequestParam("id") String id,
            @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping
    TaskDTO updateTask(@RequestBody TaskDTO dto,
                       @RequestParam("id") String id,
                       @RequestHeader(value = "Authorization", required = false) String token);
}
