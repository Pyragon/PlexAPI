package com.cryo.entities;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MediaProfile {
	
	private String container;
	private int optimizedForStreaming;
	private String videoProfile;
	private int bitrate;
	private String audioCodec;
	private String videoFrameRate;
	private long duration;
	private String protocol;
	private int audioChannels;
	private String decision;
	private int width;
	private int height;
	private int id;
	private int selected;
	private String videoResolution;
	
	@SerializedName("Part")
	private MediaPart part;
	@SerializedName("Stream")
	private Stream[] streams;

}
