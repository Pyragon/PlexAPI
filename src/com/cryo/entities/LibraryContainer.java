package com.cryo.entities;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class LibraryContainer {
	
	private String mediaTagPrefix;
	private String identifier;
	private String art;
	private String thumb;
	private int librarySectionID;
	private int allowSync;
	private String title1;
	private String title2;
	private int viewMode;
	private String librarySectionUUID;
	private long mediaTagVersion;
	private String viewGroup;
	private int size;
	private String librarySectionTitle;
	private int nocache;
	
	private Media media;
	
	@SerializedName("Directory")
	private ArrayList<Media> mediaList;

}
