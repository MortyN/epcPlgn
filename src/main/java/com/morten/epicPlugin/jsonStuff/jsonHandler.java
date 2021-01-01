package com.morten.epicPlugin.jsonStuff;

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class jsonHandler {
    public static void main(String[] args) {
//        initializeJson();

    }
    public static void initializeJson() throws IOException {
        //Example on stock config file
        Set<String> items = new HashSet<String>();



    }
    public List<String> deserializeMobList() {
        //initializing Set array for loot
        List<String> mobloot = new ArrayList<String>();
        String wDir = System.getProperty("user.dir");

        try (Reader reader = new FileReader(wDir+"/plugins/mobConfig.json")) {

            nameArr findTwo = new Gson().fromJson(reader, nameArr.class);
            mobloot.addAll(findTwo.nameID);

        }

        catch (IOException e){
            e.printStackTrace();
        }
        return mobloot;
    }

}
