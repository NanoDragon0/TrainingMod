package me.NanoDragon.TrainingMod.GUI;

import cpw.mods.fml.common.network.IGuiHandler;
import me.NanoDragon.TrainingMod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        ItemStack current = player.getCurrentEquippedItem();
        if (current != null) {
            if (ID == GuiID.UPG_PICKAXE.ordinal())
                return new ContainerItemStorage(player,
                        new InventoryItemStorage(current));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        ItemStack current = player.getCurrentEquippedItem();
        if (current != null) {
            if (ID == GuiID.UPG_PICKAXE.ordinal())
                return new GuiItemStorage(player,
                        new InventoryItemStorage(current));
        }
        return null;
    }

    public static void openGui(GuiID ID, EntityPlayer player, int x, int y, int z) {
        player.openGui(Main.instance, ID.ordinal(), player.worldObj, x, y, z);
    }

    public static void openGui(GuiID ID, EntityPlayer player) {
        player.openGui(Main.instance, ID.ordinal(), player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
    }

    public static enum GuiID {
        UPG_PICKAXE;
    }

}
