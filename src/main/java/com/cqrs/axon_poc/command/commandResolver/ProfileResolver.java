package com.cqrs.axon_poc.command.commandResolver;

import com.cqrs.axon_poc.command.commands.CreateProfileCommand;
import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.inputs.ProfileInput;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
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
                .Employee_Number(UUID.randomUUID().toString()).Employee_Code(input.getEmployee_Code()).First_Name(input.getFirst_Name())
                .Middle_Name(input.getMiddle_Name()).Last_Name(input.getLast_Name()).Date_Of_Joining(new Date().toString())
                .Email(input.getEmail()).Date_Of_Birth(input.getDate_Of_Birth()).Gender(input.getGender()).Job_Role(input.getJob_Role())
                .Job_Title(input.getJob_Title()).Client_Company(input.getClient_Company()).Client_Company_Team(input.getClient_Company_Team())
                .Client_Reporting_Manager(input.getClient_Reporting_Manager()).Qualification(input.getQualification()).Skill_Matrix(input.getSkill_Matrix())
                .Status(input.getStatus()).build();
        log.info("sending graphql create command");
        commandGateway.sendAndWait(createProfileCommand);
        Profile profile = new Profile();
        BeanUtils.copyProperties(createProfileCommand, profile);
        return profile;
    }

}
