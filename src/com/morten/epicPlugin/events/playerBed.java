package com.morten.epicPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class playerBed implements Listener {

//    isSleeping
//    boolean isSleeping()
//    Returns whether this entity is slumbering.
//            Returns:
//              slumber state

    @EventHandler
    public static void onPlayerBedEnter(PlayerBedEnterEvent event) {
        World world = Bukkit.getServer().getWorld("World");
        long time = world.getTime();
        Player player = event.getPlayer();
        boolean buttonclk = false;

        if(time <= 1000 || time >= 12000){

        }

    }
}
