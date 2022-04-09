package com.cqrs.axon_poc.commons.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class BaseEvent<T> {

    //    id is the case id
    @TargetAggregateIdentifier
    private final T id;
    private String description;
    private String name;
    private String phone;

}
