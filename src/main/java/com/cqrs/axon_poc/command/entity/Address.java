package com.cqrs.axon_poc.command.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
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
