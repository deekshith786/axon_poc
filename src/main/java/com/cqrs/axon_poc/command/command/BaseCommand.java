package com.cqrs.axon_poc.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The class {@link BaseCommand} which will extend our command classes
 * @param <T> can be
 */
@Data
@AllArgsConstructor
public class BaseCommand<T> {

    // The id is for Axon to identify which instance of aggregate that is applied on
    private final T id;
    private String description;
    private String name;
    private String phone;
}
