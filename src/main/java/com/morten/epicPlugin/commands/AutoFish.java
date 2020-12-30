package com.morten.epicPlugin.commands;

import com.morten.epicPlugin.events.cooldown;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getServer;

public class AutoFish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        Player playerEvent = player.getPlayer();

        if (cmd.getName().equalsIgnoreCase("autofish")){
            long systime = System.currentTimeMillis();
            System.out.println(systime);
            Location location = player.getLocation();
            int x = location.getBlockX();
            int y = location.getBlockY();
            int z = location.getBlockZ();

            ItemStack inMainHand = player.getInventory().getItemInMainHand();

            int checkEnch = inMainHand.getEnchantments().size();
            if(!((player.getLocation().getBlock().getType() == Material.WATER) && y == 62)){
                player.sendMessage("You need be knee deep in the " + ChatColor.BLUE + ChatColor.BOLD + "Ocean" + ChatColor.RESET +", not a waterblock!");
                return true;
            }

            else if(inMainHand.getType().equals(Material.FISHING_ROD)){
                if (checkEnch>0){
                    player.sendMessage("You need a " + ChatColor.BOLD + ChatColor.GREEN + "Fishing Rod " + ChatColor.RESET + "without enchantments!");
                }

                else {
                    if(cooldown.checkCooldown(playerEvent) == true){
                        playerEvent.getPlayer().sendMessage("You used AutoFish");
                        playerEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        cooldown.setCooldown(playerEvent, 1200);
                        //Normal loot
                        for (int i = 0; i < 30; i++) {
                            getServer().dispatchCommand(getServer().getConsoleSender() , "loot spawn " + x + " " + y + " " + z + " loot minecraft:gameplay/fishing");
                        }
                        //Treasure loot
                        for (int i = 0; i < 3; i++) {
                            getServer().dispatchCommand(getServer().getConsoleSender() , "loot spawn " + x + " " + y + " " + z + " loot minecraft:gameplay/fishing/treasure");

                        }

                    }
                    else{
                        playerEvent.sendMessage("You cannot " + ChatColor.BLUE + ChatColor.BOLD + "AutoFish " + ChatColor.RESET + "for another " + cooldown.getCooldown(playerEvent) + " seconds");
                    }
                }
            }
            else{
                player.sendMessage("You need a " + ChatColor.GREEN + ChatColor.BOLD + "Fishing Rod!");

            }



        }

        return true;
    }

}
