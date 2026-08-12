package com.atenb.vinebutlerapi.domain.repository;

import com.atenb.vinebutlerapi.domain.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
