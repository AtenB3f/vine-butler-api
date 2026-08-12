package com.atenb.vinebutlerapi.domain.repository;

import com.atenb.vinebutlerapi.domain.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
}
