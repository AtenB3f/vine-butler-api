package com.atenb.vinebutlerapi.application.service;

import com.atenb.vinebutlerapi.domain.entity.Agent;
import com.atenb.vinebutlerapi.domain.repository.AgentRepository;
import com.atenb.vinebutlerapi.domain.service.AgentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Optional<Agent> getAgentById(Long id) {
        return agentRepository.findById(id);
    }

    @Override
    public Agent registerAgent(Agent agent) {
        if (agent.getName() == null || agent.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        return agentRepository.save(agent);
    }

    @Override
    public Agent updateAgent(Long id, Agent agent) {
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        if (agent.getName() != null) {
            existingAgent.setName(agent.getName());
        }

        if (agent.getPhone() != null) {
            existingAgent.setPhone(agent.getPhone());
        }

        return agentRepository.save(existingAgent);
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}