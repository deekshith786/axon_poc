package com.cqrs.axon_poc.query.projection;

import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.model.ProfileRestModel;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import com.cqrs.axon_poc.query.queries.GetProfileByIdQuery;
import com.cqrs.axon_poc.query.queries.GetProfileQuery;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ProcessingGroup("profile")
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
                .id(profile.getId())
                .phone(profile.getPhone())
                .build())
                .collect(Collectors.toList());
        return profileRestModels;
    }

    @QueryHandler
    public List<Profile> getallProfiles(GetProfileQuery getProfileQuery){
        return profileRepository.findAll();
    }

    @QueryHandler
    public ProfileRestModel getProfileById(GetProfileByIdQuery getProfileByIdQuery) throws Exception {
        if(profileRepository.existsById(getProfileByIdQuery.getId())){
            Profile profile = profileRepository.findById(getProfileByIdQuery.getId()).orElse(null);
            ProfileRestModel profileRestModel = ProfileRestModel.builder()
                    .id(getProfileByIdQuery.getId())
                    .name(profile.getName())
                    .description(profile.getDescription())
                    .phone(profile.getPhone())
                    .build();
            return profileRestModel;
        }
        else
        {
            throw new Exception("No User assosiated with ProfileId"+ getProfileByIdQuery.getId());
        }
    }
}
