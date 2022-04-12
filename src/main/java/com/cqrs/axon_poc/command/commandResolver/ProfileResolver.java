package com.cqrs.axon_poc.command.commandResolver;

import com.cqrs.axon_poc.command.commands.CreateProfileCommand;
import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.inputs.ProfileInput;
import com.cqrs.axon_poc.command.model.ProfileRestModel;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ProfileResolver implements GraphQLMutationResolver {

    private CommandGateway commandGateway;

    private ProfileRepository profileRepository;

    public ProfileResolver(CommandGateway commandGateway, ProfileRepository profileRepository) {
        this.commandGateway = commandGateway;
        this.profileRepository = profileRepository;
    }

    public Profile addProfile(ProfileInput input) {

        CreateProfileCommand createProfileCommand = CreateProfileCommand.builder()
                .id(UUID.randomUUID().toString())
                .description(input.getDescription())
                .name(input.getName())
                .phone(input.getPhone())
                .build();
        log.info("sending graphql create command");
        commandGateway.sendAndWait(createProfileCommand);
        Profile profile = new Profile();

        ProfileRestModel profileRestModel = ProfileRestModel.builder()
                .id(createProfileCommand.getId())
                .phone(createProfileCommand.getPhone())
                .description(createProfileCommand.getDescription())
                .name(createProfileCommand.getName())
                .build();
        BeanUtils.copyProperties(profileRestModel, profile);
        return profile;
    }

}
