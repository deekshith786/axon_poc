package com.cqrs.axon_poc.command.events;

import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("profile")
public class ProfileEventHandler {

// ProcessingGroup is an annotation for the exception
    private ProfileRepository profileRepository;

    public ProfileEventHandler(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // name of the method can be anything
    @EventHandler
    public void on(ProfileCreatedEvent event) throws Exception{

        Profile profile = new Profile();
        BeanUtils.copyProperties(event, profile);
        profileRepository.save(profile);
        throw new Exception("Exception occurred");

    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
