package com.morten.epicPlugin.events;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import static org.bukkit.Bukkit.getServer;

public class richCheck implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();



        player.sendTitle(ChatColor.WHITE + "Velkommen " + ChatColor.BOLD + player.getDisplayName(),ChatColor.ITALIC + "'Democracy is the road to socialism' -Karl Marx", 20, 70,30);

    }

    @EventHandler
    public static void onPlayerDripCheck(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack[] items = inventory.getContents();

        int amount = 0;
        int invSpace = 36;
        for(ItemStack item : items){
            if((item != null) && (item.getType() == Material.DIAMOND) && invSpace != 0){
                amount += item.getAmount();
                invSpace--;
            }
        }

        if(amount==1) {
            player.sendMessage(ChatColor.GOLD + "Fattiggutt!" + ChatColor.WHITE + " du har bare en" + ChatColor.AQUA + " Diamant" + ChatColor.WHITE + " på deg");
        }
        if (amount>=16){
            player.sendMessage(ChatColor.GOLD + "Rike jævel!" + ChatColor.WHITE + " du har " + amount + ChatColor.AQUA + " Diamanter" + ChatColor.WHITE + " på deg");
        }

        if (amount<16 && amount!=0 && amount!=1) {
            player.sendMessage(ChatColor.GOLD + "Fattiggutt!" + ChatColor.WHITE + " du har bare " + amount + ChatColor.AQUA + " Diamanter" + ChatColor.WHITE + " på deg");
        }

        else if(amount==0){
            player.sendMessage(ChatColor.YELLOW + "Fattiggutt!" + ChatColor.WHITE + " du har ingen" + ChatColor.AQUA + " Diamanter" + ChatColor.WHITE + " på deg");

        }
    }

    @EventHandler
    public static void onPlayerGreentext(AsyncPlayerChatEvent event){


        if (event.getMessage().startsWith(">")) {
            event.setMessage(ChatColor.GREEN + event.getMessage());
        }

    }
}