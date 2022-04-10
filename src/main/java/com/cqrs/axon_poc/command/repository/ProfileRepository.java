package com.cqrs.axon_poc.command.repository;

import com.cqrs.axon_poc.command.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
