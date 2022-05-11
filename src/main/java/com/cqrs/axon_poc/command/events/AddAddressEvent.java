package com.cqrs.axon_poc.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressEvent {

    private String employeeCode;
    private String Employee_Number;
    private String houseOrFlatNumber;
    private String street;
    private String area;
    private String locality;
    private String city;
    private String zipcode;
    private String state;
    private String country;
    private String mobileNumber;
    private String landlineNumber;



}
