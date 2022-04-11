package com.cqrs.axon_poc.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateGraphqlProfileCommand {

    @TargetAggregateIdentifier
    private String id;
    private String description;
    private String name;
    private String phone;
}
