package com.javanauta.bfftaskscheduler.business.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTOResponse {

    private String road;
    private String number;
    private String city;
    private String postcode;
}
