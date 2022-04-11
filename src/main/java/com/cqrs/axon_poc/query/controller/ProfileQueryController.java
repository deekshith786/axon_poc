package com.cqrs.axon_poc.query.controller;

import com.cqrs.axon_poc.command.model.ProfileRestModel;
import com.cqrs.axon_poc.query.queries.GetProfileByIdQuery;
import com.cqrs.axon_poc.query.queries.GetProfileQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileQueryController {

    private QueryGateway queryGateway;

    public ProfileQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProfileRestModel> getAllProfiles(){

        GetProfileQuery getProfileQuery = new GetProfileQuery();
        List<ProfileRestModel> profileRestModels= queryGateway.query(getProfileQuery, ResponseTypes.multipleInstancesOf(ProfileRestModel.class)).join();
        return profileRestModels;
    }

    @GetMapping("/getById")
    public ProfileRestModel getProfile(@RequestParam String profileId){
        GetProfileByIdQuery getProfileByIdQuery  = new GetProfileByIdQuery(profileId);
        ProfileRestModel profileRestModel = queryGateway.query(getProfileByIdQuery, ResponseTypes.instanceOf(ProfileRestModel.class)).join();
        return profileRestModel;
    }
}
