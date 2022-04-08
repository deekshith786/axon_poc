package com.cqrs.axon_poc.command.aggregate;

import com.cqrs.axon_poc.command.command.CreateCaseCommand;
import com.cqrs.axon_poc.command.dto.CreateCaseRequest;
import com.cqrs.axon_poc.commons.events.CaseCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

/**
 * The class {@link CaseAggregate} will hold the state of the Case at certain point of time
 */
@Aggregate
@Slf4j
public class CaseAggregate {

    @AggregateIdentifier
    private String id = UUID.randomUUID().toString();
    private String description;
    private String name;
    private String phone;

    public CaseAggregate(){
    }

    @CommandHandler
    public CaseAggregate(CreateCaseCommand createCaseCommand){
        log.info("CreateCaseCommand received.");

//        when a case is created this need to create an Case created Event for that we will use the Aggregatelifecycle.apply method
//        AggregateLifecycle.apply(new CaseCreatedEvent(
//                createCaseCommand.getId(),
//                createCaseCommand.getName()
//        ));
    }
}
