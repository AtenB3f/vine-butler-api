package com.atenb.vinebutlerapi.domain.repository;

import com.atenb.vinebutlerapi.domain.entity.PropertyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyTransactionRepository extends JpaRepository<PropertyTransaction, Long> {
    Optional<PropertyTransaction> findByPropertyId(Long propertyId);
}
