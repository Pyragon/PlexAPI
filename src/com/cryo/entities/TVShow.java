package com.cryo.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.cryo.PlexEndpoints;
import com.cryo.adapters.TVShowDirectoryAdapter;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import lombok.Data;

@Data
public class TVShow {
	
	private String studio;
	private long addedAt;
	private int year;
	private String thumb;
	private double rating;
	private int ratingKey;
	private String type;
	private String title;
	private long lastViewedAt;
	private int viewedLeafCount;
	private long duration;
	private String librarySectionKey;
	private String theme;
	private int viewCount;
	private String key;
	private long updatedAt;
	private String summary;
	private String art;
	private String librarySectionID;
	private int index;
	private String banner;
	private String originallyAvailableAt;
	private int childCount;
	private int leafCount;
	private String librarySectionTitle;
	private String guid;
	private String contentRating;
	
	private Location location;
	
	@SerializedName("Similar")
	private List<Similar> similar;
	@SerializedName("Role")
	private List<Role> roles;
	@SerializedName("Genre")
	private List<Genre> genres;
	
	private HashMap<Integer, Season> seasons;

	public Episode getEpisode(int key) {
		for(Season season : seasons.values()) {
			Episode episode = season.getEpisodes().get(key);
			if(episode != null) return episode;
		}
		return null;
	}
	
	public void loadSeasons() {
		seasons = new HashMap<>();
		GsonBuilder builder = new GsonBuilder().registerTypeAdapter(new TypeToken<List<Season>>() {}.getType(), new TVShowDirectoryAdapter());
		Object obj = PlexEndpoints.loadEndpoint(PlexEndpoints.GET_SEASONS, ratingKey+"/children", null, builder);
		if(obj == null)
			return;
		SeasonList list = (SeasonList) obj;
		for(Season season : list.getSeasons()) {
			season.loadEpisodes();
			seasons.put(season.getRatingKey(), season);
		}
	}

}
