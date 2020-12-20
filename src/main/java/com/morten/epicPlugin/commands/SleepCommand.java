package com.morten.epicPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SleepCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       //between 1000 and 12000 in-game hours
        World world = Bukkit.getServer().getWorld("World");

        if(cmd.getName().equalsIgnoreCase("sleep")){
            Player player = (Player) sender;
            long time = world.getTime();

            if(time <= 1000 || time >= 12000){
                world.setTime(1000);
                player.sendMessage(ChatColor.BOLD + "(∪｡∪)｡｡｡ zzZ");
                world.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_HURT, 10, 1);
                return true;
            }
            else{
                player.sendMessage(ChatColor.BOLD + "It's not night yet");
            }

        }

        return true;
    }
}
