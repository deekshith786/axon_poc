package com.cqrs.axon_poc.command.controller;

import com.cqrs.axon_poc.command.dto.CreateCaseRequest;
import com.cqrs.axon_poc.command.dto.UpdateCaseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class {@link CaseController} is a regular spring boot controller for rest endpoints
 * The point to make a note is this controller only handles situations when we need to write on DB
 * like only POST, PUT, UPDATE, DELETE and so on need to be used but not the GET
 */
@RestController
@RequestMapping(value = "/case")
public class CaseController {

    @PostMapping(value = "/create")
    public ResponseEntity<String> createCase(@RequestBody CreateCaseRequest request) {
        return null;
    }

    @PostMapping(value = "/fetch")
    public ResponseEntity<String> updateCase(@RequestBody UpdateCaseRequest request) {
        return null;
    }
}
