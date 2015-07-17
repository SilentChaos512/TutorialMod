package net.silentchaos512.tutorial.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.lib.Names;
import net.silentchaos512.tutorial.util.LocalizationHelper;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * A simple item that represents a mithril ingot. (Episode 4)
 */
public class ItemMithrilIngot extends Item {

  public ItemMithrilIngot() {

    /*
     * Sets the maximum stack size. By default, this is 64, so this line isn't needed.
     */
    this.setMaxStackSize(64);
    /*
     * Sets the unlocalized name of the item. Actually, I don't think this is doing anything since we're overriding
     * getUnlocalizedName(ItemStack)! You could also override this function to make it do something else, but this class
     * works as is.
     */
    this.setUnlocalizedName(Names.MITHRIL_INGOT); // Not necessary?
    /*
     * Sets the creative tab the item appears in. You can use vanilla tabs, but many mods add their own.
     */
    this.setCreativeTab(TutorialMod.creativeTab);
  }

  /**
   * Same as in BlockMithrilOre. This is where we register recipes related to this item. Don't forget to call this in
   * the initialization phase!
   * 
   * If you need more examples of recipes, try this:
   * https://github.com/SilentChaos512/SilentGems/blob/master/common/net/
   * silentchaos512/gems/item/CraftingMaterial.java#L92
   */
  public void addRecipes() {

    /*
     * Examples of basic shaped/shapeless recipes. I chose to use ore dictionary recipes instead (see below).
     */
    // GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mithrilNugget, 9), this);
    // GameRegistry.addShapedRecipe(new ItemStack(this), "nnn", "nnn", "nnn", 'n',
    // ModItems.mithrilNugget);

    /*
     * A shapeless recipe requires an output stack, followed by each ingredient, one argument for each.
     */
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mithrilNugget, 9),
        "ingotMithril"));
    /*
     * A shaped recipe, like shapeless, starts with an output stack. Next is one, two, or three strings that describe
     * the recipe layout. Each character of the strings represents different ingredients. After the strings, you have
     * pairs of arguments, first a character that appears in the strings, then a Block/Item/ItemStack/ore dictionary
     * key.
     */
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this), "nnn", "nnn", "nnn", 'n',
        "nuggetMithril"));
  }

  /**
   * Adds ore dictionary entries related to the item.
   */
  public void addOreDict() {

    OreDictionary.registerOre("ingotMithril", this);
  }

  /**
   * This function allows you to register one or more textures for use by this item. In this case, we only need one, but
   * you could create several variables or an array. Whatever you need! As for how to use multiple icons, we'll cover
   * that in the near future.
   */
  @Override
  public void registerIcons(IIconRegister reg) {

    this.itemIcon = reg.registerIcon(TutorialMod.RESOURCE_PREFIX + Names.MITHRIL_INGOT);
  }

  /**
   * Here we are overriding the default getUnlocalizedName so we can return our item prefix in front of the item name.
   * Not sure if this is the best way to handle this, but it's what I normally do.
   */
  @Override
  public String getUnlocalizedName(ItemStack stack) {

    return LocalizationHelper.ITEM_PREFIX + Names.MITHRIL_INGOT;
  }
}
