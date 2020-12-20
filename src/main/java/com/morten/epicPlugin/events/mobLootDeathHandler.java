package com.morten.epicPlugin.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.morten.epicPlugin.events.mobFarmLootOn.mobFarmLoot;

public class mobLootDeathHandler implements Listener {

    @EventHandler
    public void onMobFarmDeath(EntityDeathEvent event){

        //list of items i don't want dropped
        Set<Material> mobloot = new HashSet<Material>();
//TODO JSON file is now made (manually), but i want it to generate at start and add default values, you should also be able to add values to the JSON file in-game through commands.
//Reads a json with a list of items
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("D:/plugintester/plugins/mobConfig.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray mobLootArray = (JSONArray) jsonObject.get("mobLoot");
            Iterator<String> iterator = mobLootArray.iterator();

            while(iterator.hasNext()){
                mobloot.add(Material.getMaterial(iterator.next()));
            }

        }

        catch(FileNotFoundException e) {e.printStackTrace(); }
        catch(IOException e) {e.printStackTrace(); }
        catch(ParseException e) {e.printStackTrace(); }
        catch(Exception e) {e.printStackTrace(); }


        List<ItemStack> drops = event.getDrops();
        Iterator<ItemStack> iterator = drops.iterator();

        if((event.getEntity().getType() != EntityType.PLAYER)){
            if(mobFarmLoot) {
                while (iterator.hasNext()) {
                    ItemStack item = iterator.next();
                    if (item != null && !item.getType().equals(Material.AIR)) {
                        if (mobloot.contains(item.getType())){
                            iterator.remove();
                        }
                    }
                }

            }
        }

        else{
            return;
        }
    }
}
