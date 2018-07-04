package com.cryo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;
import java.util.UUID;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import org.json.XML;

import com.cryo.PlexAPI;
import com.google.gson.Gson;

public class PlexConnection {
	
	private static String authToken ="xwdW2GqT2yKERpFmc97r";
	private static UUID uuid;
	
	public static Properties getResponse(String url, String method, Properties prop) {
		try {
			URIBuilder b = new URIBuilder(url);
			for(Object key : prop.keySet()) {
				Object value = prop.get(key);
				b.addParameter(key.toString(), value.toString());
			}
			if(authToken != null)
				b.addParameter("X-Plex-Token", authToken);
			b.addParameter("X-Plex-Username", PlexAPI.getProperties().getProperty("username"));
			if(uuid == null)
				uuid = UUID.randomUUID();
			b.addParameter("X-Plex-Client-Identifier", uuid.toString()); //get random uuid
			b.addParameter("X-Plex-Product", PlexAPI.getProperties().getProperty("product"));
			b.addParameter("X-Plex-Device", PlexAPI.getProperties().getProperty("device"));
			b.addParameter("X-Plex-Version", PlexAPI.getProperties().getProperty("version"));
			b.addParameter("X-Plex-Device-Name", InetAddress.getLocalHost().getHostName());
			b.addParameter("X-Plex-Platform", System.getProperty("os.name"));
			b.addParameter("X-Plex-Platform-Version", System.getProperty("os.version"));
			b.addParameter("X-Plex-Provides", "controller");
			URL dao = b.build().toURL();
			System.out.println(dao.toString());
			HttpURLConnection con = (HttpURLConnection) dao.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setReadTimeout(5000);
			con.connect();
			System.out.println(con.getResponseCode());
			if(con.getResponseCode() == 403) 
				return error("403: Insufficient permissions to complete this request!");
			if(con.getResponseCode() == 401) {
				Properties toAuth = new Properties();
				String username = PlexAPI.getProperties().getProperty("username");
				String password = PlexAPI.getProperties().getProperty("password");
				String auth = Base64.getEncoder().encodeToString((username+":"+password).getBytes());
				toAuth.put("Authorization", "Basic "+auth);
				Properties authProp = getResponse("https://plex.tv/users/sign_in.xml", "POST", toAuth);
				System.out.println(new Gson().toJson(authProp));
				return null;
			}
			if(con.getResponseCode() < 200 || con.getResponseCode() > 299) {
				System.out.println("Invalid response code. Check endpoint!"+url);
				return null;
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			StringBuilder builder = new StringBuilder();
			while((line = reader.readLine()) != null)
				builder.append(line);
			JSONObject container = XML.toJSONObject(builder.toString());
			System.out.println(container.length());
			System.out.println(container.toString());
			return null;
		} catch(IOException | URISyntaxException e) {
			e.printStackTrace();
			return error(e.getMessage());
		}
	}
	
	public static Properties error(String error) {
		Properties prop = new Properties();
		prop.put("error", error);
		return prop;
	}

}
