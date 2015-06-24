package net.silentchaos512.tutorial;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.silentchaos512.tutorial.block.ModBlocks;
import net.silentchaos512.tutorial.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * The main mod class. This is where everything starts for your mod. (Episode 2)
 */
@Mod(modid = TutorialMod.MOD_ID, name = TutorialMod.MOD_NAME, version = TutorialMod.VERSION_NUMBER)
public class TutorialMod {

  /**
   * Must be unique! Don't use special characters.
   */
  public static final String MOD_ID = "TutorialMod";
  /**
   * Enter the full name of your mod here.
   */
  public static final String MOD_NAME = "Silent's Awesome Tutorial Mod";
  /**
   * Leave this as is, it will be replaced when the mod is built.
   */
  public static final String VERSION_NUMBER = "@VERSION@";
  /**
   * Used for unlocalized names and such.
   */
  public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":"; // tutorialmod:

  /*
   * Insert any additional variables you need here.
   */

  /**
   * An instance of your mod. You will need to refer to this if you create any non-static variables in this class.
   */
  @Instance(MOD_ID)
  public static TutorialMod instance;

  /**
   * Proxies are typically used for registering rendering handlers and tile entities. You may not need them.
   */
  @SidedProxy(clientSide = "net.silentchaos512.tutorial.proxy.ClientProxy", serverSide = "net.silentchaos512.tutorial.proxy.CommonProxy")
  public static CommonProxy proxy;

  /**
   * The first initialization step. Load your config file, register blocks and items, and anything else that other mods
   * may need to reference. Do not register recipes here.
   * 
   * @param event
   */
  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {

    // Load config
    // Create and register blocks and items
    ModBlocks.init();
  }

  /**
   * Register recipes, ore dictionary names, and event handlers. Create data structures. Some cross-mod interactions go
   * here.
   * 
   * @param event
   */
  @EventHandler
  public void init(FMLInitializationEvent event) {

    // Create any data structures you need
    // Detect and interact with other mods
    // Register recipes
    // Register event handlers
  }

  /**
   * Mostly for mod interaction.
   * 
   * @param event
   */
  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {

    // Mod interactions, if necessary.
  }

  /**
   * The creative tab for this mod. This could be declared anywhere, but it makes the most sense here. Override
   * getTabIconItem and return the item you want to use for an icon. Because this returns an Item, not an ItemStack, you
   * can't return anything with non-zero metadata or NBT. If necessary, you can create an item just for your creative
   * tab icon. If you do, I recommend hiding the item in NEI.
   */
  public static CreativeTabs creativeTab = new CreativeTabs("tabTutorialMod") {

    @Override
    public Item getTabIconItem() {

      return Items.chicken; // Change this.
    }
  };
}
