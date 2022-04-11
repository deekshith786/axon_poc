package com.cqrs.axon_poc.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteProfileCommand {

    @TargetAggregateIdentifier
    private String id;
}
