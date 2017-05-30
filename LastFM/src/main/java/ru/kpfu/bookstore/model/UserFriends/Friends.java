
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
    "user",
    "@attr"
})
@Entity
public class Friends {

    @JsonProperty("user")
    private List<User> user = null;
    @JsonProperty("@attr")
    private Attr attr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("user")
    public List<User> getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(List<User> user) {
        this.user = user;
    }

    @JsonProperty("@attr")
    public Attr getAttr() {
        return attr;
    }

    @JsonProperty("@attr")
    public void setAttr(Attr attr) {
        this.attr = attr;
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
