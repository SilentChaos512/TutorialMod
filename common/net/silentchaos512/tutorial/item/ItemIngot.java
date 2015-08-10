package net.silentchaos512.tutorial.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.lib.EnumMetal;
import net.silentchaos512.tutorial.util.LocalizationHelper;

/**
 * The meta-item example. It contains four metal ingots in one item ID. This is heavily tied to EnumMetal. Any changes
 * made to EnumMetal should automatically change this item as well. For example, try adding a fifth metal to EnumMetal.
 * A fifth ingot should appear in game, with no changes made to this class! Examine the EnumMetal file if you haven't
 * already.
 * 
 * A meta-item is a bit more complex than a simple item. Note that the constructor contains two extra method calls,
 * setHasSubtypes and setMaxDamage. Additionally, you need to override getSubItems, registerIcons, and
 * getIconFromDamage.
 * 
 * Episode 5
 * 
 * @author SilentChaos512
 *
 */
public class ItemIngot extends Item {

  /**
   * Stores all the icons for our ingots. This is initialized in registerIcons and referenced in getIconFromDamage.
   */
  protected IIcon[] icons;

  public ItemIngot() {

    this.setHasSubtypes(true);            // Seems to be used for comparing ItemStacks and combining EntityItems?
    this.setMaxDamage(0);                 // Tells Minecraft that meta is not being used to store damage.
    this.setCreativeTab(TutorialMod.creativeTab);
  }

  public void addRecipes() {

    // TODO Episode 6
  }

  public void addOreDict() {

    // This is a for-each loop. You'll see this a lot in this class. We're iterating over every possible metal...
    for (EnumMetal metal : EnumMetal.values()) {
      // ... and creating the ItemStack to register in the ore dictionary.
      // This ItemStack constructor takes three parameters: Item, count (stack size), and meta (damage).
      // In this case, the stack size is 1, and the meta matching the meta of the EnumMetal.
      ItemStack stack = new ItemStack(this, 1, metal.getMeta());
      // We're registering our ingots as "ingotCopper", "ingotTin", etc.
      OreDictionary.registerOre("ingot" + metal.getName(), stack);
    }
  }

  /**
   * This is the same method we overrode in ItemMithrilIngot, except we actually care about the ItemStack this time!
   */
  @Override
  public String getUnlocalizedName(ItemStack stack) {

    // We don't NEED to store this value, I'm just doing it for readability.
    int metadata = stack.getItemDamage();
    // Get the EnumMetal for this ingot. It contains the information we need.
    EnumMetal metal = EnumMetal.values()[metadata];
    // item.tutorialmod:ingot_{metalNameInLowerCase}
    return LocalizationHelper.ITEM_PREFIX + "ingot_" + metal.getName().toLowerCase();
  }

  /**
   * In this method, we populate the list with ItemStacks for each possible sub-item.
   * 
   * The stacks we put in the list will appear in our creative tab and in NEI. The order they appear in is in the order
   * of the list, so you can sort your sub-items however you like! Typically though, you'll just sort them by meta.
   * 
   * You can also override this method for other items that use metadata. For example, it you have a "chargeable" item
   * like a battery, you could return an empty and a full version, so creative mode players could spawn in a fully
   * charged item.
   */
  @Override
  public void getSubItems(Item item, CreativeTabs tab, List list) {

    // The same for-each loop we've already seen...
    for (EnumMetal metal : EnumMetal.values()) {
      // ... to add one of each ingot to the list.
      list.add(new ItemStack(item, 1, metal.getMeta()));
    }
  }

  /**
   * Another method we've seen before, but with more code! Instead of just assigning an icon to itemIcon, we're
   * populating an array of IIcons.
   */
  @Override
  public void registerIcons(IIconRegister reg) {

    // Initialize the array, using the number of values in EnumMetal as the length! Never hard-code array lengths!
    icons = new IIcon[EnumMetal.count()];
    // All the texture names will start with this:
    String prefix = TutorialMod.RESOURCE_PREFIX + "ingot_";     // tutorialmod:ingot_

    // The same for-each loop...
    for (EnumMetal metal : EnumMetal.values()) {
      // The array index is the metavalue of the ingot!
      // The texture name is the prefix above plus the name of the metal in lower case!
      icons[metal.getMeta()] = reg.registerIcon(prefix + metal.getName().toLowerCase());
    }
  }

  /**
   * This methods tells Minecraft which icon to use for the Item, based on its metavalue.
   */
  @Override
  public IIcon getIconFromDamage(int meta) {

    // Make sure we don't get an ArrayIndexOutOfBoundsExceptions...
    if (meta >= 0 && meta < EnumMetal.count()) {
      return icons[meta];
    }
    return null;
  }
}
