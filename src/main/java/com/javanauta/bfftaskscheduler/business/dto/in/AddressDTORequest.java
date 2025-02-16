package com.javanauta.bfftaskscheduler.business.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTORequest {

    private String road;
    private String number;
    private String city;
    private String postcode;
}
