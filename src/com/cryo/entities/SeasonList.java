package com.cryo.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SeasonList {
	
	@SerializedName("Directory")
	private List<Season> seasons;
	

}
