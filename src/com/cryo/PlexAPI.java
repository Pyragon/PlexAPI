package com.cryo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.cryo.entities.Libraries;
import com.cryo.entities.LibraryContainer;
import com.cryo.entities.PlexInfo;
import com.cryo.entities.TVShow;
import com.cryo.entities.Video;

import lombok.Getter;

public class PlexAPI {
	
	private static @Getter String authToken;
	
	private static @Getter Properties properties;
	private static @Getter Properties mavenProperties;
	
	private static @Getter String URL;
	
	private static @Getter PlexAPI instance;
	
	public PlexAPI(Properties prop) {
		properties = prop;
		mavenProperties = new Properties();
		File file = new File("target/classes/project.properties");
		try {
			mavenProperties.load(new FileInputStream(file));
		} catch (IOException e) {
			mavenProperties.put("version", "1.0.0");
		}
		URL = "http://"+properties.getProperty("host", "127.0.0.1")+":"+properties.getProperty("port", "32400");
		instance = this;
	}
	
	public TVShow getTVShow(int id) {
		Object obj = PlexEndpoints.loadEndpoint(PlexEndpoints.GET_SHOW, Integer.toString(id));
		if(obj == null) return null;
		TVShow show = (TVShow) obj;
		show.loadSeasons();
		return show;
	}
	
	public LibraryContainer getLibrary(int id) {
		Object obj = PlexEndpoints.loadEndpoint(PlexEndpoints.LIBRARY_CONTAINER, id+"/all");
		if(obj == null) return null;
		return (LibraryContainer) obj;
	}
	
	public Libraries getLibraries() {
		Object obj = PlexEndpoints.loadEndpoint(PlexEndpoints.LIBRARIES);
		if(obj == null) return null;
		return (Libraries) obj;
	}
	
	public PlexInfo getPlexInfo() {
		Object obj = PlexEndpoints.loadEndpoint(PlexEndpoints.INDEX);
		if(obj == null) return null;
		return (PlexInfo) obj;
	}
	
	public ArrayList<Video> getNowPlaying() {
		ArrayList<Video> videos = new ArrayList<>();
		Object obj = PlexEndpoints.loadEndpoint(PlexEndpoints.NOW_PLAYING);
		if(obj == null) return null;
		Video video = (Video) obj;
		videos.add(video);
		return videos;
	}

}
