package com.javanauta.bfftaskscheduler.infrastructure.client;

import com.javanauta.bfftaskscheduler.business.dto.in.TaskDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.out.TaskDTOResponse;
import com.javanauta.bfftaskscheduler.infrastructure.enums.NotificationStatusEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "task-scheduler", url = "${task-scheduler.url}")
public interface TaskClient {

    @PostMapping
    TaskDTOResponse createTask(@RequestBody TaskDTORequest taskDTO,
                               @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping("/events")
    List<TaskDTOResponse> findListTaskByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateCreated,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateUpdated,
//            @RequestParam NotificationStatusEnum statusEnum,
            @RequestHeader(value = "Authorization", required = false) String token
    );

    @GetMapping
    List<TaskDTOResponse> findListByEmail(
            @RequestHeader(value = "Authorization", required = false) String token);

    @DeleteMapping
    void deleteTask(@RequestParam("id") String id,
                    @RequestHeader(value = "Authorization", required = false) String token);

    @PatchMapping
    TaskDTOResponse updateStatusNotification(
            @RequestParam("status") NotificationStatusEnum statusEnum,
            @RequestParam("id") String id,
            @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping
    TaskDTOResponse updateTask(@RequestBody TaskDTORequest dto,
                               @RequestParam("id") String id,
                               @RequestHeader(value = "Authorization", required = false) String token);
}
