package com.cqrs.axon_poc.query.projection;

import com.cqrs.axon_poc.command.entity.Address;
import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.repository.AddressRepository;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import com.cqrs.axon_poc.query.queries.GetAddressQuery;
import com.cqrs.axon_poc.query.queries.GetProfileQuery;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ProcessingGroup("profile")
public class ProfileProjection {

    private ProfileRepository profileRepository;
    private AddressRepository addressRepository;

    public ProfileProjection(ProfileRepository profileRepository, AddressRepository addressRepository) {
        this.profileRepository = profileRepository;
        this.addressRepository = addressRepository;
    }

//    @QueryHandler
//    public List<ProfileRestModel> handle(GetProfileQuery getProfileQuery){
//        List<Profile> profileList = profileRepository.findAll();
//
//        List<ProfileRestModel> profileRestModels = profileList.stream().map(profile -> ProfileRestModel
//                .builder()
//                .description(profile.getDescription())
//                .name(profile.getName())
//                .id(profile.getId())
//                .phone(profile.getPhone())
//                .build())
//                .collect(Collectors.toList());
//        return profileRestModels;
//    }

    @QueryHandler
    public List<Profile> getallProfiles(GetProfileQuery getProfileQuery) {
        return profileRepository.findAll();
    }

    @QueryHandler
    public List<Address> getallAddress(GetAddressQuery getAddressQuery) {
        return addressRepository.findAll();
    }
//
//    @QueryHandler
//    public ProfileRestModel getProfileById(GetProfileByIdQuery getProfileByIdQuery) throws Exception {
//        if(profileRepository.existsById(getProfileByIdQuery.getId())){
//            Profile profile = profileRepository.findById(getProfileByIdQuery.getId()).orElse(null);
//            ProfileRestModel profileRestModel = ProfileRestModel.builder()
//                    .id(getProfileByIdQuery.getId())
//                    .name(profile.getName())
//                    .description(profile.getDescription())
//                    .phone(profile.getPhone())
//                    .build();
//            return profileRestModel;
//        }
//        else
//        {
//            throw new Exception("No User assosiated with ProfileId"+ getProfileByIdQuery.getId());
//        }
//    }
}
