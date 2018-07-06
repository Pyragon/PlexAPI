package com.cryo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Session {
	
	private int bandwidth;
	private String location;
	private String id;

}
