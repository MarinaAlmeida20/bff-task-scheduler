package com.javanauta.bfftaskscheduler.business;

import com.javanauta.bfftaskscheduler.business.dto.in.AddressDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.in.LoginRequestDTO;
import com.javanauta.bfftaskscheduler.business.dto.in.PhoneNumberDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.in.UserDTORequest;
import com.javanauta.bfftaskscheduler.business.dto.out.AddressDTOResponse;
import com.javanauta.bfftaskscheduler.business.dto.out.PhoneNumberDTOResponse;
import com.javanauta.bfftaskscheduler.business.dto.out.UserDTOResponse;
import com.javanauta.bfftaskscheduler.infrastructure.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;

    public UserDTOResponse saveUser(UserDTORequest userDTORequest) {
        return userClient.saveUser(userDTORequest);
    }

    public String loginUser(LoginRequestDTO loginRequestDTO) {
        return userClient.login(loginRequestDTO);
    }

    public UserDTOResponse findUserByEmail(String email, String token) {
        return userClient.findUserByEmail(email, token);
    }

    public void deleteUserByEmail(String email, String token) {
        userClient.deleteUserByEmail(email, token);
    }

    public UserDTOResponse updateUserData(String token, UserDTORequest userDTORequest) {
        return userClient.updateUser(userDTORequest, token);
    }

    public AddressDTOResponse updateAddress(Long idAddress, AddressDTORequest addressDTORequest, String token) {
        return userClient.updateAddress(addressDTORequest, idAddress, token);
    }

    public PhoneNumberDTOResponse updatePhoneNumber(Long idPhone, PhoneNumberDTORequest phoneDTO, String token) {
        return userClient.updatePhoneNumber(phoneDTO, idPhone, token);
    }

    public AddressDTOResponse addToAddress(String token, AddressDTORequest addressDTORequest) {
        return userClient.addToAddress(addressDTORequest, token);

    }

    public PhoneNumberDTOResponse addToPhoneNumber(String token, PhoneNumberDTORequest phoneNumberDTORequest) {
        return userClient.addToPhoneNumber(phoneNumberDTORequest, token);
    }
}
