/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import ru.kpfu.bookstore.model.User;
import ru.kpfu.bookstore.model.UserFriends.UserFriend;
import ru.kpfu.bookstore.model.UserLoveTracks.UserLoveTracks;
import ru.kpfu.bookstore.model.UserTopArtists.Artist;
import ru.kpfu.bookstore.model.UserTopArtists.UserTopArtists;
import ru.kpfu.bookstore.model.UserTopTracks.Track;
import ru.kpfu.bookstore.model.UserTopTracks.UserTopTracks;

@Service
public class LastFM {
    private static final String KEY = "3aa3829cc3c67428c53c345d6e25ac21";
    static User user = new User();

    public static User getUserInfo(String username) {
        BufferedReader reader = null;
        try {
            JSONObject json = GetJSON.getGetJSON("http://ws.audioscrobbler.com/2.0/?method=user.getinfo&user=" + username + "&api_key=" + KEY + "&format=json");
            JSONObject user1 = (JSONObject) json.get("user");

            String json2 = user1.toString();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            user = gson.fromJson(json2, User.class);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }


    public static List<Object> getRecientTracks(String username) {
        BufferedReader reader = null;
        JSONObject json = GetJSON.getGetJSON("http://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=" + username + "&api_key=" + KEY + "&format=json");
        JSONObject user1 = (JSONObject) json.get("recenttracks");

        String json2 = user1.toString();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        user = gson.fromJson(json2, User.class);
        return user.getUserRecientTracks();
    }

    public static List<ru.kpfu.bookstore.model.UserFriends.User> getFriends(String username) {
        ObjectMapper om = new ObjectMapper();
        try {
            String a = GetJSON.getJSON("http://ws.audioscrobbler.com/2.0/?method=user.getfriends&user="
                            + username
                            + "&api_key="
                            + KEY
                            + "&format=json");
            UserFriend uf= om.readValue((a), UserFriend.class);
            return uf.getFriends().getUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Track> getTopTracks(String username) {
        ObjectMapper om = new ObjectMapper();
        try {
            String a = GetJSON.getJSON("http://ws.audioscrobbler.com/2.0/?method=user.gettoptracks&user="
                    + username
                    + "&api_key="
                    + KEY
                    + "&format=json");
            UserTopTracks uf= om.readValue((a), UserTopTracks.class);
            return uf.getToptracks().getTrack();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<ru.kpfu.bookstore.model.UserLoveTracks.Track> getLoveTracks(String username) {
        ObjectMapper om = new ObjectMapper();
        try {
            String a = GetJSON.getJSON("http://ws.audioscrobbler.com/2.0/?method=user.getlovedtracks&user="
                    + username
                    + "&api_key="
                    + KEY
                    + "&format=json");
            UserLoveTracks uf= om.readValue((a), UserLoveTracks.class);
            return uf.getLovedtracks().getTrack();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Artist> getTopArtists(String username) {
        ObjectMapper om = new ObjectMapper();
        try {
            String a = GetJSON.getJSON("http://ws.audioscrobbler.com/2.0/?method=user.gettopartists&user="
                    + username
                    + "&api_key="
                    + KEY
                    + "&format=json");
            UserTopArtists uf= om.readValue((a), UserTopArtists.class);
            return uf.getTopartists().getArtist();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
