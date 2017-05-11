package ru.kpfu.bookstore.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nurislam on 24.04.2017.
 */
@Entity
@Table(name = "post")
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Size(min = 1, max = 255)
    @Column
    private String userName;

    @Size(min = 1, max = 255)
    @Column
    private Date postDate;

    @Size(min = 1, max = 255)
    @Column
    private String theme;

    @Length(max = 65535)
    @Column
    private String content;

    public Post() {
    }

    public Post(String userName, Date postDate, String theme, String content) {
        this.userName = userName;
        this.postDate = postDate;
        this.theme = theme;
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
