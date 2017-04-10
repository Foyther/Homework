package ru.kpfu.bookstore.Service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nurislam on 04.04.2017.
 */
@Service
public class CityGenerator {

    public Map getCitys(){
        Map<String,String> country = new LinkedHashMap<String,String>();
        country.put("US", "United Stated");
        country.put("CHINA", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        return country;
    }
}
