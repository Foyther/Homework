/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Cleaning {
    public static String cleanImage(List<Object> image){
        String a = image.get(1).toString();
        String b = a.substring(7, a.length()-14);
        return b;
    }
    
    public static List<String> cleanRecientTracks(List<Object> track){
        List<String> result = new ArrayList<String>();
        for (int i=1; i<10; i++){ 
            String res = ""; 
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            String a = track.get(i).toString();

            String[] b = a.split("artist=\\{#text=");
            String[] c = b[1].split(",");
            Collections.addAll(list1, c);
            res = res + list1.get(0);

            String[] d = a.split("name=");
            String[] e = d[1].split(",");
            Collections.addAll(list2, e);
            res = res +" - "+ list2.get(0);
            
            Collections.addAll(result, res);
        }
        return result;
        
    }
}
