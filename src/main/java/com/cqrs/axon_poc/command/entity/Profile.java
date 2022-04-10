package com.cqrs.axon_poc.command.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The class {@link Profile} servers as a JPA entity to refer to the latest state of an arregate
 * and will be stored in the queue store
 */
@Entity
@Data
public class Profile {

    @Id
    private String id;
    private String description;
    private String name;
    private String phone;
}
