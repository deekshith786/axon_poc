package com.cqrs.axon_poc.query.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.UUID;

/**
 * The class {@link Case} servers as a JPA entity to refer to the latest state of an arregate
 * and will be stored in the queue store
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Case {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String description;
    private String name;
    private String phone;
}
