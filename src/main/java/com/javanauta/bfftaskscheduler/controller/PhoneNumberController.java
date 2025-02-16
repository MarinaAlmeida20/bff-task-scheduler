package com.javanauta.bfftaskscheduler.controller;

import com.javanauta.bfftaskscheduler.business.UserService;
import com.javanauta.bfftaskscheduler.business.dto.PhoneNumberDTO;
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
public class PhoneNumberController {

    private final UserService userService;

    @PostMapping("/phoneNumber")
    @Operation(summary = "Save user phone number", description = "Save user phone number")
    @ApiResponse(responseCode = "200", description = "Phone number success saved")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<PhoneNumberDTO> addToPhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO,
                                                           @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(userService.addToPhoneNumber(token, phoneNumberDTO));
    }

    @PutMapping("/phoneNumber")
    @Operation(summary = "User phone number updated", description = "User phone number updated")
    @ApiResponse(responseCode = "200", description = "Phone number success updated")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<PhoneNumberDTO> updatePhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO,
                                                            @RequestParam("id") Long id,
                                                            @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(userService.updatePhoneNumber(id, phoneNumberDTO, token));
    }
}
