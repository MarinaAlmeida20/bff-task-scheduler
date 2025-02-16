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
                            @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping
    UserDTO saveUser(@RequestBody UserDTO userDTO);

    @PostMapping("/login")
    String login(@RequestBody UserDTO userDTO);


    @DeleteMapping("/{email}")
    void deleteUserByEmail(@PathVariable String email,
                           @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping
    UserDTO updateUser(@RequestBody UserDTO userDTO,
                       @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping("/phoneNumber")
    PhoneNumberDTO addToPhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO,
                                    @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping("/phoneNumber")
    PhoneNumberDTO updatePhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO,
                                     @RequestParam("id") Long id,
                                     @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping("/address")
    AddressDTO addToAddress(@RequestBody AddressDTO addressDTO,
                            @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping("/address")
    AddressDTO updateAddress(@RequestBody AddressDTO addressDTO,
                             @RequestParam("id") Long id,
                             @RequestHeader(value = "Authorization", required = false) String token);
}
