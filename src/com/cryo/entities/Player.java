package com.cryo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Player {
	
	private String product;
	private String address;
	private String machineIdentifier;
	private String profile;
	private String remotePublicAddress;
	private String title;
	private String version;
	private int userID;
	private String platform;
	private int local;
	private String vendor;
	private int platformVersion;
	private String model;
	private String paused;
	private String device;

}
