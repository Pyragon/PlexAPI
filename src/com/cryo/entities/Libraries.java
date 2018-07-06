package com.cryo.entities;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Libraries {
	
	private String mediaTagPrefix;
	private String identifier;
	private int size;
	private int allowSync;
	private String title1;
	private int mediaTagVersion;
	
	@SerializedName("Directory")
	private ArrayList<Library> libraries;

}
