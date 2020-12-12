package com.morten.epicPlugin.events;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class mobFarmLootOn implements CommandExecutor {
public static boolean mobFarmLoot = true;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        Player playerEvent = player.getPlayer();

        if (cmd.getName().equalsIgnoreCase("mobfarmlooton")) {
            player.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "MobFarmLoot Enabled!" + ChatColor.RESET + " Mob farms will not drop certain items, this applies to all players! (Endermen & Zombified Pigmen)");
            mobFarmLoot = true;
        }

        return true;
    }

}

