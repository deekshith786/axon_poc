package com.cqrs.axon_poc.command.commands;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class AddAddressCommand {

    @TargetAggregateIdentifier
    private String Employee_Number;
    private String employeeCode;
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
