package com.cqrs.axon_poc.command.graphql.resolver;

import com.cqrs.axon_poc.command.commands.CreateGraphqlProfileCommand;
import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.graphql.inputs.ProfileInput;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProfileResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private CommandGateway commandGateway;

    public ProfileResolver(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Autowired
    private ProfileRepository profileRepository;

    public Profile addProfile(ProfileInput profileInput){

        CreateGraphqlProfileCommand createGraphqlProfileCommand = CreateGraphqlProfileCommand.builder()
                .id(profileInput.getId())
                .description(profileInput.getDescription())
                .name(profileInput.getName())
                .phone(profileInput.getPhone())
                .build();
        commandGateway.sendAndWait(createGraphqlProfileCommand);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> mp = objectMapper.convertValue(profileInput, Map.class);
//        Profile profile = objectMapper.convertValue(mp, Profile.class);
//        return profileRepository.save(profile);
        return null;
    }

    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }


}
