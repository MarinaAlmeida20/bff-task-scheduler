package com.javanauta.bfftaskscheduler.business.dto.out;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOResponse {

    private String email;
    private String password;
    private List<AddressDTOResponse> addresses;
    private List<PhoneNumberDTOResponse> phoneNumbers;

}
