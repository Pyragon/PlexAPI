# Plex API
This project is a wrapper for the Plex API programmed in Java.

# Functionality
Currently, this wrapper is able to load any videos currently being played from the /status/sessions/ endpoint.

Any episode/season/show can be loaded if you have the key for it. Keys are the rating keys used by the show.
(Movies TODO)

# TODO
Most of the TODO can be found in the .TODO file. (Best viewed with atom-tasks using Atom), though some of the bigger TODO I shall put here.

Loading movies (Will not work at the moment)
Authenticating via username/password (Need to manually input token at the moment)

# Example
``` Java
public static void main(String[] args) {
		Properties prop = new Properties(); //Create properties object for API to grab data from
		prop.put("username", PLEX_USERNAME); //Insert username into object
		prop.put("token", PLEX_TOKEN); //Insert authentication token into object.
		PlexAPI api = new PlexAPI(prop); //Load API object
		for(Video video : api.getNowPlaying()) { //Loop through videos found in /status/sessions/ endpoint
			TVShow show = api.getTVShow(video.getGrandparentRatingKey()); //Grab TVShow using key of grandparent (NowPlaying loads episode, ratingKey = episode key, parentRatingKey = season, grandparentRatingKey = show)
			System.out.println("Watching episode "+video.getTitle()+" from "+show.getTitle());
		}
	}
```
