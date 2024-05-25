package com.example.rentify.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rentify.Entity.Property;

@Repository

public class PropertyRepository {
	List<Property> propertyDatabase = new ArrayList<Property>();

	public Property save(Property property) {
		propertyDatabase.add(property);
		return property;
	}

	public List<Property> findAll() {
		return propertyDatabase;
	}

	public void deleteById(Long id) {
		Iterator<Property> iterator = propertyDatabase.iterator();
		while (iterator.hasNext()) {
			Property element = iterator.next();
			System.out.println(element.getId() + " " + id);
			if (element.getId().equals(id)) {
				System.out.println("deleting Property" + id);
				iterator.remove(); // Safe removal
			}
		}

	}

	public String update(Property property) {
		Iterator<Property> iterator = propertyDatabase.iterator();
		boolean found = false;
		while (iterator.hasNext()) {
			Property element = iterator.next();
			if (element.getId().equals(property.getId())) {
				found = true;
				System.out.println("updating Property" + property.getId());
				element.setAddress(property.getAddress());
				element.setArea(property.getArea());
				element.setBathrooms(property.getBathrooms());
				element.setBedrooms(property.getBedrooms());
				element.setHospitalsCollegesNearby(property.getHospitalsCollegesNearby());
				element.setImage(property.getImage());
				element.setNearestMetro(property.getNearestMetro());
			}
		}
		if(!found)
			return "Property not found";
		
		return "Success";

	}

	public List<Property> findById(String emailId) {
		List<Property> propertyList = new ArrayList<Property>();
		for(Property property: propertyDatabase) {
			if(property.getSellerEmail().equals(emailId))
				propertyList.add(property);
		}
		return propertyList;
	}
}
