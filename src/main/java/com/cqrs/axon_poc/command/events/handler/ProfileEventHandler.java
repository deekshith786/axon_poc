package com.cqrs.axon_poc.command.events.handler;

import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.events.GraphqlProfileCreatedEvent;
import com.cqrs.axon_poc.command.events.ProfileCreatedEvent;
import com.cqrs.axon_poc.command.events.ProfileDeleteEvent;
import com.cqrs.axon_poc.command.events.ProfileUpdatedEvent;
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

    public ProfileEventHandler(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @EventHandler
    public void on(ProfileCreatedEvent event) throws Exception {

        Profile profile = new Profile();
        BeanUtils.copyProperties(event, profile);
        profileRepository.save(profile);
        throw new Exception("Exception occurred");
    }

    @EventHandler
    public void updateProfile(ProfileUpdatedEvent event) throws Exception {
        log.info("finding the user");
        log.info("old_Profile_id = " + profileRepository.findById(event.getId()).get().toString());
        if (profileRepository.existsById(event.getId())) {
            log.info("user exists in the database updating the details");
            Profile newProfile = profileRepository.findById(event.getId()).get();
            newProfile.setName(event.getName());
            newProfile.setDescription(event.getDescription());
            newProfile.setId(newProfile.getId());
            newProfile.setPhone(newProfile.getPhone());
            profileRepository.save(newProfile);
        } else {
            log.info("USer not found");
            throw new Exception("User not found");
        }
    }

    @EventHandler
    public void deleteProfile(ProfileDeleteEvent event) throws Exception {

        log.info("Profile ID : " + event.getId());
        if (profileRepository.existsById(event.getId())) {
            profileRepository.deleteById(event.getId());
        } else
            throw new Exception("User not found");
    }

    @EventHandler
    public void addGraphqlProfile(GraphqlProfileCreatedEvent graphqlProfileCreatedEvent){
        log.info("graphqlProfileCreatedEvent created");
        Profile profile = new Profile();
        BeanUtils.copyProperties(graphqlProfileCreatedEvent, profile);
        profileRepository.save(profile);
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
