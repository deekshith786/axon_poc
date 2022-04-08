package com.cqrs.axon_poc.command.command;

/**
 * The class {@link BaseCommand} which will extend our command classes
 * @param <T> can be
 */
public class BaseCommand<T> {

    // The id is for Axon to identify which instance of aggregate that is applied on
    private final T id;

    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
