package com.cryo.entities;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PlexInfo {
	
	private int transcoderSubtitles;
	private int readOnlyLibraries;
	private int photoAutoTag;
	private String myPlexMappingState;
	private String transcoderVideoQualities;
	private int allowCameraUpload;
	private int pluginHost;
	private int multiuser;
	private String myPlexUsername;
	private long updatedAt;
	private int myPlexSubscription;
	private int livetv;
	private int allowSync;
	private int sync;
	private String version;
	private int itemClusters;
	private int transcoderLyrics;
	private String ownedFeatures;
	private String transcoderVideoResolutions;
	private int allowChannelAccess;
	private int size;
	private int myPlex;
	private int companionProxy;
	private int transcoderVideo;
	private int hubSearch;
	private int allowMediaDeltion;
	private int allowTuners;
	private int certificate;
	private int myLexSigninState;
	private String platform;
	private int transcoderAudio;
	private int updater;
	private int transcderPhoto;
	private int streaminingBrainABRVersion;
	private String countryCode;
	private String platformVersion;
	private int eventStream;
	private String friendlyName;
	private int requestParametersInCookie;
	private String machineIdentifier;
	private int backgroundProcessing;
	private int voiceSearch;
	private int streamingBrainVersion;
	private int mediaProviders;
	private String transcoderVideoBitrates;
	private String diagnostics;
	private int transcoderActiveVideoSessions;
	
	@SerializedName("Directory")
	private ArrayList<Directory> directories;
	

}
