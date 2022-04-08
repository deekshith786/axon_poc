package com.cqrs.axon_poc.commons.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseEvent<T> {

//    id is the case id
    @TargetAggregateIdentifier
    private final T id;

    public BaseEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
