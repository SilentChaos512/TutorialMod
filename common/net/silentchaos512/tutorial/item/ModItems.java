package net.silentchaos512.tutorial.item;

import net.silentchaos512.tutorial.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Stores, initializes, and registers items. Also adds recipes and ore dictionary entries. (Episode 4)
 */
public class ModItems {

  public static ItemMithrilIngot mithrilIngot;                  // Episode 4
  public static ItemMithrilNugget mithrilNugget;                // Episode 4

  /**
   * Declare and register items. Do NOT add recipes here!
   */
  public static void init() {

    mithrilIngot = new ItemMithrilIngot();                        // Initialize item
    GameRegistry.registerItem(mithrilIngot, Names.MITHRIL_INGOT); // Register item

    mithrilNugget = new ItemMithrilNugget();
    GameRegistry.registerItem(mithrilNugget, Names.MITHRIL_NUGGET);
  }

  /**
   * Add recipes related to the items. I also register Ore Dictionary entries here.
   */
  public static void initRecipes() {

    mithrilIngot.addRecipes();                                    // Register recipes
    mithrilIngot.addOreDict();                                    // Register ore dictionary entries.

    mithrilNugget.addOreDict();
  }
}
