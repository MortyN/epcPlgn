package com.morten.epicPlugin.events;

import com.morten.epicPlugin.jsonStuff.jsonHandler;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static com.morten.epicPlugin.events.mobFarmLootOn.mobFarmLoot;

public class mobLootDeathHandler implements Listener {
    @EventHandler
    public void onMobFarmDeath(EntityDeathEvent event){

        List<ItemStack> drops = event.getDrops();

        Iterator<ItemStack> dropIterator = drops.iterator();


        jsonHandler jsonHandler = new jsonHandler();


      if((event.getEntity().getType() != EntityType.PLAYER)){
            if(mobFarmLoot) {
                while (dropIterator.hasNext()) {
                    ItemStack item = dropIterator.next();
                    if (item != null && !item.getType().equals(Material.AIR)) {
                        Iterator jsonIterator = jsonHandler.deserializeMobList().iterator();
                        while(jsonIterator.hasNext()){
                            if(jsonIterator.next().equals(item.getType().toString())){
                                dropIterator.next().setAmount(0);
                            }
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
