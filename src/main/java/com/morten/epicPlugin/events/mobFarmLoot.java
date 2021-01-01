package com.morten.epicPlugin.events;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morten.epicPlugin.jsonStuff.MobList;
import com.morten.epicPlugin.jsonStuff.itemID;
import com.morten.epicPlugin.jsonStuff.jsonHandler;
import com.morten.epicPlugin.jsonStuff.nameArr;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.*;


public class mobFarmLoot implements CommandExecutor {
public static boolean mobFarmLoot = true;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;


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
                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " List of items: ");
                }

                else{
                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Please use MobFarmLoot ON, OFF or List to check items specified in mobConfig.json!");

                }
            }
            else if(args.length==2 && args[0].equalsIgnoreCase("add")){
                System.out.println(args[1]);
                    //matches argument with second arg, outputs null if not
                    Material m = Material.matchMaterial(args[1]);
                    //gets current directory where .jar is running from
                    String wDir = System.getProperty("user.dir");
                    //checks if the json file exists
                    File tmpDir = new File(wDir+"/plugins/mobConfig.json");
                    boolean exists = tmpDir.exists();


                    if(m!=null){
                        if(!exists){
                            List<String> items = new ArrayList<>();

                            MobList nameID = new MobList(items);
                            items.add(args[1].toUpperCase());

                            Gson gson = new Gson();
                            try (Writer writer = new FileWriter(wDir+"/plugins/mobConfig.json")){
                                new Gson().toJson(nameID, writer);
                                player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Item " + ChatColor.BOLD + args[1] + ChatColor.RESET + " is now added!");

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        if(exists){
                            jsonHandler jsonFile = new jsonHandler();
                            List<String> jsonList = jsonFile.deserializeMobList();
                            MobList nameID = new MobList(jsonList);

                            ListIterator jsonIterator = jsonFile.deserializeMobList().listIterator();

                            boolean matExistJson = false;
                            while(jsonIterator.hasNext()){
                                if(jsonIterator.next().equals(args[1].toUpperCase())){
                                    matExistJson = true;
                                }
                            }


                            if(!matExistJson){
                                jsonList.add(args[1].toUpperCase());
                                try(Writer writer = new FileWriter(wDir+"/plugins/mobConfig.json")){
                                    new Gson().toJson(nameID, writer);
                                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Item " + ChatColor.BOLD + args[1] + ChatColor.RESET + " is now added!");

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            else{
                                player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Item " + ChatColor.BOLD + args[1] + ChatColor.RESET + " already exists");
                            }

                        }
                    }
                    else if(m==null){
                        player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET +" Item " +  ChatColor.BOLD + args[1] + ChatColor.RESET + " does not exist!");
                    }
            }
            else if(args.length==2 && args[0].equalsIgnoreCase("remove")){
                jsonHandler jsonFile = new jsonHandler();
                ListIterator jsonIterator = jsonFile.deserializeMobList().listIterator();

                List<String> removedInst = new ArrayList<>();

                while(jsonIterator.hasNext()){
                        String argsItem = jsonIterator.next().toString();
                    if(argsItem.equalsIgnoreCase(args[1])){
                        jsonIterator.remove();
                    }
                    else{
                        removedInst.add(argsItem);
                    }
                }

                MobList newNameID = new MobList(removedInst);



                String wDir = System.getProperty("user.dir");

                try(Writer writer = new FileWriter(wDir+"/plugins/mobConfig.json")){
                    new Gson().toJson(newNameID, writer);
                    player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Item " + ChatColor.BOLD + args[1] + ChatColor.RESET + " is now removed!");

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            else{
                player.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "MobFarmLoot" + ChatColor.GRAY + "]" + ChatColor.RESET + " Please use MobFarmLoot ON, OFF or List to check items specified in mobConfig.json!");

            }
        }
        return true;
    }

}

