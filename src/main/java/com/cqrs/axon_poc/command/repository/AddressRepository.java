package com.cqrs.axon_poc.command.repository;

import com.cqrs.axon_poc.command.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
