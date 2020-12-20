package com.morten.epicPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class giveSand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player player = (Player) sender;
        String playerEvent = player.getPlayerListName();

        if (cmd.getName().equalsIgnoreCase("sand")){
            getServer().dispatchCommand(getServer().getConsoleSender() , "give " + playerEvent + " sand 64");
        }
        return true;
    }

}
