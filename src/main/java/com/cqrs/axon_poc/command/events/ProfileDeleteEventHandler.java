package com.cqrs.axon_poc.command.events;

import com.cqrs.axon_poc.command.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProfileDeleteEventHandler {

    private ProfileRepository profileRepository;

    public ProfileDeleteEventHandler(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @EventHandler
    public void deleteProfile(ProfileDeleteEvent event){

        log.info("Profile ID : " + event.getId());
        if(profileRepository.existsById(event.getId())){
            profileRepository.deleteById(event.getId());
        }
        else
            log.info("No user found");

    }
}
