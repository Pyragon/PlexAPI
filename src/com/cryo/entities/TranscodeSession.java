package com.cryo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TranscodeSession {
	
	private String container;
	private double minOffsetAvailable;
	private int transcodeHwRequested;
	private String audioCodec;
	private int speed;
	private long remaining;
	private long duration;
	private String sourceAudioCodec;
	private double timeStamp;
	private String protocol;
	private int audioChannels;
	private String sourceVideoCodec;
	private double maxOffsetAvailable;
	private String context;
	private String videoDecision;
	private double progress;
	private String audioDecision;
	private String transcode;
	private int complete;
	private String key;
	private int throttled;
	private String videoCodec;

}
