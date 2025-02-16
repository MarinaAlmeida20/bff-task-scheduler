package com.javanauta.bfftaskscheduler.controller;


import com.javanauta.bfftaskscheduler.business.TaskService;
import com.javanauta.bfftaskscheduler.business.dto.TaskDTO;
import com.javanauta.bfftaskscheduler.infrastructure.enums.NotificationStatusEnum;
import com.javanauta.bfftaskscheduler.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@Tag(name = "Tasks", description = "User task registration")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TaskController {

    private TaskService taskService;

    @PostMapping
    @Operation(summary = "Save task user", description = "Create a new task")
    @ApiResponse(responseCode = "200", description = "Task success saved")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO,
                                              @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(taskService.saveTask(token, taskDTO));
    }

    @GetMapping("/events")
    @Operation(summary = "Get tasks by period", description = "Search tasks registered by period")
    @ApiResponse(responseCode = "200", description = "Tasks Found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<List<TaskDTO>> findListTaskByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(taskService.findTaskSchedulerByPeriod(startDate, endDate, token));
    }


    @GetMapping
    @Operation(summary = "Get list tasks by user email", description = "Get tasks registered by user")
    @ApiResponse(responseCode = "200", description = "Tasks Found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<List<TaskDTO>> findListByEmail(
            @RequestHeader("Authorization") String token) {
        List<TaskDTO> tasks = taskService.findTasksByEmail(token);

        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping
    @Operation(summary = "Delete tasks by id", description = "Delete tasks registered by id")
    @ApiResponse(responseCode = "200", description = "Tasks Deleted")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<Void> deleteTask(@RequestParam("id") String id,
                                           @RequestHeader("Authorization") String token) {
        taskService.deleteTaskById(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Updated task status", description = "Updated tasks status")
    @ApiResponse(responseCode = "200", description = "Status task Updated")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<TaskDTO> updateStatusNotification(
            @RequestParam("status") NotificationStatusEnum statusEnum,
            @RequestParam("id") String id,
            @RequestHeader("Authorization") String token){

        return ResponseEntity.ok(taskService.updateStatus(statusEnum, id, token));
    }

    @PutMapping
    @Operation(summary = "Updated task data", description = "Updated tasks data registered")
    @ApiResponse(responseCode = "200", description = "Tasks Updated")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO dto,
                                              @RequestParam("id") String id,
                                              @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(taskService.updateTask(dto, id, token));
    }

}
