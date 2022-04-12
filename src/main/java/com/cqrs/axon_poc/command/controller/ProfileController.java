package com.cqrs.axon_poc.command.controller;

import com.cqrs.axon_poc.command.commands.CreateProfileCommand;
import com.cqrs.axon_poc.command.commands.DeleteProfileCommand;
import com.cqrs.axon_poc.command.commands.UpdateProfileCommand;
import com.cqrs.axon_poc.command.model.ProfileRestModel;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * The class {@link ProfileController} is a regular spring boot controller for rest endpoints
 * The point to make a note is this controller only handles situations when we need to write on DB
 * like only POST, PUT, UPDATE, DELETE and so on need to be used but not the GET
 */
@Slf4j
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private CommandGateway commandGateway;

    public ProfileController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addProfile(@RequestBody ProfileRestModel profileRestModel) {

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

    @PutMapping("/update")
    public String updateProfile(@RequestBody ProfileRestModel profileRestModel) {

        UpdateProfileCommand updateProfileCommand = UpdateProfileCommand.builder()
                .id(profileRestModel.getId())
                .description(profileRestModel.getDescription())
                .name(profileRestModel.getName())
                .phone(profileRestModel.getPhone())
                .build();
        log.info("UpdateProfileCommand command created");
        String result = commandGateway.sendAndWait(updateProfileCommand);
        return result;
    }

    @DeleteMapping("/delete")
    public String deleteProfile(@RequestParam String profileId){

        DeleteProfileCommand deleteProfileCommand = DeleteProfileCommand.builder().id(profileId).build();
        log.info("DeleteProfileCommand created");
        String result = commandGateway.sendAndWait(deleteProfileCommand);
        return result;
    }
}
