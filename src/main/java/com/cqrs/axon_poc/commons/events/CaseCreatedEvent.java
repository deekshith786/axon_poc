package com.cqrs.axon_poc.commons.events;

import com.cqrs.axon_poc.command.command.BaseCommand;

public class CaseCreatedEvent extends BaseCommand<String> {

    private String id;
    private String description;
    private String name;
    private String phone;

    public CaseCreatedEvent(String id, String description, String name, String phone) {
        super(id, description, name, phone);
    }
}
