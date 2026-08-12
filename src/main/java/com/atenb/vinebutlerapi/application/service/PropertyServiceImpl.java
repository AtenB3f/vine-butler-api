package com.atenb.vinebutlerapi.application.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.atenb.vinebutlerapi.domain.entity.Property;
import com.atenb.vinebutlerapi.domain.repository.PropertyRepository;
import com.atenb.vinebutlerapi.domain.service.PropertyService;
import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    @Override
    public Property registerProperty(Property property) {
        if (property.getAddress() == null) {
            throw new IllegalArgumentException("Address is required");
        }
        if (property.getPropertyType() == null) {
            throw new IllegalArgumentException("PropertyType is required");
        }
        return propertyRepository.save(property);
    }

    @Override
    public Property updateProperty(Long id, Property property) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));


        if (property.getAddress() != null) {
            existingProperty.setAddress(property.getAddress());
        }

        if (property.getAgent() != null){
            existingProperty.setAgent(property.getAgent());
        }

        if (property.getPropertyType() != null) {
            existingProperty.setPropertyType(property.getPropertyType());
        }

        if (property.getVicinityBus() != null) {
            existingProperty.setVicinityBus(property.getVicinityBus());
        }

        if (property.getVicinitySubway() != null) {
            existingProperty.setVicinitySubway(property.getVicinitySubway());
        }

        if (property.getOwnerPhoneNumber() != null) {
            existingProperty.setOwnerPhoneNumber(property.getOwnerPhoneNumber());
        }

        if (property.getIsLoan() != null){
            existingProperty.setIsLoan(property.getIsLoan());
        }

        if (property.getIsSuretyInsured() != null){
            existingProperty.setIsSuretyInsured(property.getIsSuretyInsured());
        }

        if (property.getMoveInAvailable() != null){
            existingProperty.setMoveInAvailable(property.getMoveInAvailable());
        }

        if (property.getParkingAvailable() != null){
            existingProperty.setParkingAvailable(property.getParkingAvailable());
        }

        if (property.getSourceType() != null){
            existingProperty.setSourceType(property.getSourceType());
        }

        if (property.getSourceUrl() != null){
            existingProperty.setSourceUrl(property.getSourceUrl());
        }

        if (property.getMemo() != null){
            existingProperty.setMemo(property.getMemo());
        }

        if (property.getBlogPostUrl() != null){
            existingProperty.setBlogPostUrl(property.getBlogPostUrl());
        }

        return propertyRepository.save(existingProperty);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
