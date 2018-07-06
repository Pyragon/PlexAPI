package com.cryo.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cryo.entities.Episode;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class EpisodeTypeAdapter implements JsonDeserializer<List<Episode>> {

	@Override
	public List<Episode> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		List<Episode> videos = new ArrayList<Episode>();
		if(json.isJsonArray()) {
			for(JsonElement e : json.getAsJsonArray()) {
				videos.add((Episode) context.deserialize(e, Episode.class));
			}
		} else {
			videos.add((Episode) context.deserialize(json, Episode.class));
		}
		return videos;
	}


}
