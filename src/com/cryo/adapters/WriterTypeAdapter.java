package com.cryo.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cryo.entities.Writer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class WriterTypeAdapter implements JsonDeserializer<List<Writer>> {

	@Override
	public List<Writer> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		List<Writer> writers = new ArrayList<>();
		if(json.isJsonArray()) {
			for(JsonElement e : json.getAsJsonArray()) {
				writers.add((Writer) context.deserialize(e, Writer.class));
			}
		} else
			writers.add((Writer) context.deserialize(json, Writer.class));
		return writers;
	}

}
