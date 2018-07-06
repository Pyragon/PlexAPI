package com.cryo.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cryo.entities.Genre;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class GenreTypeAdapter implements JsonDeserializer<List<Genre>> {

	@Override
	public List<Genre> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		List<Genre> list = new ArrayList<>();
		if(json.isJsonArray()) {
			for(JsonElement e : json.getAsJsonArray()) {
				list.add((Genre) context.deserialize(e, Genre.class));
			}
		} else if(json.isJsonObject())
			list.add((Genre) context.deserialize(json, Genre.class));
		return list;
	}

}
