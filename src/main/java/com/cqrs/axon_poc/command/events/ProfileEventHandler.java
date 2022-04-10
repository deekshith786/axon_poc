package com.cqrs.axon_poc.command.events;

import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProfileEventHandler {


    private ProfileRepository profileRepository;

    public ProfileEventHandler(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // name of the method can be anything
    @EventHandler
    public void on(ProfileCreatedEvent event){

        Profile profile = new Profile();
        BeanUtils.copyProperties(event, profile);
        profileRepository.save(profile);

    }
}
