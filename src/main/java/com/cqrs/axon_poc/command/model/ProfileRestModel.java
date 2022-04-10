package com.cqrs.axon_poc.command.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileRestModel {

    private String description;
    private String name;
    private String phone;

}
