
package ru.kpfu.bookstore.model.UserLoveTracks;

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
    "mbid",
    "url",
    "date",
    "artist",
    "image",
    "streamable"
})
@Entity
public class Track {

    @JsonProperty("name")
    private String name;
    @JsonProperty("mbid")
    private String mbid;
    @JsonProperty("url")
    private String url;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("artist")
    private Artist artist;
    @JsonProperty("image")
    private List<Image> image = null;
    @JsonProperty("streamable")
    private Streamable streamable;
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

    @JsonProperty("mbid")
    public String getMbid() {
        return mbid;
    }

    @JsonProperty("mbid")
    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonProperty("artist")
    public Artist getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @JsonProperty("image")
    public List<Image> getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(List<Image> image) {
        this.image = image;
    }

    @JsonProperty("streamable")
    public Streamable getStreamable() {
        return streamable;
    }

    @JsonProperty("streamable")
    public void setStreamable(Streamable streamable) {
        this.streamable = streamable;
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
