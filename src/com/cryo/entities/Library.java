package com.cryo.entities;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Library {
	
	private String art;
	private String agent;
	private long scannedAt;
	private String thumb;
	private int allowSync;
	private String language;
	private int filters;
	private String type;
	private String title;
	private String uuid;
	private long createdat;
	private String composite;
	private int refreshing;
	private String scanner;
	private int key;
	private long updatedAt;
	
	@SerializedName("Location")
	private Location location;

}
