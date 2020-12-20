package com.morten.epicPlugin.events;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.morten.epicPlugin.events.mobFarmLootOn.mobFarmLoot;

public class mobFarmLootOff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        Player playerEvent = player.getPlayer();

        if (cmd.getName().equalsIgnoreCase("mobfarmlootoff")) {
            player.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "MobFarmLoot Disabled!" + ChatColor.RESET + " All mob farms will now drop all loot, this applies to all players!");
            mobFarmLoot = false;
        }
        return true;
    }

}

