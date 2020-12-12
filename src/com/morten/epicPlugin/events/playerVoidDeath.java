package com.morten.epicPlugin.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class playerVoidDeath implements Listener {

ItemStack[] inv;
    @EventHandler
    public void onPlayerVoidDeath (PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        EntityDamageEvent deathCause = player.getLastDamageCause();
        if (deathCause.equals(EntityDamageEvent.DamageCause.VOID)) {
            inv = player.getInventory().getContents();
        }
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        if(event.getPlayer().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.VOID) {
            event.getPlayer().getInventory().setContents(inv);
        }
    }
}
