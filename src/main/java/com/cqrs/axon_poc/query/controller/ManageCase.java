package com.cqrs.axon_poc.query.controller;

import com.cqrs.axon_poc.command.controller.CaseController;
import com.cqrs.axon_poc.query.entity.Case;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class {@link ManageCase} is a regular spring boot controller for rest endpoints
 * This class only handles the situation to read from the DataBase
 * like only GET should be used
 */
@RestController
@RequestMapping(value = "/manage-case")
public class ManageCase {

    public ResponseEntity<Case> getCase(@RequestParam String id) {
        return null;
    }
}
