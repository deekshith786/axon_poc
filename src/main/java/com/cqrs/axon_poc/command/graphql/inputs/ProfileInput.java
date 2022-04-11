package com.cqrs.axon_poc.command.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileInput {

    @Id
    private String id;
    private String description;
    private String name;
    private String phone;
}
