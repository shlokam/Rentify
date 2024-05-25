package com.example.rentify.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentify.Entity.Property;
import com.example.rentify.Service.PropertyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {
	
	@Autowired
    private PropertyService propertyService;
	
	@PostMapping("/addProperty")
    public Property addProperty(@RequestBody Property property) throws IOException {
		System.out.println("inside addProperty");

        return propertyService.saveProperty(property);
    }

    @GetMapping("/allProperties")
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }
    
    @GetMapping("/getPropertyById/{emailId}")
    public List<Property> getPropertyById(@PathVariable String emailId) {
        return propertyService.getPropertyById(emailId);
    }

    @DeleteMapping("/deleteProperty/{id}")
    public void deleteProperty(@PathVariable Long id) {
    	System.out.println("inside deleteProperty" + id);
        propertyService.deleteProperty(id);
    }
    
    @PutMapping("/updateProperty")
    public String updateProperty(@RequestBody Property property) {
    	System.out.println("inside updateProperty" + property.getId());
        return propertyService.updateProperty(property);
    }

	
}
