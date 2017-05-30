package ru.kpfu.bookstore.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.bookstore.model.User;
import ru.kpfu.bookstore.model.UserTopArtists.Artist;
import ru.kpfu.bookstore.model.UserTopTracks.Track;
import ru.kpfu.bookstore.service.Cleaning;
import ru.kpfu.bookstore.service.LastFM;


@Controller
@RequestMapping("")
public class DefaultController {
    String username = " ";
  
    @RequestMapping(value="/{username}", method = RequestMethod.GET)
    public String main(ModelMap map, @PathVariable("username") String username){
        User user = LastFM.getUserInfo(username);
        map.put("image", Cleaning.cleanImage(user.getImage()));
        map.put("user", user);
        map.put("recienttrack", Cleaning.cleanRecientTracks(LastFM.getRecientTracks(username)));
        System.out.println(Cleaning.cleanRecientTracks(LastFM.getRecientTracks(username)));
        return "mainpage";  
    }

    @RequestMapping(value="/{username}/friends", method = RequestMethod.GET)
    public String friends(ModelMap map,@PathVariable("username") String username) {
        User user = LastFM.getUserInfo(username);
        List<ru.kpfu.bookstore.model.UserFriends.User> userList= LastFM.getFriends(username);
        map.put("user", user);
        map.put("friends", userList);
        return "friends";
    }

    @RequestMapping(value="/{username}/toptracks", method = RequestMethod.GET)
    public String topTracks(ModelMap map,@PathVariable("username") String username) {
        User user = LastFM.getUserInfo(username);
        List<Track> trackList= LastFM.getTopTracks(username);
        map.put("user", user);
        map.put("toptracks", trackList);
        return "toptracks";
    }

    @RequestMapping(value="/{username}/lovetracks", method = RequestMethod.GET)
    public String loveTracks(ModelMap map,@PathVariable("username") String username) {
        User user = LastFM.getUserInfo(username);
        List<ru.kpfu.bookstore.model.UserLoveTracks.Track> trackList= LastFM.getLoveTracks(username);
        map.put("user", user);
        map.put("lovetracks", trackList);
        return "lovetracks";
    }

    @RequestMapping(value="/{username}/topartists", method = RequestMethod.GET)
    public String topArtist(ModelMap map,@PathVariable("username") String username) {
        User user = LastFM.getUserInfo(username);
        List<Artist> trackList= LastFM.getTopArtists(username);
        map.put("user", user);
        map.put("topartists", trackList);
        return "topartists";
    }


}
