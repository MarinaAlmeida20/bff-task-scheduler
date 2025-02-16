package com.javanauta.bfftaskscheduler.business;

import com.javanauta.bfftaskscheduler.business.dto.AddressDTO;
import com.javanauta.bfftaskscheduler.business.dto.PhoneNumberDTO;
import com.javanauta.bfftaskscheduler.business.dto.UserDTO;
import com.javanauta.bfftaskscheduler.infrastructure.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;

    public UserDTO saveUser(UserDTO userDTO){
        return userClient.saveUser(userDTO);
    }

    public String loginUser(UserDTO userDTO){
        return userClient.login(userDTO);
    }

    public UserDTO findUserByEmail(String email, String token){
        return userClient.findUserByEmail(email, token);
    }

    public void deleteUserByEmail(String email, String token){
        userClient.deleteUserByEmail(email, token);
    }

    public UserDTO updateUserData(String token, UserDTO userDTO){
        return userClient.updateUser(userDTO, token);
    }

    public AddressDTO updateAddress (Long idAddress, AddressDTO addressDTO, String token){
        return userClient.updateAddress(addressDTO, idAddress, token);
    }

    public PhoneNumberDTO updatePhoneNumber (Long idPhone, PhoneNumberDTO phoneDTO, String token){
        return userClient.updatePhoneNumber(phoneDTO, idPhone, token);
    }

    public AddressDTO addToAddress(String token, AddressDTO addressDTO){
        return userClient.addToAddress(addressDTO, token);

    }

    public PhoneNumberDTO addToPhoneNumber(String token,PhoneNumberDTO phoneNumberDTO){
       return userClient.addToPhoneNumber(phoneNumberDTO, token);
    }
}
