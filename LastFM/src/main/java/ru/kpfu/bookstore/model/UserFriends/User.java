
package ru.kpfu.bookstore.model.UserFriends;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "realname",
    "image",
    "url",
    "country",
    "age",
    "gender",
    "subscriber",
    "playcount",
    "playlists",
    "bootstrap",
    "registered",
    "type",
    "scrobblesource"
})
@Entity
public class User {

    @JsonProperty("name")
    private String name;
    @JsonProperty("realname")
    private String realname;
    @JsonProperty("image")
    private List<Image> image = null;
    @JsonProperty("url")
    private String url;
    @JsonProperty("country")
    private String country;
    @JsonProperty("age")
    private String age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("subscriber")
    private String subscriber;
    @JsonProperty("playcount")
    private String playcount;
    @JsonProperty("playlists")
    private String playlists;
    @JsonProperty("bootstrap")
    private String bootstrap;
    @JsonProperty("registered")
    private Registered registered;
    @JsonProperty("type")
    private String type;
    @JsonProperty("scrobblesource")
    private String scrobblesource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("realname")
    public String getRealname() {
        return realname;
    }

    @JsonProperty("realname")
    public void setRealname(String realname) {
        this.realname = realname;
    }

    @JsonProperty("image")
    public List<Image> getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(List<Image> image) {
        this.image = image;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("subscriber")
    public String getSubscriber() {
        return subscriber;
    }

    @JsonProperty("subscriber")
    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    @JsonProperty("playcount")
    public String getPlaycount() {
        return playcount;
    }

    @JsonProperty("playcount")
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    @JsonProperty("playlists")
    public String getPlaylists() {
        return playlists;
    }

    @JsonProperty("playlists")
    public void setPlaylists(String playlists) {
        this.playlists = playlists;
    }

    @JsonProperty("bootstrap")
    public String getBootstrap() {
        return bootstrap;
    }

    @JsonProperty("bootstrap")
    public void setBootstrap(String bootstrap) {
        this.bootstrap = bootstrap;
    }

    @JsonProperty("registered")
    public Registered getRegistered() {
        return registered;
    }

    @JsonProperty("registered")
    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("scrobblesource")
    public String getScrobblesource() {
        return scrobblesource;
    }

    @JsonProperty("scrobblesource")
    public void setScrobblesource(String scrobblesource) {
        this.scrobblesource = scrobblesource;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
