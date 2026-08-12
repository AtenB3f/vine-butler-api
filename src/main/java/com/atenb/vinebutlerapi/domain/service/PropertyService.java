package com.atenb.vinebutlerapi.domain.service;

import com.atenb.vinebutlerapi.domain.entity.Property;
import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<Property> getAllProperties();
    Optional<Property> getPropertyById(Long id);
    Property registerProperty(Property property);
    Property updateProperty(Long id, Property property);
    void deleteProperty(Long id);
}
