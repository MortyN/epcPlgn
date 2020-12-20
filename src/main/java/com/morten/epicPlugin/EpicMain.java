package com.morten.epicPlugin;

import com.morten.epicPlugin.commands.AutoFish;
import com.morten.epicPlugin.commands.SleepCommand;
import com.morten.epicPlugin.commands.giveSand;
import com.morten.epicPlugin.events.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class EpicMain extends JavaPlugin{

    @Override
    public void onEnable() {
        cooldown.setupCooldown();
        getServer().getPluginManager().registerEvents(new richCheck(), this);
        getServer().getPluginManager().registerEvents(new mobLootDeathHandler(), this);

        //getServer().getPluginManager().registerEvents(new playerBed(), this);
        getCommand("sleep").setExecutor(new SleepCommand());
        getCommand("autofish").setExecutor(new AutoFish());
        getCommand("mobFarmLootOn").setExecutor(new mobFarmLootOn());
        getCommand("mobFarmLootOff").setExecutor(new mobFarmLootOff());
        getCommand("sand").setExecutor(new giveSand());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN +"[Epic plugin] Enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED +"[Epic plugin] Disabled!");
    }

}
