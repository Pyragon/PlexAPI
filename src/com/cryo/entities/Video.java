package com.cryo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Video {
	
	private String grandparentTitle;
	private long addedAt;
	private String grandparentThumb;
	private int parentIndex;
	private User user;
	private String thumb;
	private int year;
	private int parentRatingKey;
	private int rating;
	private String grandparentKey;
	private int ratingKey;
	private String title;
	private String type;
	private long duration;
	private int grandparentRatingKey;
	private String librarySectionKey;
	private String key;
	private long updatedAt;
	private String summary;

}
