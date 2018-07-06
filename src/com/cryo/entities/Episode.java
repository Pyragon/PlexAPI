package com.cryo.entities;

import java.util.List;
import java.util.Optional;

import com.cryo.PlexAPI;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Episode {
	
	private String grandparentTitle;
	private int parentIndex;
	private String grandparentThumb;
	private long addedAt;
	private int year;
	private String thumb;
	private int parentRatingKey;
	private String type;
	private int ratingKey;
	private double rating;
	private String grandparentKey;
	private String title;
	private long duration;
	private int grandparentRatingKey;
	private String key;
	private long updatedAt;
	private String summary;
	private String art;
	private int index;
	private String originallyAvailableAt;
	private String parentTitle;
	private String parentThumb;
	private String grandparentTheme;
	private String grandparentArt;
	private String parentKey;
	private String contentRating;
	
	@SerializedName("Media")
	private Media media;
	@SerializedName("Director")
	private List<Director> director;
	@SerializedName("Writer")
	private List<Writer> writers;
	
	public Season getSeason() {
		Optional<Season> optional = PlexAPI.getInstance().getTVShow(grandparentRatingKey).getSeasons().values().stream().filter(s -> s.getRatingKey() == parentRatingKey).findFirst();
		if(!optional.isPresent()) return null;
		return optional.get();
	}

}
