package com.tristian.crafts.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Iterator;
import java.util.List;

public class AutosmeltPickaxeListener implements Listener {


    @EventHandler
    public void onMine(BlockBreakEvent e) {
        if (e.getPlayer().getItemInHand().getType() == Material.AIR)
            return;
        if (isAutosmeltPickaxe(e.getPlayer().getItemInHand())) {
            ItemStack item = new ItemStack(e.getBlock().getType());
            ItemStack result = null;
            Iterator<Recipe> iter = Bukkit.recipeIterator();
            while (iter.hasNext()) { // loop through all recipies.
                Recipe recipe = iter.next();
                if (!(recipe instanceof FurnaceRecipe)) continue;
                if (((FurnaceRecipe) recipe).getInput().getType() != item.getType()) continue;
                result = recipe.getResult(); // find the matching furnace recipe.
                break;
            }
            if (result == null)
                return;

            e.setDropItems(false);
            e.getPlayer().getWorld().dropItem(e.getBlock().getLocation(), result);
        }


    }

    private boolean isAutosmeltPickaxe(ItemStack item) {
        ItemMeta meta;
        if ((meta = item.getItemMeta()) == null)
            return false;
        if (meta.getDisplayName().equals(""))
            return false;
        if (!meta.hasLore())
            return false;
        if (meta.getLore() == null)
            return false;
        List<String> lore = meta.getLore();
        return lore.contains(ChatColor.translateAlternateColorCodes('&', "&aThis pickaxe automatically &csmelts"));
    }
}
