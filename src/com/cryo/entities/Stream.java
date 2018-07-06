package com.cryo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Stream {
	
	private String codec;
	private String displayTitle;
	private double frameRate;
	private int streamType;
	private String decision;
	private int width;
	private String chromaLocation;
	private int bitrate;
	private String location;
	private int id;
	private int height;
	private int channels;
	private String bitrateMode;
	private String bitDepth;
	private String languageCode;
	private String language;
	private int selected;

}
