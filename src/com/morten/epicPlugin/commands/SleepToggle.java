package com.morten.epicPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SleepToggle implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //between 1000 and 12000 in-game hours
        World world = Bukkit.getServer().getWorld("World");

        if (cmd.getName().equalsIgnoreCase("sleep toggle")) {
            Player player = (Player) sender;
            long time = world.getTime();



        }
        return true;

    }
}