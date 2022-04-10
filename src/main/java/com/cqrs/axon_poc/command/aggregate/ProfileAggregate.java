package com.cqrs.axon_poc.command.aggregate;

import com.cqrs.axon_poc.command.commands.CreateProfileCommand;
import com.cqrs.axon_poc.command.events.ProfileCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

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
}
