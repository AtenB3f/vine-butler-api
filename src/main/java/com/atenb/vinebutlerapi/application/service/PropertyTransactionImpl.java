package com.atenb.vinebutlerapi.application.service;

import com.atenb.vinebutlerapi.domain.entity.PropertyTransaction;
import com.atenb.vinebutlerapi.domain.repository.PropertyTransactionRepository;
import com.atenb.vinebutlerapi.domain.service.PropertyTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyTransactionImpl implements PropertyTransactionService {

    private final PropertyTransactionRepository propertyTransactionRepository;

    PropertyTransactionImpl(PropertyTransactionRepository propertyTransactionRepository) {
        this.propertyTransactionRepository = propertyTransactionRepository;
    }

    @Override
    public List<PropertyTransaction> getAllPropertyTransactions() {
        return propertyTransactionRepository.findAll();
    }

    @Override
    public Optional<PropertyTransaction> getPropertyTransaction(Long id) {
        return propertyTransactionRepository.findById(id);
    }

    @Override
    public PropertyTransaction registerPropertyTransaction(PropertyTransaction propertyTransaction) {
        if (propertyTransaction.getProperty() == null ||
                propertyTransaction.getProperty().getId() == null) {
            throw new IllegalArgumentException("Property is required");
        }

        Optional<PropertyTransaction> existingTransaction =
                propertyTransactionRepository.findByPropertyId(
                        propertyTransaction.getProperty().getId()
                );

        if (existingTransaction.isPresent()) {
            throw new IllegalArgumentException("This property already has a transaction");
        }

        return propertyTransactionRepository.save(propertyTransaction);
    }

    @Override
    public PropertyTransaction updatePropertyTransaction(Long id, PropertyTransaction propertyTransaction) {
        PropertyTransaction existedTransaction = propertyTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PropertyTransaction not found"));

        if (propertyTransaction.getTransactionAmount() != null) {
            existedTransaction.setTransactionAmount(propertyTransaction.getTransactionAmount());
        }

        if (propertyTransaction.getTransactionStatus() != null) {
            existedTransaction.setTransactionStatus(propertyTransaction.getTransactionStatus());
        }

        if (propertyTransaction.getTransactionType() != null) {
            existedTransaction.setTransactionType(propertyTransaction.getTransactionType());
        }

        if (propertyTransaction.getMaintenanceCost() != null) {
            existedTransaction.setMaintenanceCost(propertyTransaction.getMaintenanceCost());
        }

        if (propertyTransaction.getMonthlyRent() != null) {
            existedTransaction.setMonthlyRent(propertyTransaction.getMonthlyRent());
        }

        if (propertyTransaction.getMoveInDate() != null) {
            existedTransaction.setMoveInDate(propertyTransaction.getMoveInDate());
        }

        return propertyTransactionRepository.save(existedTransaction);
    }

    @Override
    public void deletePropertyTransaction(Long id) {
        propertyTransactionRepository.deleteById(id);
    }
}
