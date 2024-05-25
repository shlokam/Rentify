package com.example.rentify.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentify.Entity.Property;
import com.example.rentify.Repository.PropertyRepository;

@Service
public class PropertyService {

	@Autowired
    private PropertyRepository propertyRepository;

    public Property saveProperty(Property property) {
    	property.setId(System.currentTimeMillis());
        return propertyRepository.save(property);
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

	public String updateProperty(Property property) {
		return propertyRepository.update(property);
		
	}

	public List<Property> getPropertyById(String emailId) {
		return propertyRepository.findById(emailId);
	}
	
}
