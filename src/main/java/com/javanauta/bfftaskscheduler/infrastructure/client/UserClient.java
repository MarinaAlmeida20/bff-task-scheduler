package com.javanauta.bfftaskscheduler.infrastructure.client;

import com.javanauta.bfftaskscheduler.business.dto.in.AddressDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.in.LoginRequestDTO;
import com.javanauta.bfftaskscheduler.business.dto.in.PhoneNumberDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.in.UserDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.out.AddressDTOResponse;
import com.javanauta.bfftaskscheduler.business.dto.out.PhoneNumberDTOResponse;
import com.javanauta.bfftaskscheduler.business.dto.out.UserDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", url = "${user.url}")
public interface UserClient {

    @GetMapping
    UserDTOResponse findUserByEmail(@RequestParam("email") String email,
                                   @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping
    UserDTOResponse saveUser(@RequestBody UserDTORequest userDTORequest);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO loginRequestDTO);


    @DeleteMapping("/{email}")
    void deleteUserByEmail(@PathVariable String email,
                           @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping
    UserDTOResponse updateUser(@RequestBody UserDTORequest userDTORequest,
                              @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping("/phoneNumber")
    PhoneNumberDTOResponse addToPhoneNumber(@RequestBody PhoneNumberDTORequest phoneNumberDTORequest,
                                            @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping("/phoneNumber")
    PhoneNumberDTOResponse updatePhoneNumber(@RequestBody PhoneNumberDTORequest phoneNumberDTORequest,
                                            @RequestParam("id") Long id,
                                            @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping("/address")
    AddressDTOResponse addToAddress(@RequestBody AddressDTORequest addressDTORequest,
                                    @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping("/address")
    AddressDTOResponse updateAddress(@RequestBody AddressDTORequest addressDTORequest,
                                    @RequestParam("id") Long id,
                                    @RequestHeader(value = "Authorization", required = false) String token);
}
