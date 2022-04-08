package com.cqrs.axon_poc.command.command;

public class CreateCaseCommand extends BaseCommand<String>{

    private final String name;

    public CreateCaseCommand(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
