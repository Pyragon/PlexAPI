package com.cryo.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class EpisodeList {
	
	@SerializedName("Video")
	private List<Episode> episodes;

}
