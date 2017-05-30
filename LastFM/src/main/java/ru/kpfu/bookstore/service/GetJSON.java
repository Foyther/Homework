
package ru.kpfu.bookstore.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class GetJSON {
    public static JSONObject getGetJSON(String url1){
        BufferedReader reader = null;
        try {
            URL url = new URL(url1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();

            reader = new BufferedReader( new InputStreamReader(connection.getInputStream()));

            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            JSONParser parser = new JSONParser();
            JSONObject json;
            json = (JSONObject) parser.parse(buffer.toString());
            return json;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJSON(String url1){
        BufferedReader reader = null;
        try {
            URL url = new URL(url1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            return buffer.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
