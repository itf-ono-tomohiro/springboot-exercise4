package com.example.demo3.domain;

public class Director {
	
	private String directorId;
	
	private String directorName;
	
	public Director() {
		
	}
	
	public Director(String directorId, String directorName) {
		this.directorId = directorId;
		this.directorName = directorName;
	}
	
	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
}
