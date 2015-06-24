package net.silentchaos512.tutorial.block;

import net.silentchaos512.tutorial.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Stores, initializes, and registers blocks. Also adds recipes and ore dictionary entries. (Episode 3)
 */
public class ModBlocks {
  
  public static BlockMithrilOre mithrilOre;                     // Episode 3

  public static void init() {
    
    mithrilOre = new BlockMithrilOre();                         // Initialize block
    GameRegistry.registerBlock(mithrilOre, Names.MITHRIL_ORE);  // Register block
    mithrilOre.addRecipes();                                    // Register recipes
    mithrilOre.addOreDict();                                    // Register ore dictionary entries
  }
}
