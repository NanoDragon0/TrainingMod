package me.NanoDragon.TrainingMod.Utils;

import cpw.mods.fml.common.registry.GameRegistry;
import me.NanoDragon.TrainingMod.Enchant.Upgradable;
import me.NanoDragon.TrainingMod.Items.UpgradablePickaxe;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;

public class AllRegister {

    public static Item upg_pickaxe;
    public static Enchantment upgradable;

    public static void register() {

        upg_pickaxe = new UpgradablePickaxe();
        upgradable = new Upgradable();

    }
}
