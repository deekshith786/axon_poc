package com.cqrs.axon_poc.command.repository;

import com.cqrs.axon_poc.command.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
}
