package com.cryo.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Media {
	
	private String studio;
	private long addedAt;
	private int year;
	private String thumb;
	private double rating;
	private int ratingKey;
	private String type;
	private String title;
	private int viewedLeafCount;
	private long lastViewedAt;
	private long duration;
	private String theme;
	private int viewCount;
	private long updatedAt;
	private String summary;
	private String art;
	private int index;
	private String banner;
	private String originallyAvailableAt;
	private int childCount;
	private int leafCount;
	private String contentRating;
	
	@SerializedName("Role")
	private List<Role> roles;
	@SerializedName("Genre")
	private List<Genre> genres;

}
