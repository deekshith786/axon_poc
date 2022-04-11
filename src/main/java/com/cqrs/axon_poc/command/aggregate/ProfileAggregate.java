package com.cqrs.axon_poc.command.aggregate;

import com.cqrs.axon_poc.command.commands.CreateProfileCommand;
import com.cqrs.axon_poc.command.commands.DeleteProfileCommand;
import com.cqrs.axon_poc.command.commands.UpdateProfileCommand;
import com.cqrs.axon_poc.command.events.ProfileCreatedEvent;
import com.cqrs.axon_poc.command.events.ProfileDeleteEvent;
import com.cqrs.axon_poc.command.events.ProfileUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Slf4j
@Aggregate
public class ProfileAggregate {

    @AggregateIdentifier
    private String id;
    private String description;
    private String name;
    private String phone;

    public ProfileAggregate() {
    }

    @CommandHandler
    public ProfileAggregate(CreateProfileCommand createProfileCommand) {

        // here we can perform all the validation and business logic
        // Also we need to create an event from the Aggregate

        ProfileCreatedEvent profileCreatedEvent = new ProfileCreatedEvent();

        BeanUtils.copyProperties(createProfileCommand, profileCreatedEvent);

        AggregateLifecycle.apply(profileCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProfileCreatedEvent profileCreatedEvent) {
        this.description = profileCreatedEvent.getDescription();
        this.name = profileCreatedEvent.getName();
        this.phone = profileCreatedEvent.getPhone();
        this.id = profileCreatedEvent.getId();

    }

    @CommandHandler
    public void updateProfileCommand(UpdateProfileCommand updateProfileCommand){

        log.info("ProfileUpdatedEvent created");
        log.info(updateProfileCommand.toString());
        ProfileUpdatedEvent profileUpdatedEvent = new ProfileUpdatedEvent();
        BeanUtils.copyProperties(updateProfileCommand, profileUpdatedEvent);
        AggregateLifecycle.apply(profileUpdatedEvent);
    }

    @EventSourcingHandler
    public void updateProfile(ProfileUpdatedEvent profileUpdatedEvent){
        this.description = profileUpdatedEvent.getDescription();
        this.name = profileUpdatedEvent.getName();
        this.phone = profileUpdatedEvent.getPhone();
        this.id = profileUpdatedEvent.getId();
    }

    @CommandHandler
    public void deleteProfileCommand(DeleteProfileCommand deleteProfileCommand) {
        log.info("ProfileDeleteEvent created");
        ProfileDeleteEvent profileDeleteEvent = ProfileDeleteEvent.builder().id(deleteProfileCommand.getId()).build();
        log.info("ProfileDeleteEvent = " + profileDeleteEvent);
        AggregateLifecycle.apply(profileDeleteEvent);
    }

    @EventSourcingHandler
    public void deleteProfile(ProfileDeleteEvent profileDeleteEvent){
        this.id = profileDeleteEvent.getId();
    }

}
