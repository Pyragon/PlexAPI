package com.cryo.entities;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Video {
	
	private String grandparentTitle;
	private String grandparentThumb;
	private String thumb;
	private String grandparentKey;
	private String librarySectionKey;
	private String key;
	private String title;
	private String type;
	private String summary;
	private String art;
	private String parentTitle;
	private String parentThumb;
	private String grandparentTheme;
	private String grandparentArt;
	private String parentKey;
	private String librarySectionTitle;
	private String guid;
	private String contentRating;
	
	private int parentIndex;
	private int year;
	private int parentRatingKey;
	private double rating;
	private int ratingKey;
	private int grandparentRatingKey;
	private int sessionKey;
	private int librarySectionID;
	private int index;
	
	private Date originallyAvailableAt;
	
	private long viewOffset;
	private long addedAt;
	private long updatedAt;
	private long duration;

	@SerializedName("Player")
	private Player player;
	@SerializedName("Media")
	private MediaProfile mediaPart;
	@SerializedName("User")
	private User user;
	@SerializedName("Director")
	private List<Director> director;
	@SerializedName("Writer")
	private List<Writer> writer;
	@SerializedName("Session")
	private Session session;

}
