package me.NanoDragon.TrainingMod.Items;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.NanoDragon.TrainingMod.GUI.GuiHandler;
import me.NanoDragon.TrainingMod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;
import java.util.Set;

public class UpgradablePickaxe extends ItemTool {

    private boolean checkDoubleClick = true;

    static final ToolMaterial UpgradablePA = EnumHelper.addToolMaterial("Upgradable", 5, 7000, 10F, 7F, 18);

    public static final Set<Block> HARVEST_BLOCKS = Sets.newHashSet(
            Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone,
            Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block,
            Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore,
            Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail,
            Blocks.golden_rail, Blocks.activator_rail
    );
    public UpgradablePickaxe() {
        super(2F, UpgradablePA, HARVEST_BLOCKS);
        this.setUnlocalizedName("upg_pickaxe");
        this.setTextureName(Main.MODID + ":upg_pickaxe1");
        this.setMaxStackSize(1);
        this.setCreativeTab(Main.tabTrainingMod);
        GameRegistry.registerItem(this, "upg_pickaxe");


    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack ItemStack, EntityPlayer EntityPlayer, List List, boolean part4) {
        NBTTagCompound nbtTagCompound = ItemStack.getTagCompound();
        List.add("§l§7Улучшает, когда копает что-то ценное");
        if (nbtTagCompound != null) {
            int diamond_mining = nbtTagCompound.getInteger("diamond_mining");
            List.add("Добыто: " + diamond_mining);
        }
        List.add("§4Креативный предмет");
    }

    @Override
    public boolean func_150897_b(Block block) {
        if (block == Blocks.obsidian)
            return toolMaterial.getHarvestLevel() == 3;
        return block != Blocks.diamond_block && block != Blocks.diamond_ore ? block != Blocks.emerald_ore && block != Blocks.emerald_block ? block != Blocks.gold_block && block != Blocks.gold_ore ? block != Blocks.iron_block && block != Blocks.iron_ore ? block != Blocks.lapis_block && block != Blocks.lapis_ore ? block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? block.getMaterial() == Material.rock || block.getMaterial() == Material.iron || block.getMaterial() == Material.anvil : toolMaterial.getHarvestLevel() >= 2 : toolMaterial.getHarvestLevel() >= 1 : toolMaterial.getHarvestLevel() >= 1 : toolMaterial.getHarvestLevel() >= 2 : toolMaterial.getHarvestLevel() >= 2 : toolMaterial.getHarvestLevel() >= 2;
    }

    @Override
    public float func_150893_a(ItemStack toolStack, Block block) {
        if (block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock)
            return super.func_150893_a(toolStack, block);
        return efficiencyOnProperMaterial;
    }

    @SubscribeEvent
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {

        if (checkDoubleClick) {
            checkDoubleClick = false;
        } else {

            if (EnchantmentHelper.getEnchantmentLevel(102, item) > 0) {
                player.addChatMessage(new ChatComponentText("[DEBUG] Успешно"));
                if (player != null) {
                    if (!player.isSneaking()) {
                        GuiHandler.openGui(GuiHandler.GuiID.UPG_PICKAXE, player);
                    }
                }
            }
            checkDoubleClick = !checkDoubleClick;
        }

        return item;
    }

}
