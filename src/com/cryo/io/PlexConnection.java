package com.cryo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

import org.apache.http.client.utils.URIBuilder;

import com.cryo.PlexAPI;

import lombok.Getter;

public class PlexConnection {
	
	private static @Getter UUID uuid;
	
	public static String getResponse(String url, String method, Properties prop) {
		try {
			URIBuilder b = new URIBuilder(url);
			if(prop != null) {
				for(Object key : prop.keySet()) {
					Object value = prop.get(key);
					b.addParameter(key.toString(), value.toString());
				}
			}
			b.addParameter("X-Plex-Token", PlexAPI.getProperties().getProperty("token"));
			b.addParameter("X-Plex-Username", PlexAPI.getProperties().getProperty("username"));
			if(uuid == null)
				uuid = UUID.randomUUID();
			b.addParameter("X-Plex-Client-Identifier", uuid.toString()); //get random uuid
			b.addParameter("X-Plex-Product", PlexAPI.getProperties().getProperty("product", "Plex Java Wrapper"));
			b.addParameter("X-Plex-Device", PlexAPI.getProperties().getProperty("device", "PC"));
			b.addParameter("X-Plex-Version", PlexAPI.getMavenProperties().getProperty("version", "1.0.0"));
			b.addParameter("X-Plex-Device-Name", InetAddress.getLocalHost().getHostName());
			b.addParameter("X-Plex-Platform", System.getProperty("os.name"));
			b.addParameter("X-Plex-Platform-Version", System.getProperty("os.version"));
			b.addParameter("X-Plex-Provides", "controller");
			URL dao = b.build().toURL();
			HttpURLConnection con = (HttpURLConnection) dao.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setReadTimeout(5000);
			con.connect();
			if(con.getResponseCode() == 403) {
				System.out.println("403: Insufficient permissions to complete this request!");
				return null;
			}
			if(con.getResponseCode() == 401) {
				System.out.println("401: Authentication token has expired. Please obtain a new one.");
				return null;
			}
			if(con.getResponseCode() < 200 || con.getResponseCode() > 299) {
				System.out.println("Invalid response code. Check endpoint!");
				return null;
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			StringBuilder builder = new StringBuilder();
			while((line = reader.readLine()) != null)
				builder.append(line);
			return builder.toString();
		} catch(IOException | URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

}
