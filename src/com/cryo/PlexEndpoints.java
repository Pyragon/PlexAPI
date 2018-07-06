package com.cryo;

import java.util.List;
import java.util.Properties;

import org.json.JSONObject;
import org.json.XML;

import com.cryo.adapters.DirectorTypeAdapter;
import com.cryo.adapters.GenreTypeAdapter;
import com.cryo.adapters.RoleTypeAdapter;
import com.cryo.adapters.EpisodeTypeAdapter;
import com.cryo.adapters.WriterTypeAdapter;
import com.cryo.entities.*;

import com.cryo.io.PlexConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public enum PlexEndpoints {
	
	INDEX("/", null, "GET", PlexInfo.class),
	NOW_PLAYING("/status/sessions/", "Video", "GET", Video.class),
	LIBRARIES("/library/sections/", null, "GET", Libraries.class),
	LIBRARY_CONTAINER("/library/sections/", null, "GET", LibraryContainer.class),
	GET_SHOW("/library/metadata/", "Directory", "GET", TVShow.class),
	GET_SEASONS("/library/metadata/", null, "GET", SeasonList.class),
	GET_EPISODES("/library/metadata/", null, "GET", EpisodeList.class),
	PAUSE_PLAYBACK("/system/players/", null, "POST", null);
	
	private String endpoint;
	private String valueName;
	private String method;
	private Class<?> c;
	
	PlexEndpoints(String endpoint, String valueName, String method, Class<?> c) {
		this.endpoint = endpoint;
		this.valueName = valueName;
		this.method = method;
		this.c = c;
	}
	
	public static void printEndpoint(PlexEndpoints endpoint, String toAppend, Properties prop) {
		System.out.println(XML.toJSONObject(PlexConnection.getResponse(PlexAPI.getURL()+""+endpoint.endpoint+""+(toAppend != null ? toAppend : ""), endpoint.method, prop)).toString(4));
	}
	
	public static void executeEndpoint(PlexEndpoints endpoint, String toAppend, Properties prop) {
		PlexConnection.getResponse(PlexAPI.getURL()+""+endpoint.endpoint+""+(toAppend != null ? toAppend : ""), endpoint.method, prop);
	}
	
	public static Object loadEndpoint(PlexEndpoints endpoint) {
		return loadEndpoint(endpoint, null, null);
	}
	
	public static Object loadEndpoint(PlexEndpoints endpoint, String toAppend) {
		return loadEndpoint(endpoint, toAppend, null);
	}
	
	public static Object loadEndpoint(PlexEndpoints endpoint, Properties prop) {
		return loadEndpoint(endpoint, null, prop);
	}
	
	public static GsonBuilder build(GsonBuilder builder) {
		if(builder == null)
			builder = new GsonBuilder();
		builder
				.registerTypeAdapter(new TypeToken<List<Genre>>() {}.getType(), new GenreTypeAdapter())
				.registerTypeAdapter(new TypeToken<List<Role>>() {}.getType(), new RoleTypeAdapter())
				.registerTypeAdapter(new TypeToken<List<Writer>>() {}.getType(), new WriterTypeAdapter())
				.registerTypeAdapter(new TypeToken<List<Director>>() {}.getType(), new DirectorTypeAdapter())
				.registerTypeAdapter(new TypeToken<List<Episode>>() {}.getType(), new EpisodeTypeAdapter());
		return builder;
	}
	
	public static Object loadEndpoint(PlexEndpoints endpoint, String toAppend, Properties prop) {
		String json = PlexConnection.getResponse(PlexAPI.getURL()+""+endpoint.endpoint+""+(toAppend != null ? toAppend : ""), endpoint.method, prop);
		JSONObject obj = XML.toJSONObject(json).getJSONObject("MediaContainer");
		if(endpoint.valueName != null && !obj.has(endpoint.valueName)) return null;
		Gson gson = build(null).create();
		return gson.fromJson(endpoint.valueName == null ? obj.toString() : obj.getJSONObject(endpoint.valueName).toString(), endpoint.c);
	}
	
	public static Object loadEndpoint(PlexEndpoints endpoint, String toAppend, Properties prop, GsonBuilder builder) {
		String json = PlexConnection.getResponse(PlexAPI.getURL()+""+endpoint.endpoint+""+(toAppend != null ? toAppend : ""), endpoint.method, prop);
		JSONObject obj = XML.toJSONObject(json).getJSONObject("MediaContainer");
		if(endpoint.valueName != null && !obj.has(endpoint.valueName)) return null;
		Gson gson = build(builder).create();
		return gson.fromJson(endpoint.valueName == null ? obj.toString() : obj.getJSONObject(endpoint.valueName).toString(), endpoint.c);
	}
}	
	