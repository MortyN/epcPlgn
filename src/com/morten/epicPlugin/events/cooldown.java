package com.morten.epicPlugin.events;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class cooldown {

    public static HashMap<UUID, Long> cooldowns;
    public static void setupCooldown(){
        cooldowns = new HashMap<>();
    }
    //setcooldown
    public static void setCooldown(Player player, long seconds){
        long delay = System.currentTimeMillis() + (seconds*1000);
        cooldowns.put(player.getUniqueId(), delay);
    }
    //getcooldown
    public static long getCooldown(Player player){
       // return cooldowns.get(player.getUniqueId());
        long secondsLeft = ((cooldowns.get(player.getUniqueId()) / 1000)) - (System.currentTimeMillis() / 1000);
        return secondsLeft; //cooldowns.get(player.getUniqueId()) - (System.currentTimeMillis());
    }
    //check cooldown
    public static boolean checkCooldown(Player player){
        if(!cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }


}
