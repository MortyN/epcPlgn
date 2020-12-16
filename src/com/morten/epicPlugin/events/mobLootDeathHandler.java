package com.morten.epicPlugin.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static com.morten.epicPlugin.events.mobFarmLootOn.mobFarmLoot;

public class mobLootDeathHandler implements Listener {

    @EventHandler
    public void onEndermenDeath(EntityDeathEvent event){
        List<ItemStack> drops = event.getDrops();
        Iterator<ItemStack> iterator = drops.iterator();
        if (!event.getEntityType().equals(EntityType.ENDERMAN)){
            return;
        }
        if(mobFarmLoot) {
            while (iterator.hasNext()) {
                ItemStack item = iterator.next();
                if (item != null && !item.getType().equals(Material.AIR)) {
                    if (item.getType().equals(Material.ENDER_PEARL)) iterator.remove();
                }
            }
        }
        else{
            return;
        }

//        EntityDamageEvent causeDeath = event.getEntity().getLastDamageCause();
//        EntityDamageEvent.DamageCause damCause = causeDeath.getCause();
//        Entity entity = event.getEntity();
//
//        if (!event.getEntityType().equals(EntityType.ENDERMAN)){
//            return;
//        }
//        if(mobFarmLoot){
//            if(damCause== EntityDamageEvent.DamageCause.SUFFOCATION){
//                event.getDrops().clear();
//                return;
//            }
//            else{
//                event.getDrops().clear();
//
//            }
//        }
    }

    @EventHandler
    public void onPiglinDeath(EntityDeathEvent event){
        List<ItemStack> drops = event.getDrops();
        Iterator<ItemStack> iterator = drops.iterator();
        if (!event.getEntityType().equals(EntityType.PIGLIN)){
            return;
        }
        if(mobFarmLoot) {
            while (iterator.hasNext()) {
                ItemStack item = iterator.next();
                if (item != null && !item.getType().equals(Material.AIR)) {
                    if (item.getType().equals(Material.ROTTEN_FLESH)) iterator.remove();
                }
            }
        }
        else{
            return;
        }
//        Random r= new Random();
//        int nuggetChance = r.nextInt(2);
//        Location piglinLoc = event.getEntity().getLocation();
//
//        if (!event.getEntityType().equals(EntityType.ZOMBIFIED_PIGLIN)){
//            return;
//        }
//        if(mobFarmLoot){
//            event.getDrops().clear();
//            if(nuggetChance == 0){
//                return;
//            }
//            else{
//                event.getEntity().getWorld().dropItem(piglinLoc,new ItemStack(Material.GOLD_NUGGET));
//            }
//        }
    }

    @EventHandler
    public void onWitherDeath(EntityDeathEvent event){
        List<ItemStack> drops = event.getDrops();
        Iterator<ItemStack> iterator = drops.iterator();
        if (!event.getEntityType().equals(EntityType.WITHER_SKELETON)){
            return;
        }
        if(mobFarmLoot) {
            while (iterator.hasNext()) {
                ItemStack item = iterator.next();
                if (item != null && !item.getType().equals(Material.AIR)) {
                    if (item.getType().equals(Material.STONE_SWORD)) iterator.remove();
                }
            }
        }
        else{
            return;
        }

    }

    @EventHandler
    public void onPillagerDeath(EntityDeathEvent event){
        List<ItemStack> drops = event.getDrops();
        Iterator<ItemStack> iterator = drops.iterator();
        if (!event.getEntityType().equals(EntityType.PILLAGER)){
            return;
        }
        if(mobFarmLoot) {
            while (iterator.hasNext()) {
                ItemStack item = iterator.next();
                if (item != null && !item.getType().equals(Material.AIR)) {
                    if (item.getType().equals(Material.CROSSBOW)) iterator.remove();
                    if (item.getType().equals(Material.IRON_AXE)) iterator.remove();
                }
            }
        }
        else{
            return;
        }

    }

    @EventHandler
    public void onRavengerDeath(EntityDeathEvent event){
        List<ItemStack> drops = event.getDrops();
        Iterator<ItemStack> iterator = drops.iterator();
        if (!event.getEntityType().equals(EntityType.PILLAGER)){
            return;
        }
        if(mobFarmLoot) {
            while (iterator.hasNext()) {
                ItemStack item = iterator.next();
                if (item != null && !item.getType().equals(Material.AIR)) {
                    if (item.getType().equals(Material.SADDLE)) iterator.remove();
                }
            }
        }
        else{
            return;
        }

    }

}
