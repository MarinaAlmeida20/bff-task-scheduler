package com.javanauta.bfftaskscheduler.controller;

import com.javanauta.bfftaskscheduler.business.UserService;
import com.javanauta.bfftaskscheduler.business.dto.in.LoginRequestDTO;
import com.javanauta.bfftaskscheduler.business.dto.in.UserDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.out.UserDTOResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "User registration and login")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Save user", description = "Create a new user")
    @ApiResponse(responseCode = "200", description = "User success saved")
    @ApiResponse(responseCode = "400", description = "User already registered")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<UserDTOResponse> saveUser(@RequestBody UserDTORequest userDTORequest){
        return ResponseEntity.ok(userService.saveUser(userDTORequest));
    }

    @PostMapping("/login")
    @Operation(summary = "User login", description = "User login")
    @ApiResponse(responseCode = "200", description = "User success logged in")
    @ApiResponse(responseCode = "401", description = "Invalid details")
    @ApiResponse(responseCode = "500", description = "Server error")
    public String login(@RequestBody LoginRequestDTO loginRequestDTO){
        return userService.loginUser(loginRequestDTO);
    }

    @GetMapping
    @Operation(summary = "Find user data by email", description = "Find user data")
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "404", description = "User not registered")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<UserDTOResponse> finUserByEmail(@RequestParam("email") String email,
                                                         @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(userService.findUserByEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Delete user by id", description = "Delete user")
    @ApiResponse(responseCode = "200", description = "User success deleted")
    @ApiResponse(responseCode = "404", description = "User already registered")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email,
                                                  @RequestHeader(value = "Authorization", required = false) String token){
        userService.deleteUserByEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @GetMapping
    @Operation(summary = "Update user data", description = "Update user data")
    @ApiResponse(responseCode = "200", description = "User success updated")
    @ApiResponse(responseCode = "404", description = "User not registered")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<UserDTOResponse> updateUser(@RequestBody UserDTORequest userDTORequest,
                                                      @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(userService.updateUserData(token, userDTORequest));
    }


}
