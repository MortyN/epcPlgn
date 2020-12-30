package com.morten.epicPlugin.events;

import com.morten.epicPlugin.jsonStuff.jsonHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class mobFarmLoot implements CommandExecutor {
public static boolean mobFarmLoot = true;
//TODO -need to add a autogenerated json file on launch that checks if "mobConfig.json" is present, if not, creates it
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;
        jsonHandler jsonHandler = new jsonHandler();
        String moblist = jsonHandler.deserializeMobList().toString();

        if (cmd.getName().equalsIgnoreCase("mobfarmloot")) {
            if(args.length==1){
                if(args[0].equalsIgnoreCase("on")) {
                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.GREEN +" Enabled!" + ChatColor.RESET + " Mobs will not drop specified items, this applies to all players!");
                    mobFarmLoot = true;

                }
                else if(args[0].equalsIgnoreCase("off")) {
                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RED +" Disabled!");
                    mobFarmLoot = false;
                }
                else if(args[0].equalsIgnoreCase("list")){
                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " List of items: " + moblist);
                }
                else{
                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Please use MobFarmLoot ON, OFF or List to check items specified in mobConfig.json!");

                }
            }
            else{
                player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Please use MobFarmLoot ON, OFF or List to check items specified in mobConfig.json!");

            }
        }
        return true;
    }

}
