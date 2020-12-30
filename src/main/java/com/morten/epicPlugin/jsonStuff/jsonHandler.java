package com.morten.epicPlugin.jsonStuff;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class jsonHandler {
    public static void main(String[] args) {
        //serializeMobList();

    }
    private static void serializeMobList() {
        //Example on stock config file
        Set<String> items = new HashSet<>();

        MobList nameID = new MobList(items);
        items.add("ENDER_PEARL");
        items.add("Rotten");
        items.add("flesh");
        items.add("cool");

        String json = new Gson().toJson(nameID);
        System.out.println(json);

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
