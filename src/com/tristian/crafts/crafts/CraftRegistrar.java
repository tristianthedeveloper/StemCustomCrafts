package com.tristian.crafts.crafts;

import org.bukkit.Bukkit;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CraftRegistrar {


    public static List<CustomCraft> crafts;

    public static void register(CustomCraft craft) {
        crafts.add(craft);
    }




    public static void sendCraftsToSpigotApi() {
        crafts.stream().map(CustomCraft::getRecipe).forEach(Bukkit.getServer()::addRecipe);
    }

    static {
        crafts = new CopyOnWriteArrayList<>(); // dont want this thing disappearing
    }
}
