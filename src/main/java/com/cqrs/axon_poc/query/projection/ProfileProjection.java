package com.cqrs.axon_poc.query.projection;

import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.model.ProfileRestModel;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import com.cqrs.axon_poc.query.queries.GetProfileQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfileProjection {

    private ProfileRepository profileRepository;

    public ProfileProjection(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @QueryHandler
    public List<ProfileRestModel> handle(GetProfileQuery getProfileQuery){
        List<Profile> profileList = profileRepository.findAll();

        List<ProfileRestModel> profileRestModels = profileList.stream().map(profile -> ProfileRestModel
                .builder()
                .description(profile.getDescription())
                .name(profile.getName())
                .phone(profile.getPhone())
                .build())
                .collect(Collectors.toList());
        return profileRestModels;
    }
}
