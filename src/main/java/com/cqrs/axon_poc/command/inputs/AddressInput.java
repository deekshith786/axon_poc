package com.cqrs.axon_poc.command.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInput {

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
