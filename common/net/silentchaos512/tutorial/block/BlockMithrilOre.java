package net.silentchaos512.tutorial.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.item.ModItems;
import net.silentchaos512.tutorial.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * A basic ore that will be smeltable after we add an ingot to match it. It is registered in the ore dictionary however.
 * (Episode 3)
 */
public class BlockMithrilOre extends Block {

  protected BlockMithrilOre() {

    /*
     * Material affects various properties of the block. Take a look at the Material class for more information.
     */
    super(Material.rock);

    /*
     * Determines how long the block takes to mine. http://minecraft.gamepedia.com/Breaking#Blocks_by_hardness
     */
    this.setHardness(3.0f);
    /*
     * Blast/explosion resistance. Higher values are less likely to be destroyed by explosions.
     * http://minecraft.gamepedia.com/Explosion#Blast_resistance
     */
    this.setResistance(15.0f);
    /*
     * The sound played when the block is walked on.
     */
    this.setStepSound(Block.soundTypeStone);
    /*
     * What tool and mining/harvest level is required to harvest the block. 0 = Wood, 1 = Stone, 2 = Iron, 3 = Diamond,
     * 4 = Cobalt (TConstruct), etc.
     */
    this.setHarvestLevel("pickaxe", 2);

    /*
     * The texture for the block. This won't work very well if you have sub-blocks. Sub-blocks will be covered in a
     * later episode.
     */
    this.setBlockTextureName(TutorialMod.RESOURCE_PREFIX + Names.MITHRIL_ORE);
    /*
     * The unlocalized name of the block.
     */
    this.setBlockName(TutorialMod.RESOURCE_PREFIX + Names.MITHRIL_ORE); // tile.tutorialmod:MithrilOre
  }

  /**
   * Adds recipes related to this block. A little hint for more knowledgeable coders: you can "automate" calling this
   * method and addOreDict by putting them into an interface. I'll leave the details to you.
   */
  public void addRecipes() {

    /*
     * Adds a smelting recipe for ore -> ingot. Includes the XP earned for smelting. For example XP
     * values, go here: http://minecraft.gamepedia.com/Smelting#Processing_ores_and_materials
     * (Episode 4)
     */
    GameRegistry.addSmelting(this, new ItemStack(ModItems.mithrilIngot), 0.9f);
  }

  /**
   * Adds ore dictionary entries for this block. I suppose you could also do it in the constructor, or have one method
   * for both recipes and ore dictionary entries. Whatever makes sense to you.
   * 
   * Also, I highly recommend looking at this page: http://www.minecraftforge.net/wiki/Common_Oredict_names
   */
  public void addOreDict() {

    OreDictionary.registerOre("oreMithril", this); // If using sub-blocks, you will need to pass in an ItemStack instead
                                                   // of a block. ItemStacks store metadata, Blocks and Items don't.
  }
}
