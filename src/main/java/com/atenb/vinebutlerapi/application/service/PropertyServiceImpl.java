package com.atenb.vinebutlerapi.application.service;

import org.springframework.stereotype.Service;
import com.atenb.vinebutlerapi.domain.entity.Property;
import com.atenb.vinebutlerapi.domain.repository.PropertyRepository;
import com.atenb.vinebutlerapi.domain.service.PropertyService;
import java.util.Optional;
import java.util.List;

@Service
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
        return propertyRepository.save(property);
    }

    @Override
    public Property updateProperty(Long id, Property property) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        // 필드 업데이트 (나중에 더 추가 가능)
        existingProperty.setAddress(property.getAddress());

        return propertyRepository.save(existingProperty);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
