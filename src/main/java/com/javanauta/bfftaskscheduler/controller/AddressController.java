package com.javanauta.bfftaskscheduler.controller;


import com.javanauta.bfftaskscheduler.business.UserService;
import com.javanauta.bfftaskscheduler.business.dto.AddressDTO;
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
public class AddressController {

    private final UserService userService;

    @PostMapping("/address")
    @Operation(summary = "Save user address", description = "Save user address")
    @ApiResponse(responseCode = "200", description = "Address success saved")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<AddressDTO> addToAddress(@RequestBody AddressDTO addressDTO,
                                                   @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(userService.addToAddress(token, addressDTO));
    }

    @PutMapping("/address")
    @Operation(summary = "User address updated", description = "User address updated")
    @ApiResponse(responseCode = "200", description = "Address success updated")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO addressDTO,
                                                    @RequestParam("id") Long id,
                                                    @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(userService.updateAddress(id, addressDTO, token));
    }
}
