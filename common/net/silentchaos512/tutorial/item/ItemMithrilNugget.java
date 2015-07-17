package net.silentchaos512.tutorial.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.lib.Names;
import net.silentchaos512.tutorial.util.LocalizationHelper;

/**
 * Item class for mithril nuggets. No major difference from ItemMithrilIngot, so refer to that instead! (Episode 4)
 */
public class ItemMithrilNugget extends Item {

  public ItemMithrilNugget() {

    this.setUnlocalizedName(Names.MITHRIL_NUGGET);
    this.setCreativeTab(TutorialMod.creativeTab);
  }

  public void addOreDict() {

    OreDictionary.registerOre("nuggetMithril", this);
  }

  @Override
  public void registerIcons(IIconRegister reg) {

    this.itemIcon = reg.registerIcon(TutorialMod.RESOURCE_PREFIX + Names.MITHRIL_NUGGET);
  }

  @Override
  public String getUnlocalizedName(ItemStack stack) {

    return LocalizationHelper.ITEM_PREFIX + Names.MITHRIL_NUGGET;
  }
}
