package com.tristian.crafts.crafts.impl;

import com.tristian.crafts.crafts.CustomCraft;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class ExperienceBottle extends CustomCraft  {

    @Override
    public ShapedRecipe getRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.EXPERIENCE_BOTTLE));
        recipe.shape("x", "x", "x",
                     "x", "y", "x",
                     "x", "x", "x");
        recipe.setIngredient('x', Material.LAPIS_BLOCK);
        recipe.setIngredient('y', Material.GLASS_BOTTLE);
        return recipe;
    }
}
