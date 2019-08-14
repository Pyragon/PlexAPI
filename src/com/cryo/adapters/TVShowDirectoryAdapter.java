package com.cryo.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cryo.entities.Season;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class TVShowDirectoryAdapter implements JsonDeserializer<List<Season>> {

	@Override
	public List<Season> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		List<Season> seasons = new ArrayList<>();
		if(json.isJsonArray()) {
			for (JsonElement e : json.getAsJsonArray()) {
				JsonObject obj = e.getAsJsonObject();
				if (!obj.has("ratingKey")) continue;
				seasons.add(context.deserialize(obj, Season.class));
			}
		} else
			seasons.add(context.deserialize(json, Season.class));
		return seasons;
	}

}
