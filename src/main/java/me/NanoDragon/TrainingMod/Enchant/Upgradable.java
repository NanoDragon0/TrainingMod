package me.NanoDragon.TrainingMod.Enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class Upgradable extends Enchantment {
    public Upgradable() {
        super(102, 1, EnumEnchantmentType.digger); // id, max_lvl, tool_type
        setName("ubgradable");
        addToBookList(this);
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
