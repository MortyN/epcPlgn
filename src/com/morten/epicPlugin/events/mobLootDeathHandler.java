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

import java.util.*;

import static com.morten.epicPlugin.events.mobFarmLootOn.mobFarmLoot;

public class mobLootDeathHandler implements Listener {

    @EventHandler
    public void onMobFarmDeath(EntityDeathEvent event){

        //list of items i don't want dropped
        //Hashset is not thread safe, assuming this isn't an issue
        Set<Material> mobloot = new HashSet<Material>();

        mobloot.add(Material.ENDER_PEARL);
        mobloot.add(Material.POPPY);
        mobloot.add(Material.ROTTEN_FLESH);
        mobloot.add(Material.GOLDEN_SWORD);
        mobloot.add(Material.STONE_SWORD);
        mobloot.add(Material.CROSSBOW);
        mobloot.add(Material.IRON_AXE);
        mobloot.add(Material.WHITE_BANNER);
        mobloot.add(Material.SADDLE);

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
