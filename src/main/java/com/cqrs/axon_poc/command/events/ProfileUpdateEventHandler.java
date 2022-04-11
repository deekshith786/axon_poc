package com.cqrs.axon_poc.command.events;

import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.command.model.ProfileRestModel;
import com.cqrs.axon_poc.command.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProfileUpdateEventHandler {

    private ProfileRepository profileRepository;

    public ProfileUpdateEventHandler(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @EventHandler
    public void updateProfile(ProfileUpdatedEvent event){
        log.info("finding the user");
        log.info("oldProfileid = " + profileRepository.findById(event.getId()).get().toString());
        if(profileRepository.existsById(event.getId())){
            log.info("user exists in the databse updating the details");
            Profile newProfile = profileRepository.findById(event.getId()).get();
            newProfile.setName(event.getName());
            newProfile.setDescription(event.getDescription());
            newProfile.setId(newProfile.getId());
            newProfile.setPhone(newProfile.getPhone());
            profileRepository.save(newProfile);
        }
        else{
            log.info("USer not found");
        }
    }
}
