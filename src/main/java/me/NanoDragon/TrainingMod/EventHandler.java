package me.NanoDragon.TrainingMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.world.BlockEvent;

import static me.NanoDragon.TrainingMod.Utils.AllRegister.upg_pickaxe;
import static me.NanoDragon.TrainingMod.Utils.AllRegister.upgradable;

public class EventHandler {

    @SubscribeEvent
    public void onBreakEvent(BlockEvent.BreakEvent event) {
        EntityPlayer p = event.getPlayer();
        ItemStack item = p.getHeldItem();
        Block block = event.block;

        if (p.inventory.getCurrentItem().getItem() == upg_pickaxe && block == Blocks.diamond_ore) {
            NBTTagCompound nbtTagCompound = item.getTagCompound();
            if (nbtTagCompound == null) {

                nbtTagCompound = new NBTTagCompound();
                item.setTagCompound(nbtTagCompound);
                nbtTagCompound.setInteger("diamond_mining", 1);


            } else if (nbtTagCompound.getInteger("diamond_mining") > 0) {

                int diamond_mining = nbtTagCompound.getInteger("diamond_mining");
                nbtTagCompound.setInteger("diamond_mining", diamond_mining + 1);

            }

            if (nbtTagCompound.getInteger("diamond_mining") == 5) {
                item.addEnchantment(upgradable, 1);
            }
        }

    }

}
