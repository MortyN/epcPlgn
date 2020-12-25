package com.morten.epicPlugin;

import com.morten.epicPlugin.commands.AutoFish;
import com.morten.epicPlugin.commands.SleepCommand;
import com.morten.epicPlugin.commands.giveSand;
import com.morten.epicPlugin.events.*;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EpicMain extends JavaPlugin{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new richCheck(), this);
        getServer().getPluginManager().registerEvents(new mobLootDeathHandler(), this);

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
