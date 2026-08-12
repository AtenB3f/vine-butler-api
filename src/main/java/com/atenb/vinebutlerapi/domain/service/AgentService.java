package com.atenb.vinebutlerapi.domain.service;

import com.atenb.vinebutlerapi.domain.entity.Agent;

import java.util.List;
import java.util.Optional;

public interface AgentService {
    List<Agent> getAllAgents();
    Optional<Agent> getAgentById(Long id);
    Agent registerAgent(Agent agent);
    Agent updateAgent(Long id, Agent agent);
    void deleteAgent(Long id);
}
