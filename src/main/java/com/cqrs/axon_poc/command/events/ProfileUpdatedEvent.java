package com.cqrs.axon_poc.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdatedEvent {

    private String id;
    private String description;
    private String name;
    private String phone;

}