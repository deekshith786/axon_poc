package com.cqrs.axon_poc.query.repository;

import com.cqrs.axon_poc.query.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case, String> {
}
