/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.model;

import javax.persistence.Entity;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    public String name;
    public String url;
    public String country;
    public String playcount;
    public String gender;
    public String age;
    public String playlists;
    public List<Object> image;
    public Object registered;
    public List<Object> track;

//    public User(){}
//    public User(int id, String author, Date date, String access, String text){
//        this.name = name;
//        this.url = url;
//        this.country = country;
//    }


    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }


    public String getUrl() {
        return url;
    }

//    public void setUrl(String url) {
//        this.url = url;
//    }

    public String getCountry() {
        return country;
    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

    public String getPlaycount() {
        return playcount;
    }

    //
//    public void setPlatcount(String playcount) {
//        this.playcount = playcount;
//    }
//    
    public String getGender() {
        return gender;
    }

//    public void setGender(String gender) {
//        if (gender.equals("n")){
//            gender = "Not indicated";
//        }
//        this.gender = gender;
//    }

    public String getAge() {
        return age;
    }

    //    public void setAge(String age) {
//        if (age.equals("0")){
//            age = "Not indicated";
//        }
//        this.age = age;
//    }
    public String getPlaylists() {
        return playlists;
    }

    public List<Object> getImage() {
        return image;
    }

    public Object getRegistered() {
        return registered;
    }

    public List<Object> getUserRecientTracks() {
        return track;
    }

}
