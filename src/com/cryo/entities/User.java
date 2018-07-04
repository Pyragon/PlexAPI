package com.cryo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	
	private String thumb;
	private int id;
	private String title;

}
