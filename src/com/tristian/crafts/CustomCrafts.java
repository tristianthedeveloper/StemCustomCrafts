package com.tristian.crafts;

import com.tristian.crafts.crafts.CraftRegistrar;
import com.tristian.crafts.crafts.CustomCraft;
import com.tristian.crafts.crafts.impl.misc.ExperienceBottle;
import com.tristian.crafts.crafts.impl.tools.AutosmeltPickaxe;
import com.tristian.crafts.listeners.AutosmeltPickaxeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomCrafts extends JavaPlugin {


    @Override
    public void onEnable() {

        try {
            registerCrafts();
            registerListeners();
        } finally {
            getLogger().fine("Finishing up...");
            finishCraftSetup();
        }

    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new AutosmeltPickaxeListener(), this);
    }

    private void registerCrafts() {

        registerCraft(new ExperienceBottle());
        registerCraft(new AutosmeltPickaxe());
    }
    public void registerCraft(CustomCraft craft) {
        CraftRegistrar.register(craft);
    }

    public void finishCraftSetup() {
        CraftRegistrar.sendCraftsToSpigotApi();
    }
}
