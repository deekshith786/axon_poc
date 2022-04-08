package com.cqrs.axon_poc.query.query;

import com.cqrs.axon_poc.command.dto.CreateCaseRequest;
import lombok.Data;

/**
 * The class {@link FindCaseByIdQuery} is a regular DTO class for performing the fetch operations
 * This class will also act as the request body for the rest end points
 */
@Data
public class FindCaseByIdQuery {

    private String case_id;

    public FindCaseByIdQuery(String case_id) {
        this.case_id = case_id;
    }
}
