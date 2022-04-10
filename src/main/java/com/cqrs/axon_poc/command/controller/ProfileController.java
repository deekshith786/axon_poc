package com.cqrs.axon_poc.command.controller;

import com.cqrs.axon_poc.command.commands.CreateProfileCommand;
import com.cqrs.axon_poc.command.model.ProfileRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * The class {@link ProfileController} is a regular spring boot controller for rest endpoints
 * The point to make a note is this controller only handles situations when we need to write on DB
 * like only POST, PUT, UPDATE, DELETE and so on need to be used but not the GET
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private CommandGateway commandGateway;

    public ProfileController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addProfile(@RequestBody ProfileRestModel profileRestModel) {

//        A command should be created to store the payload of the profile model
//        Here we are creating the object of the command to create a profile
//        Similarly we will and should create respective commad for other operations like find, delete, update etc

        CreateProfileCommand createProfileCommand =
                CreateProfileCommand.builder()
                        .id(UUID.randomUUID().toString())
                        .description(profileRestModel.getDescription())
                        .name(profileRestModel.getName())
                        .phone(profileRestModel.getPhone())
                        .build();

        String result = commandGateway.sendAndWait(createProfileCommand);
        return result;
    }
}
