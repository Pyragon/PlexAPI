package com.cryo.entities;

import lombok.Data;

@Data
public class MediaPart {
	
	private long duration;
	private String container;
	private String file;
	private long size;
	private String videoProfile;
	private int id;
	private String key;

}
