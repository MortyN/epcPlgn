package com.morten.epicPlugin.jsonStuff;

import com.google.gson.Gson;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.*;

import static com.morten.epicPlugin.events.mobFarmLoot.mobFarmLoot;

public class jsonHandler {
    public List<String> deserializeMobList() {
        //initializing Set array for loot
        List<String> mobloot = new ArrayList<String>();
        String wDir = System.getProperty("user.dir");
        if (mobFarmLoot) {
            try (Reader reader = new FileReader(wDir + "/plugins/mobConfig.json")) {

                nameArr findTwo = new Gson().fromJson(reader, nameArr.class);
                mobloot.addAll(findTwo.nameID);

            }
            //if it doesnt exist, creates a new empty mobConfig.json file
            catch (IOException e) {
                Bukkit.getLogger().severe("Cannot find mobConfig.json, creating the file at: " + wDir + "/plugins/mobConfig.json");
                List<String> items = new ArrayList<>();

                MobList nameID = new MobList(items);

                Gson gson = new Gson();
                try (Writer writer = new FileWriter(wDir + "/plugins/mobConfig.json")) {
                    new Gson().toJson(nameID, writer);
                } catch (IOException fex) {
                    fex.printStackTrace();
                }
            }
        }
        return mobloot;

    }

}
