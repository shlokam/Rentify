package com.example.rentify.Entity;

public class Property {

	private Long id;

    private String address;
    private String area;
    private int bedrooms;
    private int bathrooms;
    private String hospitalsCollegesNearby;
    private String nearestMetro;
    private String image;
    private String sellerEmail;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public String getHospitalsCollegesNearby() {
		return hospitalsCollegesNearby;
	}
	public void setHospitalsCollegesNearby(String hospitalsCollegesNearby) {
		this.hospitalsCollegesNearby = hospitalsCollegesNearby;
	}
	public String getNearestMetro() {
		return nearestMetro;
	}
	public void setNearestMetro(String nearestMetro) {
		this.nearestMetro = nearestMetro;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
    
	
    
}
