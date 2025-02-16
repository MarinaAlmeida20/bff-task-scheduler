package com.javanauta.bfftaskscheduler.infrastructure.client;

import com.javanauta.bfftaskscheduler.business.dto.AddressDTO;
import com.javanauta.bfftaskscheduler.business.dto.PhoneNumberDTO;
import com.javanauta.bfftaskscheduler.business.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", url = "${user.url}")
public interface UserClient {

    @GetMapping
    UserDTO findUserByEmail(@RequestParam("email") String email,
                            @RequestHeader("Authorization") String token);

    @PostMapping
    UserDTO saveUser(@RequestBody UserDTO userDTO);

    @PostMapping("/login")
    String login(@RequestBody UserDTO userDTO);


    @DeleteMapping("/{email}")
    void deleteUserByEmail(@PathVariable String email,
                           @RequestHeader("Authorization") String token);

    @PutMapping
    UserDTO updateUser(@RequestBody UserDTO userDTO,
                       @RequestHeader("Authorization") String token);

    @PostMapping("/phoneNumber")
    PhoneNumberDTO addToPhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO,
                                    @RequestHeader("Authorization") String token);

    @PutMapping("/phoneNumber")
    PhoneNumberDTO updatePhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO,
                                     @RequestParam("id") Long id,
                                     @RequestHeader("Authorization") String token);

    @PostMapping("/address")
    AddressDTO addToAddress(@RequestBody AddressDTO addressDTO,
                            @RequestHeader("Authorization") String token);

    @PutMapping("/address")
    AddressDTO updateAddress(@RequestBody AddressDTO addressDTO,
                             @RequestParam("id") Long id,
                             @RequestHeader("Authorization") String token);
}
