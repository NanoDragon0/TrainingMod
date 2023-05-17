package me.NanoDragon.TrainingMod;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import me.NanoDragon.TrainingMod.GUI.GuiHandler;
import me.NanoDragon.TrainingMod.Utils.AllRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;


@Mod (modid = Main.MODID, name= Main.MODNAME, version = Main.MODVER)
public class Main {

    public static Main instance;

    public static final String MODID = "trainingmod";
    public static final String MODNAME = "TrainingMod Tab";
    public static final String MODVER = "1.0.0";

    public static CreativeTabs tabTrainingMod = new CreativeTabs("TrainingMod") {

        public Item getTabIconItem() {
            return Item.getItemById(1);
        }
    };
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

            AllRegister.register();

            EventHandler events = new EventHandler();
            MinecraftForge.EVENT_BUS.register(events);
            FMLCommonHandler.instance().bus().register(events);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;
        // Инстанция мода и объект GuiHandler'а.
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

}
