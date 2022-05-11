package com.cqrs.axon_poc.command.events.handler;

import com.cqrs.axon_poc.command.entity.Address;
import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.events.*;
import com.cqrs.axon_poc.command.repository.AddressRepository;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ProcessingGroup("profile")
public class ProfileEventHandler {

    private ProfileRepository profileRepository;
    private AddressRepository addressRepository;

    public ProfileEventHandler(ProfileRepository profileRepository, AddressRepository addressRepository) {
        this.profileRepository = profileRepository;
        this.addressRepository = addressRepository;
    }

    @EventHandler
    public void on(ProfileCreatedEvent event) throws Exception {

        Profile profile = new Profile();
        BeanUtils.copyProperties(event, profile);
        profileRepository.save(profile);
        throw new Exception("Exception occurred");
    }
    @EventHandler
    public void addAddress(AddAddressEvent event) throws Exception {

        Address address = new Address();
        BeanUtils.copyProperties(event, address);
        addressRepository.save(address);
    }

//    @EventHandler
//    public void updateProfile(ProfileUpdatedEvent event) throws Exception {
//        log.info("finding the user");
//        log.info("old_Profile_id = " + profileRepository.findById(event.getId()).get().toString());
//        if (profileRepository.existsById(event.getId())) {
//            log.info("user exists in the database updating the details");
//            Profile newProfile = profileRepository.findById(event.getId()).get();
//            newProfile.setName(event.getName());
//            newProfile.setDescription(event.getDescription());
//            newProfile.setId(newProfile.getId());
//            newProfile.setPhone(newProfile.getPhone());
//            profileRepository.save(newProfile);
//        } else {
//            log.info("USer not found");
//            throw new Exception("User not found");
//        }
//    }



//    @EventHandler
//    public void addGraphqlProfile(GraphqlProfileCreatedEvent graphqlProfileCreatedEvent){
//        log.info("graphqlProfileCreatedEvent created");
//        Profile profile = new Profile();
//        BeanUtils.copyProperties(graphqlProfileCreatedEvent, profile);
//        profileRepository.save(profile);
//    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
