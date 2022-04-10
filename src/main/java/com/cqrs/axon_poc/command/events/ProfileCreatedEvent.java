package com.cqrs.axon_poc.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCreatedEvent {

    private String id;
    private String description;
    private String name;
    private String phone;

}
