package com.cryo.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cryo.entities.Role;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class RoleTypeAdapter implements JsonDeserializer<List<Role>> {
	
	@Override
	public List<Role> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		List<Role> list = new ArrayList<>();
		if(json.isJsonArray()) {
			for(JsonElement e : json.getAsJsonArray()) {
				list.add((Role) context.deserialize(e, Role.class));
			}
		} else if(json.isJsonObject())
			list.add((Role) context.deserialize(json, Role.class));
		return list;
	}

}
