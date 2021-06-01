package com.tristian.crafts.crafts.impl;

import com.tristian.crafts.crafts.CustomCraft;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class AutosmeltPickaxe extends CustomCraft {


    @Override
    public ShapedRecipe getRecipe() {
        ItemStack pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);

        ItemMeta meta = pickaxe.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aAutosmelt Pickaxe"));
        meta.setLore(Arrays.asList(
                ChatColor.translateAlternateColorCodes('&', ""),
                ChatColor.translateAlternateColorCodes('&', "&aThis pickaxe automatically &csmelts"),
                ChatColor.translateAlternateColorCodes('&', "&aitems for you! Neato!")
        ));
        ShapedRecipe recipe = new ShapedRecipe(pickaxe);
        recipe.shape("x", "x", "x",
                     "x", "y", "x",
                     "z", "z", "z");
        recipe.setIngredient('x', Material.COAL_BLOCK);
        recipe.setIngredient('y', Material.NETHERITE_PICKAXE);
        recipe.setIngredient('z', Material.NETHERITE_INGOT);
        return recipe;
    }
}
