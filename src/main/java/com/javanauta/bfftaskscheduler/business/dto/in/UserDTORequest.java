package com.javanauta.bfftaskscheduler.business.dto.in;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTORequest {


    private List<AddressDTORequest> addresses;
    private List<PhoneNumberDTORequest> phoneNumbers;

}
