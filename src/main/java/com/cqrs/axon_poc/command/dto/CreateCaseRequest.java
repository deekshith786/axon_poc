package com.cqrs.axon_poc.command.dto;

import lombok.Data;

/**
 * The class {@link CreateCaseRequest} is a regular DTO class for performing the basic operations
 * This class will also act as the request body for the rest end points
 */
@Data
public class CreateCaseRequest {

    private String name;
}
