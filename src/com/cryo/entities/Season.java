package com.cryo.entities;

import java.util.HashMap;

import com.cryo.PlexEndpoints;

import lombok.Data;

@Data
public class Season {

	private String summary;
	private int parentIndex;
	private String art;
	private long addedAt;
	private String thumb;
	private int parentRatingKey;
	private int index;
	private int ratingKey;
	private String type;
	private String title;
	private int viewedLeafCount;
	private String parentTitle;
	private String parentThumb;
	private String parentKey;
	private int leafCount;
	private String parentTheme;
	private String key;
	private long updatedAt;
	
	private HashMap<Integer, Episode> episodes;
	
	public void loadEpisodes() {
		episodes = new HashMap<>();
		Object obj = PlexEndpoints.loadEndpoint(PlexEndpoints.GET_EPISODES, ratingKey+"/children", null);
		if(obj == null)
			return;
		EpisodeList list = (EpisodeList) obj;
		for(Episode episode : list.getEpisodes()) {
			episodes.put(episode.getRatingKey(), episode);
		}
	}

}
