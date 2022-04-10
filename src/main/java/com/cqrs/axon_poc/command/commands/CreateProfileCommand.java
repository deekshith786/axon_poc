package com.cqrs.axon_poc.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * this class {@link CreateProfileCommand} commands and event will be having the state(payload) of what we are going to do
 */
@Data
@Builder
public class CreateProfileCommand {

    @TargetAggregateIdentifier
    private String id;
    private String description;
    private String name;
    private String phone;


}
