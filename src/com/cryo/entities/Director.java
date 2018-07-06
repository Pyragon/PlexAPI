package com.cryo.entities;

import org.json.JSONObject;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Director {
	
	private int id;
	private String name;
	
	private String filter;
	
	public static Director load(JSONObject object) {
		DirectorBuilder builder = new DirectorBuilder()
				.id(object.getInt("id"))
				.name(object.getString("tag"));
		return builder.build();
	}

}
