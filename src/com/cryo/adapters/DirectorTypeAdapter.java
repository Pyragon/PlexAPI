package com.cryo.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cryo.entities.Director;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DirectorTypeAdapter implements JsonDeserializer<List<Director>> {

	@Override
	public List<Director> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		List<Director> directors = new ArrayList<>();
		if(json.isJsonArray()) {
			for(JsonElement e : json.getAsJsonArray()) {
				directors.add(context.deserialize(e, Director.class));
			}
		} else
			directors.add(context.deserialize(json, Director.class));
		return directors;
	}

}
