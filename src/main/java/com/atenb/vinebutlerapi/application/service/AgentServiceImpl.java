package com.atenb.vinebutlerapi.application.service;

import com.atenb.vinebutlerapi.domain.entity.Agent;
import com.atenb.vinebutlerapi.domain.repository.AgentRepository;
import com.atenb.vinebutlerapi.domain.service.AgentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        return agentRepository.save(agent);
    }

    @Override
    public Agent updateAgent(Long id, Agent agent) {
        Agent exitedAgent = agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        if (agent.getName() != null) {
            exitedAgent.setName(agent.getName());
        }

        if (agent.getPhone() != null) {
            exitedAgent.setPhone(agent.getPhone());
        }

        return agentRepository.save(exitedAgent);
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}