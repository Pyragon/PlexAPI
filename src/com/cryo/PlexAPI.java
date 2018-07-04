package com.cryo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import com.cryo.io.PlexConnection;
import com.google.gson.Gson;

import lombok.Getter;

public class PlexAPI {
	
	private static @Getter String authToken;
	
	private static @Getter Properties properties;
	
	public static void main(String[] args) {
		PlexAPI api = new PlexAPI();
	}
	
	private PlexAPI() {
		loadProperties();
	}

	public static void loadProperties() {
		File file = new File("props.json");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String json = reader.readLine();
			Gson gson = new Gson();
			properties = gson.fromJson(json, Properties.class);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
