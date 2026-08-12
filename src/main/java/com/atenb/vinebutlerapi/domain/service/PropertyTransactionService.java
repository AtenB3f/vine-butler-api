package com.atenb.vinebutlerapi.domain.service;

import com.atenb.vinebutlerapi.domain.entity.PropertyTransaction;

import java.util.List;
import java.util.Optional;

public interface PropertyTransactionService {
    List<PropertyTransaction> getAllPropertyTransactions();
    Optional<PropertyTransaction> getPropertyTransaction(Long id);
    PropertyTransaction registerPropertyTransaction(PropertyTransaction propertyTransaction);
    PropertyTransaction updatePropertyTransaction(Long id, PropertyTransaction propertyTransaction);
    void deletePropertyTransaction(Long id);
}
